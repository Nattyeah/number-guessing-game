import java.util.Scanner;

public class GameManager {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private int totalAttempts;
    private int remainingAttempts;
    private int targetNumber;
    private Difficulty difficulty;
    private boolean isGameWon;
    private final Scanner scanner;

    public GameManager() {
        this.scanner = new Scanner(System.in);
    }

    public void startGame(Difficulty difficulty) {
        this.difficulty = difficulty;
        this.remainingAttempts = difficulty.getAttempts();
        this.totalAttempts = 0;
        this.isGameWon = false;
        this.targetNumber = (int) (Math.random() * (MAX - MIN + 1)) + MIN;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + remainingAttempts + " attempts to guess the number.");

        playGame();
    }

    public boolean playAgain() {
        System.out.print("\nWould you like to play again? (yes/no): ");
        String playAgain = scanner.nextLine().trim().toLowerCase();
        return playAgain.equals("yes") || playAgain.equals("y");
    }

    public void close() {
        scanner.close();
    }

    private void playGame() {
        while (remainingAttempts > 0 && !isGameWon) {
            System.out.print("Enter your guess: ");
            int guess = getUserInput();
            totalAttempts++;
            remainingAttempts--;


            if (guess == targetNumber) {
                isGameWon = true;
                System.out.println("Congratulations! You guessed the number in " + totalAttempts + " attempts.");
            } else if (guess < targetNumber) {
                System.out.println("Incorrect! The number is greater than " + guess + ".");
                System.out.println("Remaining attempts: " + remainingAttempts + "\n");
            } else {
                System.out.println("Incorrect! The number is less than " + guess + ".");
                System.out.println("Remaining attempts: " + remainingAttempts + "\n");
            }
        }

        if (!isGameWon) {
            System.out.println("\nGame Over! The number was " + targetNumber + ". Better luck next time!");
        }
    }

    private int getUserInput() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input < MIN || input > MAX) {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                    System.out.print("Enter your guess: ");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Enter your guess: ");
            }
        }
    }
}
