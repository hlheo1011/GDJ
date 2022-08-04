package quiz01_coffee;

public class Americano extends Espresso {
	
	private String type;

	public Americano(String origin, int addWater, String type) {
		super(origin, addWater);
		this.type = type;
	}

	public void info() {
		System.out.println(super.getOrigin() + "원두 , 물 : " + "ml, " + type + " 아메리카노");
	}
	
	
	



}
