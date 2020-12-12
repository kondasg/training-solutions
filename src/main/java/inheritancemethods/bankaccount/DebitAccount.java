package inheritancemethods.bankaccount;

public class DebitAccount {

    private final String accountNumber;
    private long balance;
    private final double COST = 3.0;
    private final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public final long costOfTransaction(long amount) {
        double transactionCost = amount * (COST / 100);
        if (transactionCost < MIN_COST) {
            return MIN_COST;
        }
        else {
            return (long) transactionCost;
        }
    }

    public boolean transaction(long amount) {
        long debit = amount + costOfTransaction(amount);
        if ( debit < balance) {
            balance -= debit;
            return true;
        }
        return false;
    }

    public void balanceToZero() {
        balance = 0;
    } // az egyenleget nullázza le, túlköltés esetén


}
