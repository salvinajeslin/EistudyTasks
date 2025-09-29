package command;

import singleton.OfficeManager;
import util.Logger;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BookRoomCommand implements Command {
    private final int roomId;
    private final String time;
    private final int duration;
    private static final Logger logger = Logger.getInstance();

    public BookRoomCommand(int roomId, String time, int duration) {
        this.roomId = roomId;
        this.time = time;
        this.duration = duration;
        logger.info("BookRoomCommand created for Room " + roomId);
    }

    @Override
    public void execute() {
        try {
            LocalTime start = LocalTime.parse(time); // expects HH:mm
            OfficeManager.getInstance().bookRoom(roomId, start, duration);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format. Use HH:mm (e.g., 09:00).");
        }
    }
}
