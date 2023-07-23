import java.util.HashMap;
import java.util.Scanner;

class ATM{
    private HashMap<String, String> users;

    public  ATM() {
        // Dummy data for user IDs and PINs (In a real system, these would come from a database)
        users = new HashMap<>();
        users.put("user1", "1234");
        users.put("user2", "5678");
    }

    public boolean verifyUser(String userId, String pin) {
        String storedPin = users.get(userId);
        return storedPin != null && storedPin.equals(pin);
    }

    public void startATM() {
        Scanner scanner = new Scanner(System.in);
        String userId, pin;

        System.out.println("Welcome to the ATM!");

        // Prompt for user ID and PIN
        System.out.print("Enter User ID: ");
        userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        pin = scanner.nextLine();

        // Verify user
        if (verifyUser(userId, pin)) {
            System.out.println("User Verified!");
            Transactions transactions = new Transactions(userId);
            transactions.processTransactions();
        } else {
            System.out.println("Invalid User ID or PIN. Exiting...");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.startATM();
    }
}

class Transactions {
    private String userId;
    private Scanner scanner;

    public Transactions(String userId) {
        this.userId = userId;
        scanner = new Scanner(System.in);
    }

    public void processTransactions() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Withdraw withdraw = new Withdraw(userId);
                    withdraw.withdrawAmount();
                    break;
                case 2:
                    Deposit deposit = new Deposit(userId);
                    deposit.depositAmount();
                    break;
                case 3:
                    Transfer transfer = new Transfer(userId);
                    transfer.transferAmount();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nATM Menu");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
    }
}

class Withdraw {
    private String userId;
    private Scanner scanner;

    public Withdraw(String userId) {
        this.userId = userId;
        scanner = new Scanner(System.in);
    }

    public void withdrawAmount() {
        
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

  

        System.out.println("Amount withdrawn: " + amount);
    }
}

class Deposit {
    private String userId;
    private Scanner scanner;

    public Deposit(String userId) {
        this.userId = userId;
        scanner = new Scanner(System.in);
    }

    public void depositAmount() {
        
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

      

        System.out.println("Amount deposited: " + amount);
    }
}

class Transfer {
    private String userId;
    private Scanner scanner;

    public Transfer(String userId) {
        this.userId = userId;
        scanner = new Scanner(System.in);
    }

    public void transferAmount() {
        
        System.out.print("Enter the recipient's User ID: ");
        String recipientUserId = scanner.nextLine();

        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        

        System.out.println("Amount transferred: " + amount + " to User ID: " + recipientUserId);
    }
}
