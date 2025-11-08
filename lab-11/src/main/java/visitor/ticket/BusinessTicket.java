package visitor.ticket;

import visitor.TicketElement;
import visitor.TicketVisitor;

public record BusinessTicket(double basePrice) implements TicketElement {

    @Override
    public void accept(TicketVisitor visitor) {
        visitor.visit(this);
    }
}
