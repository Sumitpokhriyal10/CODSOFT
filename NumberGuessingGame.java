import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("Guess the number between 1 and 100! You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number within the range of 1 to 100.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
