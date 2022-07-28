package ex02_is_a;

public class HybridMain {

	public static void main(String[] args) {

		Hybrid hybrid = new Hybrid();
		
		hybrid.drive();
		hybrid.charge();
		hybrid.addOil();
		
		Car car = new Car();
		car.drive();
		
		Ev ev = new Ev();
		ev.drive();
		ev.charge();

	}

}
