      /*

      THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING

      CODE WRITTEN BY OTHER STUDENTS. Han-Yu Chen

      */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	// fill in code here
	// define data members

	public GuessingGame ( ) {
		// fill in code here
		// initialization

	}

	public int myGuessIs() {
		// fill in code here
	}
	
	public int totalNumGuesses() {
		// fill in code here
		// this should return the total number of guesses taken
	}
 
	public void updateMyGuess(int nmatches) {
		// fill in code here
		// update the guess based on the number of matching digits claimed by the user
	}
	
	// fill in code here (optional)
	// feel free to add more methods as needed
	
	// you shouldn't need to change the main function
	public static void main(String[] args) {

		GuessingGame gamer = new GuessingGame( );
  
		System.out.println("Let's play a game. Think of a number between 1000 and 9999");
        
        System.out.println("Press \"ENTER\" when you are ready");
        
        scanner.nextLine();
        
		int numMatches = 0;
		int myguess = 0;
		
		do {
			myguess = gamer.myGuessIs();
			if (myguess == -1) {
				System.out.println("I don't think your number exists!");
				System.exit(0);
			}
			System.out.println("I guess your number is " + myguess + ". How many digits did I guess correctly?");
			String userInput = scanner.nextLine();
			
			// quit if the user input nothing (such as pressed ESC)
			if (userInput == null)
				System.exit(0);
			// parse user input, pop up a warning message if the input is invalid
			try {
				numMatches = Integer.parseInt(userInput.trim());
			}
			catch(Exception exception) {
				System.out.println("Your input is invalid. Please enter a number between 0 and 4");
				continue;
			}
			// the number of matches must be between 0 and 4
			if (numMatches < 0 || numMatches > 4) {
				System.out.println("Your input is invalid. Please enter a number between 0 and 4");
				continue;
			}
			if (numMatches == 4)
				break;
			// update based on user input
			gamer.updateMyGuess(numMatches);
			
		} while (true);
		
		// the game ends when the user says all 4 digits are correct
		System.out.println("Aha, I got it, your number is " + myguess + ".");
		System.out.println("I did it in " + gamer.totalNumGuesses() + " turns.");
	}
}
