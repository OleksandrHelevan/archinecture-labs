package flyweight;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlightType {
    private final String airline;
    private final String aircraftModel;
    private final String logo;

    public void showInfo(String ticketNumber, String passenger) {
        System.out.println("Квиток №" + ticketNumber + " | Пасажир: " + passenger);
        System.out.println("Авіакомпанія: " + airline +
                ", Літак: " + aircraftModel +
                ", Логотип: " + logo);
        System.out.println("----------------------");
    }
}
