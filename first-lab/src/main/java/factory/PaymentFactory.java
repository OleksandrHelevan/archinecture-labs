package factory;

public interface PaymentFactory {
    void pay(double amount);
    String getName();
}
