package iterator;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FlightTicketIterator implements TicketIterator {

    private final List<Ticket> tickets;
    private int position = 0;

    @Override
    public boolean hasNext() {
        return position < tickets.size();
    }

    @Override
    public Ticket next() {
        return tickets.get(position++);
    }
}
