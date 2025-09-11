package factory.impl;

import factory.PaymentFactory;
import factory.PaymentType;
import factory.model.CashRegisterPayment;
import factory.model.CreditCardPayment;
import factory.model.CryptoPayment;
import factory.model.PayPalPayment;

public class PaymentFactoryImpl {
    public static PaymentFactory createPayment(PaymentType type) {
        return switch (type) {
            case CREDIT_CARD -> new CreditCardPayment();
            case PAYPAL -> new PayPalPayment();
            case CRYPTO -> new CryptoPayment();
            case CASH_REGISTER -> new CashRegisterPayment();
        };
    }
}