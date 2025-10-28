package cor;

public class TicketIssuer extends BookingHandler {
    @Override
    protected boolean process(BookingRequest request) {
        if(request.isPaymentValid() && request.isSeatAvailable())
            System.out.println("Квиток успішно оформлено для пасажира: " + request.getPassengerName());
        else
            System.out.println("Квиток не оформлено для пасажира: " + request.getPassengerName());
        return true;
    }
}