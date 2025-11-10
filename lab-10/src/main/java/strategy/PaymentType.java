package strategy;

import lombok.Getter;

import static strategy.PaymentConstants.*;

@Getter
public enum PaymentType implements PaymentStrategy {

    CARD("Банківська карта") {
        @Override
        public double calculateTotal(double basePrice) {
            return basePrice * (1 + getCommissionRate(basePrice));
        }

        @Override
        public double getCommissionRate(double basePrice) {
            if (basePrice < THOUSAND_LIMIT) {
                return FIVE_PERCENT;
            } else if (basePrice < TWO_THOUSAND_FIVE_HUNDRED_LIMIT) {
                return TWO_PERCENT;
            } else {
                return 0.0;
            }
        }
    },

    CASH("Готівка") {
        @Override
        public double calculateTotal(double basePrice) {
            return basePrice * (1 + getCommissionRate(basePrice));
        }

        @Override
        public double getCommissionRate(double basePrice) {
            if (basePrice < THOUSAND_LIMIT) {
                return FIVE_PERCENT;
            } else if (basePrice < TWO_THOUSAND_FIVE_HUNDRED_LIMIT) {
                return THREE_PERCENT;
            } else {
                return ONE_PERCENT;
            }
        }
    };

    private final String displayName;

    PaymentType(String displayName) {
        this.displayName = displayName;

    }
    @Override
    public abstract double calculateTotal(double basePrice);
    public abstract double getCommissionRate(double basePrice);

    public void printPaymentInfo(double basePrice) {
        double rate = getCommissionRate(basePrice);
        double total = calculateTotal(basePrice);
        double commission = total - basePrice;

        System.out.printf("""
                Спосіб оплати: %s
                Ціна квитка: %.2f грн
                Комісія: %.2f грн (%.1f%%)
                До сплати: %.2f грн
                ------------------------------
                """, getDisplayName(), basePrice, commission, rate * 100, total);
    }
}
