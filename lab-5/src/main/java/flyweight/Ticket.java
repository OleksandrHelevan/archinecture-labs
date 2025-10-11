package flyweight;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Ticket {
    private final String ticketNumber;
    private final String passenger;
    private final FlightType flightType;

    public void showTicket() {
        flightType.showInfo(ticketNumber, passenger);
    }
}