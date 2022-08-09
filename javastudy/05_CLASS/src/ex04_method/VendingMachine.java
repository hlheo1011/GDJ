package ex04_method;

public class VendingMachine {

	String getCoffee(int money, int button) {
		
		String[] menu = {"아메리카노", "카페라떼"};	
		
		return menu[button - 1] + " " + (money / 1000) + "잔";
		
		/*	인덱스 번호를 맞추는 다른 코드
		 * String[] menu = {"", "아메리카노", "카페라떼"};	
		 * return menu[button] + " " + (money / 1000) + "잔";
		 */
		
	}
	
}
