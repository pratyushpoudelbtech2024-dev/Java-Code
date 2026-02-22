import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};
        String userChoice;
        String computerChoice;

        System.out.println("=== Rock Paper Scissors Game ===");

        while (true) {

            System.out.println("\nChoose: Rock, Paper, Scissors");
            System.out.println("Type 'quit' to exit");
            System.out.print("Your choice: ");
            userChoice = sc.nextLine();

            if (userChoice.equalsIgnoreCase("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            // Generate computer choice
            computerChoice = choices[rand.nextInt(3)];

            System.out.println("Computer chose: " + computerChoice);

            // Convert to proper case for comparison
            userChoice = userChoice.substring(0, 1).toUpperCase() +
                         userChoice.substring(1).toLowerCase();

            // Check winner
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            }
            else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                     (userChoice.equals("Scissors") && computerChoice.equals("Paper")) ||
                     (userChoice.equals("Paper") && computerChoice.equals("Rock"))) {
                System.out.println("You win!");
            }
            else if (userChoice.equals("Rock") ||
                     userChoice.equals("Paper") ||
                     userChoice.equals("Scissors")) {
                System.out.println("Computer wins!");
            }
            else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}