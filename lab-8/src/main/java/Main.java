import iterator.FlightTickets;
import iterator.Ticket;
import iterator.TicketIterator;
import mediator.FlightMediator;
import mediator.PaymentButton;
import mediator.ResultList;
import mediator.SearchForm;

public class Main {

    public static void main(String[] args) {
        FlightTickets flightTickets = new FlightTickets();

        flightTickets.addTicket(new Ticket("PS101", "Лондон", 5400));
        flightTickets.addTicket(new Ticket("PS202", "Париж", 6200));
        flightTickets.addTicket(new Ticket("PS303", "Прага", 4800));

        TicketIterator iterator = flightTickets.createIterator();

        System.out.println("Доступні квитки у касі:");
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            System.out.println(ticket);
        }

        SearchForm form = new SearchForm();
        ResultList list = new ResultList();
        PaymentButton pay = new PaymentButton();

        FlightMediator mediator = new FlightMediator();
        mediator.registerComponents(form, list, pay);

        form.setRoute("Київ", "Париж");
        list.selectFirst();
        pay.click();
    }

}
