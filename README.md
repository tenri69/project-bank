# Simple Bank Application (Java Swing)

A small desktop bank application built with Java and Swing.  
The focus of this project is to practice basic object-oriented programming, GUI programming, and simple business logic.

## Features

- Create new bank accounts
- List all accounts with owner name and current balance
- Deposit money to an account
- Withdraw money from an account (with balance check)
- Transfer money between two accounts
- Basic input validation and error messages

## Technology

- Java (JDK 8+)
- Swing for the graphical user interface
- Simple in-memory data model (no database)

## Project Structure

```text
src/
  model/
    Account.java        // Represents a bank account (owner, account number, balance)
    Bank.java           // Manages all accounts and operations (create, deposit, withdraw, transfer)
    Transaction.java    // Represents a transaction (type, amount, accounts, time)
    TransactionType.java// Enum describing transaction types (DEPOSIT, WITHDRAW, TRANSFER)

  ui/
    BankFrame.java      // Main application window (JFrame, tabs for accounts and transactions)
    AccountsPanel.java  // GUI for creating accounts and listing all accounts
    TransactionsPanel.java // GUI for deposit, withdraw, and transfer
