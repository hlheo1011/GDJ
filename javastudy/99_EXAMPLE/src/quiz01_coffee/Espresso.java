package quiz01_coffee;

public class Espresso extends Coffee {
	
	private int addWater;

	public Espresso(String origin, int addWater) {
		super(origin);
		this.addWater = addWater;
	}
	
	public void info() {
		System.out.println(super.getOrigin() + "원두, 물 : " + addWater + "ml");
	}
	


}
