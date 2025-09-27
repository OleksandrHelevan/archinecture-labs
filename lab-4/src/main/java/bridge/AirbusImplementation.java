package bridge;

public class AirbusImplementation implements Aircraft {
    @Override
    public void operate(String flightNumber) {
        System.out.println("Рейс " + flightNumber + " виконується літаком Airbus.");
    }
}