import java.util.*;

public class game {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalRounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int number = r.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number within the range 1 to 100.");
                } else if (guess == number) {
                    System.out.println("Your guess is correct!");
                    guessedCorrectly = true;
                } else if (guess > number) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + number + ".");
            }

            totalRounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over! You played " + totalRounds + " rounds with a total of " + totalAttempts + " attempts.");
        scanner.close();
    }
}
