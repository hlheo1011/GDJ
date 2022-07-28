package ex11_static;

public class MyMathMain {

	public static void main(String[] args) {

		System.out.println(MyMath.PI);
		System.out.println(MyMath.abs(-5));
		
		// 수학연산자는 객체를 만들 필요가 없다. 어차피 같은 실행이여서.
		// 객체를 만들어봐야 메모리 낭비이다
		
		System.out.println(MyMath.pow(2, 5));		// 2의 5제곱(32)

	}

}
