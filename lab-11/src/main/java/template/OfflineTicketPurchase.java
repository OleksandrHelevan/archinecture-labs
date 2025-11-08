package template;

public class OfflineTicketPurchase extends TicketPurchaseTemplate {

    @Override
    protected void selectFlight() {
        System.out.println("Касир вводить дані рейсу вручну.");
    }

    @Override
    protected void selectSeat() {
        System.out.println("Касир обирає доступне місце з системи.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Оплата готівкою у касі.");
    }
}
