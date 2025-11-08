package template;

public class MobileTicketPurchase extends TicketPurchaseTemplate {

    @Override
    protected void selectFlight() {
        System.out.println("Обрано рейс у мобільному додатку.");
    }

    @Override
    protected void selectSeat() {
        System.out.println("Автоматично призначено місце біля вікна.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Оплата через Google Pay / Apple Pay.");
    }
}
