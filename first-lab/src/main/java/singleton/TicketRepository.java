package singleton;

import common.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TicketRepository {
    private static volatile TicketRepository instance;
    private final List<Ticket> tickets;

    private TicketRepository() {
        this.tickets = Collections.synchronizedList(new ArrayList<>());
    }

    public static TicketRepository getInstance() {
        if (instance == null) {
            synchronized (TicketRepository.class) {
                if (instance == null) {
                    instance = new TicketRepository();
                }
            }
        }
        return instance;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getAllTickets() {
        synchronized (tickets) {
            return new ArrayList<>(tickets);
        }
    }

    public Optional<Ticket> getTicketById(String id) {
        synchronized (tickets) {
            return tickets.stream()
                    .filter(t -> t.getId().equals(id))
                    .findFirst();
        }
    }
}
