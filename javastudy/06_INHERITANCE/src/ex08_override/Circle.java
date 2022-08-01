package ex08_override;

public class Circle extends Shape {
	
	private double radius;

	public Circle(String type, double radius) {
		super(type);
		this.radius = radius;
	}

	// circle의 면적은 파이 * R의 제곱이다.
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);		// pow.. radius = 반지름, 2 = 2제곱
	}
	
	@Override
	public void info() {
		super.info();			
		System.out.println("반지름 : " + radius);
		System.out.println("넓이 : " + getArea());
		// 여기서는 super.info가 필요하다. 타입(종류)이 나오니깐.
	}
	

}
