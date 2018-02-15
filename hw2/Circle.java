/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS. Han-Yu Chen */

//A class for a circle. 
public class Circle {  // Save as "Circle.java"
   // private instance variable, not accessible from outside this class
   protected double radius;//the radius of the circle.
   protected double x; //the x coordinate of the circle.
   protected double y;// the y coordinate fo the circle. 
   // The default constructor with no argument.
   // It sets the radius and color to their default value.
   public Circle() {
      radius = 1.0;
      // color = "blue";
   }
   
   // 2nd constructor with given radius, but color default
   public Circle(double r) {
      radius = r;
      // color = "blue";
   }
   
   //You should complete this next constructor. "r" is the radius name, "ex" should be the x coordinate, and "why" should be the y coordinate. 

   public Circle(double r, double ex, double why){
      radius = r;
      x = ex;
      y = why;
   	//your code here. 
   }

   // A public method for retrieving the radius
   public double getRadius() {
     return radius; 
   }
   
   // A public method for computing the area of circle
   public double getArea() {
      return radius*radius*Math.PI;
   }

   //A public method you need to write to compute the circumference of the circle.

   public double getCircumference(){
      return radius*2*Math.PI;
   	//your code goes here. 
   }

   //A public method that compares the sizes of two circles. CircleA.isBiggerThan(CircleB) should return true if circleA has a larger area than circle B, false otherwise. 
   //The method is named, but you should fill in the signature. 
   public boolean isBiggerThan(Circle second){
      return this.getRadius() > second.getRadius();
   	//Fill this code in. 
   }

   //A public method that takes as input an x coordinate (as a double) and a y coordinate (a double), and returns true if the (x,y) coordinate 
   //is inside the circle, and false otherwise. The method is named, but you should fill in the signature. 
   public boolean containsPoint(double xPoint, double yPoint){
      double xDistance = xPoint - this.x;
      double yDistance = yPoint - this.y;

      return (xDistance * xDistance) + (yDistance * yDistance) < this.getRadius() * this.getRadius();
   	//fill in this code. 
   }

   public double getX(){
      return x;
   }

   public double getY(){
      return y;
   }

   //A method that sets the radius called setRadius. the signature should be a double. it should have return type void, and  should set the radius.
   public void setRadius(double r){
      radius = r;
   }

   //a method that sets the center called setCenter. the signature should be two doubles, ex and why. it should have return type void,  and it should set the x coordinate of the circle to ex and the y coordinate of the circle to why.
   public void setCenter(double ex, double why){
      x = ex;
      y = why;
   }

   //a toString method that prints the statement "This cicrlce is centered at point  (display the coordinate of the center) with radius (display the radius)".//

   public String toString(){
      return "This circle is centered at point ( " + x + ", " + y + " ) with radius " +radius;
   }


   





}