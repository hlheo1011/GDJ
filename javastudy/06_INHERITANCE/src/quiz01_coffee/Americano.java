package quiz01_coffee;

public class Americano extends Espresso {
	
	private String type;

	public Americano(String origin, int ml, String type) {
		super(origin, ml);
		this.type = type;
	}
	
	@Override
	public void info() {
		System.out.println();
		super.info();
		System.out.print(", " + type + " 아메리카노");
	}
	


}
