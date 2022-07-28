package ex09_this;

public class Student {

	// this
	// 1. 현재 객체의 참조값
	// 2. 현재 객체의 멤버(필드, 메소드)를 호출할 때 사용
	// 3. 생성자 내부에서 다른 생성자를 호출할 때 this() 형태로 사용
	
	// 필드
	private String stuNo;		// this.stuNo
	private String name;		// this.name
	
	// 생성자
	public Student() {
		
	}
	public Student(String stuNo, String name) {
		this.stuNo = stuNo;
		this.name = name;
	}
	
	// 메소드
	public String getStuNo() {
		return stuNo;					// stuNo = pStuNo 라고 했던걸 this를 붙임으로 인해
	}									// 필드값으로 불려진다.
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	// 메소드
	
	
	


	
	
	// 위 코드는 Source > Generate Getters and Setters로 들어가서 get과 set을 만들어준다.
	// 메소드 명을 바꾸려는 시도를 하면 안된다. (setStuNo)
	// 그래서 getters setters는 손으로 구현하지 않는다. 휴먼오류 때문에.
	
	
}
