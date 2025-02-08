package RandomJava.src.bankmanager;

/**
 * Class representing a Savings Account.
 * This type of account earns interest over time.
 */
public class SavingsAccount extends BankAccount {
    // Attributes specific to Savings Account
    private double interestRate;

    // Constructor to initialize a Savings Account
    public SavingsAccount(String accountNumber, double balance, String accountHolderName, double interestRate) {
        super(accountNumber, balance, accountHolderName);
        this.interestRate = interestRate;
    }

    /**
     * Withdraw money from the Savings Account.
     * @param amount the amount to withdraw.
     */
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return;
        }
        if (balance - amount < 0) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " from the account.");
    }

    /**
     * Display Savings Account information.
     */
    @Override
    public void displayAccountInfo() {
        System.out.println("Savings Account Information");
        System.out.println("---------------------------------------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("---------------------------------------");
        System.out.println();
    }
}
