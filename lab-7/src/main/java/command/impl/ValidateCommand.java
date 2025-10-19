package command.impl;

import command.BookingCommand;
import cor.BookingRequest;
import cor.PassengerDataValidator;

public class ValidateCommand implements BookingCommand {
    private final PassengerDataValidator validator = new PassengerDataValidator();
    @Override
    public void execute(BookingRequest request) {
        validator.handle(request);
    }
}