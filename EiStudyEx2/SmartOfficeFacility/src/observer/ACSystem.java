package observer;

public class ACSystem implements Observer {
    @Override
    public void update(boolean isOccupied) {
        if (isOccupied) {
            System.out.println("AC turned ON");
        } else {
            System.out.println("AC turned OFF");
        }
    }
}
