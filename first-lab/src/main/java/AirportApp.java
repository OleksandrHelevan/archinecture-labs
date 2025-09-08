import model.*;
import prototype.impl.GroupTicket;
import singleton.TicketRepository;
import prototype.impl.GroupTicketBookingService;

import java.time.LocalTime;

public class AirportApp {
    public static void main(String[] args) {
        City kyiv = new City("Kyiv-UA","Kyiv", "Ukraine");
        City london = new City("London-UK","London", "United Kingdom");
        City khust = new City("Khust-UA","Khust", "Ukraine");
        City chernivtsi = new City("Chernivtsi-UA","Chernivtsi", "Ukraine");

        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusHours(2);

        Route fromKyivToChernivtsi = new Route("1", kyiv, chernivtsi, startTime, endTime);
        Route fromKhustToChernivtsi = new Route("2", khust, chernivtsi, startTime, endTime);
        Route fromLondonToKyiv = new Route("3", london, kyiv, startTime, endTime);
        Route fromKhustToLondon = new Route("4", khust, london, startTime, endTime);

        Ticket ticket1 = new Ticket("1", fromKhustToChernivtsi, 500, Currency.UAH);
        Ticket ticket2 = new Ticket("2", fromLondonToKyiv, 1000, Currency.UAH);
        Ticket ticket3 = new Ticket("3", fromKyivToChernivtsi, 600, Currency.UAH);
        Ticket ticket4 = new Ticket("4", fromKhustToLondon, 1000, Currency.UAH);

        Ticket[] tickets = new Ticket[]{ticket1, ticket2, ticket3, ticket4};

        Thread[] threads = new Thread[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            Ticket ticket = tickets[i];
            threads[i] = new Thread(() -> TicketRepository.getInstance().addTicket(ticket));
            threads[i].start();
        }

        GroupTicketBookingService bookingService = new GroupTicketBookingService();

        GroupTicket prototype1 = new GroupTicket(ticket1);
        GroupTicket prototype2 = new GroupTicket(ticket2);
        GroupTicket prototype3 = new GroupTicket(ticket3);

        bookingService.bookTicketsForGroup(prototype1, 2);
        bookingService.bookTicketsForGroup(prototype2, 2);
        bookingService.bookTicketsForGroup(prototype3, 2);

        System.out.println("All tickets in repository:");
        TicketRepository.getInstance().getAllTickets().forEach(System.out::println);
    }
}
