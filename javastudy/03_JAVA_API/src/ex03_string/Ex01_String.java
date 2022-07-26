package ex03_string;

public class Ex01_String {

	public static void main(String[] args) {

		String str1 = "hello";
		String str2 = "hello";
		
		/* str1  0x123
		   str2  0x123
		
		   		 hello  0x123	
		*/ 
		// 같은 번지수 저장
		System.out.println(str1 == str2);
		
		String str3 = new String("hi");
		String str4 = new String("hi");
		/* str3  0x123
		   str4  0x456
		  
		  		hi	0x123
		  		hi  0x456
		 */
		// 다른 번지수 저장
		System.out.println(str3 == str4);
		// 문자열을 비교할때 비교연산(==)을 등호로 쓰면 안된다.

		// 1. 문자열 동등 비교
		// - 문자열을 동등 비교할때는 equals라는 메소드를 써야한다.
		// 메소드를 호출하는 법은 클래스를 이용한 호출법과, 객체를 이용한 호출법이 있다.
		// 아래 예시는 객체를 이용한 호출법이다.
		// Sting str3 = 은 객체이다.
		// 아래 예시는 참조값(번지수)를 비교하는게 아니라, 문자열을 비교하는 것이다.
		
		// 같을 때 비교.
		boolean result1 = str1.equals(str2);
		boolean result2 = str3.equals(str4);
		System.out.println(result1);
		System.out.println(result2);
		
		// 다를 때 비교.
		if(str1.equals(str2)) {
			System.out.println("str1, str2는 같아요");
		} else {
			System.out.println("str1, str2는 달라요");
		}
		
		if(!str3.equals(str4)) {
			System.out.println("str3, str4는 달라요");
		} else {
			System.out.println("str3, str4는 같아요");
		}
		// 부정문은 가급적 사용하지 않는다.
		
		
		// 2. 대소문자를 무시한 문자열 동등 비교 
		// (예를 들면 ID 칠때 대소문자 무시
		String str5 = "Hello World";
		String str6 = "hELLO wORLD";
		boolean result3 = str5.equalsIgnoreCase(str6);			// case = 대소문자를 의미함
		System.out.println(result3);
		
		
		// 3. 문자열 길이 반환
		String name = "홍길동";
		int length = name.length();
		System.out.println("글자수 : " + length);
		// 공백도 글자수에 포함이 된다.
		// 아스키 코드에도 등록되어 있다. 32번.
		
		
		// 4. 특정 위치의 문자만 반환
		// 특정위치
		// 인덱스(Index)라고 한다.
		// 글자마다 부여된 정수값.
		// 0으로 시작 (첫번째 글자는 인덱스가 0이다.)
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2));
		
		
		// 5. 문자열의 일부 문자열(String)을 반환
		//  1) substring(begin)	: 인덱스 begin(인덱스 포함)부터 끝까지 반환
		//  2) substring(begin, end) : 인덱스 begin(인덱스 포함)부터 인덱스 end(불포함)까지 반환
		System.out.println(name.substring(0,1)); // 첫번째 글자만
		System.out.println(name.substring(1));	// 두번째 글자뿌터 끝까지
		
		
		// 6. 특정 문자열을 찾아서 해당 인덱스(int)를 반환
		//		1) indexOf
		//			(1) 발견된 첫 번째 문자열의 인덱스를 반환
		//			(2) 발견된 문자열이 없는 경우 -1을 반환
		//		2) lastIndexOf
		//			(1) 발견된 마지막 문자열의 인덱스를 반환
		//			(2) 발견된 문자열이 없는 경우 -1을 반환
		int idx1 = name.indexOf("홍"); 
		int idx2 = name.indexOf("길동");
		System.out.println(idx1);
		System.out.println(idx2);
		
		int idx3 = name.lastIndexOf("동"); 
		int idx4 = name.lastIndexOf("길동");
		System.out.println(idx3);
		System.out.println(idx4);
		
		
		// 7. 문자열이 특정 패턴으로 시작하는지? 여부를 boolean(true, false) 반환
		// startWith(문자열)
		if(name.startsWith("이")) {
			System.out.println("이씨입니다.");
		} else {
			System.out.println("이씨가 아닙니다.");
		}
		
		
		// 8. 문자열이 특정 패턴으로 끝나는지 여부를 boolean(true, false) 반환
		// endWith(문자열)
		String filename = "image.jpg";		// jpg, png로 끝나면 이미지로 가정
		if(filename.endsWith("jpg") || filename.endsWith("png")) {
			System.out.println("이미지입니다.");
		} else {
			System.out.println("이미지가 아닙니다.");
		}
		
		
		// 9. 문자열이 특정 패턴을 포함하는지 여부를 boolean(true, false) 반환
		String email = "hoh1011@naver.com";
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일입니다.");
		} else {
			System.out.println("이메일이 아닙니다.");
		}
		
		
		// 10. 불필요한 공백 제거(좌우 공백) 
		// 중간 공백은 제거하지 않는다. 앞 뒤만 제거함.
		String message = " 안녕  하세요  ";
		System.out.println(message.trim());
		System.out.println(message.trim().length());
		
		
		// 11. 대소문자 변환하기
		// toUpperCase() : 대문자로 변환하기
		// toLowerCase() : 소문자로 변환하기
		String source = "best of best";
		System.out.println(source.toUpperCase());		// 소스가 변하는게 아니라, 이 메소드를 사용했을때 이렇게 나옵니다. 를 알려줌
		System.out.println(source.toLowerCase());
		
		
		// 12. 찾아 바꾸기
		// replace(old, new) : old를 찾아서 new로 변환하기
		String replaced = source.replace("best", "worst");
		System.out.println(source);
		System.out.println(replaced);
		
		// 주의. replaceAll() 메소드는 특정 문자열을 찾아서 변환하는 것이 아님.
		String ip = "192.168.101.91";
		String replacedIp = ip.replaceAll(".", "_");	// 192_168_10_101_91 를 기대하지만,
		System.out.println(replacedIp);
		
		
		// 13. 빈 문자열인지 여부를 검사한 뒤 boolean(true, false) 반환
		String id = " ";
		if(id.isEmpty()) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		if(id.trim().isEmpty()) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		if(id.isBlank()) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		// 연습. 파일이름을 파일명과 확장자로 분리하시오.
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행한다.
		String fullName = "apple.jpg";
		String fileName = "";				// apple
		String extName = "";				// jpg or .jpg
		int idxOfDot = fullName.lastIndexOf(".");
		fileName = fullName.substring(0, idxOfDot);
		extName = fullName.substring(idxOfDot + 1);		
		/* 내가 푼 답안
		if(fullName.startsWith("apple")) {
			fileName = "apple";
		}
		if(fullName.endsWith("jpg")) {
			extName = ".jpg";
		}
		*/		
		System.out.println(fileName);
		System.out.println(extName);
		
		
		// 연습. 문자열 "abc12345def67890ghijk"에서
		// 아라비아 숫자 1234567890은 제외하고 한 글자씩 화면에 출력하시오.
		String str = "abc12345def67890ghijk";
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);								// 한번 호출해서 변수로 저장
			if(ch >= '0' && ch <= '9') {
				continue;
			}
			System.out.println(ch);
		}
		
		/* 위와 같은 코드지만 위를 더 많이 쓴다. 등호의 차이 ( <, <=, -1 의 변화)
		for(int i = 0; i <= str.length() - 1; i++) {
			System.out.println(str.charAt(i));
		}
		*/
		
		// 문자가 아무리 길어도 길이 -1 을 하면 index 범위가 나온다.
		// str의 인덱스 : 0 ~ str.length()-1
		// && : 사잇값
		// if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
		// 위에서 숫자는 char 값으로 해야한다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
