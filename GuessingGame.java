import java.util.Scanner;
import java.util.Random;

public class GuessingGame
 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int wins = 0;

        System.out.println("Hi Welcome To The Guessing Game!");

        while (true) {
            int number = random.nextInt(maxRange) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Congratulations! You've guessed the number " + number + " correctly in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    wins++;
                    break;
                } else if (guess < number) {
                    System.out.println("Your guess is Too Low.Please try again.");
                } else {
                    System.out.println("Your guess is Too High.Please try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
            }

            rounds++;

            System.out.print("Do you want to play again? (Yes/No): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game Over! You played " + rounds + " round(s) and won " + wins + " time(s).");

        scanner.close();
    }
}
