package RandomJava.src.bankmanager;

/**
 * Class representing a Certificate of Deposit account.
 * This type of account earns interest over a fixed maturity period.
 */
public class CertificateOfDeposit extends BankAccount {
    // Attributes specific to Certificate of Deposit
    private double interestRate;
    private int maturityPeriod;

    // Constructor to initialize a Certificate of Deposit account
    public CertificateOfDeposit(String accountNumber, double balance, String accountHolderName, double interestRate,
            int maturityPeriod) {
        super(accountNumber, balance, accountHolderName);
        this.interestRate = interestRate;
        this.maturityPeriod = maturityPeriod;
    }

    /**
     * Withdraw money from the Certificate of Deposit account.
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
        System.out.println("Certificate of Deposit matured.");
        System.out.println("Interest earned: $" + (balance * interestRate / 100));
        balance += balance * interestRate / 100;
        System.out.println("New balance after maturity: $" + balance);
    }

    /**
     * Display Certificate of Deposit account information.
     */
    @Override
    public void displayAccountInfo() {
        System.out.println("Certificate of Deposit Information");
        System.out.println("---------------------------------------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Maturity Period: " + maturityPeriod + " years");
        System.out.println("---------------------------------------");
        System.out.println();
    }
}
