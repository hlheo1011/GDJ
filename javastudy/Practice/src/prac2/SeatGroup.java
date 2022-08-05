package prac2;

import java.util.Scanner;

public class SeatGroup {

	private String seatType;	// "S", "R", "A"
	private Seat[] seats;		// 좌석이 여러개 있는 그룹.
	private Scanner sc;
	// idx는 사용 할 필요는 없다. 순서대로 자리를 배치 하는 것이 아니기 때문에.
	
	public SeatGroup(String seatType, int cnt) {	// "S"석 10개, "A"석 20개로 사용할 생성자 
		this.seatType = seatType;
		seats = new Seat[cnt];
		for(int i = 0; i < seats.length; i++) {
			//seat의 길이도 상관없고 cnt도 상관없다.
			seats[i] = new Seat();	//빈 좌석 가져다 두기
			// 이 코드를 안넣으면, null값 10개만 생성한거고, 의자는 없는거다. 10개의 new Seat가 필요한거다.			
		}
		sc = new Scanner(System.in);
	}
	
	// 예약
	public boolean reserve() {
		reserveInfo();	// 예약상황 확인
		// 시트번호는 1번부터 시작
		System.out.print("예약할 시트번호 >>>");
		int seatNo = sc.nextInt();
		if(seatNo < 1 || seatNo > seats.length) {
			System.out.println(seatNo + "번 좌석은 없는 좌석입니다.");
			return false;
		}
		// 예약된 시트인지 확인
		if(seats[seatNo - 1].isOccupied()) {
			// isIccupied는 Seat 클래스에 있음.
			System.out.println(seatNo + "번 좌석은 이미 예약된 좌석입니다.");
			return false;
		}	
		// 예약 진행
		System.out.print("예약자 이름 >>> ");
		String name = sc.next();
		seats[seatNo - 1].reserve(name);
		System.out.println(seatNo + "번 좌석 예약이 완료되었습니다.");
		return true;		
	}

	
	// 예약 취소
	public boolean cancle() {
		reserveInfo();
		System.out.print("취소자 이름 >>> ");
		String name = sc.next();
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {// 예약된 좌석만 비교 
			// if가 없어도 비교가 되긴 하지만 null값이랑도 비교한다.
			// if(seats[i] != null) 은 할수 없다. 생성자에서 null값이 아닌 new seat를 생성했기 떄문에. 
				if(seats[i].isMatched(name)) {	// 예약자 이름과 취소자 이름이 같으면 true 반환.
					seats[i].cancle();
					System.out.println("예약자 " + name + "의 예약이 취소되었습니다.");
					return true;
				}
			}
		} // for
		System.out.println(name + "으로 예약된 좌석이 없습니다.");
		return false;
	}
	
	
	// 예약 상황 출력
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {
				System.out.print(seats[i].getName().substring(0, 1) + "* ");
			} else {
				System.out.print((i + 1) + (i < 9 ? "   " : "  "));
			}
			if((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
	}
	
	
	
	
}
