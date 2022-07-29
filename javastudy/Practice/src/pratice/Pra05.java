package pratice;

import java.util.Scanner;

public class Pra05 {

	public static void main(String[] args) {

		// 문제5.
		// 3명의 학생의 점수를 입력 받아서 평균 점수와 1등의 이름과
		// 꼴등의 이름을 출력하시오
		
		String[] name = {"피카츄", "뽀로로", "브레드"};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("피카츄의 점수 입력 >>> ");
		name[0] = sc.next();
		int average1 = Integer.parseInt(name[0]);
		
		System.out.print("뽀로로의 점수 입력 >>> ");
		name[1] = sc.next();
		int average2 = Integer.parseInt(name[1]);
		
		System.out.print("브레드의 점수 입력 >>> ");
		name[2] = sc.next();
		int average3 = Integer.parseInt(name[2]);
		
		// 1등, 3등

		
		
		// 평균
		/*
		int average1 = Integer.parseInt(name[0]);
		int average2 = Integer.parseInt(name[1]);
		int average3 = Integer.parseInt(name[2]);
		*/
		
		double sum = (double)(average1 + average2 + average3) / name.length;
		
		System.out.println("평균 :" + sum);
		
		
		

		
				
	}

}
