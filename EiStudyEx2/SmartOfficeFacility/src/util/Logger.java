package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public enum LogLevel {
        INFO,
        WARN,
        ERROR
    }

    private static Logger instance;
    private final SimpleDateFormat dateFormat;

    private Logger() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(LogLevel level, String message) {
        String timeStamp = dateFormat.format(new Date());
        System.out.println("[" + timeStamp + "] [" + level + "] " + message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
