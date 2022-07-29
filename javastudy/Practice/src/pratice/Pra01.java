package pratice;

import java.util.Scanner;

public class Pra01 {

	public static void main(String[] args) {	
	
	// 문제1.
	// 점수와 학년을 입력받아 60점 이상이면 합격, 60점 미만이면 불합격을 출력하시오.
	// 4학년인 경우 70점 이상이어야 합격이다.

		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요(0~100) >>> ");
		int score = sc.nextInt();
		System.out.print("학년을 입력하세요(1~4) >>> ");
		int year = sc.nextInt();
		
		if(score > 100 || score < 0) {
			System.out.println("잘못된 점수");
				return;
		} 
		
		if(year > 4 || year < 0) {
			System.out.println("잘못된 학년");
			return;
		} 
		
		if(year >= 4 && score >= 70) {
			System.out.println("합격!");
		} else if (year < 3 && score >= 60) {
			System.out.println("합격!");
		} else {
			System.out.println("불합격!");
		}
		
		sc.close();
	}


}



