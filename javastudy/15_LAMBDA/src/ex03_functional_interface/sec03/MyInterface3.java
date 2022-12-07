package ex03_functional_interface.sec03;

@FunctionalInterface // 추상 메소드를 1개 가지고 있는 메소드(=람다식으로 생성할 수 있는 인터페이스)
public interface MyInterface3 {
	public int method();
	// public void m(); // 추상메소드를 2개 가지고 있으면 오류 뜸

}
