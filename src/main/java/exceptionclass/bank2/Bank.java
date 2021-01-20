package exceptionclass.bank2;

import java.util.List;

public class Bank {

    List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException();
        }
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double amount) {
        for (Account account: accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.subtract(amount);
                return;
            }
        }
        throw new InvalidAccountNumberBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }

    public void deposit(String accountNumber, double amount) {
        for (Account account: accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                return;
            }
        }
        throw new InvalidAccountNumberBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }
}
