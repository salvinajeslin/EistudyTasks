package proxy;

import util.Logger;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        Logger.log("Loading image: " + fileName);
        try {
            Thread.sleep(500); // Simulate delay for loading
        } catch (InterruptedException e) {
            Logger.error("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public void display() {
        Logger.log("Displaying image: " + fileName);
    }
}
