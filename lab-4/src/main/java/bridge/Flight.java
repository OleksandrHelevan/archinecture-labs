package bridge;

public abstract class Flight {
    protected Aircraft aircraft;

    public Flight(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public abstract void schedule(String flightNumber);
}
