package com.gdu.app15.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;
import java.util.regex.Matcher;

import org.springframework.stereotype.Component;

@Component
public class MyFileUtil {
	
	// 파일명 : UUID 값을 사용
	// 경로명 : 현재 날짜를 디렉터리로 생성해서 사용
	
	public String getFilename(String filename) {
		
		// 확장자 예외 처리
		String extension = null;
		if(filename.endsWith("tar.gz")) {
			
			extension = "tar.gz";
		
		} else {
			
			// 파라미터로 전달된 filename의 확장자만 살려서 UUID.확장자 방식으로 반환
			String[] arr = filename.split("\\."); // split이 정규식 받아옴 정규식에서 .(마침표) 인식 : \. 또는 [.]
			
			// 확장자
			extension = arr[arr.length -1];
			
		}
		// UUID.확장자
		return UUID.randomUUID().toString().replaceAll("\\-", "") + "." + extension;
	}
	
	// 오늘 경로
	public String getTodayPath() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String sep = Matcher.quoteReplacement(File.separator);
		return "storage" + sep +year + sep + makeZero(month) + sep +makeZero(day);
 	}
	// 어제 경로
	public String getYesterdayPath() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); // 1일전
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String sep = Matcher.quoteReplacement(File.separator);
		return "storage" + sep +year + sep + makeZero(month) + sep +makeZero(day);
	}
	
	// 1~9 -> 01-09
	public String makeZero(int n) {
		return (n<10) ? "0" + n: "" + n;
	}
}
