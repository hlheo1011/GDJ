package prac2;

import java.util.Arrays;
import java.util.Scanner;

public class Hall {
	
	private String hallName; // 홀 이름
	private SeatGroup[] seatGroups;	// "S"석 "R"석 "A"석이 한 그룹 씩 있다.
	private Scanner sc;
	private String[] seatTypes = {"S", "R", "A"};
	private int[] seatCount = {20, 30, 40};
	
	public Hall(String hallName) {
		this.hallName = hallName;
		seatGroups = new SeatGroup[seatTypes.length];	// S, R, A 석이 있음을 의미
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i] = new SeatGroup(seatTypes[i], seatCount[i]);
		}
		sc = new Scanner(System.in);
	}
	
	// 예약
	public void reserve() {
		System.out.print("예약할 좌석 타입 입력" + Arrays.toString(seatTypes) + " >>> ");
		String seatType = sc.next();
		// S 입력 -> seatGroups[0].reserve();
		// R 입력 -> seatGroups[1].reserve();
		// A 입력 -> seatGroups[2].reserve();
		for(int i = 0; i < seatTypes.length; i++) {
			if(seatType.equals(seatTypes[i])) {
				seatGroups[i].reserve();		
				return;
				// (boolean)반환타입을 만들어 놓고, 안써도 상관없다.
			}
		}
		System.out.println(seatType + "타입은 없는 타입입니다.");
	}
	
	// 예약 취소
	public void cancel() {
		System.out.print("취소할 좌석 타입 입력" + Arrays.toString(seatTypes) + " >>> ");
		String seatType = sc.next();
		for(int i = 0; i < seatTypes.length; i++) {
			if(seatType.equals(seatTypes[i])) {
				seatGroups[i].cancle();		
				return;
			}
		}
		System.out.println(seatType + "타입은 없는 타입입니다.");
	}

	// 전체 예약 확인
	public void hallInfo() {
		System.out.println("[" + hallName + "]");
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i].reserveInfo();
		}
		System.out.println();
	}
	
	// 실행
	public void manage() {
		while(true) {
			System.out.println("1.예약 2.취소 3.예약현황 0.종료");
			int choice = sc.nextInt();
			switch(choice) {
			case 1 : reserve(); break;
			case 2 : cancel(); break;
			case 3 : hallInfo(); break;
			case 0 : System.out.println("예약프로그램을 종료합니다."); return;
			default : System.out.println("Bad Request");
			}
		}
	}


}
