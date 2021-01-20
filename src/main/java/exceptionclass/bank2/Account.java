package exceptionclass.bank2;

public class Account {

    private final String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null) {
            throw new IllegalArgumentException();
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maxSubtract = 100000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double amount) {
        amountTest(amount);
        this.maxSubtract = amount;
    }

    public double subtract(double amount) {
        amountTest(amount);
        if (balance < amount) {
            throw new LowBalanceBankOperationException(ErrorCode.LOW_BALANCE);
        }
        return balance -= amount;
    }

    public double deposit(double amount) {
        amountTest(amount);
        return balance += amount;
    }

    public void amountTest(double amount) {
        if (amount < 0) {
            throw new InvalidAmountBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
    }
}
