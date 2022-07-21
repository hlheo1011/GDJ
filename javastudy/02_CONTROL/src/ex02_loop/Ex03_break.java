package ex02_loop;

public class Ex03_break {

	public static void main(String[] args) {

		// break문
		// switch문을 종료할 때 사용한다.
		// 반복문(for, while)을 종료시킬 때 사용한다.
		
		/*while(true) { 		// while(true) {}의 true는 항상 만족한다. = 무한 루프
			if(조건문) {	// System.out.println(); 을 할 수 없다. 끝이 없어서 도달할수 없는 값.
				break;		// 그래서 break를 써줘야 함
			}
		}
		
		System.out.println();
		*/
		
		// 모금 목표 : 100000원
		// 한 번에 30원씩 모금
		
		// 1회 모금액 30원	현재 30원
		// 2회 모금액 30원	현재 60원
		// ... 위와 같이 출력
		
		
		int total = 0;			// 현재 00원
		int money = 50000;			// 모금액 30원
		int serial = 0;			// n회
		int goal = 1000000;		// 목표금액
		while(true) {
			if(total >= goal) {
				break;
			}
			
			total += money;
			serial++;
			System.out.println(serial + "회 모금액 " + money + "원" + "\t현재 " + total + "원");
		}
			
		

	}

}
