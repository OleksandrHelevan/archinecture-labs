package iterator;

import java.util.ArrayList;
import java.util.List;

public class FlightTickets implements TicketCollection {

    private final List<Ticket> tickets = new ArrayList<>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public TicketIterator createIterator() {
        return new FlightTicketIterator(tickets);
    }
}
