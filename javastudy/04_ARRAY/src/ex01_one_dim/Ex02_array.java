package ex01_one_dim;

public class Ex02_array {

	public static void main(String[] args) {

		// 배열의 초기화
		// int[] arr = new int[5];			// 배열을 생성한것이지 초기화 한것은 아니다.
		// int[] arr = new int[] {10, 20, 30, 40, 50}; // 이런식으로 초기화 하지만, 아래처럼 사용된다.
		int[] arr = {10, 20, 30, 40, 50};

		// 최대/최소
		int max = arr[0];
		int min = arr[0];							// 최소값의 초기값은 0 을 주면 안된다. 0과 비교를 하기 떄문에
		
		for(int i = 1; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);
		
		

		String[] arr2 = {"라이언", "춘식이"};
		String lion = arr2[0];
		String chunSick = arr2[1];
		
		System.out.println(lion);
		System.out.println(chunSick);
		
		
	}

}
