
package memento;

public class Booking {
    private String from;
    private String to;
    private String passengerName;
    private String flightClass;
    private boolean baggageIncluded;

    public void setData(String from, String to, String passengerName, String flightClass, boolean baggageIncluded) {
        this.from = from;
        this.to = to;
        this.passengerName = passengerName;
        this.flightClass = flightClass;
        this.baggageIncluded = baggageIncluded;
    }

    public void show() {
        System.out.println("Бронювання:");
        System.out.println("  Звідки: " + from);
        System.out.println("  Куди: " + to);
        System.out.println("  Пасажир: " + passengerName);
        System.out.println("  Клас: " + flightClass);
        System.out.println("  Багаж: " + (baggageIncluded ? "так" : "ні"));
    }

    public BookingMemento save() {
        return new BookingMemento(from, to, passengerName, flightClass, baggageIncluded);
    }

    public void restore(BookingMemento memento) {
        this.from = memento.from();
        this.to = memento.to();
        this.passengerName = memento.passengerName();
        this.flightClass = memento.flightClass();
        this.baggageIncluded = memento.baggageIncluded();
    }
}
