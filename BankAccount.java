import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    // Attributes - Private to ensure data security (Encapsulation)
    private String holder;
    private double balance;
    private List<String> transactions; // List to store transaction history

    // Constructor - Initializes the account
    public BankAccount(String holder, double initialBalance) {
        this.holder = holder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        // Records the opening of the account as the first transaction
        addTransaction("Initial deposit: $" + initialBalance);
    }

    // Private method to record each operation in the list
    private void addTransaction(String message) {
        transactions.add(message);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit: +$" + amount);
            System.out.println("Success! Deposited: $" + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    // Method to withdraw money with balance verification
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdraw: -$" + amount);
            System.out.println("Success! Withdrew: $" + amount);
        } else {
            addTransaction("Failed withdraw attempt: Insufficient funds");
            System.out.println("Error: Insufficient funds or invalid amount.");
        }
    }

    // Getters - Professional way to access private variables
    public double getBalance() {
        return balance;
    }

    public String getHolder() {
        return holder;
    }

    // Method to display the full account statement
    public void displayStatement() {
        System.out.println("\n--- Account Statement: " + holder + " ---");
        // Loop to print each transaction saved in the list
        for (String t : transactions) {
            System.out.println(t);
        }
        System.out.println("Final Balance: $" + balance);
        System.out.println("-----------------------------------");
    }
}