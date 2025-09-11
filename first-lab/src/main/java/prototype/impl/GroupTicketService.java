package prototype.impl;

import common.Ticket;
import singleton.TicketRepository;

public class GroupTicketService {

    private final TicketRepository repository = TicketRepository.getInstance();

    public void bookTicket(GroupTicket prototype) {
        Ticket ticket = prototype.cloneTicket();
        repository.addTicket(ticket);
    }

    public void bookTicketsForGroup(GroupTicket prototype, int count) {
        for (int i = 0; i < count; i++) {
            bookTicket(prototype);
        }
    }
}
