package main.ui;

import main.model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuForm extends JFrame {
    private JPanel navPanel;
    private JPanel mainFrame;
    private JButton accountDetailsButton;
    private JButton depositWithdrawButton;
    private JButton transactionHistoryButton;
    private JLabel bankAccountTitle;
    private JButton signOutButton;
    private JLabel accountBalance;

    private Account account; // Reference to Account data

    // Constructor that accepts an Account object
    public MainMenuForm(Account account) {
        this.account = account; // Store the account data for passing to other forms

        setTitle("Main Menu - Bank Account Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);

        // Set background color for accountBalance similar to other components
        Color backgroundColor = new Color(192, 133, 82); // Adjust this to match the button background
        accountBalance.setOpaque(true); // Make the background color visible
        accountBalance.setBackground(backgroundColor);
        accountBalance.setForeground(Color.WHITE); // Set text color for contrast

        // Dynamically set the account balance text
        //accountBalance.setText("Balance: $" + String.format("%.2f", account.getBalance()));

        setVisible(true);

        // Set up event listeners
        setupListeners();
    }

    private void setupListeners() {
        accountDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Account Details Form with account data
                new AccountDetails(account); // Pass account data to AccountDetails
                dispose(); // Optionally close MainMenuForm
            }
        });

        depositWithdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Deposit/Withdraw Form
                new TransactionMenu(account); // Pass account data to TransactionMenu
                dispose(); // Close MainMenuForm if needed
            }
        });

        transactionHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Transaction History Form
                //new TransactionHistoryForm(account); // Pass account data to TransactionHistoryForm
                dispose(); // Close MainMenuForm if needed
            }
        });

        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sign out and return to login screen
                new LogIn();
                dispose(); // Close MainMenuForm
            }
        });
    }
}
