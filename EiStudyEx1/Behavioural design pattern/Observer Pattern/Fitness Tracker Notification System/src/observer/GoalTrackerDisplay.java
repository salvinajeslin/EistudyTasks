package observer;

public class GoalTrackerDisplay implements Observer {
    @Override
    public void update(int steps, int heartRate, int sleepHours) {
        if (steps >= 10000) {
            System.out.println("Goal Tracker: Congrats! You've reached your daily goal.");
        } else {
            System.out.println("Goal Tracker: Keep going! " + (10000 - steps) + " steps to go.");
        }
    }
}
