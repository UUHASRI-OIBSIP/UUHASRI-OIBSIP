import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class OnlineExaminationSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, String> users = new HashMap<>();
    private static String currentUser;

    public static void main(String[] args) {
        boolean isRunning = true;
        initializeUsers();

        while (isRunning) {
            System.out.println("\nWelcome to Online Examination System");
            System.out.println("\n***********************************************");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    updateProfileAndPassword();
                    break;
                case 3:
                    if (currentUser != null) {
                        startExam();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 4:
                    logout();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeUsers() {
        
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void updateProfileAndPassword() {
        if (currentUser != null) {
            System.out.println("Current username: " + currentUser);
            System.out.print("Enter new username: ");
            String newUsername = scanner.nextLine();
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();

            users.remove(currentUser);
            users.put(newUsername, newPassword);
            currentUser = newUsername;
            System.out.println("Profile and password updated successfully!");
        } else {
            System.out.println("Please login first.");
        }
    }

    private static void startExam() {
        System.out.println("Welcome to the exam, " + currentUser + "!");

    }

    private static void logout() {
        if (currentUser != null) {
            currentUser = null;
            System.out.println("Logged out successfully.");
        } else {
            System.out.println("No user is currently logged in.");
        }
    }
}
