package quiz02_rsp;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		String[] rsp = {"가위", "바위", "보"};
		
		// rsp 배열에서 임의의 값 하나를
		// rsp[0] == "가위";
		// rsp[1] == "바위";
		// rsp[2] == "보";
		
		// 몇 번만에 HashSet에 모두 넣을 수 있는지 확인한다.
		
		Set<String> set = new HashSet<String>();
		int cnt = 0;
		
		while(set.size() < 3) {
			int i = (int)(Math.random() * 3);	// 0, 1, 2 중 하나
			set.add(rsp[i]);	// 랜덤으로 추가 하여라
			cnt++;				// 몇회만에 넣었는지?
		}
		
		System.out.println(set);
		System.out.println(cnt);

	}

}
