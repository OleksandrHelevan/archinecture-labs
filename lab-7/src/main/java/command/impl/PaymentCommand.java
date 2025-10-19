package command.impl;

import command.BookingCommand;
import cor.BookingRequest;
import cor.PaymentProcessor;

public class PaymentCommand implements BookingCommand {
    private final PaymentProcessor processor = new PaymentProcessor();
    @Override
    public void execute(BookingRequest request) {
        processor.handle(request);
    }
}