package util;

import java.io.File;

public class ValidationUtil {
    public static boolean isValidFile(String fileName) {
        // Simulate validation logic
        return fileName != null && !fileName.trim().isEmpty() && fileName.endsWith(".jpg");
    }
}
