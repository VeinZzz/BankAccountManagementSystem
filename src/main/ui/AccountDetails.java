package main.ui;

import main.model.Account;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccountDetails extends JFrame {
    private JPanel mainPanel;
    private JPanel navPanel;
    private JLabel navNameLabel;
    private JButton homeButton;
    private JButton signOutButton;
    private JButton withdrawDepositButton;
    private JButton transactionHistoryButton;
    private JButton manageAccountButton;
    private JLabel accIcon;
    private JPanel accInfoPanel;
    private JLabel accHeading;
    private JTextField nameField;
    private JLabel nameLabel;
    private JLabel accTypeLabel;
    private JTextField accTypeField;
    private JLabel emailAddLabel;
    private JTextField emailAddField;
    private JLabel locationLabel;
    private JTextField locationField;
    private JLabel accNumLabel;
    private JTextField accNumField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JPanel accBtns;
    private JButton changeInfoBtn;
    private JButton deleteAccBtn;

    private Account account;

    private static final String USERS_FILE_PATH = "BankAccountManagementSystem-main/src/data/users.txt";

    public AccountDetails(Account account) {
        this.account = account;

        setTitle("Account Details - Bank Account Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(800, 600);

        addBordersToLabels();
        populateAccountDetails();
        setupListeners();
    }

    // Method to populate fields with account data in a non-editable format
    private void populateAccountDetails() {
        // If account data is missing or incomplete, load from file
        if (account.getFullName() == null || account.getEmail() == null || account.getAccountNumber() == null) {
            loadAccountDataFromFile(account.getUsername());
        }

        // Set text fields with account data
        nameField.setText(account.getFullName());
        accTypeField.setText(account.getAccountType());
        emailAddField.setText(account.getEmail());
        locationField.setText(account.getCity());
        accNumField.setText(account.getAccountNumber());
        passwordField.setText(account.getPassword());
        passwordField.setEditable(false); // Mask password as non-editable
    }

    // Method to load account data from the text file based on the username
    private void loadAccountDataFromFile(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");

                // Assuming the format is username, password, fullName, city, accountType, accountNumber, email
                if (userDetails.length >= 7 && userDetails[0].trim().equals(username)) {
                    // Populate account details if found
                    account.setFullName(userDetails[2].trim());
                    account.setCity(userDetails[3].trim());
                    account.setAccountType(userDetails[4].trim());
                    account.setAccountID(userDetails[5].trim());
                    account.setEmail(userDetails[6].trim());
                    break; // Stop reading once the account is found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading account details from file.");
        }
    }

    // Method to add borders to nameField and emailAddField
    private void addBordersToLabels() {
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        nameField.setBorder(border);
        emailAddField.setBorder(border);
    }

    private void setupListeners() {
        homeButton.addActionListener(e -> openMainMenu());
        transactionHistoryButton.addActionListener(e -> openTransactionHistory());
        withdrawDepositButton.addActionListener(e -> openTransactionMenu());

        signOutButton.addActionListener(e -> {
            dispose();
            new LogIn();
        });

        changeInfoBtn.addActionListener(e -> changeAccountInfo());
        deleteAccBtn.addActionListener(e -> deleteAccount());
    }


    private void openMainMenu() {
        dispose();
        new MainMenuForm(account);
    }

    private void openTransactionHistory() {
        dispose();
        //new TransactionHistoryForm(account);
    }

    private void openTransactionMenu() {
        dispose();
        new TransactionMenu(account);
    }


    // Method to handle changing account information
    private void changeAccountInfo() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to save changes?", "Confirm Update", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            account.setFullName(nameField.getText());
            account.setAccountType(accTypeField.getText());
            account.setEmail(emailAddField.getText());
            account.setCity(locationField.getText());
            account.setPassword(new String(passwordField.getPassword()));

            JOptionPane.showMessageDialog(this, "Account information updated successfully.");
            // Save changes to file (if applicable)
        }
    }

    // Method to handle account deletion
    private void deleteAccount() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this account? This action cannot be undone.",
                "Delete Account", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Logic to delete the account (e.g., remove from file or database)
            JOptionPane.showMessageDialog(this, "Account deleted successfully.");
            dispose();
            new LogIn();
        }
    }
}
