package ui;

import model.Account;
import model.Bank;

import javax.swing.*;
import java.awt.*;

public class AccountsPanel extends JPanel {

    private Bank bank;
    private DefaultListModel<String> accountListModel;
    private JList<String> accountList;
    private JTextField ownerField;

    public AccountsPanel(Bank bank) {
        this.bank = bank;
        setLayout(new BorderLayout());

        // Top: create account
        JPanel createPanel = new JPanel();
        createPanel.add(new JLabel("Owner:"));
        ownerField = new JTextField(15);
        createPanel.add(ownerField);
        JButton createButton = new JButton("Create account");
        createPanel.add(createButton);

        add(createPanel, BorderLayout.NORTH);

        // Center: list accounts
        accountListModel = new DefaultListModel<>();
        accountList = new JList<>(accountListModel);
        add(new JScrollPane(accountList), BorderLayout.CENTER);

        createButton.addActionListener(e -> {
            String owner = ownerField.getText().trim();
            if (owner.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Owner name is required");
                return;
            }
            Account acc = bank.createAccount(owner);
            ownerField.setText("");
            refreshAccountList();
            JOptionPane.showMessageDialog(this, "Created account " + acc.getAccountNumber());
        });

        refreshAccountList();
    }

    private void refreshAccountList() {
        accountListModel.clear();
        for (Account acc : bank.getAllAccounts()) {
            accountListModel.addElement(
                    acc.getAccountNumber() + " - " + acc.getOwnerName() + " (Balance: " + acc.getBalance() + ")"
            );
        }
    }
}
