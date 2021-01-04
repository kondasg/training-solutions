package staticattrmeth.bank;

import java.math.BigDecimal;

public class BankTransaction {

    private static final long MIN = 1;
    private static final long MAX = 10_000_000;
    private static long currentMinValue;
    private static long currentMaxValue;
    private static BigDecimal sumOfTrxs;
    private static int counter;

    private final long trxValue;

    public BankTransaction(long trxValue) {
        if (MIN > trxValue || MAX < trxValue) {
            throw new IllegalArgumentException();
        }
        this.trxValue = trxValue;
        sumOfTrxs = sumOfTrxs.add(BigDecimal.valueOf(trxValue));
        counter++;
        if (counter == 1) {
            currentMinValue = currentMaxValue = trxValue;
        }
        else {
            if (trxValue < currentMinValue) currentMinValue = trxValue;
            if (trxValue > currentMaxValue) currentMaxValue = trxValue;
        }
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static long getCurrentMinValue() {
        return counter == 0 ? 0 : currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return counter == 0 ? 0 : currentMaxValue;
    }

    public static void initTheDay() {
        currentMinValue = MIN;
        currentMaxValue = MAX;
        sumOfTrxs = BigDecimal.valueOf(0);
        counter = 0;
    }

    public static BigDecimal averageOfTransaction() {
        return counter == 0 ? BigDecimal.valueOf(0) : sumOfTrxs.divide(BigDecimal.valueOf(counter));
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTrxs;
    }


}
