package proxy;

import util.Logger;
import util.ValidationUtil;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        try {
            if (!ValidationUtil.isValidFile(fileName)) {
                Logger.error("Invalid file: " + fileName);
                return;
            }
            if (realImage == null) {
                Logger.log("Creating RealImage instance for: " + fileName);
                realImage = new RealImage(fileName);
            } else {
                Logger.log("Using cached RealImage for: " + fileName);
            }
            realImage.display();
        } catch (Exception e) {
            Logger.error("ProxyImage error: " + e.getMessage());
        }
    }
}
