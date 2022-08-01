package ex08_override;

public class Rectangle extends Shape {
	
	private double height;
	private double width;

	public Rectangle(String type, double height, double width) {
		super(type);
		this.height = height;
		this.width = width;
	}
	
	// 직사각형
	@Override
	public double getArea() {
		return height * width;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println("너비 : " + width + ", 높이 : " + height);
		System.out.println("넓이 : " + getArea());
	}
	
	

}
