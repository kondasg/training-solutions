package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccount {
    private final String nameOfOwner;
    private final String accountNumber;
    private final int balance;

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}