package model;

import java.time.LocalTime;

public class Booking {
    private final int roomId;
    private final LocalTime start;
    private final int durationMinutes; // duration in minutes

    public Booking(int roomId, LocalTime start, int durationMinutes) {
        this.roomId = roomId;
        this.start = start;
        this.durationMinutes = durationMinutes;
    }

    public int getRoomId() { return roomId; }
    public LocalTime getStart() { return start; }
    public int getDurationMinutes() { return durationMinutes; }

    public LocalTime getEnd() {
        return start.plusMinutes(durationMinutes);
    }

    public boolean overlapsWith(Booking other) {
        if (other == null) return false;
        LocalTime a1 = this.getStart(), a2 = this.getEnd();
        LocalTime b1 = other.getStart(), b2 = other.getEnd();
        return !(a2.isBefore(b1) || a1.isAfter(b2) || a2.equals(b1) || a1.equals(b2));
        // Note: adjust overlap logic depending on exclusive/inclusive boundaries.
    }
}
