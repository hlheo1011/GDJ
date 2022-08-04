package ex02_try_catch;

import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void m1() {
		try {
			String[] hobbies = new String[3];
			hobbies[1] = "swimming";
			hobbies[2] = "running";
			
			// 향상for문은 인덱스 없이 1개씩 꺼내 쓸때 적절하다.
			for(String hobby : hobbies) {
				System.out.println(hobby.substring(0, 2));
				// Null 값이 메소드를 호출할떄 nullpointExceptio이 발생한다.
				}
		} catch(Exception e) {
			System.out.println("NullPointerException 발생");
		}
		
	}

	
	public static void m2() {

		
		try {
			String input = "20,21,,22,23,24,25";
			String[] inputs = input.split(",");
			int[] ages = new int[inputs.length];
			
			for(int i = 0; i < inputs.length; i++) {
				ages[i] = Integer.parseInt(inputs[i]);
				System.out.println("변환 값 : " + ages[i]);
			}
		} catch(NumberFormatException e){
			System.out.println("NumberFormatException 발생");
		} catch(Exception e){
			System.out.println("NumberFormatException 발생");
		}
		
	}
	
	public static void m3() {
		// 어떤 예외가 발생하는지 확인해서
		// try - catch문 넣기 (Exception, RuntumeException은 사용하지 않기)
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("정수1 >>> ");
			int a = sc.nextInt();
			System.out.print("정수2 >>> ");
			int b = sc.nextInt();		
			System.out.println(a + "+" + b + "=" + (a + b));
			System.out.println(a + "-" + b + "=" + (a - b));
			System.out.println(a + "*" + b + "=" + (a * b));
			System.out.println(a + "/" + b + "=" + (a / b));
			System.out.println(a + "%" + b + "=" + (a % b));
			sc.close();
			} catch (ArithmeticException e) {
				System.out.println("ArithmeticException 오류 발생");
			} catch (InputMismatchException e) {
				System.out.println("InputMismatchException 오류 발생");
			}
		
	}
		
	public static void m4() {
		
		try {
			File file = new File("C:\\sample.tex");
			FileReader fr = new FileReader(file);	// try - catch문이 없으면 실행이 불가능
		} catch (Exception e) {
			System.out.println("컴파일 에러");
		}
	}
	
	
	public static void main(String[] args) {
		m4();

	}

}
