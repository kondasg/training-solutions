package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {
    public int countWithBalanceGreaterThan(List<BankAccount> bankAccounts, int minBalance) {
        int count = 0;
        for (BankAccount bankAccount : bankAccounts ) {
            if (bankAccount.getBalance() > minBalance) count++;
        }
        return count;
    }
}
