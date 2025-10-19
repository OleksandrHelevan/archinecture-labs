package cor;

public class SeatAvailabilityChecker extends BookingHandler {
    @Override
    protected boolean process(BookingRequest request) {
        if (!request.isSeatAvailable()) {
            System.out.println("Немає вільних місць на рейсі " + request.getFlightNumber());
            return false;
        }
        System.out.println("Місця на рейсі доступні.");
        return true;
    }
}