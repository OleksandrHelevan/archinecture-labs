package service;


import command.BookingInvoker;
import command.impl.CheckSeatCommand;
import command.impl.IssueTicketCommand;
import command.impl.PaymentCommand;
import command.impl.ValidateCommand;
import cor.BookingRequest;

public class AirlineBookingService {
    private final BookingInvoker invoker;

    public AirlineBookingService() {
        invoker = new BookingInvoker();
        invoker.addCommand(new ValidateCommand());
        invoker.addCommand(new CheckSeatCommand());
        invoker.addCommand(new PaymentCommand());
        invoker.addCommand(new IssueTicketCommand());
    }

    public void process(BookingRequest bookingRequest) {
        System.out.println("=== Початок обробки заявки ===");
        invoker.executeAll(bookingRequest);
        System.out.println("=== Завершено ===\n");
    }
}
