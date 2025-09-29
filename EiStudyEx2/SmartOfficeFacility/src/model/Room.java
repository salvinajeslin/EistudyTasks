package model;

import util.Logger;

public class Room {
    private final int roomId;
    private int maxCapacity = 10;
    private boolean booked = false;
    private int occupants = 0;
    private Booking currentBooking = null;
    private static final Logger logger = Logger.getInstance();

    public Room(int roomId) {
        this.roomId = roomId;
        logger.info("Room " + roomId + " created.");
    }

    public int getRoomId() { return roomId; }

    public boolean isBooked() { return booked; }

    public void setBooking(Booking booking) {
        this.currentBooking = booking;
        this.booked = booking != null;
        logger.info("Room " + roomId + " booking set: " + (booking != null));
    }

    public Booking getCurrentBooking() { return currentBooking; }

    public int getOccupants() { return occupants; }

    public void setOccupants(int occupants) {
        this.occupants = occupants;
        logger.info("Room " + roomId + " occupants set to " + occupants);
    }

    public boolean isOccupied() {
        return occupants >= 2; // occupancy rule
    }

    public void cancelBooking() {
        this.currentBooking = null;
        this.booked = false;
        logger.info("Room " + roomId + " booking cancelled.");
    }

    public int getMaxCapacity() { return maxCapacity; }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity <= 0) return;
        this.maxCapacity = maxCapacity;
        logger.info("Room " + roomId + " maxCapacity set to " + maxCapacity);
    }
}
