package RandomJava.src.bankmanager;

// Import necessary Swing and AWT libraries for GUI components
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI class for the Bank Account Management System.
 * Provides a custom dark-themed, professional interface for user interactions.
 * This class extends JFrame to create the main application window.
 */
public class BankAccountGUI extends JFrame {

    /**
     * Constructor: Initializes the main application window
     * Sets up the basic frame properties and applies custom styling
     */
    public BankAccountGUI() {
        // Configure the main window properties
        setTitle("Bank Account Management System");
        setSize(600, 400);                           // Set window dimensions
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define what happens when window is closed
        setLocationRelativeTo(null);                 // Center the window on screen
        setLayout(new BorderLayout());               // Use BorderLayout for component arrangement

        // Apply our custom dark theme to the GUI
        applyDarkTheme();

        // Set up all GUI components
        createComponents();
    }

    /**
     * Applies a custom dark theme to all GUI components
     * Sets colors for various UI elements to create a cohesive dark theme
     */
    private void applyDarkTheme() {
        // Set dark colors for main container
        getContentPane().setBackground(new Color(30, 30, 30));
        
        // Configure colors for various UI components
        UIManager.put("Panel.background", new Color(40, 40, 40));     // Panel background
        UIManager.put("Panel.foreground", Color.WHITE);               // Panel text
        UIManager.put("Label.foreground", Color.WHITE);               // Label text
        UIManager.put("Button.background", new Color(50, 50, 50));    // Button background
        UIManager.put("Button.foreground", Color.WHITE);              // Button text
        UIManager.put("Button.focus", new Color(70, 70, 70));         // Button focus state
        UIManager.put("TextField.background", new Color(50, 50, 50)); // Text field background
        UIManager.put("TextField.foreground", Color.WHITE);           // Text field text
        UIManager.put("TextField.caretForeground", Color.WHITE);      // Text field cursor
        UIManager.put("ComboBox.background", new Color(50, 50, 50));  // Dropdown background
        UIManager.put("ComboBox.foreground", Color.WHITE);            // Dropdown text
    }

    /**
     * Creates and arranges all main components of the GUI
     * Sets up the main menu with various banking operation buttons
     */
    private void createComponents() {
        // Create main menu panel with grid layout
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(6, 1, 15, 15));  // 6 rows, 1 column, with gaps
        menuPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // Create buttons for different banking operations
        JButton createAccountButton = createStyledButton("Create a new account");
        JButton depositButton = createStyledButton("Deposit money");
        JButton withdrawButton = createStyledButton("Withdraw money");
        JButton displayInfoButton = createStyledButton("Display account information");
        JButton searchByNameButton = createStyledButton("Search account by name");
        JButton exitButton = createStyledButton("Exit");

        // Apply custom hover effects to each button with different colors
        styleButton(createAccountButton, new Color(75, 110, 175));    // Blue shade
        styleButton(depositButton, new Color(75, 145, 80));          // Green shade
        styleButton(withdrawButton, new Color(175, 75, 75));         // Red shade
        styleButton(displayInfoButton, new Color(100, 80, 155));     // Purple shade
        styleButton(searchByNameButton, new Color(155, 100, 80));    // Brown shade
        styleButton(exitButton, new Color(120, 120, 120));          // Gray shade

        // Add action listeners to handle button clicks
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAccount();  // Handle create account action
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                depositMoney();   // Handle deposit action
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdrawMoney();  // Handle withdraw action
            }
        });

        displayInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAccountInfo();  // Handle display info action
            }
        });

        searchByNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchAccountByName();  // Handle search action
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Exit the application
            }
        });

        // Add all buttons to the menu panel
        menuPanel.add(createAccountButton);
        menuPanel.add(depositButton);
        menuPanel.add(withdrawButton);
        menuPanel.add(displayInfoButton);
        menuPanel.add(searchByNameButton);
        menuPanel.add(exitButton);

        // Add the complete menu panel to the main frame
        add(menuPanel, BorderLayout.CENTER);
    }

    /**
     * Creates a styled button with consistent formatting
     * @param text The text to display on the button
     * @return A formatted JButton
     */
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);                          // Remove focus border
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));   // Set custom font
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));       // Change cursor on hover
        return button;
    }

    /**
     * Applies hover effects to a button
     * @param button The button to style
     * @param hoverColor The color to show when hovering
     */
    private void styleButton(JButton button, Color hoverColor) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            // Change color when mouse enters button area
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            // Restore original color when mouse exits button area
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(50, 50, 50));
            }
        });
    }

    /**
     * Handles the creation of a new bank account
     * Displays a dialog to collect account information
     */
    private void createAccount() {
        // Create input fields for account details
        JTextField accountNumberField = new JTextField();
        JTextField accountHolderNameField = new JTextField();
        JTextField balanceField = new JTextField();
        JTextField additionalInfoField = new JTextField();
        JComboBox<String> accountTypeComboBox = new JComboBox<>(
                new String[] { "Savings", "Checking", "Certificate of Deposit" });

        // Create and configure the input panel
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Add input fields to the panel
        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);
        panel.add(new JLabel("Account Holder Name:"));
        panel.add(accountHolderNameField);
        panel.add(new JLabel("Initial Balance:"));
        panel.add(balanceField);
        panel.add(new JLabel("Interest Rate/Overdraft Limit/Maturity Period:"));
        panel.add(additionalInfoField);
        panel.add(new JLabel("Account Type:"));
        panel.add(accountTypeComboBox);

        // Show dialog and process input
        int result = JOptionPane.showConfirmDialog(null, panel, "Create Account", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Get values from input fields
                String accountNumber = accountNumberField.getText();
                String accountHolderName = accountHolderNameField.getText();
                double balance = Double.parseDouble(balanceField.getText());
                double additionalInfo = Double.parseDouble(additionalInfoField.getText());
                int accountType = accountTypeComboBox.getSelectedIndex() + 1;

                // Create the account using Main class method
                Main.createAccount(accountNumber, accountHolderName, balance, accountType, additionalInfo);
            } catch (NumberFormatException e) {
                // Show error message if invalid numbers are entered
                JOptionPane.showMessageDialog(null,
                        "Please enter valid numeric values for balance and additional info.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Handles money deposit operation
     * Displays a dialog to collect deposit information
     */
    private void depositMoney() {
        // Create input fields for deposit
        JTextField accountNumberField = new JTextField();
        JTextField amountField = new JTextField();

        // Create and configure the input panel
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        // Show dialog and process deposit
        int result = JOptionPane.showConfirmDialog(null, panel, "Deposit Money", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Get values and process deposit
                String accountNumber = accountNumberField.getText();
                double amount = Double.parseDouble(amountField.getText());

                Main.depositMoney(accountNumber, amount);
            } catch (NumberFormatException e) {
                // Show error for invalid amount
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric value for the amount.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Handles money withdrawal operation
     * Displays a dialog to collect withdrawal information
     */
    private void withdrawMoney() {
        // Create input fields for withdrawal
        JTextField accountNumberField = new JTextField();
        JTextField amountField = new JTextField();

        // Create and configure the input panel
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        // Show dialog and process withdrawal
        int result = JOptionPane.showConfirmDialog(null, panel, "Withdraw Money", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Get values and process withdrawal
                String accountNumber = accountNumberField.getText();
                double amount = Double.parseDouble(amountField.getText());

                Main.withdrawMoney(accountNumber, amount);
            } catch (NumberFormatException e) {
                // Show error for invalid amount
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric value for the amount.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Displays account information
     * Shows a dialog to enter account number and displays the information
     */
    private void displayAccountInfo() {
        // Create input field for account number
        JTextField accountNumberField = new JTextField();

        // Create and configure the input panel
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);

        // Show dialog and display account info
        int result = JOptionPane.showConfirmDialog(null, panel, "Display Account Info", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String accountNumber = accountNumberField.getText();
            Main.displayAccountInfo(accountNumber);
        }
    }

    /**
     * Searches for an account by account holder name
     * Shows a dialog to enter name and displays matching accounts
     */
    private void searchAccountByName() {
        // Create input field for account holder name
        JTextField accountHolderNameField = new JTextField();

        // Create and configure the input panel
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Account Holder Name:"));
        panel.add(accountHolderNameField);

        // Show dialog and search for account
        int result = JOptionPane.showConfirmDialog(null, panel, "Search Account by Name", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String accountHolderName = accountHolderNameField.getText();
            Main.displayAccountInfo(accountHolderName);
        }
    }

    /**
     * Main method to launch the application
     * Creates and displays the main GUI window
     */
    public static void main(String[] args) {
        // Ensure GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            BankAccountGUI gui = new BankAccountGUI();
            gui.setVisible(true);  // Make the GUI visible
        });
    }
}
