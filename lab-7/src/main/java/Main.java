import cor.BookingRequest;
import service.AirlineBookingService;

public class Main {
    public static void main(String[] args) {
        AirlineBookingService service = new AirlineBookingService();

        BookingRequest request1 = new BookingRequest("Гелеван Олександр", "PS123", true, true);
        BookingRequest request2 = new BookingRequest("Руснак Василь", "PS321", true, false);

        service.process(request1);
        service.process(request2);
    }
}
