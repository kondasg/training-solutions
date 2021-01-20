package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    List<BankAccount> accountList = new ArrayList<>();

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void uploadListFromFile(String s) {
        Path file = Path.of(s);
        try {
            List<String> accounts = Files.readAllLines(file);
            for (String account: accounts) {
                String[] splittedAccount = account.split(";");
                accountList.add(new BankAccount(splittedAccount[0], splittedAccount[1], Integer.parseInt(splittedAccount[2])));
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void makeTransactions(String s) {
        Path file = Path.of(s);
        try {
            List<String> transactions = Files.readAllLines(file);
            for (String transaction: transactions) {
                String[] splittedTransaction = transaction.split(";");
                for (BankAccount bankAccount: accountList) {
                    if (bankAccount.getAccountNumber().equals(splittedTransaction[0])) {
                        bankAccount.setBalance(Integer.parseInt(splittedTransaction[1]));
                    }
                }
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
