package pratice;

import java.util.Scanner;

public class Pra02 {

	public static void main(String[] args) {

		// 문제2. 
		// 커피 메뉴를 입력받아 가격을 알려주는 프로그램을 구현하시오.
		// switch 문을 이용하여 구현하시오.
		// (에스프레소, 카푸치노, 카페라떼는 3500원, 아메리카노는 2000원이다.)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("무슨 커피 드릴까요? >>> ");
		String menu = sc.next();
		int price = 0;
		switch(menu) {
		case "에스프레소":
		case "카푸치노":
		case "카페라떼": 
			price = 3500;
			System.out.println(menu + "는 " + price + "원 입니다."); break;
		case "아메리카노": 
			price = 2000;
			System.out.println(menu + "는 " + price +  "원 입니다."); break;
		default : System.out.println(menu + "(은)는 메뉴에 없습니다.");
		}

		sc.close();

		
		
		
	}

}
