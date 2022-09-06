package ex03_insert;

import java.util.Scanner;

public class InsertMain {

	public static void main(String[] args) {
		
		// 게시판 정보를 입력 받아서 BOARD 테이블에 저장하기
		// 1. Scanner 클래스로 정보 입력 받기
		// 2. Board 클래스 타입의 객체에 입력 받은 정보 저장하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("제목 >>> ");
		String title = sc.nextLine();
		
		System.out.print("내용 >>> ");
		String content = sc.nextLine();
		

	}

}
