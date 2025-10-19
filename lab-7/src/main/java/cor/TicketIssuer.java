package cor;

public class TicketIssuer extends BookingHandler {
    @Override
    protected boolean process(BookingRequest request) {
        System.out.println("Квиток успішно оформлено для пасажира: " + request.getPassengerName());
        return true;
    }
}