package flyweight;

public class FlightType {
    private final String airline;
    private final String aircraftModel;
    private final String logo;

    public FlightType(String airline, String aircraftModel, String logo) {
        this.airline = airline;
        this.aircraftModel = aircraftModel;
        this.logo = logo;
    }

    public void showInfo(String ticketNumber, String passenger) {
        System.out.println("Квиток №" + ticketNumber + " | Пасажир: " + passenger);
        System.out.println("Авіакомпанія: " + airline +
                ", Літак: " + aircraftModel +
                ", Логотип: " + logo);
        System.out.println("----------------------");
    }
}
