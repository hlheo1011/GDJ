package quiz04_employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Company {

	// 필드
	private Employee[] employees;
	private int idx;
	private Scanner sc;
	
	// 생성자
	public Company() {
		employees = new Employee[5];
		sc = new Scanner(System.in);		
	}
	
	
	// 1. 등록메소드 (레귤러인지,템버러리인지) (풀,1)
	public void addEmployee() throws EmployeeException {
		System.out.println("현재 등록된 직원 : " + idx + "명");
		if(idx == employees.length) {
			throw new EmployeeException("FULL", 1000);
		}
		
		System.out.print("월급제(M)인지 시급제(T)인지 선택하세요.");
		String type = sc.next().substring(0, 1);
		
		if(type.equalsIgnoreCase("m")) {
			System.out.println("▷ 월급제 직원 등록");
			System.out.print("1.직원번호 >>> ");
			int regularNo = sc.nextInt();
			System.out.print("2.직원이름 >>> ");
			String regularName = sc.next();
			System.out.print("3.월급입력 >>> ");
			int salary = sc.nextInt();
			Regular regular = new Regular(regularNo, regularName, salary);
			employees[idx++] = regular;
			
		} else if (type.equalsIgnoreCase("t")) {
			System.out.println("▷ 시급제 직원 등록");	
			System.out.print("1.직원번호 >>> ");
			int temporaryNo = sc.nextInt();
			System.out.print("2.직원이름 >>> ");
			String temporaryName = sc.next();
			System.out.print("3.시급입력 >>> ");
			int timeMoney = sc.nextInt();
			System.out.print("4.일한시간입력 >>> ");
			int times = sc.nextInt();
			
			Temporary temporary = new Temporary(temporaryNo, temporaryName);
			employees[idx++] = temporary;		
			
			temporary.setPay(timeMoney * times);
			temporary.setWorkTimes(times);			
			
		} else {
			throw new EmployeeException("잘못된 입력", 1500);
		}


	}
	
	
	// 2. 삭제메소드 (사원번호 일치하면 삭제) (임티,2)
	public void dropEmployee() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("EMPTY", 2000);
			}
		System.out.print("직원 번호 >>> ");
		int employeeNo = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(employees[i].getEmpNo() == employeeNo) {
				System.arraycopy(employees, i + 1, employees, i, idx - i - 1);
				employees[--idx] = null;
				System.out.println("직원번호 " + employeeNo + "인 직원이 삭제되었습니다.");
				return;
			}
		}
		System.out.println("직원번호를 잘못 입력하였습니다.");
		
	}
	
	
	// 3. 조회메소드 (사원번호 일치하면 수정) (임티,2)
	public void findEmployee() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("EMPTY", 2000);
			}
		System.out.print("조회할 직원 번호 입력 >>> ");
		int empNo = sc.nextInt();
		// 번지수가 아닌 문자열을 출력해야 할거같은데  .. . 
		
		for(int i = 0; i < employees.length; i++) {
			if(employees[i].toString().equals(empNo)) {
				System.out.println(employees[i]);
				return;
			}
		}
		System.out.println("직원번호를 잘못 입력하였습니다.");
		
	
	}
	
	
	// 4. 조회메소드 (임티,2)
	public void printAllEmployees() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("EMPTY", 1000);
		}
		System.out.println("전체 직원을 조회합니다.");
		for(int i = 0; i < employees.length; i++) {
			if(employees[i] != null) {
				System.out.println(employees[i]);
			}
		}
	}
	
	
	public void manage() {
		
		while(true) {		
			try {
				System.out.print("1.등록 2.삭제 3.개인직원조회 4.전체직원조회 0.종료");
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) { 
				case 1 : addEmployee(); break;
				case 2 : dropEmployee(); break;
				case 3 : findEmployee(); break;
				case 4 : printAllEmployees(); break;
				case 0 : System.out.println("직원 관리 프로그램을 종료합니다."); return;
				default : throw new RuntimeException();
				}
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("처리 명령은 정수(1~4,0) 입니다.");
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	// 시급, 월급받는사람 월급을 표핸해보기 ★★★★

	
	
}
