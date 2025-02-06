package RandomJava.src.movieguess;

import java.io.*;
import java.util.*;

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
        System.out.println("\n+------------------------------------------------------------+");
        System.out.println("|                         Movie List                          |");
        System.out.println("+------------------------------------------------------------+");
        for (int i = 0; i < movies.size(); i++) {
            System.out.printf("| %-57s |", movies.get(i));
            if ((i + 1) % 4 == 0 || i == movies.size() - 1) {
                System.out.println("\n+------------------------------------------------------------+");
            } else {
                System.out.println();
            }
        }
    }

    public void saveHighScore(String playerName, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(HIGH_SCORES_FILE_PATH, true))) {
            writer.println(playerName + ": " + score + " guesses");
            System.out.println("Your score has been saved. Good job!");
        } catch (IOException e) {
            System.out.println("Error: Unable to save high score.");
        }
    }

    public void displayHighScoresInTable() {
        File file = new File(HIGH_SCORES_FILE_PATH);
        if (!file.exists()) {
            System.out.println("\nNo high scores yet. Be the first to set the bar!");
            return;
        }

        List<String> highScores = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                highScores.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to read high scores.");
        }

        // Sort high scores by guesses (ascending order)
        highScores.sort((a, b) -> {
            int scoreA = Integer.parseInt(a.replaceAll("[^0-9]", ""));
            int scoreB = Integer.parseInt(b.replaceAll("[^0-9]", ""));
            return Integer.compare(scoreA, scoreB);
        });

        System.out.println("\n+---------------------------------------------+");
        System.out.println("|                  High Scores                 |");
        System.out.println("+---------------------------------------------+");
        for (String score : highScores) {
            System.out.printf("| %-40s |\n", score);
        }
        System.out.println("+---------------------------------------------+");
    }
}