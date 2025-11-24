package ui;

import model.Bank;

import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {

    private Bank bank;

    private JTextField accountField;
    private JTextField toAccountField;
    private JTextField amountField;

    public TransactionsPanel(Bank bank) {
        this.bank = bank;
        setLayout(new GridLayout(5, 2, 5, 5));

        accountField = new JTextField();
        toAccountField = new JTextField();
        amountField = new JTextField();

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton transferButton = new JButton("Transfer");

        add(new JLabel("From account:"));
        add(accountField);
        add(new JLabel("To account (for transfer):"));
        add(toAccountField);
        add(new JLabel("Amount:"));
        add(amountField);
        add(depositButton);
        add(withdrawButton);
        add(transferButton);
        add(new JLabel("")); // filler

        depositButton.addActionListener(e -> doDeposit());
        withdrawButton.addActionListener(e -> doWithdraw());
        transferButton.addActionListener(e -> doTransfer());
    }

    private double parseAmount() {
        try {
            return Double.parseDouble(amountField.getText().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    private void doDeposit() {
        String acc = accountField.getText().trim();
        try {
            double amount = parseAmount();
            bank.deposit(acc, amount);
            JOptionPane.showMessageDialog(this, "Deposit successful");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void doWithdraw() {
        String acc = accountField.getText().trim();
        try {
            double amount = parseAmount();
            bank.withdraw(acc, amount);
            JOptionPane.showMessageDialog(this, "Withdraw successful");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void doTransfer() {
        String from = accountField.getText().trim();
        String to = toAccountField.getText().trim();
        try {
            double amount = parseAmount();
            bank.transfer(from, to, amount);
            JOptionPane.showMessageDialog(this, "Transfer successful");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
