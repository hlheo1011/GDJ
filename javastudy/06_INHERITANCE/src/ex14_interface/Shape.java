package ex14_interface;

public interface Shape {
	
	// final 상수(를 가질 수 있다.)
	// 일반 필드 값은 못가진다.
	public final static double PI = 3.141592;
	
	// 추상 메소드(를 가질 수 있다.) (abstract는 생략 가능)
	public double getArea();
	
	// default 메소드 (본문이 있는 메소드)
	// 공통 메소드
	public default void message() {
		System.out.println("나는 도형이다.");
	}
	
	
	
	
}
