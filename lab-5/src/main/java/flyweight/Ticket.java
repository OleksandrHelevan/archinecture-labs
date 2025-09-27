package flyweight;

public class Ticket {
    private final String ticketNumber;
    private final String passenger;
    private final FlightType flightType;

    public Ticket(String ticketNumber, String passenger, FlightType flightType) {
        this.ticketNumber = ticketNumber;
        this.passenger = passenger;
        this.flightType = flightType;
    }

    public void showTicket() {
        flightType.showInfo(ticketNumber, passenger);
    }
}