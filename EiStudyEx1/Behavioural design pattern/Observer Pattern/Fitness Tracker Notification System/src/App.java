import model.FitnessData;
import observer.GoalTrackerDisplay;
import observer.HealthMonitorDisplay;
import observer.SleepAnalyzerDisplay;
import subject.FitnessTracker;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker();

        GoalTrackerDisplay goalTracker = new GoalTrackerDisplay();
        HealthMonitorDisplay healthMonitor = new HealthMonitorDisplay();
        SleepAnalyzerDisplay sleepAnalyzer = new SleepAnalyzerDisplay();

        tracker.registerObserver(goalTracker);
        tracker.registerObserver(healthMonitor);
        tracker.registerObserver(sleepAnalyzer);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("\nEnter fitness data: Steps HeartRate SleepHours");
                int steps = scanner.nextInt();
                int heartRate = scanner.nextInt();
                int sleepHours = scanner.nextInt();

                FitnessData data = new FitnessData(steps, heartRate, sleepHours);
                tracker.setFitnessData(data);

                System.out.println("\nDo you want to enter more data? (yes/no)");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("yes")) {
                    running = false;
                }

            } catch (Exception e) {
                System.err.println("Invalid input. Please enter numeric values.");
                scanner.nextLine(); // clear buffer
            }
        }

        System.out.println("Exiting Fitness Tracker. Goodbye!");
        scanner.close();
    }
}
