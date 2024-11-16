package main;

import main.ui.LogIn;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LogIn().setVisible(true);
        });
    }
}
