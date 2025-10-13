import decorator.*;
import proxy.Role;
import proxy.TicketBookingProxy;
import proxy.User;
import proxy.service.TicketBookingService;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        User admin = new User("Oleksandr", Role.ADMIN);
        User guest = new User("Vasyl", Role.GUEST);

        TicketBookingService adminProxy = new TicketBookingProxy(admin);
        TicketBookingService guestProxy = new TicketBookingProxy(guest);

        Ticket basic = new BasicTicket("Lviv", "London", LocalDate.of(2025, 11, 1), 120.0);

        Ticket withBaggage = new ExtraBaggageDecorator(basic, 20, 30.0);
        Ticket withPriority = new PriorityBoardingDecorator(withBaggage, 15.0);
        Ticket withSeat = new SeatSelectionDecorator(withPriority, "12A", 10.0);
        Ticket withMeal = new MealDecorator(withSeat, "Vegetarian", 8.0);
        Ticket insured = new InsuranceDecorator(withMeal, "BasicCoverage", 5.0);

        printTicket(insured);

        System.out.println("Admin:");
        adminProxy.bookTicket(insured);

        System.out.println("\nGuest:");
        guestProxy.bookTicket(insured);

    }

    private static void printTicket(Ticket t) {
        System.out.printf(Locale.US, "%s%nTotal cost: %.2f%n", t.getDescription(), t.getCost());
    }

}
