package ex13_abstract;

public class Circle extends Shape {
	
	private double radius;

	public Circle(String type, double radius) {
		super(type);
		this.radius = radius;
	}

	// Shape 클래스는 추상 클래스이므로, 반드시 double getArea() 메소드를 오버라이드 해야 함.
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);			// pow는 제곱. (반지름의 2제곱) 반지름 x 반지름도 무방함.
	}
	

}
