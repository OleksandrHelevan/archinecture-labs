package iterator;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Ticket {
    private final String flightNumber;
    private final String destination;
    private final double price;


}
