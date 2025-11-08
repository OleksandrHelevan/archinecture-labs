package state.impl;

import state.TicketContext;
import state.TicketState;

public class SelectingFlightState implements TicketState {
    @Override
    public void selectFlight(TicketContext context) {
        System.out.println("Ви вже обираєте рейс.");
    }

    @Override
    public void makePayment(TicketContext context) {
        System.out.println("Рейс обрано. Перехід до оплати...");
        context.setState(new PaymentPendingState());
    }

    @Override
    public void confirm(TicketContext context) {
        System.out.println("Неможливо підтвердити, поки не здійснена оплата.");
    }

    @Override
    public void cancel(TicketContext context) {
        System.out.println("Скасовано вибір рейсу.");
        context.setState(new CancelledState());
    }
}
