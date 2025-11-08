package state;

public interface TicketState {
    void selectFlight(TicketContext context);
    void makePayment(TicketContext context);
    void confirm(TicketContext context);
    void cancel(TicketContext context);
}

