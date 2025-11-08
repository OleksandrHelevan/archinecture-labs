package state;

import lombok.Getter;
import lombok.Setter;
import state.impl.SelectingFlightState;

@Getter
@Setter
public class TicketContext {
    private TicketState state;
    private final String passenger;
    private final String flight;
    private final double price;

    public TicketContext(String passenger, String flight, double price) {
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
        this.state = new SelectingFlightState();
    }

    public void selectFlight() {
        state.selectFlight(this);
    }

    public void makePayment() {
        state.makePayment(this);
    }

    public void confirm() {
        state.confirm(this);
    }

    public void cancel() {
        state.cancel(this);
    }

}
