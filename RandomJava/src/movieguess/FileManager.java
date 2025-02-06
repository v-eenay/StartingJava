package RandomJava.src.movieguess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private static final String MOVIE_FILE_PATH = "movielist.txt";
    private static final String HIGH_SCORES_FILE_PATH = "highscores.txt";

    public ArrayList<String> loadMovies() {
        ArrayList<String> movies = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(MOVIE_FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                movies.add(fileScanner.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Movie database file not found.");
        }
        return movies;
    }

    public void displayMoviesInTable() {
        ArrayList<String> movies = loadMovies();
        System.out.println("\n+-----------------------------+-----------------------------+-----------------------------+-----------------------------+");
        System.out.println("|          Movie List          |          Movie List          |          Movie List          |          Movie List          |");
        System.out.println("+-----------------------------+-----------------------------+-----------------------------+-----------------------------+");
        for (int i = 0; i < movies.size(); i += 4) {
            System.out.printf("| %-27s |", i < movies.size() ? movies.get(i) : "");
            System.out.printf(" %-27s |", (i + 1) < movies.size() ? movies.get(i + 1) : "");
            System.out.printf(" %-27s |", (i + 2) < movies.size() ? movies.get(i + 2) : "");
            System.out.printf(" %-27s |\n", (i + 3) < movies.size() ? movies.get(i + 3) : "");
            System.out.println("+-----------------------------+-----------------------------+-----------------------------+-----------------------------+");
        }
    }
    public void saveHighScore(String playerName, int score) {
        try (PrintWriter writer = new PrintWriter(new File(HIGH_SCORES_FILE_PATH))) {
            writer.println(playerName + ": " + score + " guesses");
            System.out.println("Your score has been saved. Good job!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to save high score.");
        }
    }

    public void displayHighScoresInTable() {
        File file = new File(HIGH_SCORES_FILE_PATH);
        if (!file.exists()) {
            System.out.println("\nNo high scores yet. Be the first to set the bar!");
            return;
        }

        System.out.println("\n+-----------------------------+");
        System.out.println("|         High Scores         |");
        System.out.println("+-----------------------------+");
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.printf("| %-27s |\n", fileScanner.nextLine());
            }
            System.out.println("+-----------------------------+");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to read high scores.");
        }
    }
}