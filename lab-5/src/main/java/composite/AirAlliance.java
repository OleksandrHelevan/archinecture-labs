package composite;

import java.util.ArrayList;
import java.util.List;

public class AirAlliance implements FlightComponent {
    private final String allianceName;
    private final List<FlightComponent> members = new ArrayList<>();

    public AirAlliance(String allianceName) {
        this.allianceName = allianceName;
    }

    public void add(FlightComponent company) {
        members.add(company);
    }

    @Override
    public void showInfo() {
        System.out.println("Альянс: " + allianceName);
        for (FlightComponent m : members) {
            m.showInfo();
        }
    }

    @Override
    public int getFlightCount() {
        return members.stream().mapToInt(FlightComponent::getFlightCount).sum();
    }
}