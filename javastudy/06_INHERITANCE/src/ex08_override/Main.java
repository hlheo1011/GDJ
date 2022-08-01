package ex08_override;

public class Main {

	public static void main(String[] args) {
		
		Circle circle = new Circle("도넛", 7.5);
		circle.info();
		
		System.out.println();
		
		Rectangle rectangle = new Rectangle("직사각형", 3, 4);
		rectangle.info();
		
		System.out.println();
		
		Square square = new Square("정사각형", 5);
		square.info();
		
	}

}
