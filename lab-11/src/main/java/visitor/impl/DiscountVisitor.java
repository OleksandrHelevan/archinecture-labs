package visitor.impl;

import visitor.TicketVisitor;
import visitor.ticket.BusinessTicket;
import visitor.ticket.EconomyTicket;
import visitor.ticket.FirstClassTicket;

public class DiscountVisitor implements TicketVisitor {

    @Override
    public void visit(EconomyTicket ticket) {
        double discount = ticket.basePrice() * 0.05;
        System.out.printf("Економ-клас: знижка %.2f грн. Ціна після знижки: %.2f грн%n",
                discount, ticket.basePrice() - discount);
    }

    @Override
    public void visit(BusinessTicket ticket) {
        double discount = ticket.basePrice() * 0.1;
        System.out.printf("Бізнес-клас: знижка %.2f грн. Ціна після знижки: %.2f грн%n",
                discount, ticket.basePrice() - discount);
    }

    @Override
    public void visit(FirstClassTicket ticket) {
        double discount = ticket.basePrice() * 0.15;
        System.out.printf("Перший клас: знижка %.2f грн. Ціна після знижки: %.2f грн%n",
                discount, ticket.basePrice() - discount);
    }
}
