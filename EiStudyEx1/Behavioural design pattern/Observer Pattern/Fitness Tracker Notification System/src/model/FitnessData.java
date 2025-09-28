package model;

public class FitnessData {
    private int steps;
    private int heartRate;
    private int sleepHours;

    public FitnessData(int steps, int heartRate, int sleepHours) {
        this.steps = steps;
        this.heartRate = heartRate;
        this.sleepHours = sleepHours;
    }

    public int getSteps() { return steps; }
    public int getHeartRate() { return heartRate; }
    public int getSleepHours() { return sleepHours; }
}
