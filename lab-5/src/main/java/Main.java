import composite.AirAlliance;
import composite.Airline;
import composite.Flight;
import flyweight.FlightType;
import flyweight.FlightTypeFactory;
import flyweight.Ticket;

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

        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

        FlightType lhA320 = FlightTypeFactory.getFlightType("Lufthansa", "Airbus A320", "LH");
        FlightType lhA320Again = FlightTypeFactory.getFlightType("Lufthansa", "Airbus A320", "LH");
        FlightType ryanairB737 = FlightTypeFactory.getFlightType("Ryanair", "Boeing 737", "FR");

        Ticket t1 = new Ticket("LH12345", "Іван", lhA320);
        Ticket t2 = new Ticket("LH12346", "Олена", lhA320Again);
        Ticket t3 = new Ticket("FR77777", "Андрій", ryanairB737);

        t1.showTicket();
        t2.showTicket();
        t3.showTicket();

        System.out.println("Унікальних об'єктів FlightType створено: " + FlightTypeFactory.getPoolSize());
    }
}
