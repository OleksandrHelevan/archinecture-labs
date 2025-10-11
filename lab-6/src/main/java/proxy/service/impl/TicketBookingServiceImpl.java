package proxy.service.impl;

import decorator.Ticket;
import proxy.service.TicketBookingService;

public class TicketBookingServiceImpl implements TicketBookingService {

    @Override
    public void bookTicket(Ticket ticket) {
        System.out.println("Booking confirmed: " + ticket.getDescription());
        System.out.println("Total cost: $" + ticket.getCost());
    }
}
