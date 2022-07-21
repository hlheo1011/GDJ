package ex02_loop;

public class Ex04_continue {

	public static void main(String[] args) {
		
		// continue문
		// 반복문의 시작 지점으로 이동한다.
		// 실행에서 제외할 코드가 있는 경우에 사용한다.
		// (continue는.. 공부안해도 됨. (대체 코드가 많음))
		// (continue가 많이 들어가면 좋은 코드가 아님.)
		// (이런게 있다라고 소개정도 하는 수업)
		
		// 1 ~ 100 중에서 3의배수를 제외하고 모두 더하기
		int total = 0;
		int n = 0;
		
		while(n < 100) {			// ← 
									// 	↑
			n++;					// 	↑
									//	↑ 
			if(n % 3 == 0) {		// 	↑
				continue;			// →
			}
			
			total += n;
		}
	
		System.out.println("합계(continue) " + total);
		
		// 같은코드
		total = 0;
		n = 0;
		while(n < 100) {
			n++;
			if(n % 3 != 0) {
				total += n;
			}
		}
		
		System.out.println("합계(if) " + total);
		// continue 없이 코드를 만드는 건 언제나 가능하다.
		
		/*/		
		while() {
			a;
			b;
			c;
			continue;  // a b c 만 실행하고 다시 while()문으로 이동한다. 
			// 그래서 무한 반복이 되므로 보통 if contune; 를 쓴다. (특정 조건 만족시 진행)
			d;
			e;
			f;
			g;
			h;
		}
		/*/

	}

}
