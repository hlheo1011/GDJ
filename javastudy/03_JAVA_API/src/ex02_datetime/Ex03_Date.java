package ex02_datetime;

import java.sql.Date;

public class Ex03_Date {

	public static void main(String[] args) {
		
		// java.sql.Date 클래스
		// 데이터베이스의 날짜 표시 방식에 맞춰 놓은 클래스
		// Oracle 데이터베이스의 날짜 타입("/", "-")과 매칭해서 사용
		
		// long 타입의 Date는 timestemp 뿐이다.
		
		
		// 아래는 예시는 예시일 뿐, 안외워도 된다.
		// 위에 주석 3줄이 중요하다.
		Date now = new Date(System.currentTimeMillis());
		System.out.println(now);		

	}

}
