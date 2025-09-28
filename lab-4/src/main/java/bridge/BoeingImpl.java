package bridge;

public class BoeingImpl implements Aircraft {
    @Override
    public void operate(String flightNumber) {
        System.out.println("Рейс " + flightNumber + " виконується літаком Boeing.");
    }
}
