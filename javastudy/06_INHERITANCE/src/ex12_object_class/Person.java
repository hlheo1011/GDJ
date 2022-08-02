package ex12_object_class;

public class Person {
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("먹는다.");
	}
		
	
	@Override
	// 오버라이드를 쓰는 이유는, Object안에 toString을 안쓰기 때문.
	// Object안에 toString은 평생 도움 될 일이 없다.
	public String toString() {
		return "이름 : " + name;	// System.out.println(person); 여기에서 사용 됨.
	}
	
	
	
	
	// Object equals
	@Override
	public boolean equals(Object anObject) { 	// p1. equals(p2)에서 사용됨.
		Person p = (Person) anObject;		 	// 펄슨타입으로 캐스팅
		return name.equals(p.name);				// equals(String에 가지고 있는)
	}
	
	

}
