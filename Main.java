import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount myAccount = new BankAccount("DevKimFilipe", 1000.0);
        int option;

        do {
            System.out.println("\n--- JAVA BANK MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Statement");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Current Balance: $" + myAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = input.nextDouble();
                    myAccount.deposit(dep);
                    break;
                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double wit = input.nextDouble();
                    myAccount.withdraw(wit);
                    break;
                case 4:
                    myAccount.displayStatement();
                    break;
                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        } while (option != 0);

        input.close();
    }
}