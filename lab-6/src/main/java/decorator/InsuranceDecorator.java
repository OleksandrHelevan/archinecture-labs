package decorator;

public class InsuranceDecorator extends TicketDecorator {
    private final double price;
    private final String policy;

    public InsuranceDecorator(Ticket delegate, String policy, double price) {
        super(delegate);
        this.policy = policy;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return delegate.getDescription() + " + Insurance: " + policy;
    }

    @Override
    public double getCost() {
        return delegate.getCost() + price;
    }
}

