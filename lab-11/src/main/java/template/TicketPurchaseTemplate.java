package template;

public abstract class TicketPurchaseTemplate {

    public final void purchaseTicket() {
        selectFlight();
        selectSeat();
        makePayment();
        sendConfirmation();
        System.out.println("Покупка завершена.\n");
    }

    protected abstract void selectFlight();
    protected abstract void selectSeat();
    protected abstract void makePayment();

    protected void sendConfirmation() {
        System.out.println("Надсилаємо підтвердження на email...");
    }
}
