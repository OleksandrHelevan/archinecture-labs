package prototype.impl;

import prototype.CloneableTicket;
import common.Ticket;

import java.util.UUID;

public class GroupTicket implements CloneableTicket {
    private final Ticket ticketTemplate;

    public GroupTicket(Ticket ticketTemplate) {
        this.ticketTemplate = ticketTemplate;
    }

    @Override
    public Ticket cloneTicket() {
        return new Ticket(
                UUID.randomUUID().toString(),
                ticketTemplate.getRoute(),
                ticketTemplate.getPrice(),
                ticketTemplate.getCurrency()
        );
    }
}
