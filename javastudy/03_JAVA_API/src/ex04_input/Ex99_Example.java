package ex04_input;

public class Ex99_Example {

	public static void main(String[] args) {

		// 연습문제 1번
		for(int n = 1; n <= 10; n++) {
			System.out.print(n + " ");
		}
		
		// 연습문제 2번
		for(int n = 10; n >= 1; n--) {
			System.out.println(n + " ");
		}
		
		// 연습문제 3번
		for(int n = 1; n <= 9; n++) {
			System.out.print("7x" + n + "=" + (7 * n) + " ");
		}
		
		System.out.println();
		// 연습문제 4번
		for(int n = 1; n <= 100; n++) {
				if(n % 3 == 0) {
				System.out.print(n + " ");
				}
		}
		
		System.out.println();
		// 연습문제 5번
		int total = 0;
		for(int n = 1; n <= 100; n++) {
			total += n;
		}
		System.out.println(total);
		
		// 연습문제 7번
		int point = 9;
		String star = "";
		for(int n = 1; n <= point; n++) {
			star += "★";
		}
		System.out.println(star);
		
		// 연습문제 8번
		int balance = 69450;
		int money = 4000;
		while(balance >= money) {
			System.out.println("잔액 :" + balance + " 인출액 :" + money);
			balance -= money;
			}
		System.out.println(balance);
		
		// 연습문제 9번
		int total2 = 0;
		for(int n = 1; n <= 100; n++) {
			if(n % 3 == 0); continue;
		}
		System.out.println("연습문제 9번 " + total2);




	}

}
