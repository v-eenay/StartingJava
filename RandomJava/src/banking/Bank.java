package RandomJava.src.banking; // Declares that this class belongs to the 'banking' package

import java.util.Scanner; // Imports the Scanner class from java.util package to read user input

/**
 * Represents a bank for managing accounts.
 */
public class Bank { // Defines the Bank class
    public static void main(String[] args) { // Main method - entry point of the program
        Bank bank = new Bank(); // Creates a new instance of the Bank class
        bank.run(); // Calls the run method on the bank instance
    }
    public void run() { // Method to handle the banking operations
        System.out.println("Welcome to the bank! What is your name?"); // Displays welcome message
        Scanner scanner = new Scanner(System.in); // Creates a Scanner object to read input from console
        String name = scanner.nextLine(); // Reads the user's name from input
        
        System.out.println("Hello, " + name + "! What type of account would you like to open?"); // Greets user and asks for account type
        String accountType = scanner.nextLine(); // Reads the account type from input
        
        System.out.println("How much money would you like to deposit?"); // Asks for initial deposit amount
        double balance = scanner.nextDouble(); // Reads the initial deposit amount
        
        BankAccount account = new BankAccount(accountType, balance); // Creates a new bank account with specified type and balance
        
        System.out.println("Thank you for opening an account with us, " + name + "!"); // Confirms account creation
        System.out.println("Your account details are as follows:"); // Introduces account details
        account.display(); // Displays the account information
        
        System.out.println("Would you like to make a deposit or withdrawal?"); // Asks for transaction type
        String transactionType = scanner.next(); // Reads the transaction type
        
        if (transactionType.equals("deposit")) { // Checks if user wants to make a deposit
            System.out.println("How much money would you like to deposit?"); // Asks for deposit amount
            double amount = scanner.nextDouble(); // Reads the deposit amount
            account.deposit(amount); // Performs the deposit
            System.out.println("Your account details are as follows:"); // Introduces updated account details
            account.display(); // Displays the updated account information
        } else if (transactionType.equals("withdrawal")) { // Checks if user wants to make a withdrawal
            System.out.println("How much money would you like to withdraw?"); // Asks for withdrawal amount
            double amount = scanner.nextDouble(); // Reads the withdrawal amount
            account.withdraw(amount); // Performs the withdrawal
            System.out.println("Your account details are as follows:"); // Introduces updated account details
            account.display(); // Displays the updated account information
        } else {
            System.out.println("Invalid transaction type"); // Displays error for invalid transaction type
        }        
        scanner.close(); // Closes the Scanner object to prevent resource leak
    }
}