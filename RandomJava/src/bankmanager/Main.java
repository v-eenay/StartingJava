package RandomJava.src.bankmanager;

import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

/**
 * Main class for the Bank Account Management System.
 * This class handles all the core banking operations and user interactions.
 */
public class Main {
    // ArrayList to store all bank accounts
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    // File path where account data will be stored
    private static final String FILE_PATH = "accounts.txt";

    /**
     * Main method - Entry point of the program.
     * Initializes the GUI for user interaction.
     */
    public static void main(String[] args) {
        loadAccounts(); // Load existing accounts from file when starting
        SwingUtilities.invokeLater(() -> {
            BankAccountGUI gui = new BankAccountGUI();
            gui.setVisible(true);
        });
    }

    /**
     * Creates a new bank account based on user input.
     * Supports creation of both Savings and Checking accounts.
     */
    public static void createAccount(String accountNumber, String accountHolderName, double balance, int accountType,
            double additionalInfo) {
        BankAccount account = null;
        // Create appropriate account type based on user choice
        try {
            if (accountType == 1) {
                account = new SavingsAccount(accountNumber, balance, accountHolderName, additionalInfo);
            } else if (accountType == 2) {
                account = new CheckingAccount(accountNumber, balance, accountHolderName, additionalInfo);
            } else if (accountType == 3) {
                account = new CertificateOfDeposit(accountNumber, balance, accountHolderName, additionalInfo,
                        (int) additionalInfo);
            } else {
                throw new IllegalArgumentException("Invalid account type. Please enter 1, 2, or 3.");
            }
            accounts.add(account);
            saveAccounts(); // Save the new account to file
            JOptionPane.showMessageDialog(null, "Account created successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error creating account: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Handles money deposit operation.
     * Finds account by number and adds the specified amount.
     */
    public static void depositMoney(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            try {
                account.deposit(amount);
                saveAccounts();
                JOptionPane.showMessageDialog(null, "Deposit successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error depositing money: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account not found. Please enter a valid account number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Handles money withdrawal operation.
     * Finds account by number and withdraws the specified amount if possible.
     */
    public static void withdrawMoney(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            try {
                account.withdraw(amount);
                saveAccounts();
                JOptionPane.showMessageDialog(null, "Withdrawal successful!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Insufficient funds or withdrawal limit exceeded.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error withdrawing money: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account not found. Please enter a valid account number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays account information for a specified account number or name.
     */
    public static void displayAccountInfo(String searchTerm) {
        BankAccount account = findAccount(searchTerm);
        if (account != null) {
            JOptionPane.showMessageDialog(null, account.toString(), "Account Information",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Account not found. Please enter a valid account number or name.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Helper method to find an account by account number or account holder name.
     * 
     * @param searchTerm the account number or name to search for.
     * @return the found BankAccount object or null if not found.
     */
    private static BankAccount findAccount(String searchTerm) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(searchTerm)
                    || account.getAccountHolderName().equalsIgnoreCase(searchTerm)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Saves all accounts to a file using object serialization.
     */
    private static void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    /**
     * Loads all accounts from file using object deserialization.
     * Creates new ArrayList if file doesn't exist or there's an error.
     */
    @SuppressWarnings("unchecked")
    private static void loadAccounts() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                accounts = (ArrayList<BankAccount>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading accounts: " + e.getMessage());
                accounts = new ArrayList<>();
            }
        }
    }
}
