package visitor.impl;

import visitor.TicketVisitor;
import visitor.ticket.BusinessTicket;
import visitor.ticket.EconomyTicket;
import visitor.ticket.FirstClassTicket;

public class TaxVisitor implements TicketVisitor {

    @Override
    public void visit(EconomyTicket ticket) {
        double tax = ticket.basePrice() * 0.02;
        System.out.printf("Економ-клас: податок %.2f грн. Підсумок: %.2f грн%n",
                tax, ticket.basePrice() + tax);
    }

    @Override
    public void visit(BusinessTicket ticket) {
        double tax = ticket.basePrice() * 0.04;
        System.out.printf("Бізнес-клас: податок %.2f грн. Підсумок: %.2f грн%n",
                tax, ticket.basePrice() + tax);
    }

    @Override
    public void visit(FirstClassTicket ticket) {
        double tax = ticket.basePrice() * 0.06;
        System.out.printf("Перший клас: податок %.2f грн. Підсумок: %.2f грн%n",
                tax, ticket.basePrice() + tax);
    }
}
