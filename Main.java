import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner to read keyboard input
        Scanner input = new Scanner(System.in);
        
        // Initializing the account with your name and initial balance
        BankAccount myAccount = new BankAccount("Kim Borges", 2500.0);

        System.out.println("--- Welcome to Java Bank System ---");
        System.out.println("Account Holder: " + myAccount.getHolder());
        System.out.println("Current Balance: $" + myAccount.getBalance());

        // 1. DEPOSIT LOGIC
        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = input.nextDouble();
        myAccount.deposit(depositAmount);

        // 2. WITHDRAW LOGIC
        System.out.print("\nEnter amount to withdraw: ");
        double withdrawAmount = input.nextDouble();
        myAccount.withdraw(withdrawAmount);

        // 3. FINAL STATEMENT
        System.out.println("\n--- FINAL STATEMENT ---");
        System.out.println("Customer: " + myAccount.getHolder());
        System.out.println("Final Balance: $" + myAccount.getBalance());
        System.out.println("-----------------------");
        
        input.close();
    }
}