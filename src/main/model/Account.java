package main.model;

public class Account {
    private String fullName;
    private String accountType;
    private String email;
    private String city;
    private String accountNumber;
    private String password;
    private String balance;
    private String username;

    // Constructors, getters, and setters
    public Account(String fullName, String accountType, String email, String city, String accountNumber, String password) {
        this.fullName = fullName;
        this.accountType = accountType;
        this.email = email;
        this.city = city;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;
    }

    public Account(String fullName, String username, String password, String city, double balance) {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBalance() {
        this.balance = balance;
        return "";
    }

    public void setAccountID(String trim) {
        return;
    }

    public String getUsername() {
        return username;
    }
}
