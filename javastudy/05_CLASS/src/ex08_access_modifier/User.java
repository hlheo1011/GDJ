package ex08_access_modifier;

public class User {
	
	// 일단 접근 권한부터 입력을 해야 한다.
	
	
	// (앞으로) 필드는 private이다.
	private String id;
	private String password;
	private String email;
	private int point ;
	private boolean isVip;
	
	// 메소드는 public 이다.
	public String getId() {
		return id;
	}	// 메소드를 통한 우회 확인.

	public void setId(String pId) {
		id = pId;
	}	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String pPassword) {
		password = pPassword;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String pEmail) {
		email = pEmail;
	}
	
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int pPoint) {
		point = pPoint;
		setVip(point >= 10000);
	}
	
	public boolean getVip() {
		return isVip;
	}
	private void setVip(boolean pVip) {
		isVip = pVip;
	}

	

}
