package iterator;

import java.util.List;

public class FlightTicketIterator implements TicketIterator {

    private final List<Ticket> tickets;
    private int position = 0;

    public FlightTicketIterator(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean hasNext() {
        return position < tickets.size();
    }

    @Override
    public Ticket next() {
        return tickets.get(position++);
    }
}
