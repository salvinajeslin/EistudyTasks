package util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppLogger {
    private static final Logger LOGGER = Logger.getLogger(AppLogger.class.getName());

    private AppLogger() { } // Prevent instantiation

    public static void info(String msg) {
        LOGGER.log(Level.INFO, msg);
    }

    public static void error(String msg, Exception e) {
        LOGGER.log(Level.SEVERE, msg, e);
    }
}
