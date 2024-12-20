package main.services;

import main.model.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AuthService {

    private static final String USERS_FILE_PATH = "BankAccountManagementSystem-main/src/data/users.txt";

    // Method to authenticate user by username and password
    public Account authenticate(String inputUsername, String inputPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line by comma
                String[] userDetails = line.split(",");

                // Ensure the userDetails array has enough data for account details
                if (userDetails.length < 5) { // Adjust based on the expected data in each line
                    continue; // Skip this line if it doesn't have enough information
                }

                // Extract account details from the line
                String username = userDetails[0].trim();
                String password = userDetails[1].trim();
                String fullName = userDetails[2].trim();
                String city = userDetails[3].trim();
                double balance;

                // Parse balance from the userDetails array
                try {
                    balance = Double.parseDouble(userDetails[4].trim());
                } catch (NumberFormatException e) {
                    balance = 0.0; // Default balance if parsing fails
                }

                // Compare input with stored username and password
                if (username.equals(inputUsername) && password.equals(inputPassword)) {
                    // Authentication successful, return an Account object
                    return new Account(fullName, username, password, city, balance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if authentication fails
    }

}
