package main.ui;

import main.model.Account;

import javax.swing.*;

public class DepositMenu extends JFrame {
    private JPanel depositPanel;
    private JPanel navPanel;
    private JLabel iconLabel;
    private JLabel nameLabel;
    private JButton signOutButton;
    private JButton manageAccountButton;
    private JButton transactionHistoryButton;
    private JButton withdrawDepositButton;
    private JButton homeButton;
    private JPanel depositSide;
    private JLabel depositHeading;
    private JFormattedTextField depositAmountField;
    private JPanel btnPanel;
    private JButton depositButton;

    private Account account;

    public DepositMenu(Account account) {
        this.account = account; // Store account data

        setTitle("Deposit Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(depositPanel);
        setLocationRelativeTo(null);

        // Display user name in navigation bar
        nameLabel.setText("Welcome, " + account.getFullName());

        setVisible(true);

        setupListeners();
    }

    private void setupListeners() {
        depositButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Deposit functionality coming soon!");
        });

        homeButton.addActionListener(e -> {
            dispose();
            new MainMenuForm(account); // Navigate back to Main Menu
        });

        signOutButton.addActionListener(e -> {
            dispose();
            new LogIn(); // Navigate to Login screen
        });

        manageAccountButton.addActionListener(e -> {
            dispose();
            new AccountDetails(account); // Navigate to Account Details
        });

        withdrawDepositButton.addActionListener(e -> {
            dispose();
            new TransactionMenu(account); // Navigate to Transaction Menu
        });
    }
}
