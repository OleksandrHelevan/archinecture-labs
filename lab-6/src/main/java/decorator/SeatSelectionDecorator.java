package decorator;

public class SeatSelectionDecorator extends TicketDecorator {
    private final String seat;
    private final double price;

    public SeatSelectionDecorator(Ticket delegate, String seat, double price) {
        super(delegate);
        this.seat = seat;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return delegate.getDescription() + " + Seat: " + seat;
    }

    @Override
    public double getCost() {
        return delegate.getCost() + price;
    }
}
