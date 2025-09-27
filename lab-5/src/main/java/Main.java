import composite.AirAlliance;
import composite.Airline;
import composite.Flight;

public class Main {

    public static void main(String[] args) {

        Flight f1 = new Flight("LH123", "Khust");
        Flight f2 = new Flight("LH456", "Kyiv");
        Flight f3 = new Flight("UA789", "Chernivtsi");
        Flight f4 = new Flight("UA101", "Lviv");

        Airline mau = new Airline("Mau");
        mau.add(f1);
        mau.add(f2);

        Airline united = new Airline("United Airlines");
        united.add(f3);
        united.add(f4);

        AirAlliance ukrAlliance = new AirAlliance("UKR Alliance");
        ukrAlliance.add(mau);
        ukrAlliance.add(united);

        ukrAlliance.showInfo();
        System.out.println("Загальна кількість рейсів в альянсі: " + ukrAlliance.getFlightCount());
    }
}
