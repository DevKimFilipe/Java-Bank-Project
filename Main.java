import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner to read user input from the console
        Scanner input = new Scanner(System.in);

        // 1. ACCOUNT CREATION
        // Creating the account with your dev name and an initial balance
        BankAccount myAccount = new BankAccount("DevKimFilipe", 1000.0);
        
        System.out.println("Welcome to the Java Bank System!");
        System.out.println("Account holder: " + myAccount.getHolder());
        System.out.println("Initial Balance: $" + myAccount.getBalance());

        // 2. DEPOSIT LOGIC
        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = input.nextDouble();
        myAccount.deposit(depositAmount);

        // 3. WITHDRAW LOGIC
        System.out.print("\nEnter amount to withdraw: ");
        double withdrawAmount = input.nextDouble();
        myAccount.withdraw(withdrawAmount);

        // 4. FINAL STATEMENT (The new feature!)
        // This will print the entire history of transactions
        myAccount.displayStatement();

        // Closing the scanner to release memory
        input.close();
        System.out.println("\nThank you for using our banking system!");
    }
}