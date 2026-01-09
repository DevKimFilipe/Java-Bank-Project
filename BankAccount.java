import java.util.ArrayList;
import java.util.List;
public class BankAccount {
    // Attributes - Private to ensure data security
    private String holder;
    private double balance;
private List<String> transactions;

    // Constructor - Initializes the account with a name and a starting value
    public BankAccount(String holder, double initialBalance) {
        this.holder = holder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    // Method to add money to the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposit: +$" + amount);
            System.out.println("Success! Deposited: $" + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    // Method to remove money with balance verification
    public void withdraw(double amount)
        transactions.add("Withraw: -$" + amount:);
    {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Success! Withdrew: $" + amount);
        } else {
            System.out.println("Error: Insufficient funds or invalid amount.");
        }
    }

    // Getters - Professional way to access private variables from other classes
    public double getBalance() {
        return balance;
    }

    public String getHolder() {
        return holder;
    }
    public void displayStatemente(){
        System.out.println("\n--- Account Statement ---");
        for (String t : transactions) {
            System.out.println(t);
        }
        System.out.println("Final balance: $" + balance);
    }
}   