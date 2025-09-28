package observer;

public class HealthMonitorDisplay implements Observer {
    @Override
    public void update(int steps, int heartRate, int sleepHours) {
        if (heartRate > 120) {
            System.out.println("Health Monitor: High heart rate detected! Rest or consult doctor.");
        } else {
            System.out.println("Health Monitor: Heart rate is normal.");
        }
    }
}
