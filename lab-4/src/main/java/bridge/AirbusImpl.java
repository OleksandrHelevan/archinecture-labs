package bridge;

public class AirbusImpl implements Aircraft {
    @Override
    public void operate(String flightNumber) {
        System.out.println("Рейс " + flightNumber + " виконується літаком Airbus.");
    }
}