package template;

public class WebTicketPurchase extends TicketPurchaseTemplate {

    @Override
    protected void selectFlight() {
        System.out.println("Обрано рейс через веб-інтерфейс.");
    }

    @Override
    protected void selectSeat() {
        System.out.println("Користувач обрав місце з інтерактивної схеми літака.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Оплата виконана через банківську карту на сайті.");
    }
}
