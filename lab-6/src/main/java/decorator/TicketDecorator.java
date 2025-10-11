package decorator;

public abstract class TicketDecorator implements Ticket {
    protected final Ticket delegate;

    protected TicketDecorator(Ticket delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getDescription() {
        return delegate.getDescription();
    }

    @Override
    public double getCost() {
        return delegate.getCost();
    }
}
