package itec220.labs;

public class RunMyClass {

	public static void main(String[] args) {
		
		System.out.format("Rectangle Count: %d%n", Rectangle.getCount());
		
		Rectangle rectangle1 = new Rectangle(10, 10);
		
		System.out.format("Rectangle Count: %d%n", Rectangle.getCount());
		
		Rectangle rectangle2 = new Rectangle(12,10);
		
		System.out.format("Rectangle Count: %d%n", Rectangle.getCount());
		
		System.out.println();
		System.out.format("Rectangle 1 Area: %4.2f%n", rectangle1.getArea());
		System.out.format("Rectangle 1 Perimeter: %4.2f%n", rectangle1.getPerimeter());
		System.out.println();
		
		
		System.out.format("Rectangle 2 Area: %4.2f%n", rectangle2.getArea());
		System.out.format("Rectangle 2 Perimeter: %4.2f%n", rectangle2.getPerimeter());
		System.out.println();
	}

}
