package ex06_constructor;


public class Student extends Person {
	
	// 필드값
	private String school;
	
	// 생성자
	// public Person(String name) 을 여기서 가져다 주는거다.
	// String school은 Student 필드값을 가져오는거다.
	// super = Person 슈퍼클래스의 생성자를 지정하는 일.
	public Student(String name, String school) {
		super(name);
		this.school = school;
	}
			

	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}
	
	

}
