package decorator;

import java.time.LocalDate;

public class BasicTicket implements Ticket {
    private final String from;
    private final String to;
    private final LocalDate date;
    private final double baseFare;

    public BasicTicket(String from, String to, LocalDate date, double baseFare) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.baseFare = baseFare;
    }

    @Override
    public String getDescription() {
        return String.format("Ticket %s -> %s on %s", from, to, date);
    }

    @Override
    public double getCost() {
        return baseFare;
    }
}
