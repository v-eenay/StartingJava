package RandomJava.src.guessgame;
import java.util.Scanner;  // Import Scanner class for user input

/**
 * GuessGame - A number guessing game where players try to guess a random number
 * This class implements a simple yet engaging number guessing game with visual feedback
 */
public class GuessGame {
    public static void main(String[] args){
        // Generate a random number between 1 and 100
        int randomNumber = (int) (Math.random() * 100) + 1;
        
        // Initialize game state variables
        boolean hasWon = false;  // Tracks if player has won
        int attempts = 0;        // Counts number of attempts made
        int maxAttempts = 10;    // Maximum allowed attempts
        
        // Display welcome message and game instructions using ASCII art borders
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║           Welcome to the Number Guessing Game        ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  I have carefully selected a number between 1-100.   ║");
        System.out.println("║  You have " + maxAttempts + " attempts to discover this mystery!     ║");
        System.out.println("║  Are you ready for the challenge?                    ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        
        // Create Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);
        
        // Main game loop - continues until max attempts are reached
        for(int i=maxAttempts; i>0; i--){
            attempts++;  // Increment attempt counter
            
            // Display current attempt number
            System.out.println("\n🎲 Attempt " + attempts + " of " + maxAttempts + " 🎲");
            System.out.println("◆━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━◆");
            System.out.print("Enter your prediction (1-100): ");
            
            // Get user's guess
            int guess = scanner.nextInt();
            
            // Check if guess is correct
            if(guess == randomNumber){
                // Display victory message with decorative elements
                System.out.println("\n✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
                System.out.println("         🌟 EXCELLENT! That's correct! 🌟");
                System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
                hasWon = true;  // Set win flag
                break;          // Exit the game loop
            } 
            // Provide hint if guess is too low
            else if(guess < randomNumber){
                System.out.println("\n↑↑↑ The mysterious number is higher than " + guess + "! ↑↑↑");
                System.out.println("💫 Keep aiming higher, you're getting closer! 💫");
            } 
            // Provide hint if guess is too high
            else {
                System.out.println("\n↓↓↓ The mysterious number is lower than " + guess + "! ↓↓↓");
                System.out.println("💫 Keep aiming lower, you're getting closer! 💫");
            }
        }
        
        // Game end statistics and messages
        if(hasWon){
            // Display victory statistics with performance rating
            System.out.println("\n🏆━━━━━━━━━━━ GAME STATISTICS ━━━━━━━━━━━🏆");
            System.out.println("🌟 Attempts used: " + attempts + " out of " + maxAttempts);
            // Calculate and display success rate
            System.out.println("🌟 Success rate: " + String.format("%.1f", ((float)(maxAttempts-attempts+1)/maxAttempts)*100) + "%");
            // Display performance message based on number of attempts
            System.out.println("🌟 Performance: " + (attempts <= 3 ? "Exceptional!" : attempts <= 6 ? "Great!" : "Good!"));
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("🎉 Congratulations! You've mastered the challenge! 🎉");
        } else {
            // Display game over message and statistics for loss
            System.out.println("\n╔═══════════════════ GAME OVER ═══════════════════╗");
            System.out.println("║  📊 Final Statistics:                           ║");
            System.out.println("║  • Attempts used: " + attempts + " out of " + maxAttempts + "                  ║");
            System.out.println("║  • The mysterious number was: " + randomNumber + "               ║");
            System.out.println("║  • Success rate: 0%                            ║");
            System.out.println("╠═══════════════════════════════════════════════╣");
            System.out.println("║    Don't give up! Try again for victory!      ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        }
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}