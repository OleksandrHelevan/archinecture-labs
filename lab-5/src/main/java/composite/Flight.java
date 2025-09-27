package composite;

public class Flight implements FlightComponent {
    private final String flightNumber;
    private final String destination;

    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    @Override
    public void showInfo() {
        System.out.println("Рейс " + flightNumber + " - " + destination);
    }

    @Override
    public int getFlightCount() {
        return 1;
    }
}