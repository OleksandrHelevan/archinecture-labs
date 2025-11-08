package state.impl;

import state.TicketContext;
import state.TicketState;

public class CancelledState implements TicketState {
    @Override
    public void selectFlight(TicketContext context) {
        System.out.println("Ви можете обрати новий рейс.");
        context.setState(new SelectingFlightState());
    }

    @Override
    public void makePayment(TicketContext context) {
        System.out.println("Замовлення скасовано. Почніть заново.");
    }

    @Override
    public void confirm(TicketContext context) {
        System.out.println("Неможливо підтвердити скасоване замовлення.");
    }

    @Override
    public void cancel(TicketContext context) {
        System.out.println("Уже скасовано.");
    }
}

