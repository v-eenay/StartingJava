package RandomJava.src.movieguess;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    private FileManager fileManager;

    public GameLogic(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public int playGame(String playerName) {
        System.out.println("\nAlright, " + playerName + ", let's see if you're a Spielberg or a Scorsese!");

        ArrayList<String> movieTitles = fileManager.loadMovies();
        String randomMovieTitle = movieTitles.get(new Random().nextInt(movieTitles.size()));
        StringBuilder guessedLetters = new StringBuilder();
        int guesses = 0;

        System.out.println("A random movie has been selected. Can you guess its title?");

        Scanner userInput = new Scanner(System.in);
        try {
            while (true) {
                // Display the current state of the movie title in a table format
                printMovieTitle(randomMovieTitle, guessedLetters.toString());

                // Check if the player has guessed all the letters
                if (isFullyGuessed(randomMovieTitle, guessedLetters.toString())) {
                    System.out.println("\nCongratulations, " + playerName + "! You guessed the movie: " + randomMovieTitle);
                    System.out.println("It only took you " + guesses + " guesses. Not too shabby!");
                    return guesses; // Exit the method immediately after winning
                }

                // Ask the player to guess a letter
                System.out.print("\nGuess a letter: ");
                String guessedLetter = userInput.nextLine().toLowerCase();

                // Validate the input
                if (!Utils.isValidLetter(guessedLetter)) {
                    System.out.println("That's not a valid letter. Try again, champ!");
                    continue;
                }

                // Check if the letter has already been guessed
                if (guessedLetters.indexOf(guessedLetter) != -1) {
                    System.out.println("You've already guessed '" + guessedLetter + "'. Try something new!");
                    continue;
                }

                // Process the guess
                if (randomMovieTitle.toLowerCase().contains(guessedLetter)) {
                    System.out.println("Nice one! '" + guessedLetter + "' is in the movie title.");
                    guessedLetters.append(guessedLetter);
                } else {
                    System.out.println("Oops! '" + guessedLetter + "' isn't in the movie title. Better luck next time!");
                }

                guesses++;
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Exiting gracefully...");
        } finally {
            userInput.close(); // Ensure the scanner is closed properly
        }
        return guesses; // Fallback return (should never reach here)
    }

    private boolean isFullyGuessed(String movieTitle, String guessedLetters) {
        for (char c : movieTitle.toCharArray()) {
            if (Character.isLetterOrDigit(c) && guessedLetters.indexOf(String.valueOf(c).toLowerCase()) == -1) {
                return false;
            }
        }
        return true;
    }

    private void printMovieTitle(String movieTitle, String guessedLetters) {
        System.out.println("+-----------------------------+");
        System.out.print("| ");
        for (char c : movieTitle.toCharArray()) {
            if (c == ' ' || !Character.isLetterOrDigit(c)) {
                System.out.print(c); // Spaces and special characters are revealed
            } else if (guessedLetters.indexOf(String.valueOf(c).toLowerCase()) != -1) {
                System.out.print(c); // Correctly guessed letters are revealed
            } else {
                System.out.print("_"); // Unguessed letters are hidden
            }
        }
        System.out.println(" |\n+-----------------------------+");
    }
}