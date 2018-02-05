import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

 // fill in code here
 // define data members
 private ArrayList<Integer> list;
 private int numOfMatch;
 private int numGuess;
 private int random;
 private int guess;

  private static Scanner scanner = new Scanner( System.in );

  public static int numOfMatch(int a, int b){
   return thousands(a, b)+hundreds(a, b)+tenth(a, b)+unit(a, b);
  }

  public static int thousands(int a, int b){
   if(a / 1000 == b / 1000){
    return 1;
   }
   return 0;
  }

  public static int hundreds(int a, int b){
   if(a / 100 % 10 == b / 100 % 10) {
    return 1;
   }
   return 0;
  }

  public static int tenth(int a, int b){
   if(a / 10 % 10 == b / 10 % 10) {
    return 1;
   }
   return 0;
  }

  public static int unit(int a, int b){
   if(a % 10 == b % 10){
    return 1;
   }
   return 0;
  }

 public GuessingGame ( ){
  // fill in code here
  // initialization
  list = new ArrayList<Integer>();
  for(int i = 1000; i < 10000; i++){
   list.add(i);
  }
 }

 public int myGuessIs() {
  // fill in code here
  if(list.size() == 0){
   return -1;
  }
  numGuess++;
  int result;
  random = (int)(list.size()*Math.random());
  result = list.get(random);
  this.guess = result;
  return result;
 }
 
 public int totalNumGuesses() {
  // fill in code here
  // this should return the total number of guesses taken
  return this.numGuess;
 }
 
 public void updateMyGuess(int nmatches) {
  // fill in code here
  // update the guess based on the number of matching digits claimed by the user
  for(int i=0;i<list.size();i++){
   if(numOfMatch(list.get(i), this.guess) != nmatches){
    list.remove(i);
    i--;
   }
  }
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