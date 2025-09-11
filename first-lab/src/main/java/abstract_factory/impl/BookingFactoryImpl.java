package abstract_factory.impl;

import abstract_factory.BookingFactory;
import factory.PaymentFactory;
import factory.PaymentType;
import factory.impl.PaymentFactoryImpl;
import common.Currency;
import common.Route;
import common.Ticket;
import prototype.impl.GroupTicketBookingService;

public class BookingFactoryImpl implements BookingFactory {

    private final GroupTicketBookingService groupService = new GroupTicketBookingService();

    @Override
    public Ticket createTicket(String id, Route route, double price, Currency currency) {
        return new Ticket(id, route, price, currency);
    }

    @Override
    public PaymentFactory createPayment(PaymentType type) {
        return PaymentFactoryImpl.createPayment(type);
    }

}