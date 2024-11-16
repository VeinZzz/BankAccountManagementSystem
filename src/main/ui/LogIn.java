package main.ui;

import main.model.Account;
import main.services.AuthService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {
    private JPanel logInPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton logInBtn;
    private JButton signUpBtn;
    private JLabel messageLabel;
    private JPanel infoFields; // Declare the field to match the form binding
    private JPanel btnPanel;
    private JLabel logInLabel;
    private static final String USERS_FILE_PATH = "src/data/users.txt";

    public LogIn() {
        setTitle("Log In - Bank Account Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(logInPanel);
        setLocationRelativeTo(null);
        setVisible(true);

        // Initialize the AuthService
        AuthService authService = new AuthService();

        // Set up the login button action
        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogIn(authService);
            }
        });

        // Set up the sign-up button action
        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp();
                dispose(); // Close the login form
            }
        });
    }

    private void handleLogIn(AuthService authService) {
        // Get the username and password input
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Authenticate user and get account
        Account account = authService.authenticate(username, password);

        if (account != null) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            new MainMenuForm(account); // Pass Account object to MainMenuForm
            dispose(); // Close the login form
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect username or password.");
        }
    }
}
