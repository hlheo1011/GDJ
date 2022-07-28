package ex03_has_a;

public class Gun {
	
	// 필드
	private String model;	// 총기 모델
	private int bullet;		// 탄
	private final int MAX_BULLET = 15; // 최대 15발 까지 들어감. // 상수여서 모두 대문자?
	
	// 메소드
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getBullet() {
		return bullet;
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	// 장전
	public void reload(int bullet) {
		if(this.bullet == MAX_BULLET) {				//this.bullet = 현재 총알
			return;									//장전이 안된다.
		}
		this.bullet += bullet;
		this.bullet = (this.bullet > MAX_BULLET) ? MAX_BULLET : this.bullet;	
		// 현재총알이 = 맥스 총알보다 크면, 맥스총알 : 아니면 현재 총알.
	}
	
	// 총쏘기
	public void shoot() {			// 총을 안 쏠수도 있다.
		if(bullet == 0) {
			return;
		}
		bullet--;
	}

}
