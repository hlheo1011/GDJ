package ex07_constructor;

public class ComputerMain {

	public static void main(String[] args) {

		Computer myCom = new Computer("gram", 150);			// new Compuer <- 메소드를 생성하지 않았지만, 생겼다.
															
		myCom.printCompuerStatus();
		
		Computer yourCom = new Computer();
		yourCom.printCompuerStatus();
		
		
		

	}

}
