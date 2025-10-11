package decorator;

public class ExtraBaggageDecorator extends TicketDecorator {
    private final double baggageCost;
    private final int extraKg;

    public ExtraBaggageDecorator(Ticket delegate, int extraKg, double baggageCost) {
        super(delegate);
        this.extraKg = extraKg;
        this.baggageCost = baggageCost;
    }

    @Override
    public String getDescription() {
        return delegate.getDescription() + String.format(" + Extra baggage (%d kg)", extraKg);
    }

    @Override
    public double getCost() {
        return delegate.getCost() + baggageCost;
    }
}
