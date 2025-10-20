import memento.Booking;
import memento.BookingHistory;
import observer.AdminDashboard;
import observer.BookingSystem;
import observer.MobileApp;
import observer.PassengerNotifier;

public class Main {
    public static void main(String[] args) {
        Booking booking = new Booking();
        BookingHistory history = new BookingHistory();

        booking.setData("Київ", "Прага", "Олександр Гелеван", "Економ", false);
        history.save(booking);
        booking.show();

        System.out.println("\n--- Зміна бронювання ---");
        booking.setData("Київ", "Прага", "Олександр Гелеван", "Бізнес", true);
        history.save(booking);
        booking.show();

        System.out.println("\n--- Відкат до попереднього стану ---");
        history.undo(booking);
        booking.show();

        BookingSystem system = new BookingSystem();

        PassengerNotifier passengerNotifier = new PassengerNotifier("Руснак Василь");
        AdminDashboard adminDashboard = new AdminDashboard();
        MobileApp mobileApp = new MobileApp();

        system.addObserver(passengerNotifier);
        system.addObserver(adminDashboard);
        system.addObserver(mobileApp);

        system.bookFlight("PS101 Київ → Прага", "Руснак Василь");

        system.cancelBooking("PS101 Київ → Прага", "Руснак Василь");
    }
}
