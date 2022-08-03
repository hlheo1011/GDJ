package library;

import java.util.Scanner;

public class Library {
	
	// 필드
	private Scanner sc;					// 객체의 선언.
	private Book[] books;				// 배열의 선언.
	private int idx;					// 책을 저장 할때 배열이여서 인덱스가 기억한다.
	
	public Library() {
		sc = new Scanner(System.in);
		books = new Book[100];
	}
	
	
	// 메소드의 기능을 숨긴다. 
	private void addBook() {
		if(idx == books.length) {
			System.out.println("더 이상 등록할 수 없습니다.");
			return;
		}
		System.out.println("===책등록===");
		System.out.print("제목 입력 >>> ");
		String title = sc.next();
		System.out.print("저자 입력 >>> ");
		String author = sc.next();
		Book book = new Book(idx + 1, title, author);		// idx 의 초기값은 0 이기때문에 + 1
		books[idx++] = book;
	}

	private void removeBook() {
		if(idx == 0) {
			System.out.println("삭제할 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("===책삭제===");
		System.out.print("삭제할 책 번호 >>> ");
		int bookNo = sc.nextInt();
		// 번호는 1번이지만, 인덱스는 0이기 때문에.
		for(int i = 0; i < idx; i++) {
			if(books[i].getBookNo() == bookNo) {
				System.arraycopy(books, i + 1, books, i, idx - i - 1);
				// books, bookNo + 1 < 원본
				// books, bookNo < 복사하는 곳
				books[--idx] = null;
				System.out.println("책 번호가 " + (i + 1) + "인 책을 삭제했습니다.");
				return;
			}
		}
		System.out.println("책 번호가 " + bookNo + "인 책이 없습니다.");	
		
	}
	
	private void findBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("===책조회===");
		System.out.print("조회할 책 제목 입력 >>> ");
		String title = sc.next();
		for(int i = 0; i < idx; i++) {
			// 저장된 책 제목 : books[i].getTitle()
			// 조회할 책 제목 : title
			// String 동등비교 : equals() 메소드
			if(books[i].getTitle().equals(title)) {			// == 같은 코드 if(title.equals(books[i].getTitle())
				System.out.println(books[i]);
				return;
				// 또는 break. break 넣으면 for문이 끝난다. 
				// return은 메소드 자체가 끝난다. 
				// 여기선 return이 좋다. for문이 끝났을때 찾는 책을 못찾았다는 메세지 입력을 위해서.
			}	// else는 안됨. 왜냐하면 찾는책 없다고 계속 해서 나옴. 
		}
		System.out.println("제목이 " + title + "인 책은 없습니다.");
	}
	
	private void printAllBooks() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("===전체조회===");
		for(int i = 0; i < idx; i++) {
			System.out.println(books[i]);
		}
	}
	
	public void manage() {	
		while(true) {
			System.out.print("1.추가 2.삭제 3.조회 4.전체목록 0.프로그램종료 >>> ");
			int choice = sc.nextInt();	// 숫자 정보 먹는 애
			sc.nextLine();				// Enter key 먹는 애 - 입력받아서 저장안하고 버림. (불필요한 엔터 제거)
			switch(choice) {
			case 1: addBook(); break;
			case 2: removeBook(); break;
			case 3: findBook(); break;
			case 4: printAllBooks(); break;
			case 0: System.out.println("Library 프로그램을 종료합니다. 감사합니다.");
					return;		// manage() 메소드 종료
			default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요.");
			}
		}
			
		
	}

}