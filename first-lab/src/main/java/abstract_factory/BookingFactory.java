package abstract_factory;

import factory.PaymentFactory;
import factory.PaymentType;
import common.Currency;
import common.Route;
import common.Ticket;

public interface BookingFactory {
    Ticket createTicket(String id, Route route, double price, Currency currency);
    PaymentFactory createPayment(PaymentType type);
}
