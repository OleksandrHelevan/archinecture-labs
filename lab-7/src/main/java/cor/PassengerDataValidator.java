package cor;

public class PassengerDataValidator extends BookingHandler {
    @Override
    protected boolean process(BookingRequest request) {
        if (request.getPassengerName() == null || request.getPassengerName().isEmpty()) {
            System.out.println("Дані пасажира невалідні.");
            return false;
        }
        System.out.println("Дані пасажира валідні.");
        return true;
    }
}