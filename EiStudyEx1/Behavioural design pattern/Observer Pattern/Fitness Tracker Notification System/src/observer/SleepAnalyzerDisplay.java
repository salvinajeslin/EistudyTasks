package observer;

public class SleepAnalyzerDisplay implements Observer {
    @Override
    public void update(int steps, int heartRate, int sleepHours) {
        if (sleepHours < 6) {
            System.out.println("Sleep Analyzer: You had less sleep. Try to sleep more.");
        } else {
            System.out.println("Sleep Analyzer: Sleep was good.");
        }
    }
}
