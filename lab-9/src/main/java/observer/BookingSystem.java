package observer;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void bookFlight(String flight, String passenger) {
        System.out.println("Квиток заброньовано: " + flight + " для " + passenger);
        notifyObservers("Бронювання підтверджено для " + passenger + " на рейс " + flight);
    }

    public void cancelBooking(String flight, String passenger) {
        System.out.println("Бронювання скасовано: " + flight + " (" + passenger + ")");
        notifyObservers("Бронювання " + passenger + " на рейс " + flight + " скасовано.");
    }
}
