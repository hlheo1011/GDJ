package ex02_casting;

public class Ex01 {

	public static void main(String[] args) {
		
		// 자동 형 변환
		// promotion이라고 한다.
		// 자동으로 다른 데이터타입으로 변환하는 것을 말한다.
		// 작은 크기의 데이터타입이 큰 크기의 데이터타입으로 변환될 때 자동으로 진행된다.
		// 정수가 실수로 변환될 때 자동으로 진행된다.
		
		long money = 10000; // 4바이트에 저장된 10000이 8바이트로 promotion된다.
		System.out.println(money);
		
		int score = 100;
		double realScore = score;  // 4바이트 int가 8바이트 double로 promotion된다. (정수타입인 int 가 실수타입인 double로 바뀌었다.)
		System.out.println(realScore);
		
		
		

	}

}
