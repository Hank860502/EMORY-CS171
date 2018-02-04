/*

THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING

CODE WRITTEN BY OTHER STUDENTS. Han-Yu Chen

*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	private static Scanner scanner = new Scanner( System.in );
	// fill in code here
	// define data members
	private int count;
	private ArrayList<Integer> al;
	private ArrayList<Integer> store;
	private ArrayList<Integer> lastSet;
	private boolean foundAllNumbers;

	public GuessingGame ( ) {
		// fill in code here
		// initialization
		this.count = 0;
		this.foundAllNumbers = false;
		this.al = new ArrayList<Integer>();
		// al.add(0000); can't test on this because 0000 = 0
	  al.add(1111);
	  al.add(2222);
	  al.add(3333);
	  al.add(4444);
	  al.add(5555);
	  al.add(6666);
	  al.add(7777);
	  al.add(8888);
	  al.add(9999);

		this.store = new ArrayList<Integer>(); // store all the matching nums
		this.lastSet = new ArrayList<Integer>(); // store all the possible combination using the 4 number
	}

	public int myGuessIs() {
		// fill in code here
		// return -1 if no valid guess
		// return the next guess value
		// add count 1 on the totalNumguess
		if (this.count == 0){
			return this.al.get(0);
		} else if(this.store.size() == 4){
			this.foundAllNumbers = true;
			// list out all the possible numbers that contains these four numbers but 0 could not be the first digit
      for(int i=1000; i<9999; i++){
      	if()
      }
      }
      return ;
      // 現在有四個一定存在的數了，先用猜的






		} else if (this.al.size()==0){ // BUUUGGGG
			return -1;
		} else if (this.count > 0 && this.count < 4){
			return this.al.get(0);
		} else {
				return 878787;
			}

	}
	
	public int totalNumGuesses() {
		// fill in code here
		// this should return the total number of guesses taken
		return this.count;
	}
 
	public void updateMyGuess(int nmatches) {
		// fill in code here
		// update the guess based on the number of matching digits claimed by the user
		if (this.foundAllNumbers == false) {
			if (this.al.size() == 1){
				for (int i = (4-store.size()); i>0; i--) {
					this.store.add(0); // if run through the 9 pairs of numbers and still couldn't get which 4 numbers is in size, fill in the remain spot with 0
				} 
				myGuessIs();
			} else if (nmatches == 0) {
				this.al.remove(0); // if no number matches, delete that value from al and move on to next guess
				myGuessIs();
			} else if (nmatches > 0) {
				for (int i=nmatches; i>0; i--) {
					this.count++;
					this.store.add(this.count);
					System.out.println("UPDATE!");
					System.out.println(this.store.size() + " sizeeee. " + "Count is at " + this.count);
				}
				this.al.remove(0);
				myGuessIs();
			}
		} else if (this.foundAllNumbers == true){
			// if (nmatches == 0) {

			// }
		}
			// return al.get(rand.nextInt(al.size()));
			// getting a random number from the remain arraylist as the next guess
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
			System.out.println(gamer.al.size());
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
			System.out.print("hank's test");
			
		} while (true);
		
		// the game ends when the user says all 4 digits are correct
		System.out.println("Aha, I got it, your number is " + myguess + ".");
		System.out.println("I did it in " + gamer.totalNumGuesses() + " turns.");
	}
}
