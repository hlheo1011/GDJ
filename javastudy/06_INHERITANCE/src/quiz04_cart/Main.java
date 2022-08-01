package quiz04_cart;

public class Main {

	public static void main(String[] args) {
		
		Customer customer = new Customer();				// 아직 돈이 없는 고객
		customer.setMoney(10000);						// 고객은 10000원을 가진다.
		customer.buy(new Snack("홈런볼", 1500));		// 홈런볼 1500원짜리 1개를 구매한다.
		customer.buy(new Meat("한우", 5000));			// 한우 5000원짜리 1개를 구매한다.
		customer.buy(new Milk("서울우유", 2500));		// 서울우유 2500원짜리 1개를 구매한다.
		customer.buy(new Meat("불고기", 5000));			// 구매 불가	
		System.out.println();
		customer.receipt();								// 영수증을 본다.

		
		

	}

}
