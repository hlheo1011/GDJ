package ex02_loop;

public class Ex01_for {

	public static void main(String[] args) {
		
		// for문
		// 연속된 숫자를 생성할 때 주로 사용한다.
		// 배열과 함께 자주 사용된다. (아직 안배운 내용임)
		// for(초기문; 조건문; 증감문) { // 일반적으로 증감문이 들어감.
		//		실행문
		// }
		
		// 1 ~ 10
		// 초기문은 선언하듯이 선언해 두는 것이다. (int n = 1;)
		// 조건문은 비교가 필요함 (n <=10)
		// 증감문은 (++, --)
		for(int n = 1; n <= 10; n++) {
			System.out.print(n); // 1,2,3,4,5,6,7,8,9,10
		}
		// for 문이 끝났을때 'n'의 값은 11임. System.out.println(n); 실행이 안됨.. 이유는 나중에..
		
		// 초기문 1번 -> 조건문 비교, 조건문 만족 시 -> 실행문 -> 증감문
		// -> 도돌이표 (조건문..실행문..증감문..)
		
		// print : 나열식 // println : 줄바꿈 해줌 // ln = line의 의미
		
		System.out.println(); // 간혹가다 이런 문구가 있음. Java에서는 줄 바꿈의 뜻 임
		
		// 연습. for문
		// 10 ~ 1
		for(int n = 10; n >= 1; n--) {
			System.out.print(n);
		}
		System.out.println();
		
		// 연습. for문
		// 구구단 7단 출력
		for(int n = 1; n <= 9; n++) {
			System.out.println("7x" + n + "=" + ( 7 * n));
		}

		// 연습. for문
		// 1 ~ 100 사이의 모든 3의 배수만 출력하기
		for(int n = 1; n <= 100; n++) {
			if(n % 3 == 0) {   // 3으로 나눴을때, 나머지가 0이라면
				System.out.print(n + " ");
			}
		}
		System.out.println();
		
		// 예시
		int wallet = 0;
		wallet += 1000;
		wallet += 2000;
		wallet += 3000;
		System.out.println(wallet);
		
		// 연습. for문 (위의 지갑 예시를 보고 적용)
		// 1 ~ 100 모든 정수 더하기 (5,050)
		
		int total = 0;
		for(int n = 1; n <= 100; n++) {
			total += n;
			}
		System.out.println("전체 합(total): " + total);
		
		
		// 연습. (for문)
		// begin ~ end 모든 정수 더하기
		// begin과 end중 누가 큰 지 모르는 상황
		// begin을 end보다 항상 작은 값으로 바꾸는 작업을 한 뒤, begin ~ end 모두 더하기 진행
		// begin이 end보다 크다면 begin과 end를 교환
		
		int begin = 100;
		int end = 1;
		
		if(begin > end) {
			int temp;
			temp = begin;
			begin = end;
			end = temp;
		}
		
		int sum = 0;
		for(int n = begin; n <= end; n++) {
			sum += n;
		}
		System.out.println("전체 합(sum): " + sum);
		
		
		// 연습. (for문)
		// 평점(1~5)에 따른 별(★) 출력하기
		int point = 3;
		String star = "";
		for(int n = 1; n <= point; n++) {
			star += "★";
		}
		System.out.println(star);		
		
		
		// 0에서부터 시작하는 반복문
		int point2 = 2;
		String star2 = "";
		for(int n = 0; n < point2; n++) {
			star2 += "★";
		}
		System.out.println(star2);	
		
		//
		
		
		
		/* 내가 푼 답안
		for(int star = 1; star <= 5; star++) {
			if(star == 1) {
				System.out.println(star + "점: ★");
			} else if(star == 2) {
				System.out.println(star + "점: ★★");
			} else if(star == 3) {
				System.out.println(star + "점: ★★★");
			} else if(star == 4) {
				System.out.println(star + "점: ★★★★");
			} else {
				System.out.println(star + "점: ★★★★★");				
			}
		}		
		System.out.println();
		
		
		String score;
		for(int star = 1; star <= 5; star++) {
			switch(star) {
			case 1: score = "점: ★"; break;
			case 2: score = "점: ★★"; break;
			case 3: score = "점: ★★★"; break;
			case 4: score = "점: ★★★★"; break;
			default: score = "점: ★★★★★"; 
			}
		}
		
		*/
		
		/* 추가적으로,
		String star;
		star = "★"						// 결론적으로는 ★이 한개 적립(?)
		star = "★"
		
		String star = "";
		star += "★"; 					// += 쓸때는, 빈 문자열("")을 꼭 넣어줘야 한다.
		star += "★";					// 결론적으로는 ★이 두개 누적
		*/
		

		
		
	}

}
