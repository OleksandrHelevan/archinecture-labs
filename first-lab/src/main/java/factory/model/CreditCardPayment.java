package factory.model;

import factory.PaymentFactory;

public class CreditCardPayment implements PaymentFactory {
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with Credit Card...");
    }

    @Override
    public String getName() {
        return "Credit Card";
    }
}
