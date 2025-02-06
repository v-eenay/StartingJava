package RandomJava.src.movieguess;

import java.util.Scanner;

public class MovieGuess {

    public static void main(String[] args) {
        System.out.println("Welcome to MovieGuess: The Game Where Your Cinematic Knowledge Shines!");
        System.out.println("Or... where you realize you've been living under a rock. Let's find out!");

        Scanner userInput = new Scanner(System.in);
        try {
            System.out.println("\nBefore we begin, what shall we call you, oh mighty movie enthusiast?");
            String playerName = userInput.nextLine();
            System.out.println("Greetings, " + playerName + "! May your guesses be as sharp as a Hitchcock plot twist.");

            FileManager fileManager = new FileManager();
            boolean keepRunning = true;

            while (keepRunning) {
                System.out.println("\n+---------------------------------------------+");
                System.out.println("|                 Main Menu                   |");
                System.out.println("+---------------------------------------------+");
                System.out.println("| 1. Play the game (Test your cinematic IQ!)  |");
                System.out.println("| 2. See the list of movies (Spoilers-free!)  |");
                System.out.println("| 3. See high scores (Who's the real cinephile?) |");
                System.out.println("| 4. Exit (Leaving so soon? We'll miss you!)  |");
                System.out.println("+---------------------------------------------+");
                System.out.print("Enter your choice (1-4): ");

                int choice = Utils.getIntInput(userInput);

                switch (choice) {
                    case 1:
                        GameLogic gameLogic = new GameLogic(fileManager);
                        int score = gameLogic.playGame(playerName);
                        fileManager.saveHighScore(playerName, score);
                        break;
                    case 2:
                        fileManager.displayMoviesInTable();
                        break;
                    case 3:
                        fileManager.displayHighScoresInTable();
                        break;
                    case 4:
                        System.out.println("Thanks for playing, " + playerName + "! Until next time, stay reel!");
                        keepRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please pick a number between 1 and 4.");
                }
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Exiting gracefully...");
        } finally {
            userInput.close();
        }
    }
}