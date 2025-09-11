package abstract_factory.impl;

import abstract_factory.TicketFactory;
import factory.PaymentFactory;
import factory.PaymentType;
import factory.impl.PaymentFactoryImpl;
import common.Currency;
import common.Route;
import common.Ticket;

public class TicketFactoryImpl implements TicketFactory {

    @Override
    public Ticket createTicket(String id, Route route, double price, Currency currency) {
        return new Ticket(id, route, price, currency);
    }

    @Override
    public PaymentFactory createPayment(PaymentType type) {
        return PaymentFactoryImpl.createPayment(type);
    }

}