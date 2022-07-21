package ex02_loop;

public class Ex02_while {

	public static void main(String[] args) {

		// while문
		// 특정 실행문을 반복할 때 사용한다.
		// 특정 반복 횟수가 정해지지 않은 경우에 사용한다. 
		// (읽어들일 데이터가 어느정도인지 가늠할 수 없을때 사용한다.)
		// (예제를 해줄 수가 없다.)
		// (하다못해 파일이라도 읽어봐야하는데.. 읽어 볼 수도 없다.)
		// (그냥 이런게 있다. 라고만 알고 있으면 됨.)
		// while(조건문) {
		//		실행문
		// }
		// (if문과 똑같이 생김)
		
		int balance = 79350;			// for문으로 만들 순 있으나, 예쁘진 않다.
		int money = 450;				// 이런 경우 while문이 적당하다.
		// 통장 잔액이 79350일 때, 450원씩 계속 출금했을때의 통장 잔고를 모두 출력
		
		while(balance >= money) {
			System.out.println("잔액 " + balance + " 인출액 " + money); 
			balance -= money;
		}
		System.out.println("잔액 " + balance);		
		
		// 예시 할게 없다.. 있긴 있으나 도움이 안됨.
		// for문을 많이 연습해라
		

	}

}
