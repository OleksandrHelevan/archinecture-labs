import state.TicketContext;
import strategy.PaymentType;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Онлайн каса авіаквитків ===\n");

        TicketContext ticket1 = new TicketContext("Шоні", "Чернівці - Київ", 2000);
        System.out.println("Квиток №1 (успішна покупка)\n");
        ticket1.selectFlight();
        ticket1.makePayment();
        ticket1.makePayment();
        ticket1.confirm();
        System.out.println("=================================\n");

        TicketContext ticket2 = new TicketContext("Олег", "Львів - Хуст", 2500);
        System.out.println("Квиток №2 (оплату не завершено)\n");
        ticket2.selectFlight();
        ticket2.makePayment();
        ticket2.cancel();
        ticket2.confirm();


        System.out.println("=== Онлайн каса авіаквитків ===\n");

        double[] prices = {800, 1500, 2800};

        System.out.println("=== Оплата карткою ===");
        for (double price : prices) {
            PaymentType.CARD.printPaymentInfo(price);
        }

        System.out.println("\n=== Оплата готівкою ===");
        for (double price : prices) {
            PaymentType.CASH.printPaymentInfo(price);
        }
    }
}
