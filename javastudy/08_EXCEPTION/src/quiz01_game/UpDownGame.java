package quiz01_game;

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
		try {
			count++;
			System.out.print("숫자를 입력하세요. >>> ");
			int n = sc.nextInt();
			if(n < 1 || n > 100) {
				throw new RuntimeException("1 ~ 100 사이 정수만 입력할 수 있습니다.");
			}
			return n;
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다.");
			sc.next();
			// sc.next(); 는 잘못 입력된 문자열 먹어 치우기
			input();
			// 다시 시도.
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
			input();
		}
		return 0; // 이클립스 안심시키는? 용도 // 실제로 이 리턴을 만날 일은 없다.
		// 코드가 이 아래까지 나올 일은 없지만, 오류가 뜸.
	}
	
	
	// 실행
	public void play() {
			while(true) {
				int n = input();
				
				if(n < rand) {
					System.out.println("Up!");
				} else if (n > rand) {
					System.out.println("Down!");
				} else {
					System.out.println(n + ", 정답입니다! " + count + "회 시도 만에 성공!");
					break;
				}
			}

		
		
	}
	
	

}
