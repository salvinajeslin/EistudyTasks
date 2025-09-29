package command;

import singleton.OfficeManager;

public class AddOccupantCommand implements Command {
    private final int roomId;
    private final int occupants;

    public AddOccupantCommand(int roomId, int occupants) {
        this.roomId = roomId;
        this.occupants = occupants;
    }

    @Override
    public void execute() {
        OfficeManager.getInstance().addOccupants(roomId, occupants);
    }
}
