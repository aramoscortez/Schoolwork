package itec220.labs;

public class Rectangle {
	
	private double width = 0;
	private double height = 0;
	
	private static int count = 0;
	
	Rectangle(){
		this.width = 1;
		this.height = 1;
		System.out.println("I am alive!");
		count++;
	}
	
	Rectangle(double height, double width){
		this.setWidth(width);
		this.height = height;
		System.out.println("I am alive!");
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea() {
		return this.width * this.height;
	}
	
	public double getPerimeter() {
		return 2*(this.height + this.width);
	}

	public static void main(String[] args) {
		// TODO
	}

}
