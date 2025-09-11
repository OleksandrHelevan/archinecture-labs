package factory.model;

import factory.PaymentFactory;

public class CashRegisterPayment implements PaymentFactory {
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " via cash register...");
    }

    @Override
    public String getName() {
        return "Cash Register";
    }
}
