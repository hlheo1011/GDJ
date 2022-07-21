package ex01_random;

public class Ex01 {													// class 상위 = Math

	public static void main(String[] args) {						// main method 하위 (class안에 main이 들어옴)

		// 난수 (Random number) 발생								// 어떤 클래스를 적고 마침표를 찍으면, 메소드를 확인 할 수 있다.
		// Random 클래스, Math 클래스를 주로 활용한다. 
		// 인증코드 랜덤 숫자로 활용 가능하다.
		
		System.out.println(Math.random());
		
		// 0.0 <= Math.random() < 1.0 								// 0.0 ~ 1.0 사이의 데이터가 발생한다.
		// 0%  <= Math.random() < 100%								// 위의 값을 이렇게도 볼 수 있다. 확률 처리할 때 사용
		
		// 1. 확률 처리하기
		// 10% 확률로 "대박", 90% 확률로 "쪽박"
		if(Math.random() < 0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		}
		
		// 2. 난수 값 생성
		
		// Math.random()					0,0 <= n < 1.0
		// Math.random() * 5 				0.0 <= n < 5.0
		// (int)(Math.random() * 5)			0   <= n < 5				// 강제 형 변환
		// (int)(Math.random() * 5) + 1		1   <= n < 6				// 1부터 5개의 난수가 발생한다.
		
		// 연습.
		// 주사위 2개 던지기
		for(int n = 0; n < 2; n++) {
			int dice = (int)(Math.random() * 6) + 1;
			System.out.println("주사위" + dice);
		}
		
		// 연습.
		// 6자리 숫자 인증번호 만들기\
		// String code = "501924"		
		String code = "";							// string을 int로 하면 안됨. 앞자리가 0인경우는 생략되며, 합산됨
		for(int n = 0; n < 6; n++) {
			code += (int)(Math.random() * 10);
		}
		System.out.println(code);

		// 아스키 코드
		// 48 = '0'
		// 65 = 'A' ~ 90 = 'Z'
		// 97 = 'a'
		
		// 1 + 1.5 =				// 정수와 실수 계산은 자동캐스팅으로 계산 해준다
		// 1 + 'A';					// 정수와 문자 또한 자동캐스팅(?)으로 계산 해준다.
									// 'A'의 아스키코드는 65번이므로 +1 = 66인 'B'
		
		System.out.println((char)((int)(Math.random() * 26) + 'a'));
		
		
		// 연습.
		// 대문자와 소문자를 말 그대로 랜덤하게 섞어서 6자리
		code = "";			// 변수(?) 초기화
		
		for(int n = 0; n < 6; n++) {
			if(Math.random() < 0.5) {					// 50%의 확률의 0.5
				code += (char)((int)(Math.random() * 26) + 'A');
			} else {
				code += (char)((int)(Math.random() * 26) + 'a');
			}
		}
		System.out.println(code);

	
		// 연습 > 통장에서 보이스피싱을 당해서 얼마정도 랜덤으로 빼갔는지 출력.	
		

	}

}
