package factory.model;
import factory.PaymentFactory;

public class CryptoPayment implements PaymentFactory {
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with Cryptocurrency...");
    }

    @Override
    public String getName() {
        return "Cryptocurrency";
    }
}