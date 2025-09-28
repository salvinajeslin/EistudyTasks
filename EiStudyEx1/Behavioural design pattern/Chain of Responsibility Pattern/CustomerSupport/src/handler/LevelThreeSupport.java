package handler;

import model.SupportRequest;
import utils.Logger;

public class LevelThreeSupport extends SupportHandler {

    @Override
    public void handleRequest(SupportRequest request) {
        Logger.log("LevelThreeSupport: Handling request - " + request.getMessage());
    }
}
