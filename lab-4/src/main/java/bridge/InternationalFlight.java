package bridge;

public class InternationalFlight extends Flight {

    public InternationalFlight(Aircraft aircraft) {
        super(aircraft);
    }

    @Override
    public void schedule(String flightNumber) {
        System.out.println("Заплановано міжнародний рейс " + flightNumber + ".");
        aircraft.operate(flightNumber);
    }
}
