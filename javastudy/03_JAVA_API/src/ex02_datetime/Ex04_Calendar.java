package ex02_datetime;

import java.util.Calendar;

public class Ex04_Calendar {

	public static void main(String[] args) {

		// java.utill.Calendar 클래스
		// 현재 날짜 또는 특정 날짜를 나타낼 때 사용
		// 날짜의 특정 요소(년, 월, 일, 시, 분, 초, ...)를 쉽게 사용
		// OOP (객체지향 프로그램) (Object Oriented Programming = 객체를 기반으로 프로그래밍을 한다.)
		
		Calendar cal = Calendar.getInstance();	// 객체 cal은 현재 날짜와 시간으로 구성 (실행되는 순간의 날짜 구성)
		
		// 년, 월, 일, 요일 	// 일 이라고 하는건 달(month) 기준이여서 Day of month를 사용한다.
		int year = cal.get(Calendar.YEAR); 		// int year = cal.get(1);
		int month = cal.get(Calendar.MONTH) + 1;	// 월 : 0 ~ 11 (주의가 필요함) // 실제 사용시 +1 을 붙인다.
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int weekNo = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		switch(weekNo) {
		case 1: System.out.println("일요일"); break;
		case 2: System.out.println("월요일"); break;
		case 3: System.out.println("화요일"); break;
		case 4: System.out.println("수요일"); break;
		case 5: System.out.println("목요일"); break;
		case 6: System.out.println("금요일"); break;
		default : System.out.println("토요일");
		}
		System.out.println(weekNo);
		
		// 오전/오후, 시, 분, 초
		int ampm = cal.get(Calendar.AM_PM); 			// 오전(0), 오후(1)
		int hour12 = cal.get(Calendar.HOUR);			// 시(1 ~ 12)
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);		// 시(0 ~ 23) !!주의
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		switch(ampm) {
		case 0: System.out.println("오전"); break;
		case 1: System.out.println("오후"); break;
		}

		System.out.println(hour12);
		System.out.println(hour24);
		System.out.println(minute);
		System.out.println(second);
		
		// timestemp
		long timestemp = cal.getTimeInMillis();
		System.out.println(timestemp);
		
	}

}
