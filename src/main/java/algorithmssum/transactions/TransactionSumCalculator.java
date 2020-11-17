package algorithmssum.transactions;

import java.util.List;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction item: transactions) {
            if (item.isCredit()) sum += item.getAmount();
        }
        return sum;
    }
}
