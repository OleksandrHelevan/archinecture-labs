package state.impl;

import state.TicketContext;
import state.TicketState;

public class TicketConfirmedState implements TicketState {
    @Override
    public void selectFlight(TicketContext context) {
        System.out.println("Квиток уже підтверджено. Змінити рейс неможливо.");
    }

    @Override
    public void makePayment(TicketContext context) {
        System.out.println("Квиток уже оплачено.");
    }

    @Override
    public void confirm(TicketContext context) {
        System.out.println("Квиток уже підтверджено! Приємного польоту.");
    }

    @Override
    public void cancel(TicketContext context) {
        System.out.println("Квиток скасовано. Гроші буде повернено протягом 3 днів.");
        context.setState(new CancelledState());
    }
}
