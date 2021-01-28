package initializer.initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private long balance;
    private static final List<Rate> RATES = new ArrayList<>();

    public CreditCard(long balance, Currency currency, List<Rate> rate) {
        RATES.addAll(rate);
        this.balance = (long) (balance * conversionFactor(currency));
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    private double conversionFactor(Currency currency) {
        double conversionFactor = 1;
        for (Rate rate: RATES) {
            if (currency.equals(rate.getCurrency())) {
                conversionFactor = rate.getConversionFactor();
            }
        }
        return conversionFactor;
    }

    public boolean payment(long amount, Currency currency) {
        long pay = (long) (amount * conversionFactor(currency));
        if (pay >= balance) {
            return false;
        }
        else {
            balance -= pay;
            return true;
        }
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }
}
