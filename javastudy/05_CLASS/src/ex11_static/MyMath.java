package ex11_static;

public class MyMath {

	// static
	// 1. 정적 요소이다.
	// 2. 객체 생성 이전에 메모리에 미리 만들어 지는 공동 요소
	// 3. 클래스에서 1개만 만들어 진다.
	// 4. 클래스를 이용해서 호출하기 때문에 클래스 변수, 클래스 메소드 라고도 부른다.
	
	// 필드값
	// static final = S F
	public static final double PI = 3.141592;
	// final = 마지막 값. 바꿀 수 없다. 그래서 퍼블릭으로 해도 된다.
	// 공개하는 필드 값은 public static final이 붙는다.
	
	
	// 메소드
	public static int abs(int n) {
		return (n >= 0) ? n : -n;
	}
	
	public static int pow(int a, int b) {
		// a의 b제곱 반환
		int result = 1;
		for (int cnt = 0; cnt < b; cnt++) {
			result *= a;
		}
		return result;
	}
	
}
