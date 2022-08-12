package entities;

public class Circle {
	
	public final static double PI = 3.14159265;
	
	public double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double perimeter() {
		return 2*PI*radius;
	}
	
	public static double calculatePerimeter(double radius) {
		return 2*PI*radius;
	}
	
	public double area() {
		return PI*radius*radius;
	}
	
	public static double calculateArea(double radius) {
		return PI*radius*radius;
	}
}
