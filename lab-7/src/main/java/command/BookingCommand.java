package command;

import cor.BookingRequest;

public interface BookingCommand {
    void execute(BookingRequest request);
}