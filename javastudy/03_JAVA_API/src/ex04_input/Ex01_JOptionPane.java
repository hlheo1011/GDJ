package ex04_input;

import javax.swing.JOptionPane;

public class Ex01_JOptionPane {

	public static void main(String[] args) {

		// javax.swing.JOptionPane 클래스		// 확장 되었다는 의미에서 java뒤에 x를 붙임.
		// GUI 툴을 제공하는 클래스
		// 공부 할 필요 없다..
		
		String name = JOptionPane.showInputDialog("이름을 입력하세요");
		String age = JOptionPane.showInputDialog("나이를 입력하세요");
		
		System.out.println(name);
		System.out.println(age);
		
		// 대화 상자가 떴을때 숫자를 입력하면 String이다.
	}

}
