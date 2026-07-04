import java.util.Random;

import javax.swing.JOptionPane;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int totalScore = 0;
        boolean playAgain = true;
        while (playAgain) {
            Random rand = new Random();
            int numberToGuess = rand.nextInt(100) + 1;
            int maxAttempts = 5;
            int score = 0;
            boolean guessedCorrectly = false;
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                String input = JOptionPane.showInputDialog("Round starts! \n Guess a number between 1 to 100 \n Attempt"
                        + attempt + "of" + maxAttempts + ":");
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game Cancelled!");
                    return;
                }
                try {
                    int guess = Integer.parseInt(input);
                    if (guess == numberToGuess) {
                        guessedCorrectly = true;
                        score = maxAttempts - attempt + 1;
                        JOptionPane.showMessageDialog(null, "Correct! You earned" + score + "points.");
                        break;
                    } else if (guess < numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Too low!");

                    } else {
                        JOptionPane.showMessageDialog(null, "Too high!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                    attempt--;

                }
            }
            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "You have used all attemots! The number was:" + numberToGuess);
            }
            totalScore += score;

            int option = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play Again?",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            playAgain = (option == JOptionPane.YES_OPTION);
        }

        JOptionPane.showMessageDialog(null, "Game Over! \n Your Total Score:" + totalScore);
    }
}
