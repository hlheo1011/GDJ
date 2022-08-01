package ex06_constructor;

public class Alba extends Student {
	
	// 필드
	private String company;
	
	// 생성자
	public Alba(String name, String school, String company) {
		super(name, school);
		this.company = company;
	}

	// get,set
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}