package visitor;

public interface TicketElement {
    void accept(TicketVisitor visitor);
}
