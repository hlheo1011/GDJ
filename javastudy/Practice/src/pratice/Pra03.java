package pratice;

import java.util.Scanner;

public class Pra03 {

	public static void main(String[] args) {

		// 문제3.
		// 돈을 입력받아 오만원권, 만원권, 오천원권, 천원권, 오백원 동전,
		// 백원 동전, 오십원 동전, 십원 동전, 오원 동전, 일원 동전이
		// 각각 몇 개로 변환되는지 출력하시오. 이 때 반드시 다음과 같은
		// 배열을 사용하여 반복문으로 처리하시오.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 입력하세요 >>> ");
		int money = sc.nextInt();
		
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		
		for(int i = 0; i < unit.length; i++) {
			
			unit[0] = money / 50000;			// 5만원
			unit[1] = (money - 50000) / 10000;	// 만원
			unit[2] = money / 5000;				// 5천원
			unit[3] = (money - 5000) / 1000;	// 천원	
			unit[4] = money / 500;				// 오백원
			unit[5] = (money - 500) / 100;		// 백원
			unit[6] = money / 50;				// 오십원
			unit[7] = (money - 50) / 10;		// 십원
			unit[8] = money / 5;				// 오원
			unit[9] = (money - 5) / 1;			// 일원		
			
			System.out.println(unit[i]);
		}
		

		
		
		// 금액을 입력하시오 >> 75832원
		// 50000원 짜리 : 1개
		// 10000원 짜리 : 2개
		// 5000원 짜리 : 1개
		// 500원 짜리 : 1개
		// 100원 짜리 : 3개
		// 10원 짜리 : 3개
		// 1원 짜리 : 2개

	}

}
