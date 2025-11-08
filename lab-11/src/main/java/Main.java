import template.*;
import visitor.TicketElement;
import visitor.TicketVisitor;
import visitor.impl.DiscountVisitor;
import visitor.impl.TaxVisitor;
import visitor.ticket.BusinessTicket;
import visitor.ticket.EconomyTicket;
import visitor.ticket.FirstClassTicket;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Template Method — Покупка квитка ===\n");

        TicketPurchaseTemplate web = new WebTicketPurchase();
        web.purchaseTicket();

        TicketPurchaseTemplate mobile = new MobileTicketPurchase();
        mobile.purchaseTicket();

        TicketPurchaseTemplate offline = new OfflineTicketPurchase();
        offline.purchaseTicket();

        System.out.println("=== Visitor Pattern — Обробка квитків ===\n");

        List<TicketElement> tickets = List.of(
                new EconomyTicket(800),
                new BusinessTicket(1800),
                new FirstClassTicket(3500)
        );

        TicketVisitor discountVisitor = new DiscountVisitor();
        TicketVisitor taxVisitor = new TaxVisitor();

        System.out.println(">>> Розрахунок знижок:");
        tickets.forEach(t -> t.accept(discountVisitor));

        System.out.println("\n>>> Розрахунок податків:");
        tickets.forEach(t -> t.accept(taxVisitor));
    }
}
