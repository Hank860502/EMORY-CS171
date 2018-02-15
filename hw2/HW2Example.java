public class HW2Example{
	public static boolean isLarger(Circle first, Rectangle second){
		return first.getArea() >= second.area();
	}

	public static boolean containsCenter(Circle first, Circle second){
		return first.containsPoint(second.getX(), second.getY());
	}

	public static double isLonger(Circle first, Rectangle second){
		if(first.getCircumference() > second.perimeter()){
			return first.getCircumference();
		}
		return second.perimeter();
	}

	public static double isLonger(Rectangle first, Circle second){
		if(first.perimeter() > second.getCircumference()){
			return first.perimeter();
		}
		return second.getCircumference();
	}

	public static double isDeeper(Circle first, Rectangle second){
		if(first.getArea() > second.area()){
			return first.getArea();
		}
		return second.area();
	}

	public static double isDeeper(Rectangle first, Circle second){
		if(first.area() > second.getArea()){
			return first.area();
		}
		return second.getArea();
	}
}