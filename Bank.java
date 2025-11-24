package model;

import java.util.*;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String ownerName) {
        String accountNumber = "ACC-" + (accounts.size() + 1);
        Account account = new Account(accountNumber, ownerName);
        accounts.put(accountNumber, account);
        return account;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public void deposit(String accountNumber, double amount) {
        Account acc = getAccount(accountNumber);
        if (acc == null) {
            throw new IllegalArgumentException("Account not found");
        }
        acc.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) {
        Account acc = getAccount(accountNumber);
        if (acc == null) {
            throw new IllegalArgumentException("Account not found");
        }
        acc.withdraw(amount);
    }

    public void transfer(String fromAcc, String toAcc, double amount) {
        if (fromAcc.equals(toAcc)) {
            throw new IllegalArgumentException("Accounts must be different");
        }
        Account from = getAccount(fromAcc);
        Account to = getAccount(toAcc);
        if (from == null || to == null) {
            throw new IllegalArgumentException("Account not found");
        }
        from.withdraw(amount);
        to.deposit(amount);
    }
}
