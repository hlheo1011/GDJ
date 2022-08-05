package quiz04_employee;

public class Temporary extends Employee {
	
	private int pay;
	private int workTimes;
	
	public Temporary(int empNo, String name) {
		super(empNo, name);
	}
	// Temporary의 pay와 workTimes의 필드값은 따로 추가 하려고, 생성자에 추가하지 않았다.


	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getWorkTimes() {
		return workTimes;
	}
	public void setWorkTimes(int workTimes) {
		this.workTimes = workTimes;
	}

	@Override
	public String toString() {
		return super.toString() + ", pay=" + pay + ", workTimes=" + workTimes + "]";
	}
	
	
	
	
	
	

}
