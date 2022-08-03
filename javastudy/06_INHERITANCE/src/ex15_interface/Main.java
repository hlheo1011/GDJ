package ex15_interface;

public class Main {

	public static void main(String[] args) {

		Phone p1 = new SmartPhone();
		p1.call();
		p1.sms();
		((Computer) p1).game();
		((Computer) p1).internet();


		System.out.println();
		Computer p2 = new SmartPhone();
		((Phone) p2).call();
		((Phone) p2).sms();
		p2.game();
		p2.internet();
		
		System.out.println();
		SmartPhone p3 = new SmartPhone();
		p3.call();
		p3.sms();
		p3.game();
		p3.internet();
		
	}

}
