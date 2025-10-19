package command.impl;

import command.BookingCommand;
import cor.BookingRequest;
import cor.SeatAvailabilityChecker;

public class CheckSeatCommand implements BookingCommand {
    private final SeatAvailabilityChecker checker = new SeatAvailabilityChecker();
    @Override
    public void execute(BookingRequest request) {
        checker.handle(request);
    }
}