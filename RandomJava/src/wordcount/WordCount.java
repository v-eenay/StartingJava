package RandomJava.src.wordcount;

/************************************************
 * Word Count Program
 * This program reads a text file and counts the total
 * number of words within it.
 ************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {

        /*----------------------------------------
         * File Operations Initialization
         *----------------------------------------*/
        File file = new File("file.txt");
        Scanner fileScanner = new Scanner(file);
        
        /*----------------------------------------
         * Word Count Processing
         *----------------------------------------*/
        int totalWords = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] words = line.split(" ");
            totalWords += words.length;
        }
        
        /*----------------------------------------
         * Output Results
         *----------------------------------------*/
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║   Word Count Analysis Result   ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║   Total words found: " + totalWords);
        System.out.println("╚════════════════════════════════╝");
        
        /*----------------------------------------
         * Cleanup Resources
         *----------------------------------------*/
        fileScanner.close();
    }
}