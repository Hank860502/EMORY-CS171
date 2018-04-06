/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS. Han-Yu Chen
*/




import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Stack;

/*
 * Recursive class to represent a position in a path
 */
class Position{
	public int i;     //column
	public int j;     //row
	public char val;  //1, 0, or 'X'
	
	// reference to the previous position (parent) that leads to this position on a path
	Position parent;
	
	Position(int x, int y, char v){
		i=x; j = y; val=v;
	}
	
	Position(int x, int y, char v, Position p){
		i=x; j = y; val=v;
		parent=p;
	}
	
}


public class PathFinder {
	
	public static void main(String[] args) throws IOException {
		if(args.length<1){
			System.err.println("***Usage: java PathFinder maze_file");
			System.exit(-1);
		}
		
		char [][] maze;
		maze = readMaze(args[0]);
		printMaze(maze);
		Position [] path = stackSearch(maze);
		System.out.println("stackSearch Solution:");
		printPath(path);
		printMaze(maze);
		
		char [][] maze2 = readMaze(args[0]);
		path = queueSearch(maze2);
		System.out.println("queueSearch Solution:");
		printPath(path);
		printMaze(maze2);
	}
	
	//add and pop for stack (FILO)
	public static Position [] stackSearch(char [] [] maze){
		ArrayDeque<Position> myStack = new ArrayDeque<Position>();
		Position current = new Position(0,0,'X',null);
		Position[] p;
	  myStack.push(current);
	  int x;
	  int y;
	   
		
		while(!myStack.isEmpty()){
			current=myStack.pop();
			
			x=current.i;
			y=current.j;
			if(x==maze.length-1&& y == maze[0].length - 1){
				break;
			}
      else{
    		int parentX;
				int parentY;
				if(current.parent!=null){
					parentX = current.parent.i;
				  parentY = current.parent.j;
				}
				else{
					parentX=0;
				  parentY=0;
				} //down
				if((y < maze.length - 1) && (y+1 != parentY) && (maze[y+1][x] == '0')){
			    myStack.add(new Position(x, y+1,'X', current));
		    } //up
			  if((y > 0) &&(y-1!=parentY)&&(maze[y-1][x] == '0')){
			   	myStack.add(new Position(x, y-1 ,'X',current));
			  }
			  //right
			  if((x < maze[0].length - 1) &&(x+1!=parentX)&& (maze[y][x+1] == '0')){
					myStack.add(new Position(x+1, y, 'X',current));
				}
			  //left
				if((x > 0) &&(x-1!=parentX) &&(maze[y][x-1] == '0' )){
					myStack.add(new Position(x-1, y, 'X',current));
				}	 
		    if(myStack.isEmpty())
		    return null;
      }
		}
				
		Stack<Position> temp = new Stack<Position>();
		while (current.parent!= null){
			temp.push(current);
			maze[current.j][current.i] = 'X';
			current = current.parent;
			
		}
		maze[0][0] = 'X';
		p = new Position[temp.size()];
		for(int o = 0; o < p.length; o++){
			p[o]=temp.pop();
		}
        return p;
			
		  
	}
	//add and remove for queue: FOFO
	public static Position [] queueSearch(char [] [] maze){
		Queue<Position> myQueue = new ArrayDeque<Position>();
		Position current = new Position(0,0,'X',null);
		Position[] p;
		
		myQueue.add(current);
		int x;
		int y;
		
		while(!myQueue.isEmpty()){
			
			current=myQueue.remove();
			x=current.i;
			y=current.j;
			
			if(x == maze[0].length-1 && y == maze.length-1){
				break;
			}
			
			else {
				int parentX;
				int parentY;
				if(current.parent != null){
					parentX=current.parent.i;
				  parentY=current.parent.j;
				}
				else {
					parentX=0;
				  parentY=0;
				}
				
				//down
				if((y < maze.length - 1) && (y+1 != parentY) && (maze[y+1][x] == '0')){
			    myQueue.add(new Position(x, y+1,'X', current));
		    }
				//up
			  if((y > 0) && (y-1 != parentY) && (maze[y-1][x] == '0')){
			   	myQueue.add(new Position(x, y-1 ,'X',current));
			  }
			  //right
			  if((x < maze[0].length - 1) && (x+1 != parentX) && (maze[y][x+1] == '0')){
					myQueue.add(new Position(x+1, y, 'X',current));
				}
			    //left
				if((x > 0) && (x-1 != parentX) && (maze[y][x-1] == '0' )){
					myQueue.add(new Position(x-1, y, 'X',current));
				}
				
				if(myQueue.isEmpty())
				return null;
			}		
		}

    Queue<Position> temp = new LinkedList<Position>();
		while (current.parent != null){
			temp.add(current);
			maze[current.j][current.i] = 'X';
			current = current.parent;
		}

		maze[0][0] = 'X';
		
		p = new Position[temp.size()];
		for(int o=0; o < p.length; o++){
			p[p.length-1-o] = temp.remove();
		}
    return p;		
	}
	
	public static void printPath(Position [] path){
		// todo: print the path to the stdout
		if(path==null){
			System.out.println("No solution found!");
		}
		else{
			System.out.print("(");
			for(int k=0; k<path.length;k++){
			    System.out.print("["+path[k].i+"]["+path[k].j+"],");
		    }
			System.out.print(")");
		}
		System.out.println();
	}
	
	/**
	 * Reads maze file in format:
	 * N  -- size of maze
	 * 0 1 0 1 0 1 -- space-separated 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static char [][] readMaze(String filename) throws IOException{
		char [][] maze;
		Scanner scanner;
		try{
			scanner = new Scanner(new FileInputStream(filename));
		}
		catch(IOException ex){
			System.err.println("*** Invalid filename: " + filename);
			return null;
		}
		
		int N = scanner.nextInt();
		scanner.nextLine();
		maze = new char[N][N];
		int i=0;
		while(i < N && scanner.hasNext()){
			String line =  scanner.nextLine();
			String [] tokens = line.split("\\s+");
			int j = 0;
			for (; j< tokens.length; j++){
				maze[i][j] = tokens[j].charAt(0);
			}
			if(j!=N){
				System.err.println("*** Invalid line: " + i + " has wrong # columns: " + j);
				return null;
			}
			i++;
		}
		if(i!=N){
			System.err.println("*** Invalid file: has wrong number of rows: " + i);
			return null;
		}
		return maze;
	}
	
	public static void printMaze(char[][] maze){
		
		if(maze==null || maze[0] == null){
			System.err.println("*** Invalid maze array");
			return;
		}
		
		for(int i=0; i< maze.length; i++){
			for(int j = 0; j< maze[0].length; j++){
				System.out.print(maze[i][j] + " ");	
			}
			System.out.println();
		}
		
		System.out.println();
	}
}
