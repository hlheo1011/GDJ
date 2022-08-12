package ex05_inputstream;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -1830845902387248224L;
	
	private int userNo;
	private String name;
	private int age;
	
	public User(int userNo, String name, int age) {
		super();
		this.userNo = userNo;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", name=" + name + ", age=" + age + "]";
	}
	
	

	
	
}
