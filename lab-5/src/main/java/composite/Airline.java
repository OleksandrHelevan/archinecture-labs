package composite;

import java.util.ArrayList;
import java.util.List;

public class Airline implements FlightComponent {
    private final String name;
    private final List<FlightComponent> flights = new ArrayList<>();

    public Airline(String name) {
        this.name = name;
    }

    public void add(FlightComponent flight) {
        flights.add(flight);
    }

    @Override
    public void showInfo() {
        System.out.println("Авіакомпанія: " + name);
        for (FlightComponent f : flights) {
            f.showInfo();
        }
    }

    @Override
    public int getFlightCount() {
        return flights.stream().mapToInt(FlightComponent::getFlightCount).sum();
    }
}
