/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS. Han-Yu Chen
*/

import java.util.Stack;

public class NQueens {
 
  //***** fill in your code here *****
  //feel free to add additional methods as necessary
 
  //finds and prints out all solutions to the n-queens problem
  public static int solve(int n) {
    //***** fill in your code here *****
    Stack<Integer> placable =  new Stack<Integer>();
    int num = 0;
    int temp = 0;
    placable.push(0); // prevent error
    if(n == 1){ // number 1 should be considered differently
      printSolution(placable);
      return 1;
    }
    for(int i = 1; i < n; i++){ // row
      if(i == 0){ // if empty, push temp
        placable.push(temp);
        temp = 0; // set temp to initial
        continue;
      }
      for(int j = temp; j < n; j++){ // number to fill
        for(int k = 0; k < i; k++){ // check safe or not
          if(placable.get(k) == j || placable.get(k) - j == k - i || placable.get(k) - j == i - k){
            if(j == n - 1){ // no element to put into stack
              temp = placable.pop() + 1; // record number in the previous row
              i = i - 2;  // rewrite previous row
              if(temp == n){  // if the number is last
                if(placable.size() == 0){ //if stack is empty
                  return num; // no valid position
                }
                temp = placable.pop() + 1; // pop second previous row
                i--; // rewrite second previous row
              }
              j = n + 1; // force end loop
            } 
            break;
          }
          if(k == i-1){ // j can be put in the stack
            placable.push(j);  // push j into the stack
            if(placable.size() == n){ // if solution is found
              num++;
              printSolution(placable);
              placable.pop(); // pop last row
              temp = placable.pop() + 1;  // pop second last row
              i = i - 2;
              if(temp == n){  // if the number is in the last position
                temp = placable.pop() + 1; // pop third last row
                i--;  // rewrite the third last row
              }
              j = n + 1; // force end loop
              break;
            }
            j = n + 1;  // force end loop
            temp = 0;
            break;
          }
        }
      }
    }
    //update the following statement to return the number of solutions found
    return 0; // if can't find any solution
  }//solve()
  
  //this method prints out a solution from the current stack
  //(you should not need to modify this method)
  private static void printSolution(Stack<Integer> s) {
    for (int i = 0; i < s.size(); i ++) {
      for (int j = 0; j < s.size(); j ++) {
        if (j == s.get(i))
          System.out.print("Q ");
        else
          System.out.print("* ");
      }//for
      System.out.println();
    }//for
    System.out.println();  
  }//printSolution()
  
  // ----- the main method -----
  // (you shouldn't need to change this method)
  public static void main(String[] args) {
  
  int n = 8;
  
  // pass in parameter n from command line
  if (args.length == 1) {
    n = Integer.parseInt(args[0].trim());
    if (n < 1) {
      System.out.println("Incorrect parameter");
      System.exit(-1);
    }//if   
  }//if
  
  int number = solve(n);
  System.out.println("There are " + number + " solutions to the " + n + "-queens problem.");
 }//main()
  
}
