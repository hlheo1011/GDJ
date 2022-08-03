package ex04_builder;

public class Main {

	public static void main(String[] args) {

		User user = User.builder()
				.userNo(1)
				.id("admin")
				.email("admin@naver.com")
				.build();		// 여기까지 만들어 주세요. 끝남을 알리는 명령어.
		
		System.out.println(user);

	}

}
