package model;

public class SupportRequest {
    private int level; // 1, 2, or 3
    private String message;

    public SupportRequest(int level, String message) {
        this.level = level;
        this.message = message;
    }

    public int getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
