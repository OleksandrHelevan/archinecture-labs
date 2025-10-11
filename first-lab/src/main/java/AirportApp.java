import abstract_factory.impl.TicketFactoryImpl;
import builder.Client;
import factory.PaymentType;
import common.*;
import object_pool.RacePool;
import prototype.impl.GroupTicket;
import prototype.impl.GroupTicketService;
import singleton.TicketRepository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AirportApp {

    public static void main(String[] args) throws InterruptedException {

        Client oleksandr = new Client.Builder()
                .id("1")
                .username("oleksandr")
                .password("oleksandr")
                .build();

        Client andriy = new Client.Builder()
                .id("2")
                .username("vasyl")
                .password("vasyl")
                .build();

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

        TicketFactoryImpl factory = new TicketFactoryImpl();
        TicketRepository repo = TicketRepository.getInstance();
        GroupTicketService groupService = new GroupTicketService();

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

        RacePool racePool = new RacePool();
        racePool.addTicket(ticket1);

        Thread client1 = new Thread(() -> {
            try {
                Ticket t = racePool.reserve(ticket1.getRoute().getId());
                System.out.println(oleksandr.getUsername() + " reserved: " + t.getId());
                Thread.sleep(1000);
                racePool.release(t);
                System.out.println(oleksandr.getUsername() + " returned: " + t.getId());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread client2 = new Thread(() -> {
            try {
                Ticket t = racePool.reserve(ticket1.getRoute().getId());
                System.out.println(andriy.getUsername() + " reserved: " + t.getId());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        client1.start();
        Thread.sleep(200);
        client2.start();

        client1.join();
        client2.join();


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

        System.out.println("All tickets in repo:");
        repo.getAllTickets().forEach(System.out::println);

        System.out.println("All available tickets for Route 1: " + racePool.availableCount("1"));

    }
}
