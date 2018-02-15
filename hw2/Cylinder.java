public class Cylinder extends Circle{
	
	private double z;
	private double height;

	public Cylinder(){
		super(1,0,0);
		height = 1;
		z = 0;
	}
	public Cylinder(int x, int y, int radius, int height){
		super(radius,x,y);
		this.height = height;
		z = 0;
	}

	public double getArea(){
		return radius*radius*Math.PI*height;
	}

	public double getHeight(){
		return height;
	}

	public void setHeight(double height){
		this.height = height;
	}
}