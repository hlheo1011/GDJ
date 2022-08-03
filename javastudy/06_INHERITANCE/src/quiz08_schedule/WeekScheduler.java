package quiz08_schedule;

import java.util.Scanner;

public class WeekScheduler {
	
	// 필드
	private int nthWeek;	// 1 ~ n주차
	private Day[] week;
	private String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	private Scanner sc;
	
	// 생성자
	public WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		week = new Day[7];					// 일주일의 수.
		sc = new Scanner(System.in);
	}
	
	// 메소드
	private void makeSchedule() {
		System.out.println("▦▦▦ 등록 ▦▦▦");
		System.out.print("요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);		// 월요일 입력시 요일을 짜르기 위해, 0번만 인식하게 해줌.
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
			// dayNames[i] 랑.. 수요일이랑.. 비교를 하는것..이다..? ? ?
				if(week[i] == null) {	// 등록된 스케쥴이 없으면
				// week[i]에 스케쥴을 넣는게 우리가 해야 할 일이다.
					System.out.print("스케쥴 입력 >>> ");
					String schedule = sc.nextLine();	// 스케쥴에 공백입력이 가능
					Day day = new Day();
					day.setSchedule(schedule);
					week[i] = day;
					// [i] 스케쥴을 받아서 위크 i에 넣는다.
					System.out.println(dayName + "요일에 새 스케쥴이 등록되었습니다.");
				} else {
					System.out.println(dayName + "요일은 이미 스케쥴이 있습니다." );
				}
				return;
				// if, else 다음에 for 아래있는 없는요일은 출력하면 안되니까 return.
			}
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");
	}
	
	
	private void changeSchedule() {
		System.out.println("▦▦▦ 수정 ▦▦▦");
		System.out.println("변경할 요일 입력 >>> ");
		String dayName = sc.next().substring(0,1);
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {
					System.out.println(dayName + "요일은 스케쥴이 없습니다.");
					System.out.print("새 스케쥴을 등록할까요(y/n)? >>> ");
					String yesNo = sc.next().substring(0,1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						System.out.print("새 스케쥴 입력 >>> ");
						String schedule = sc.nextLine();
						Day day = new Day();
						day.setSchedule(schedule);
						week[i] = day;
						System.out.println(dayName + "요일에 새 스케쥴이 등록되었습니다");
					} else {
						System.out.println(dayName + "요일의 새 스케쥴 등록이 취소되었습니다.");
					}
				} else {
					System.out.print(dayName + "요일의 스케쥴은 " + week[i].getSchedule() + "입니다.");
					System.out.println("변경할까요?(y/n) >>> ");
					String yesNo = sc.next().substring(0,1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						System.out.print("변경할 스케쥴 입력 >>> ");
						String schedule = sc.nextLine();
						week[i].setSchedule(schedule);
						System.out.println(dayName + "요일의 스케쥴이 변경되었습니다.");
					} else {
						System.out.println(dayName + "요일의 스케쥴 변경이 취소되었습니다.");
					}
				}
				return;
			}
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");
	
	}
	
	
	private void deleteSchedule() {
		System.out.println("▦▦▦ 삭제 ▦▦▦");
		System.out.println("삭제할 요일 입력 >>> ");
		String dayName = sc.next().substring(0,1);
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {
					System.out.println(dayName + "요일은 스케쥴이 없습니다.");
				} else {
					System.out.println(dayName + "요일의 스케쥴은 " + week[i].getSchedule() + "입니다.");
					System.out.println("삭제할까요(y/n)? >>> ");
					String yesNo = sc.next().substring(0,1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						week[i] = null;
						System.out.println(dayName + "요일의 스케쥴이 취소되었습니다.");
					} else {
						System.out.println("스케쥴 삭제가 취소되었습니다.");
					}
				}
				return;
			}
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");
	}
	
	
	private void printWeekSchedule() {
		System.out.println("▦▦▦ 전체조회 ▦▦▦");
		System.out.println(nthWeek + "주차 스케쥴 안내");
		for(int i = 0; i < week.length; i++) {
			System.out.print(dayNames[i] + "요일 - ");
			System.out.println(week[i] == null ? "X" : week[i].getSchedule());
		}
	}
	
	
	public void manage() {
		
		while(true) {
			
			System.out.print("1.등록 2.수정 3.삭제 4.전체조회 0.종료 >>> ");
			int choice  = sc.nextInt();	// 숫자만 받아감
			sc.nextLine();				// 엔터만 받아감
			
			switch(choice) {
			case 1: makeSchedule(); break;
			case 2: changeSchedule(); break;
			case 3: deleteSchedule(); break;
			case 4: printWeekSchedule(); break;
			case 0: System.out.println("스케쥴러를 종료합니다."); return;
			default : System.out.println("인식할 수 없는 명령입니다.");
			}
			
		}
		
	}

	
	
	
	
	
	
}
