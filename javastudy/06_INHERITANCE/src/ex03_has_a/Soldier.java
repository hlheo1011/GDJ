package ex03_has_a;

public class Soldier {
	
	// 필드
	private Gun gun;	// 총을 가지고 있다.

	// 메소드
	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	public void reload(int bullet) {		// 군인이 총알을 받으면 그 총알을 총에 넣는다.
		gun.reload(bullet);
	}
	
	public void shoot() {
		gun.shoot();
	}
	
	

}
