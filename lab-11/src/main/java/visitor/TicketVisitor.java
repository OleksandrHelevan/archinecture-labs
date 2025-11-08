package visitor;

import visitor.ticket.BusinessTicket;
import visitor.ticket.EconomyTicket;
import visitor.ticket.FirstClassTicket;

public interface TicketVisitor {
    void visit(EconomyTicket ticket);
    void visit(BusinessTicket ticket);
    void visit(FirstClassTicket ticket);
}
