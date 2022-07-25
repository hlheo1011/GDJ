package ex04_input;

import java.util.Scanner;

public class Ex02_Scanner {

	public static void main(String[] args) {

		// java.util.Scanner 클래스
		// 공부 해야함~~ 낼 시험에 나옴~~
		// 데이터타입별로 입력 받을 수 있는 메소드를 제공
		// int		: nextInt()
		// long		: nextLong()
		// double	: nextDouble()
		// String	: nextLine() - 공백 포함 입력, next() - 공백 포함 불가능
		
		
		Scanner sc = new Scanner(System.in);		// 객체 sc는 System.in(키보드)으로부터 입력을 받는다.
		
		System.out.print("이름을 입력하세요 >>> ");
		String name = sc.next();					// String을 입력받을때 next를 쓴다.
		
		
		System.out.print("나이를 입력하세요 >>> ");
		int age = sc.nextInt();
		
		System.out.println(name);
		System.out.println(age);
				
		// 입력 후 엔터하면 다음 질문이 나온다. (데이터 타입에 맞게 입력을 해야한다.)
		
		
		// 연습. char 타입의 성별을 입력 받기
		System.out.print("성별(남/여)을 입력하세요 >>> ");
		char gender = sc.next().charAt(0);			// 메소드 뒤에 메소드를 연결했다는 의미의 메소드 체인.
		System.out.println(gender);
		
		sc.close(); 		// 생략이 가능하다.
		

	}

}
