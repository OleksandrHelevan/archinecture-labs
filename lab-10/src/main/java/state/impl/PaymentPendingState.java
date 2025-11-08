package state.impl;

import state.TicketContext;
import state.TicketState;

public class PaymentPendingState implements TicketState {
    @Override
    public void selectFlight(TicketContext context) {
        System.out.println("Рейс уже обрано. Спочатку завершіть оплату.");
    }

    @Override
    public void makePayment(TicketContext context) {
        System.out.println("Оплату прийнято. Підтвердження квитка...");
        context.setState(new TicketConfirmedState());
    }

    @Override
    public void confirm(TicketContext context) {
        System.out.println("Підтвердити неможливо без оплати.");
    }

    @Override
    public void cancel(TicketContext context) {
        System.out.println("Оплату скасовано. Замовлення анульовано.");
        context.setState(new CancelledState());
    }
}
