/*
  THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
  CODE WRITTEN BY OTHER STUDENTS. Han-Yu Chen
*/


public class Josephus{
  public static void main(String[] args){
    /* 
     * Sample testing code
     * Feel free to edit for additional tests of your CircularList 
     * imlementation as well as the solve method
     */

    CircularList cl = new CircularList();
    for(int i=0; i<10; i++) {
      cl.insert(new ListElem(i));
    }

    int m = 3; 
    System.out.println(solve(cl, m));
  }

	public static int solve(CircularList cl, int m){
    if (m == 0){} // do nothing
    int num;

    while(cl.getSize() > 1) {
      for(int i = 0; i < m-1; i++) {
        cl.rotate();
      }
      num = cl.remove();
    }
    return(cl.getTail().value);

		/*
		* your code to solve the Josephus problem
		*/
		
	}
}
