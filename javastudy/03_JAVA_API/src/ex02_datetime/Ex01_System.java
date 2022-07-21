package ex02_datetime;

public class Ex01_System {

	public static void main(String[] args) {
		
		// System.out.println(); 의 System이다.
		
		// 1. 타임스탬프(timestamp)
		// 얘는 유명함, 중요함, 전산공부 할 때 필요
		// 1970-01-01 0:00부터 1/1000초마다 증가하는 long 타입의 정수값 (1초에 숫자 1000씩 증가함)
		long timestamp = System.currentTimeMillis();
		System.out.println(timestamp);
		
		// 2. 나도타임(nanoTime) (시간단위임)
		// 자주 사용되진 않음 // 안중요함
		/* s(second) 
		   > ㎳(밀리세컨)(천분의 1초)
		   > ㎲(마이크로세컨)(백만분의 1초)
		   > ㎱(나노세컨)(십억분의 1초) ('ㄹ' 에 있음) */
		// 나노초(㎱) 값을 가지는 long 타입의 정수값
		// 어떤 기준일자는 없어서 두 개의 나노초(㎱) 사이의 경과시간 계산용
		long beginTime = System.nanoTime();
		int total = 1 + 2 + 3 + 4 + 5;
		long endTime = System.nanoTime();
		System.out.println(total + "계산에 걸린 시간 : " + (endTime - beginTime) + "㎱");

		

	}

}
