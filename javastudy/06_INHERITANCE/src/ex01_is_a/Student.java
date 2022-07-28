package ex01_is_a;

// 서브클래스
// extends라는 키워드를 사용한다.
// 슈퍼클래스 Person의 모든 메소드를 자기것처럼 사용할 수 있다.

public class Student extends Person {

	public void study() {
		System.out.println("공부한다.");
	}
}
