package quiz04_cart;

public class Customer {
	
	// 필드
	private int money;
	private int bonusPoint;
	int total;
	private Product[] cart = new Product[10];
	private int idx;	// cart에 담긴 Product의 개수. cart 배열의 인덱스.
	
	// 생성자 생략
	// new Customer() 가능
	
	// 메소드 게터세터~
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	
	// buy() 메소드
	public void buy(Product product) {		// 업 캐스팅.
		int price = product.getPrice();				// 동일한 메소드를 여러번 호출 하게 만들어 놓을 필요는 없다. 성능상의 이점. // 리펙토링 한다.
		// 가진 돈보다 비싼 물건은 못 산다.
		if(money < price) {
			System.out.println(product.getName() + " 사려면 돈이 " + (price - money) + "원 부족합니다");
			return;			// 더이상 못 사게 리턴.
		}
		// 카트가 가득 차면 물건을 못 산다.
		if(idx == cart.length) {				// 인덱스가 10이 되면. (cart 길이가 10임)
			System.out.println("카트가 가득 찼습니다.");
			return;			// 더이상 못 사게 리턴.
		}
		// 구매
		cart[idx++] = product; // 최초 인덱스가 0이기 때문에, 카트에 넣는다. 0번에 넣어 준 뒤 인덱스는 1로 는다.
		money -= price;
		total += price;
		bonusPoint += price * 0.1;
	}

		
	
	
	
	public void receipt() {
		// 물건을 안 샀다.
		if(idx == 0) {
			System.out.println("구매한 물건이 없습니다.");
			return;
		}
		System.out.println("======= 영수증 =======");
		// 구매 총액 구하기 및 출력
		for(int i = 0; i < idx; i++) {	// lenght만큼 말고 idx만큼 해주는게 맞다. (구매한 수 만큼)
			Product product = cart[i];
			System.out.println(product.getName() + "  " + product.getPrice() + "원");
			total += product.getPrice();			// 제품의 가격을 누적시켜 준다.
		}
		// for문 끝
		System.out.println("------------------------------");
		System.out.println("구매총액 " + total + "원");
		System.out.println("보너스 " + bonusPoint + "원");
		System.out.println("남은돈 " + money + "원");				// -= 연산을 썼기 때문에 따로 뭘 더 할 필요는 없다.
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
