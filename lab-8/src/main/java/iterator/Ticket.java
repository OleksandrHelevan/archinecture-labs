package iterator;

public class Ticket {
    private final String flightNumber;
    private final String destination;
    private final double price;

    public Ticket(String flightNumber, String destination, double price) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Рейс " + flightNumber + " - " + destination + " | " + price + "₴";
    }
}
