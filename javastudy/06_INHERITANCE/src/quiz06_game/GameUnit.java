package quiz06_game;

public abstract class GameUnit {
	
	// 필드값
	private String name;
	private int energy;
	private int power;
	private boolean isAlive;	// boolean alive;로 해도 동일한 Getter/Setter가 생성됨.
	
	// 생성자
	public GameUnit(String name, int energy, int power) {
		super();
		this.name = name;
		this.energy = energy > 0 ? energy : 0;
		this.power = power;
		this.isAlive = energy > 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	// 메소드
	public void info() {
		System.out.println(name + " 에너지 " + energy + " 공격력 " + power);
	}

	public abstract void attack(GameUnit unit);
	
	

}
