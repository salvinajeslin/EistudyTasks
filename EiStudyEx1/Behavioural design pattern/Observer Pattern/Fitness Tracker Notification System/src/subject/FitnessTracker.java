package subject;

import observer.Observer;
import model.FitnessData;

import java.util.ArrayList;
import java.util.List;

public class FitnessTracker implements Subject {
    private List<Observer> observers;
    private FitnessData fitnessData;

    public FitnessTracker() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(
                    fitnessData.getSteps(),
                    fitnessData.getHeartRate(),
                    fitnessData.getSleepHours()
            );
        }
    }

    public void setFitnessData(FitnessData fitnessData) {
        this.fitnessData = fitnessData;
        notifyObservers();
    }
}
