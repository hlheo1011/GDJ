package com.gdu.app12.util;

import java.security.MessageDigest;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {
	
	
	// 크로스 사이트 스크립팅 방지
	public String preventXSS(String str) {
		// 입력칸에 스크립트문 불러오기 방지
		str = str.replace("<", "&lt;");
		// 스크립트 안에 '<'라는 문자가 들어오면. 작다기호로 바꿔주기
		str = str.replace(">", "&gt;");
		str = str.replace("\"", "&quot;");
		str = str.replace("\'", "&#x27;");
		return str;
		// web페이지로 뿌릴땐 다시 < > " ' 로 변환해서 출력되지만, 내부에서는 &lt로 나오기 때문에 스크립트 문은 실행되지 않는다.
	}

	// SHA-256 암호화
	// 1. 입력 값을 256비트(32바이트) 암호화 처리하는 알고리즘
	// 2. 암호화는 가능하지만 복호화는 불가능 하다.
	// 3. 1바이트를 2글자로 표현하면 총 64글자(DB에 저장될 때 크기) 공간이 필요
	// 4. 모든 입력이 64글자 암호화 처리
	// 5. java.security 패키지
	public String sha256(String str) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
		} catch(Exception e) {
			e.printStackTrace();
		}
		byte[] b = md.digest();		// 배열 b는 : 문자열 str이 암호화된 32바이트 크기의 배열
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < b.length; i ++) {
			sb.append(String.format("%2X", b[i]));		// %2X (2자리 16진수(0~F) 라는 format임), %2x (2자리 16진수(0~f)
		}
		return sb.toString();
	}
	
	// 인증코드 만들기
	// 1. 보안을 위해서 Math.reandom() 내지는 Random 클래스 사용을 지양한다.
	// 2. SecureRandom 클래스를 대신 사용한다.
	
	private SecureRandom secureRandom = new SecureRandom();
	
	public String getAuthCode(int length) {
		/*
			문자	아스키코드	  생성
			'0'		48			  48부터 10개 중 하나의 난수('0'~'9')
			'A'		65			  65부터 26개 중 하나의 난수('A'~'Z')
			'a'		97			  97부터 26개 중 하나의 난수('a'~'z')
		*/
		// 대문자와 숫자의 조합
		StringBuilder sb = new StringBuilder();
		for(int cnt = 0; cnt < length; cnt++) {	// length만큼 반복
			if(secureRandom.nextDouble() < 0.5) {	// 50% 확률로
				sb.append( (char)(secureRandom.nextInt(10) + '0') );
			} else {
				sb.append( (char)(secureRandom.nextInt(26) + 'A') );
			}
			
		}
		
		return sb.toString();
	}
	
	
	
}
