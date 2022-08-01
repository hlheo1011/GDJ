package ex08_override;

public class Shape {
	
	private String type; // 도형의 종류

	public Shape(String type) {
		super();							// extends가 없지만. 신경 안써도 된다.
		this.type = type;
	}
	
	
	public double getArea() {
		return 0;
	}
	public void info() {
		System.out.println("도형의 종류 : " + type);
	}
	
	

}
