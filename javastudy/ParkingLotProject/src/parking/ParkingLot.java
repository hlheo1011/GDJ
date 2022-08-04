package parking;

import java.util.Scanner;

public class ParkingLot {
	
	// field
	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	// constructor
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	// method - addCar
	private void addCar() {
		if(idx == cars.length) {
			System.out.println("더이상 차량 등록이 불가능합니다. (현재 등록된 차량 : " + idx + "대)");
			return;
		}	
		System.out.println("현재 등록된 차량 " + idx + "대");
		Car car = new Car();
		System.out.print("차량 번호 >>> ");
		String carNo = sc.next();
		car.setCarNo(carNo);
		System.out.print("차량 모델 >>> ");
		String carModel = sc.next();
		car.setModel(carModel);
		cars[idx++] = car;
		System.out.println("차량번호 " + carNo + "차량이 등록되었습니다.");
	}
	

	// method - deletCar
	private void deleteCar() {
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.print("제거할 차량번호 >>> ");
		String carNo = sc.nextLine();
		for(int i = 0; i < idx; i++) {
			if(cars[i].getCarNo().equals(carNo)) {
				cars[--idx] = null;
				System.out.println("차량번호 " + carNo + " 차량이 삭제되었습니다.");
				return;
			}
			
		}
		System.out.println("대상 차량이 존재하지 않습니다.");	
	}
	
	// method - printAllCars
	private void printAllCars() {
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;			
		}
		System.out.println(name + " 차량 목록");
		for(int i = 0; i < cars.length; i++) {
			if(cars[i] != null) {
				System.out.println(cars[i]);
			}
		}
	}
	
	// method - manage
	public void manage() {
		while(true) {
			System.out.print("1.추가 2.삭제 3.전체 0.종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1: addCar(); break;
			case 2: deleteCar(); break;
			case 3: printAllCars(); break;
			case 0: System.out.println("주차 차량관리 프로그램을 종료합니다.");	return;
			default: System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
	}

}
