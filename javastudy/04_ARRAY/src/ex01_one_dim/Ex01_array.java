package ex01_one_dim;

public class Ex01_array {

	public static void main(String[] args) {

		// 배열(Array)
		// 1. 여러 개의 변수를 하나의 이름으로 관리하는 자료 구조
		//	- 하나의 데이터를 여러개 저장하는 것이 배열이다.
		// 2. 배열의 구성요소
		//	1) 인덱스 : 각 변수의 위치 정보. 0으로 시작
		//  2) 배열명 : 모든 변수를 관리하는 하나의 이름
		// 3. 각 변수는 배열명에 대괄호[] (브라켓:bracket)와 인덱스를 붙여서 구분
		
		// 배열 선언 및 생성 (변수는 선언만 하면 사용이 가능, 배열은 선언을 한 뒤, 생성도 해야 함)
		// 1. 배열 선언
		// 	 int[] arr;			// java에선 첫번째 방식을 추천 한다.
		//   int arr[];
		// 2. 배열 생성
		//	 arr = new int[3];
		// 3. 배열 선언 및 생성
		//	 int[] arr = new int[3];
		
		// 배열 요소
		// 1. 배열로 관리되는 각각의 변수
		// 2. 모든 배열 요소의 호출
		// 	  arr[0]						// 배열안에 인덱스를 붙여준다.
		//	  arr[1]						// 2번째 요소
		//    arr[2]						// 3번째 요소
		// 3. ★배열 요소는 자동으로 초기화가 된다★ (어떤 값을 가진다.)
		//	 값이 없음을 의미하는 0, 0.0, false﻿ null 값을 가진다. 		// 값이 없다라는건 거짓이다.
		
		// 배열의 장점
		// * 변수 3개가 있는 상황 가정
		// 일반 변수						배열
		// int a, b, c;					int[] arr = new int[3];
		// System.out.println(a);		for(int i = 0; i < 3; i++) {
		// System.out.println(b);			System.out.println(arr[i]);
		// System.out.println(c);
		
		int[] arr = new int[3];
		
		for(int i = 0; i < arr.length; i++) {		// i를 (index)변수 이름으로 우선사용 후 >  j > k
			System.out.println(arr[i]);				// 선언만 하고 초기값 지정을 안했기 때문에 사실상 오류가 나야하는 코드지만
		}											// 배열은 자동으로 초기화가 되기 때문에 값이 있다고 본다.
		
		
		
		// 학생 3명의 점수라고 가정
		arr[0] = 100;								// 충분히 사용 가능
		arr[1] = 50;
		arr[2] = 80;
		for(int i =0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		// 학생 3명의 평균은 ?
		
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		
		// 캐스팅 1번 방법
		double average = (double)total / arr.length;
		
		System.out.println("평균 : " + average + "점");	
		
	}

}
