//A class for a rectangle.

public class Rectangle{//save as Rectangle.java.

	 // private instance variable, not accessible from outside this class



	private double L;//the length of the rectangle
   private double H; //the height of the rectangle
   private double x;// The x coordinate of the  bottom left corner of the rectangle
   private double y; // the y coordinate of the bottom left corner of the rectangle


   //You should write a basic constructor that creates a rectangle with side lengths 1 whose bottom left corner is at (0.0, 0.0)
   public Rectangle(){
      L = 1;
      H = 1;
      x = 0.0;
      y = 0.0;
   }

   //Now write a constructor that takes all four inputs, named Ell, Eich, Ex, and Why for L, H, x, and y respectively. 
   public Rectangle(double Ell, double Eich, double Ex, double Why){
      L = Ell;
      H = Eich;
      x = Ex;
      y = Why;
   }
   //Write a method called getLenght which returns the length.
   public double getLength(){
      return L;
   }
   //Write a method called getHeight which returns the height. 
   public double getHeight(){
      return H;
   }
   //Write a method called setLength which takes as input a double called Ell which sets the length of the rectangle.
   public void setLength(double Ell){
      L = Ell;
   }
   //write a method called setHeight which takes as input a double called Eich which sets the height of the rectangle.
   public void setHeight(double Eich){
      H = Eich;
   }
   //write a method called perimeter which computes the perimeter of the rectangle. 
   public double perimeter(){
      return (L+H)*2;
   }
   //write a method called area which computes the area of the rectangle. 
   public double area(){
      return L*H;
   }
}