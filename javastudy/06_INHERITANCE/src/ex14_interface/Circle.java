package ex14_interface;

public class Circle implements Shape {
	
	// 필드
	private double radius;
	
	// 생성자
	public Circle(double radius) {
		this.radius = radius;
	}

	// 메소드
	@Override
	public double getArea() {
		return PI * Math.pow(radius, 2);
		// PI는 인터페이스 Shape에 선언 해 둔 상수값.	
	}

}
