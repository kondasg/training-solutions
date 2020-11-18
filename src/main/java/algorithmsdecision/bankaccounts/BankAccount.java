package algorithmsdecision.bankaccounts;

public class BankAccount {

    private final String nameOfOwner;
    private final String accountNumber;
    private int balance;

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {
        if ( balance - amount >= 0 ) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(int amount) {
        balance += amount;
        return true;
    }

}
