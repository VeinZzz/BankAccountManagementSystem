package main.ui;

import main.model.Account;

import javax.swing.*;

public class WithdrawMenu extends JFrame {
    private JPanel withdrawPanel;
    private JPanel navPanel;
    private JButton manageAccountButton;
    private JButton signOutButton;
    private JButton transactionHistoryButton;
    private JButton withdrawDepositButton;
    private JButton homeButton;
    private JLabel nameIcon;
    private JLabel nameLabel;
    private JPanel withdrawSide;
    private JLabel withdrawHeading;
    private JFormattedTextField withdrawAmountField;
    private JPanel btnPanel;
    private JButton goBackButton;
    private JButton withdrawButton;

    private Account account;

    public WithdrawMenu(Account account) {
        this.account = account;

        setTitle("Withdraw Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(withdrawPanel);
        setLocationRelativeTo(null);

        // Display user name in navigation bar
        nameLabel.setText("Welcome, " + account.getFullName());

        setVisible(true);

        setupListeners();
    }

    private void setupListeners() {
        withdrawButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Withdraw functionality coming soon!");
        });

        goBackButton.addActionListener(e -> {
            dispose();
            new TransactionMenu(account); // Navigate back to Transaction Menu
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
    }
}
