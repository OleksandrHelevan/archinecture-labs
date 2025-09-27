package bridge;

public class BoeingImplementation implements Aircraft {
    @Override
    public void operate(String flightNumber) {
        System.out.println("Рейс " + flightNumber + " виконується літаком Boeing.");
    }
}
