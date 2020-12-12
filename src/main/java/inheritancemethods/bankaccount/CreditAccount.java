package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        long debit = amount + super.costOfTransaction(amount);
        if ( debit < super.getBalance() + overdraftLimit) {
            if ( debit < super.getBalance() ) {
                super.setBalance(super.getBalance() - debit);
            }
            else {
                overdraftLimit -= debit - super.getBalance();
                super.balanceToZero();
            }
            return true;
        }
        return false;
    }
}
