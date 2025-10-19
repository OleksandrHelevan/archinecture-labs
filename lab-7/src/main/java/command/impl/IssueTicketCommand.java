package command.impl;

import command.BookingCommand;
import cor.BookingRequest;
import cor.TicketIssuer;

public class IssueTicketCommand implements BookingCommand {
    private final TicketIssuer issuer = new TicketIssuer();
    @Override
    public void execute(BookingRequest request) {
        issuer.handle(request);
    }
}