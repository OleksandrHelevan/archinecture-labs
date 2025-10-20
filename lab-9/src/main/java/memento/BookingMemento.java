
package memento;

public record BookingMemento(
        String from,
        String to,
        String passengerName,
        String flightClass,
        boolean baggageIncluded
) {}
