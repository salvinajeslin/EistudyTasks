package command;

import singleton.OfficeManager;

public class CancelRoomCommand implements Command {
    private final int roomId;

    public CancelRoomCommand(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public void execute() {
        OfficeManager.getInstance().cancelBooking(roomId);
    }
}
