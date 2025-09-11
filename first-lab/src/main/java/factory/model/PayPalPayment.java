package factory.model;

import factory.PaymentFactory;

public class PayPalPayment implements PaymentFactory {
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " via PayPal...");
    }

    @Override
    public String getName() {
        return "PayPal";
    }
}