import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int number = rand.nextInt(100) + 1; // Random number between 1 and 100
        int attempts = 5;
        int guess;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have 5 attempts!");

        for (int i = 1; i <= attempts; i++) {

            System.out.print("Attempt " + i + ": Enter your guess: ");
            guess = sc.nextInt();

            if (guess > number) {
                System.out.println("Too High!");
            } 
            else if (guess < number) {
                System.out.println("Too Low!");
            } 
            else {
                System.out.println("Correct! You Win!");
                sc.close();
                return;
            }
        }

        System.out.println("Game Over! The number was " + number);
        sc.close();
    }
}