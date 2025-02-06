package banking;

public class BankAccount {
    // Instance variables
    private String accountType;
    private double balance;
    Customer customer;

    // Constructor
    public BankAccount(String accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getter and Setter methods
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
    }
    // Method to withdraw money
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
    // Method to display account details
    public void display() {
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
    // Method to display customer details
    public void displayCustomer() {
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Address: " + customer.getAddress());
    }
}
