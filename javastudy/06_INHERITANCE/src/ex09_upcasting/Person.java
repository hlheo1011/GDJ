package ex09_upcasting;

public class Person {
	
	public void eat() {
		System.out.println("먹는다.");
	}
	
	// 서브클래스의 메소드. 하는 일은 없어도 된다.
	// Person타입의 객체가 호출할 수 있도록 추가해 둔 메소드
	public void study() {}
	public void work() {}

}
