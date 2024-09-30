import java.util.Scanner;
public class SimpleBankingApplication {
    private double balance;
    private String accountHolderName;
    public SimpleBankingApplication(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposit Successful! Amount: $%.2f | Updated Balance: $%.2f%n", amount, balance);
        } else {
            System.out.println("Error: Deposit amount must be greater than zero.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawal Successful! Amount: $%.2f | Updated Balance: $%.2f%n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds. Unable to withdraw the requested amount.");
        } else {
            System.out.println("Error: Withdrawal amount must be greater than zero.");
        }
    }
    public void checkBalance() {
        System.out.printf("Current Balance: $%.2f%n", balance);
    }
    public void showMenu() {
        System.out.println("\n========== Simple Banking Application Menu ==========");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Simple Banking Application!");
        System.out.println("===========================================");
        System.out.print("Enter the account holder's name: ");
        String accountHolderName = scanner.nextLine();
        double initialBalance = 0;
        boolean validBalance = false;
        while (!validBalance) {
            System.out.print("Enter the initial balance: $");
            if (scanner.hasNextDouble()) {
                initialBalance = scanner.nextDouble();
                if (initialBalance >= 0) {
                    validBalance = true;
                } else {
                    System.out.println("Error: Initial balance cannot be negative.");
                }
            } else {
                System.out.println("Error: Please enter a valid numeric value for the balance.");
                scanner.next(); // Clear invalid input
            }
        }
        SimpleBankingApplication bankAccount = new SimpleBankingApplication(accountHolderName, initialBalance);
        int option;
        do {
            bankAccount.showMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid option (1-4).");
                scanner.next(); // Clear invalid input
                bankAccount.showMenu();
            }
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawalAmount);
                    break;
                case 3:
                    bankAccount.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the Simple Banking Application. Have a great day!");
                    break;
                default:
                    System.out.println("Error: Invalid option. Please choose between 1-4.");
                    break;
            }
        } while (option != 4);

        scanner.close();
    }
}
