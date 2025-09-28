package handler;

import model.SupportRequest;
import utils.Logger;

public class LevelTwoSupport extends SupportHandler {

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getLevel() <= 2) {
            Logger.log("LevelTwoSupport: Handling request - " + request.getMessage());
        } else {
            Logger.log("LevelTwoSupport: Passing request to LevelThreeSupport.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}
