package bridge;

public class DomesticFlight extends Flight {

    public DomesticFlight(Aircraft aircraft) {
        super(aircraft);
    }

    @Override
    public void schedule(String flightNumber) {
        System.out.println("Заплановано внутрішній рейс " + flightNumber + ".");
        aircraft.operate(flightNumber);
    }
}
