package RandomJava.src.bankmanager;

import java.io.Serializable;

/**
 * Base class for bank accounts.
 * This class provides basic functionality for all types of bank accounts.
 */
public abstract class BankAccount implements Serializable {
    // Attributes common to all bank accounts
    protected String accountNumber;
    protected double balance;
    protected String accountHolderName;

    // Constructor to initialize a bank account
    public BankAccount(String accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    /**
     * Get the account number.
     * @return the account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Get the account holder's name.
     * @return the account holder's name.
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Get the current balance.
     * @return the current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposit money into the account.
     * @param amount the amount to deposit.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return;
        }
        balance += amount;
        System.out.println("Deposited Rs. " + amount + " to the account.");
    }

    /**
     * Withdraw money from the account.
     * @param amount the amount to withdraw.
     */
    public abstract void withdraw(double amount);

    /**
     * Display account information.
     */
    public abstract void displayAccountInfo();

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\n" +
               "Account Holder: " + accountHolderName + "\n" +
               "Balance: Rs. " + balance;
    }
}
