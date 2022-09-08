package controller;

import java.util.Scanner;

import domain.ContactDTO;
import service.ContactService;
import service.ContactServiceImpl;

public class ContactController {

	/************** Field **************/
	private Scanner sc;
	private ContactService contactService;
	
	
	/************** Constructor **************/
	// 입력을 위한 Scanner 클래스
	// ContactService 호출을 담당
	public ContactController() {
		sc = new Scanner(System.in);
		contactService = new ContactServiceImpl();
	}
	
	
	/************** Method **************/
	public static void menu() {
		
		System.out.println("1.연락처등록");
		System.out.println("2.연락처수정");
		System.out.println("3.연락처삭제");
		System.out.println("4.연락처조회");
		System.out.println("5.전체연락처");
		System.out.println("0.종료");
		
	}
	
	public void play() {
		while(true) {
			menu();
			System.out.print("선택(1~5,0) >>> ");
			int choice = sc.nextInt();	// 숫자는 choice에 저장
			sc.nextLine();				// 숫자 입력하고 누른 엔터 처리
			switch(choice) {
			case 1: 
				System.out.print("신규 연락처 이름 >>> ");
				String name = sc.next();
				System.out.print("신규 연락처 전화번호 >>> ");
				String tel = sc.next();
				System.out.print("신규 연락처 이메일 >>> ");
				String email = sc.next();
				ContactDTO contact = new ContactDTO();	// 위에서 추가할 거를 하나로 모아줌
				contact.setName(name);
				contact.setTel(tel);
				contact.setEmail(email);
				contactService.addContact(contact);	// 하나로 모아준걸 contact 1. 출발 > ContactServiceImpl의 2. addContact로 도착
				
				
				break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 0: return;
			default: System.out.println("다시 선택 하세요.");
			}
		}
	}
	
}