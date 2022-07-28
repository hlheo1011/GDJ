package ex08_access_modifier;

public class UserMain {

	public static void main(String[] args) {
		
		User user = new User();
		
		user.setId("admin");
		System.out.println(user.getId());
		
		user.setPassword("12345");
		System.out.println(user.getPassword());
		
		user.setEmail("hoh1011@naver.com");
		System.out.println(user.getEmail());
		
		user.setPoint(1000);
		System.out.println(user.getPoint());
			
		System.out.println(user.getVip());

	}

}
