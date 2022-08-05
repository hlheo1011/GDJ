package quiz02_game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpDownGame {
	
	// 필드
	private int rand; // 1 ~ 100 사이 난수
	private int count; // 시도 횟수
	private Scanner sc;

	
	// 생성자
	public UpDownGame() {
		// rand, sc 만들기
		rand = (int)(Math.random() * 100 + 1);
		sc = new Scanner(System.in);		
	}
	
	// 입력
	public int input() {
		// public int input() throws RuntimeException, InputMismatchException { // uncheckedException 이여서 메소드 뒤에 명시를 안해줘도 된다.
			count++;
			System.out.print("숫자를 입력하세요. >>> ");
			int n = sc.nextInt();
			if(n < 1 || n > 100) {
				throw new RuntimeException("1 ~ 100 사이 정수만 입력할 수 있습니다.");
			}
			return n;
		}
	
	// 실행
	public void play() {
		
			while(true) {
				
				try {
					int n = input();	
					if(n < rand) {
						System.out.println("Up!");
					} else if (n > rand) {
						System.out.println("Down!");
					} else {
						System.out.println(n + ", 정답입니다! " + count + "회 시도 만에 성공!");
						break;
					}
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println("정수만 입력 가능합니다.");
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}

		
		
	}
	
	

}
