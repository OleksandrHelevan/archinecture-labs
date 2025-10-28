package mediator;

import lombok.Getter;

public class PaymentButton implements Component {
    private Mediator mediator;
    @Getter
    private boolean enabled = false;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        System.out.println("Кнопка оплати " + (enabled ? "активна" : "неактивна"));
    }

    public void click() {
        if (enabled) {
            mediator.notify(this, Event.PAY);
        } else {
            System.out.println("Неможливо оплатити: немає вибраного рейсу.");
        }
    }
}
