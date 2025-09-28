package handler;

import model.SupportRequest;
import utils.Logger;

public class LevelOneSupport extends SupportHandler {

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getLevel() <= 1) {
            Logger.log("LevelOneSupport: Handling request - " + request.getMessage());
        } else {
            Logger.log("LevelOneSupport: Passing request to LevelTwoSupport.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}
