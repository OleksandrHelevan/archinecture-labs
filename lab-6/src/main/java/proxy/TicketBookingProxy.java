package proxy;

import decorator.Ticket;
import proxy.service.TicketBookingService;
import proxy.service.impl.TicketBookingServiceImpl;

public class TicketBookingProxy implements TicketBookingService {

    private TicketBookingService realService;
    private final User user;

    public TicketBookingProxy( User user) {
        this.user = user;
    }

    @Override
    public void bookTicket(Ticket ticket) {
        if (user.getRole() == Role.GUEST) {
            System.out.println("Access denied for user " + user.getUsername() + "! Only registered users can book tickets.");
        } else {
            this.realService = new TicketBookingServiceImpl();
            System.out.println("User " + user.getUsername() + " is authorized to book tickets.");
            realService.bookTicket(ticket);
        }
    }
}
