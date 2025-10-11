package decorator;

public class MealDecorator extends TicketDecorator {
    private final String mealType;
    private final double price;

    public MealDecorator(Ticket delegate, String mealType, double price) {
        super(delegate);
        this.mealType = mealType;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return delegate.getDescription() + " + Meal: " + mealType;
    }

    @Override
    public double getCost() {
        return delegate.getCost() + price;
    }
}
