package RandomJava.src.bankmanager;

/**
 * Class representing a Checking Account.
 * This type of account allows for overdrafts up to a specified limit.
 */
public class CheckingAccount extends BankAccount {
    // Attributes specific to Checking Account
    private double limit;

    // Constructor to initialize a Checking Account
    public CheckingAccount(String accountNumber, double balance, String accountHolderName, double limit) {
        super(accountNumber, balance, accountHolderName);
        this.limit = limit;
    }

    /**
     * Withdraw money from the Checking Account.
     * @param amount the amount to withdraw.
     */
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return;
        }
        if (balance - amount < -limit) {
            System.out.println("Insufficient funds.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn Rs. " + amount + " from the account.");
    }

    /**
     * Display Checking Account information.
     */
    @Override
    public void displayAccountInfo() {
        System.out.println("Checking Account Information");
        System.out.println("---------------------------------------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Overdraft Limit: Rs. " + limit);
        System.out.println("---------------------------------------");
        System.out.println();
    }
}
