package application;

import entities.Circle;

public class Program {
	
	public static void main(String[] args) {

		Circle c1 = new Circle(3);
				
		System.out.println( "Pi = " + Circle.PI );
		System.out.println( "Radius = " + c1.radius);
		System.out.println( "Perimeter = " + c1.perimeter() );
		System.out.println( "Area = " + c1.area() );
		
		System.out.println("------------------");
				
		System.out.println(Circle.calculatePerimeter(2));
		
	}

}
