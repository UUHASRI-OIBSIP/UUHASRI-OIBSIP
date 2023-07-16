import java.util.Random;
import java.util.Scanner;

class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int maxAttempts = 10;
        int score = 0;

        // Outer loop for multiple rounds
        while (true) {
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            System.out.println("****************WELCOME TO NUMBER GUESSING GAME *****************");
            while (attempts < maxAttempts) {
				
                System.out.print("Enter your guess number (1 to 100): ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts!!");
					     System.out.println("The system generated Random number is "+ randomNumber);
                    score++;
                    break;
                } else if (guess < randomNumber) {
               
                    System.out.println("Higher! Try again.");
                } else {
                 
                    System.out.println("Lower! Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Your final score: " + score);
		System.out.println("****THANKS FOR PARTICIPATING ******");
        sc.close();
    }
}
