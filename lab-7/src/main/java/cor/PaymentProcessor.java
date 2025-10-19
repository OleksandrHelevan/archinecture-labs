package cor;

public class PaymentProcessor extends BookingHandler {
    @Override
    protected boolean process(BookingRequest request) {
        if (!request.isPaymentValid()) {
            System.out.println("Оплата не пройшла.");
            return false;
        }
        System.out.println("Оплата підтверджена.");
        return true;
    }
}