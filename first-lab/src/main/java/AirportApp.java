import abstract_factory.impl.BookingFactoryImpl;
import factory.PaymentType;
import common.*;
import prototype.impl.GroupTicket;
import prototype.impl.GroupTicketBookingService;
import singleton.TicketRepository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AirportApp {

    public static void main(String[] args) throws InterruptedException {
        City kyiv = new City("Kyiv-UA", "Kyiv", "Ukraine");
        City london = new City("London-UK", "London", "United Kingdom");
        City khust = new City("Khust-UA", "Khust", "Ukraine");
        City chernivtsi = new City("Chernivtsi-UA", "Chernivtsi", "Ukraine");

        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusHours(2);

        Route fromKyivToChernivtsi = new Route("1", kyiv, chernivtsi, startTime, endTime);
        Route fromKhustToChernivtsi = new Route("2", khust, chernivtsi, startTime, endTime);
        Route fromLondonToKyiv = new Route("3", london, kyiv, startTime, endTime);
        Route fromKhustToLondon = new Route("4", khust, london, startTime, endTime);

        BookingFactoryImpl factory = new BookingFactoryImpl();
        TicketRepository repo = TicketRepository.getInstance();
        GroupTicketBookingService groupService = new GroupTicketBookingService();

        List<Thread> ticketThreads = new ArrayList<>();
        ticketThreads.add(new Thread(() -> repo.addTicket(factory.createTicket("1", fromKhustToChernivtsi, 500, Currency.UAH))));
        ticketThreads.add(new Thread(() -> repo.addTicket(factory.createTicket("2", fromLondonToKyiv, 1000, Currency.UAH))));
        ticketThreads.add(new Thread(() -> repo.addTicket(factory.createTicket("3", fromKyivToChernivtsi, 600, Currency.UAH))));
        ticketThreads.add(new Thread(() -> repo.addTicket(factory.createTicket("4", fromKhustToLondon, 1000, Currency.UAH))));

        ticketThreads.forEach(Thread::start);
        for (Thread t : ticketThreads)
            t.join();

        Ticket ticket1 = repo.getTicketById("1").orElseThrow();
        Ticket ticket2 = repo.getTicketById("2").orElseThrow();
        Ticket ticket3 = repo.getTicketById("3").orElseThrow();

        GroupTicket prototype1 = new GroupTicket(ticket1);
        GroupTicket prototype2 = new GroupTicket(ticket2);
        GroupTicket prototype3 = new GroupTicket(ticket3);

        List<Thread> groupThreads = new ArrayList<>();
        groupThreads.add(new Thread(() -> groupService.bookTicketsForGroup(prototype1, 2)));
        groupThreads.add(new Thread(() -> groupService.bookTicketsForGroup(prototype2, 2)));
        groupThreads.add(new Thread(() -> groupService.bookTicketsForGroup(prototype3, 2)));

        groupThreads.forEach(Thread::start);
        for (Thread t : groupThreads) t.join();

        factory.createPayment(PaymentType.CREDIT_CARD);
        factory.createPayment(PaymentType.PAYPAL);
        factory.createPayment(PaymentType.CRYPTO);
        factory.createPayment(PaymentType.CASH_REGISTER);

        System.out.println("All tickets in repository:");
        repo.getAllTickets().forEach(System.out::println);
    }
}
