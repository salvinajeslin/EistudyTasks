package singleton;

import model.Room;
import model.Booking;
import observer.Observer;
import util.Logger;

import java.time.LocalTime;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;

public class OfficeManager {
    private static volatile OfficeManager instance;
    private final Map<Integer, Room> rooms = new HashMap<>();
    private final List<Observer> observers = new ArrayList<>();
    private static final Logger logger = Logger.getInstance();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    private final Map<Integer, ScheduledFuture<?>> autoReleaseTasks = new ConcurrentHashMap<>();
    private final Map<Integer, Integer> roomUsageStats = new HashMap<>();
    private OfficeManager() {}

    public static OfficeManager getInstance() {
        if (instance == null) {
            synchronized (OfficeManager.class) {
                if (instance == null) {
                    instance = new OfficeManager();
                }
            }
        }
        return instance;
    }

    // Configure number of rooms
    public void configureRooms(int count) {
        if (count <= 0) {
            logger.warn("Invalid room count: " + count);
            return;
        }
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            rooms.put(i, new Room(i));
            roomUsageStats.put(i, 0);
        }
        logger.info("Office configured with " + count + " rooms.");
        System.out.println("Office configured with " + count + " meeting rooms:");
        rooms.values().forEach(r -> System.out.println("Room " + r.getRoomId()));
    }

    public boolean roomExists(int roomId) {
        return rooms.containsKey(roomId);
    }

    public Room getRoom(int roomId) {
        return rooms.get(roomId);
    }

    // Set room capacity
    public void setRoomCapacity(int roomId, int cap) {
        Room r = rooms.get(roomId);
        if (r == null) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        if (cap <= 0) {
            System.out.println("Invalid capacity. Please enter a valid positive number.");
            return;
        }
        r.setMaxCapacity(cap);
        System.out.println("Room " + roomId + " maximum capacity set to " + cap + ".");
    }

    // Booking with time conflict check
    public boolean bookRoom(int roomId, LocalTime start, int durationMinutes) {
        Room r = rooms.get(roomId);
        if (r == null) {
            System.out.println("Invalid room number.");
            return false;
        }
        Booking newBooking = new Booking(roomId, start, durationMinutes);
        // simple conflict: existing booking overlaps
        Booking existing = r.getCurrentBooking();
        if (existing != null && existing.overlapsWith(newBooking)) {
            System.out.println("Room " + roomId + " is already booked during this time. Cannot book.");
            return false;
        }
        r.setBooking(newBooking);
        System.out.println("Room " + roomId + " booked from " + start + " for " + durationMinutes + " minutes.");
        logger.info("Booked room " + roomId + " at " + start + " for " + durationMinutes);
        roomUsageStats.put(roomId, roomUsageStats.getOrDefault(roomId, 0) + 1);
        // schedule auto-release if not occupied within 5 minutes from booking start
        scheduleAutoReleaseIfNotOccupied(roomId, Duration.ofMinutes(5));
        return true;
    }

    public void cancelBooking(int roomId) {
        Room r = rooms.get(roomId);
        if (r == null) {
            System.out.println("Room " + roomId + " does not exist.");
            return;
        }
        if (!r.isBooked()) {
            System.out.println("Room " + roomId + " is not booked. Cannot cancel booking.");
            return;
        }
        r.cancelBooking();
        cancelAutoReleaseTask(roomId);
        notifyObservers(false); // when booking cancelled assume room unoccupied
        System.out.println("Booking for Room " + roomId + " cancelled successfully.");
    }

    public void addOccupants(int roomId, int count) {
        Room r = rooms.get(roomId);
        if (r == null) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        r.setOccupants(count);
        if (r.isOccupied()) {
            // occupied: notify observers to turn on systems
            notifyObservers(true);
            System.out.println("Room " + roomId + " is now occupied by " + count + " persons. AC and lights turned on.");
            cancelAutoReleaseTask(roomId); // occupant arrived => cancel pending auto-release
        } else {
            // not enough occupants
            System.out.println("Room " + roomId + " occupancy insufficient to mark as occupied.");
            // If room becomes unoccupied and had a booking, schedule auto-release countdown (5 minutes)
            if (r.isBooked()) {
                scheduleAutoReleaseIfNotOccupied(roomId, Duration.ofMinutes(5));
            } else {
                // if unbooked, ensure AC/lights off
                notifyObservers(false);
                System.out.println("Room " + roomId + " is now unoccupied. AC and lights turned off.");
            }
        }
    }

    // Observer additions
    public void addObserver(Observer observer) {
        observers.add(observer);
        logger.info("Observer added: " + observer.getClass().getSimpleName());
    }

    private void notifyObservers(boolean isOccupied) {
        logger.info("Notifying observers about occupancy change: " + isOccupied);
        for (Observer observer : observers) {
            observer.update(isOccupied);
        }
    }

    // Auto-release scheduler helpers
    private void scheduleAutoReleaseIfNotOccupied(int roomId, Duration delay) {
        cancelAutoReleaseTask(roomId);
        Runnable task = () -> {
            Room r = rooms.get(roomId);
            if (r == null) return;
            if (!r.isOccupied() && r.isBooked()) {
                r.cancelBooking();
                notifyObservers(false);
                System.out.println("Room " + roomId + " was unoccupied for " + delay.toMinutes() + " minutes. Booking released. AC and lights off.");
                logger.info("Auto-released booking for room " + roomId);
            }
        };
        ScheduledFuture<?> future = scheduler.schedule(task, delay.toMillis(), TimeUnit.MILLISECONDS);
        autoReleaseTasks.put(roomId, future);
    }

    private void cancelAutoReleaseTask(int roomId) {
        ScheduledFuture<?> f = autoReleaseTasks.remove(roomId);
        if (f != null && !f.isDone()) f.cancel(false);
    }
    public void printRoomUsageStats() {
        System.out.println("Room Usage Statistics:");
        for (Map.Entry<Integer, Integer> entry : roomUsageStats.entrySet()) {
            System.out.printf("Room %d: %d bookings%n", entry.getKey(), entry.getValue());
        }
    }
    // Shutdown scheduler if application ends
    public void shutdown() {
        scheduler.shutdownNow();
    }
}
