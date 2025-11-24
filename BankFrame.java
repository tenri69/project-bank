package ui;

import model.Bank;

import javax.swing.*;
import java.awt.*;

public class BankFrame extends JFrame {

    private Bank bank;

    public BankFrame() {
        this.bank = new Bank();
        setTitle("Simple Bank Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Accounts", new AccountsPanel(bank));
        tabbedPane.addTab("Transactions", new TransactionsPanel(bank));

        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankFrame frame = new BankFrame();
            frame.setVisible(true);
        });
    }
}
