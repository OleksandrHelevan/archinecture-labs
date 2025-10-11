package decorator;

public class PriorityBoardingDecorator extends TicketDecorator {
    private final double price;

    public PriorityBoardingDecorator(Ticket delegate, double price) {
        super(delegate);
        this.price = price;
    }

    @Override
    public String getDescription() {
        return delegate.getDescription() + " + Priority boarding";
    }

    @Override
    public double getCost() {
        return delegate.getCost() + price;
    }
}
