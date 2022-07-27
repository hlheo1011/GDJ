package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Car car = new Car();
		
		car.addOil(50);			// 기름 50 더하기
		car.addOil(5);			// 기름 5 더하기
		car.addOil(100);		// 기름 100 더하기
		
		car.pushAccel();		// 기름 1 사용, 속도 25 증가
		car.pushAccel();		// 기름 1 사용, 속도 25 증가
		
		car.pushBreak();		// 속도 25 감소
		
		car.panel();			// systemp.out.println 기름 및 속도 출력
	}
}
