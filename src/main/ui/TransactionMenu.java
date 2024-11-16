package main.ui;

import main.model.Account;

import javax.swing.*;

public class TransactionMenu extends JFrame {
    private JPanel transacMenu;
    private JPanel navPanel;
    private JLabel nameLabel;
    private JButton homeButton;
    private JButton withdrawDepositButton;
    private JButton transactionHistoryButton;
    private JButton manageAccountButton;
    private JButton signOutButton;
    private JLabel navNameLabel;
    private JPanel choosePanel;
    private JLabel transacHeading;
    private JPanel transacBtnPanel;
    private JButton withdrawButton;
    private JButton depositButton;
    private JLabel chooseLabel;

    private Account account;

    public TransactionMenu(Account account) {
        this.account = account; // Store account data

        setTitle("Transaction Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(transacMenu);
        setLocationRelativeTo(null);

        // Display user name
        navNameLabel.setText("Welcome, " + account.getFullName());

        setVisible(true);

        setupListeners();
    }

    private void setupListeners() {
        withdrawButton.addActionListener(e -> openWithdrawMenu());
        depositButton.addActionListener(e -> openDepositMenu());
        manageAccountButton.addActionListener(e -> openAccountDetails());

        homeButton.addActionListener(e -> {
            dispose();
            new MainMenuForm(account); // Navigate back to Main Menu
        });

        signOutButton.addActionListener(e -> {
            dispose();
            new LogIn(); // Navigate to Login
        });
    }

    private void openWithdrawMenu() {
        dispose();
        new WithdrawMenu(account);
    }

    private void openDepositMenu() {
        dispose();
        new DepositMenu(account);
    }

    private void openAccountDetails() {
        dispose();
        new AccountDetails(account);
    }
}