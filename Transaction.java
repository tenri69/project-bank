package model;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime time;
    private TransactionType type;
    private String fromAccount;
    private String toAccount;
    private double amount;

    public Transaction(TransactionType type, String fromAccount, String toAccount, double amount) {
        this.time = LocalDateTime.now();
        this.type = type;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    // getters...
}
