package proxy;

import decorator.Ticket;
import proxy.service.TicketBookingService;

public class TicketBookingProxy implements TicketBookingService {

    private final TicketBookingService realService;
    private final User user;

    public TicketBookingProxy(TicketBookingService realService, User user) {
        this.realService = realService;
        this.user = user;
    }

    @Override
    public void bookTicket(Ticket ticket) {
        if (user.getRole() == Role.GUEST) {
            System.out.println("Access denied for user " + user.getUsername() + "! Only registered users can book tickets.");
        } else {
            System.out.println("User " + user.getUsername() + " is authorized to book tickets.");
            realService.bookTicket(ticket);

        }
    }
}
