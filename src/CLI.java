public class CLI {
    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        String command = args[0].toLowerCase();

        if (command.equals("start")) {
            if (args.length < 2) {
                System.out.println("Error: Please select a difficulty level: Easy, Medium, or Hard.");
                printUsage();
                return;
            }

            String difficultyLevel = args[1].toUpperCase();
            try {
                Difficulty difficulty = Difficulty.valueOf(difficultyLevel);
                GameManager gameManager = new GameManager();
                gameManager.startGame(difficulty);

                while (gameManager.playAgain()) {
                    gameManager = new GameManager();
                    gameManager.startGame(difficulty);
                }

                gameManager.close();
            } catch (IllegalArgumentException e) {
                System.out.println("\"Error: Invalid difficulty level. Please use 'easy', 'medium', or 'hard'" + e.getMessage());
                printUsage();
            }
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Welcome to the Number Guessing Game - Usage:!");
        System.out.println("  java CLI start <difficulty>");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Please select the difficulty level: ");
        System.out.println("Easy (10 chances)");
        System.out.println("Medium (5 chances)");
        System.out.println("Hard (3 chances)");
        System.out.println("\nExample: java CLI start medium");
    }
}
