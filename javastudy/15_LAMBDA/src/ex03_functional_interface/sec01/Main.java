package ex03_functional_interface.sec01;

public class Main {
	
	public static void main(String[] args) {
		
		MyInterface1 my = () -> System.out.println("집에 가고 싶다.");
		my.method();
				
		MyInterface1 you = () -> System.out.println("나는 자고 싶다.");
		you.method();
			
		};
	

}
