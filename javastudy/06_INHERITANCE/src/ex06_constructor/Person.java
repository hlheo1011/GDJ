package ex06_constructor;

public class Person {
	
	// 필드
	private String name;
	
	// 생성자	// 전달받은 매개값을 필드값으로 전달 해 주는 생성자를 만듬.
	public Person(String name) {
		this.name = name;
	}
	
	
	//getter , setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
