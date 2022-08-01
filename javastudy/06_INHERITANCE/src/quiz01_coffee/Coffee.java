package quiz01_coffee;

public class Coffee {
	
	private String origin;
	
	
	public Coffee(String origin) {
		this.origin = origin;
	}

	public void info() {
		System.out.print(origin + " 원두, ");
	}

}
