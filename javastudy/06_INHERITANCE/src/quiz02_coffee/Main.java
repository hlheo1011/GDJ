package quiz02_coffee;

public class Main {

	public static void main(String[] args) {

		Espresso espresso = new Espresso("케냐", 50);
		espresso.info();
		
		System.out.println();
		Americano americano = new Americano(espresso , 2, "아이스");
		americano.info();
		
	}

}
