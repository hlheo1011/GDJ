package pratice;

public class Gun {
	
	// 필드
	private String model;
	private int bullet;
	private final int FULL_BULLET = 6;
		
	// 메소드
	// 장전
	public void reload(int bullet) {
		this.bullet += bullet;
	}
	
	// 총쏘기
	public void shoot(int a) {
		if(this.bullet < 0) {
			System.out.println("헛빵!");
		} else {
			this.bullet--;
		}
	}
	
	
	public void info() {
		System.out.println(" : " + model);
	}


}
