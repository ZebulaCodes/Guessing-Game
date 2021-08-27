// package guessinggame;

import javax.swing.*;

public class GuessingGame {
    public static void main(String[] args) {

        // Create random number between 1-100 for CPU
        int computerNumber = (int) (Math.random() * 10 + 1);
        // Initialize user variable
        int userAnswer = 0;
        // Print the random CPU number to the console
        // System.out.println("The correct guess would be: " + computerNumber);
        // Initialize the first attempted guess count
        int count = 1;
        // Value to tell when game is over
        boolean gameOver = false;

        while (userAnswer != computerNumber && gameOver == false) {
            // Display small dialog box. 3 = Question Mark icon
            String response = JOptionPane.showInputDialog(null, "Enter a guess between 1 & 10", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);
            // Run determineGuess to get answer and display results
            JOptionPane.showMessageDialog(null, "" + determineGuess(userAnswer, computerNumber, count));
            count++;
            if (count == 6) {
                gameOver = true;
            }
        } // end while

        // Game over screen
        if (count == 6) {
            JOptionPane.showMessageDialog(null,
                    "Game Over.\nYou have reached the maximum number of guess attempts.\n The correct number was: "
                            + computerNumber,
                    "Game Over", 2);
        }
    } // end main

    // Class to determine whethere or not the user is correct
    public static String determineGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer <= 0 || userAnswer > 10) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nAttempt Number: " + count;
        } else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\n Attempt Number: " + count;
        } else {
            return "Your guess is incorrect.\nAttempt Number: " + count;
        }
    } // end class
} // end program
