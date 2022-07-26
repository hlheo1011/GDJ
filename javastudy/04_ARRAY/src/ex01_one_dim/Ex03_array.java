package ex01_one_dim;

import java.util.Arrays;

public class Ex03_array {

	public static void main(String[] args) {

		// 배열의 데이터타입
		// int[] : 참조 타입(Reference Type)
		
		/*
		 
		int[] arr = { 10000, 20000, 30000 };
		
	     |-------|
	 arr | 0x123 |
	     |-------|
	     | . . . |
	     |-------|
  arr[0] | 10000 | 0x123
	     |-------|
  arr[1] | 20000 | 
	     |-------|
  arr[2] | 30000 |
	     |-------|
	  
	     * 실제로 연속된 메모리 공간을 사용한다
	     * 자바에선 위 그림이 그렇게 중요하진 않다.. C언어에서 중요하다..
	     * 하지만 이해는 해야함
		 */
		
		// 배열의 길이 늘리기
		// 1. 배열의 길이는 변경할 수 없다.
		// 2. 늘어난 길이의 새로운 배열을 만들고, 
		// 	  기존 배열의 값을 모두 새로운 배열로 옮기고,
		//	  기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다.
		
		// 길이가 5인 배열을 사용하다가
		// 길이가 1000인 배열로 바꾸기		
		int[] arr = {1, 2, 3, 4, 5};
		
		// 늘어난 길이의 새로운 배열을 만들고, 
		int[] temp = new int[1000];
		
		// 기존 배열의 값을 모두 새로운 배열로 옮기고,
		System.arraycopy(arr, 0, temp, 0, arr.length);		
		// arr 0번을 temp 0번으로 옮기는게 시작이다. 언제까지? arr.length 까지
		
		// 기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다.
		arr = temp;
		
		// 이제 arr 배열의 길이는 1000이다.
		System.out.println(arr.length);
		
		// arr을 출력하는 방법
		System.out.println(Arrays.toString(arr));
		
		
		
		
		// Java는 메모리 누수를 스스로 해결한다

		

	}

}
