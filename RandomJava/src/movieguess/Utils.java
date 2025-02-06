package RandomJava.src.movieguess;

import java.util.Scanner;

public class Utils {

    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        return input;
    }

    public static boolean isValidLetter(String input) {
        return input.length() == 1 && Character.isLetter(input.charAt(0));
    }
}