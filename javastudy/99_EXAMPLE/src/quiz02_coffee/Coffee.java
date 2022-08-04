package quiz02_coffee;

public class Coffee {
	
	private String origin;
	private int addWater;
	
	public Coffee(String origin, int addWater) {
		this.origin = origin;
		this.addWater = addWater;
	}
	
	public void info() {
		System.out.println(origin + " 원두, 물 : " +  addWater + "ml");		
	}


}
