package ex13_abstract;

// 추상 메소드
// 1. 본문이 없는 메소드
// 2. 호출용으로 사용되는 메소드
// 3. 중괄호{} 자체를 없애고 세미콜론(;)을 추가함
// 4. public abstract(추천) 또는 abstract public

// 추상 클래스
// 1. 추상 메소드가 1개 이상 존재하는 클래스.
// 2. public abstract class
// 3. 본문이 없는 메소드를 포함하기 때문에 객체 생성이 불허됨.
// 4. 추상 클래스를 상속 받는 클래스는 "반드시" "모든" 추상 메소드를 오버라이드 해야 함. 

public abstract class Shape {
	
	private String type;

	public Shape(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public abstract double getArea();		// 본문이 없다. 중괄호 없다.	
		
		// shape를 상속 받는 객체들이 호출할 때 사용하는 메소드.
		// = 사용되지느 않는다. → 추상 메소드로 바꿔준다.
		// 모든 도형은 넓이가 있지만, 결정된 도형이 없어서 리턴 0
		// 넓이가 없는데 굳이 0을 넣은 이유는 호출 때문이다.
		// 0이라도 없으면 호출이 안된다. 0을 넣은 이유는 오직 호출 때문이다.
									
	

}
