package main.ui;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SignUp extends JFrame {
    JPanel signUpPanel;
    private JLabel signUpLabel;
    private JPanel signUpForm;
    private JTextField nameField;
    private JLabel nameLabel;
    private JLabel contactLabel;
    private JTextField contactField;
    private JLabel birthLabel;
    private JPanel birthFieldPlaceholder; // Placeholder for the JDateChooser
    private JLabel cityLabel;
    private JComboBox<String> cityField;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JPasswordField reEnterField;
    private JLabel reEnterLabel;
    private JPanel signBtns;
    private JButton backBtn;
    private JButton signUpBtn;
    private JLabel messageLabel;

    private JDateChooser birthField; // Actual JDateChooser component
    private static final String USERS_FILE_PATH = "src/data/users.txt";

    public SignUp() {
        setTitle("Sign Up - Bank Account Management System");
        setSize(550, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(signUpPanel);
        setLocationRelativeTo(null);
        setVisible(true);

        // Initialize the date picker (JDateChooser) and add it to the placeholder panel
        birthField = new JDateChooser();
        birthField.setDateFormatString("yyyy-MM-dd"); // Set date format
        birthFieldPlaceholder.setLayout(new java.awt.BorderLayout()); // Set layout for placeholder
        birthFieldPlaceholder.add(birthField); // Add JDateChooser to the placeholder panel

        // Populate cities
        populateCities();

        // Add event listeners
        setupListeners();
    }

    private void populateCities() {
        cityField.addItem("Select City");
        cityField.addItem("Alaminos");
        cityField.addItem("Angeles");
        cityField.addItem("Antipolo");
        cityField.addItem("Bacolod");
        cityField.addItem("Bacoor");
        cityField.addItem("Bago");
        cityField.addItem("Baguio");
        cityField.addItem("Bais");
        cityField.addItem("Balanga");
        cityField.addItem("Batac");
        cityField.addItem("Batangas City");
        cityField.addItem("Bayawan");
        cityField.addItem("Baybay");
        cityField.addItem("Bayugan");
        cityField.addItem("Biñan");
        cityField.addItem("Bislig");
        cityField.addItem("Bogo");
        cityField.addItem("Borongan");
        cityField.addItem("Butuan");
        cityField.addItem("Cabadbaran");
        cityField.addItem("Cabanatuan");
        cityField.addItem("Cabuyao");
        cityField.addItem("Cadiz");
        cityField.addItem("Cagayan de Oro");
        cityField.addItem("Calamba");
        cityField.addItem("Calapan");
        cityField.addItem("Calbayog");
        cityField.addItem("Caloocan");
        cityField.addItem("Candon");
        cityField.addItem("Canlaon");
        cityField.addItem("Carcar");
        cityField.addItem("Catbalogan");
        cityField.addItem("Cauayan");
        cityField.addItem("Cavite City");
        cityField.addItem("Cebu City");
        cityField.addItem("Dagat-dagatan");
        cityField.addItem("Dagupan");
        cityField.addItem("Danao");
        cityField.addItem("Dapitan");
        cityField.addItem("Dasmariñas");
        cityField.addItem("Davao City");
        cityField.addItem("Digos");
        cityField.addItem("Dipolog");
        cityField.addItem("Dumaguete");
        cityField.addItem("El Salvador");
        cityField.addItem("Escalante");
        cityField.addItem("Gapan");
        cityField.addItem("General Santos");
        cityField.addItem("General Trias");
        cityField.addItem("Gingoog");
        cityField.addItem("Guihulngan");
        cityField.addItem("Himamaylan");
        cityField.addItem("Ilagan");
        cityField.addItem("Iligan");
        cityField.addItem("Iloilo City");
        cityField.addItem("Imus");
        cityField.addItem("Iriga");
        cityField.addItem("Isabela");
        cityField.addItem("Kabankalan");
        cityField.addItem("Kidapawan");
        cityField.addItem("Koronadal");
        cityField.addItem("La Carlota");
        cityField.addItem("Lamitan");
        cityField.addItem("Laoag");
        cityField.addItem("Lapu-Lapu");
        cityField.addItem("Las Piñas");
        cityField.addItem("Legazpi");
        cityField.addItem("Ligao");
        cityField.addItem("Lipa");
        cityField.addItem("Lucena");
        cityField.addItem("Maasin");
        cityField.addItem("Mabalacat");
        cityField.addItem("Makati");
        cityField.addItem("Malabon");
        cityField.addItem("Malaybalay");
        cityField.addItem("Malolos");
        cityField.addItem("Mandaluyong");
        cityField.addItem("Mandaue");
        cityField.addItem("Manila");
        cityField.addItem("Marawi");
        cityField.addItem("Marikina");
        cityField.addItem("Masbate City");
        cityField.addItem("Mati");
        cityField.addItem("Meycauayan");
        cityField.addItem("Muñoz");
        cityField.addItem("Muntinlupa");
        cityField.addItem("Naga (Camarines Sur)");
        cityField.addItem("Naga (Cebu)");
        cityField.addItem("Navotas");
        cityField.addItem("Olongapo");
        cityField.addItem("Ormoc");
        cityField.addItem("Oroquieta");
        cityField.addItem("Ozamiz");
        cityField.addItem("Pagadian");
        cityField.addItem("Palayan");
        cityField.addItem("Panabo");
        cityField.addItem("Parañaque");
        cityField.addItem("Pasay");
        cityField.addItem("Pasig");
        cityField.addItem("Passi");
        cityField.addItem("Puerto Princesa");
        cityField.addItem("Quezon City");
        cityField.addItem("Roxas");
        cityField.addItem("Sagay");
        cityField.addItem("Samal");
        cityField.addItem("San Carlos (Negros Occidental)");
        cityField.addItem("San Carlos (Pangasinan)");
        cityField.addItem("San Fernando (La Union)");
        cityField.addItem("San Fernando (Pampanga)");
        cityField.addItem("San Jose");
        cityField.addItem("San Jose del Monte");
        cityField.addItem("San Juan");
        cityField.addItem("San Pablo");
        cityField.addItem("San Pedro");
        cityField.addItem("Santa Rosa");
        cityField.addItem("Santo Tomas");
        cityField.addItem("Santiago");
        cityField.addItem("Silay");
        cityField.addItem("Sipalay");
        cityField.addItem("Sorsogon City");
        cityField.addItem("Surigao City");
        cityField.addItem("Tabaco");
        cityField.addItem("Tabuk");
        cityField.addItem("Tacloban");
        cityField.addItem("Tagaytay");
        cityField.addItem("Tagbilaran");
        cityField.addItem("Taguig");
        cityField.addItem("Tagum");
        cityField.addItem("Talisay (Cebu)");
        cityField.addItem("Talisay (Negros Occidental)");
        cityField.addItem("Tanauan");
        cityField.addItem("Tandag");
        cityField.addItem("Tangub");
        cityField.addItem("Tanjay");
        cityField.addItem("Tarlac City");
        cityField.addItem("Tayabas");
        cityField.addItem("Toledo");
        cityField.addItem("Trece Martires");
        cityField.addItem("Tuguegarao");
        cityField.addItem("Urdaneta");
        cityField.addItem("Valencia");
        cityField.addItem("Valenzuela");
        cityField.addItem("Victorias");
        cityField.addItem("Vigan");
        cityField.addItem("Zamboanga City");
    }

    private void setupListeners() {
        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSignUp();
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LogIn();
                dispose();
            }
        });
    }

    private void handleSignUp() {
        String name = nameField.getText().trim();
        String contact = contactField.getText().trim();
        Date birthDate = birthField.getDate(); // Get date from JDateChooser
        String city = (String) cityField.getSelectedItem();
        String password = new String(passwordField.getPassword());
        String reEnterPassword = new String(reEnterField.getPassword());

        // Validate inputs

        if (messageLabel != null) {
            messageLabel.setText("All fields are required.");
            return;
        }

        if (name.isEmpty() || contact.isEmpty() || birthDate == null || "Select City".equals(city)) {
            messageLabel.setText("All fields are required.");
            return;
        }

        if (!password.equals(reEnterPassword)) {
            messageLabel.setText("Passwords do not match.");
            return;
        }

        if (password.length() < 6) {
            messageLabel.setText("Password must be at least 6 characters.");
            return;
        }

        if (isUserExists(contact)) {
            messageLabel.setText("User with this contact already exists.");
            return;
        }

        // Format birthDate as a string (e.g., yyyy-MM-dd)
        String birthDateString = new SimpleDateFormat("yyyy-MM-dd").format(birthDate);

        // Register the user
        boolean isRegistered = registerUser(name, contact, birthDateString, city, password);
        if (isRegistered) {
            JOptionPane.showMessageDialog(this, "Sign-Up Successful! Please log in.");
            new LogIn();
            dispose();
        } else {
            messageLabel.setText("Sign-Up failed. Please try again.");
        }
    }

    private boolean isUserExists(String contact) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(USERS_FILE_PATH));
            for (String line : lines) {
                String[] userDetails = line.split(",");
                if (userDetails.length > 1 && userDetails[1].equals(contact)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean registerUser(String name, String contact, String birthDate, String city, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE_PATH, true))) {
            writer.write(name + "," + contact + "," + birthDate + "," + city + "," + hashPassword(password));
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String hashPassword(String password) {
        return Arrays.toString(password.toCharArray());
    }
}