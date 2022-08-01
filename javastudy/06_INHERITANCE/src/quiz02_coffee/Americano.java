package quiz02_coffee;

public class Americano {
	
	private Espresso espresso;		// 에스프레소를 필드로 가져온다.
	private int shot;
	private String type;
	
	
	public Americano(Espresso espresso, int shot, String type) {
		this.espresso = espresso;
		this.shot = shot;
		this.type = type;
	}



	public void info() {
		espresso.info(); 				// 에스프레소 필드에서 호출......
		System.out.print(", " + shot + "샷");
		System.out.println(", " + type + " 아메리카노");
	}


	


}
