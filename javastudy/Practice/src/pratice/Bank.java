package pratice;

public class Bank {

	// 필드
	private String accNo;		// 계좌번호
	private long balance;		// 통장에 있는금액
	
	// 생성자부턴 메소드니까 퍼블릭을 쓰는거다.
	// 클래스 이름이 뱅크니까 생성자 이름도 뱅크다.
	public Bank(String accNo, long balance) {	// new Bank("1234", 50000); << 호출할수 있게 만들어줌.
												// ○ Bank b = new Bank("1234", 50000);
		this.accNo = accNo;
		this.balance = balance;
	}
	
	// 1. 입금(마이너스 입금 불가)
	public void deposit(long money) {	// deposit이 호출 될때, 50000을 호출할게요. 라고 하는게 long money로 넘어간다.
		if(money <= 0) {				// ○ b.deposit(50000) // 마이너스 입금아 안되니까 if문.
			return;						// 반환타입이 void인 메소드를 종료하는 코드.
		}
		balance += money;
		
	}
	
	// 2. 출금(마이너스 출금 + 잔액보다 큰 출금 불가)
	// 실제로 출금된 금액을 반환
	public long withdrawal(long money) {	// ling 출금액 = b.withdrawal(50000);
		if(money <= 0 || money > balance) {
			return 0;						// return만 쓰면 안된다. 반환타입이 long이기 때문에 값을 넣어줘야 한다. 0원으로 반환하라.
		}
		balance -= money;
		return money;						// 얼마출금했지? money 출금했으니, money를 반환.	
	}
	// 출금을 이렇게 한 이유는 3.이체 가면 이해가 된다.
	
	
	// 3. 이체(내 통장에서 > 상대방통장에 입금)
	public void transfer(Bank other, long money) {		// 다른사람에게 (other) 얼마를(money) 준거니?
		// 내 통장에서 출금된 금액만큼 상대 계좌에 입금한다.
		// long withdrawalMoney = withdrawal(money);		// 이체는 코드를 새로 만들지 않고, 1.입금과 2. 출금을 불러온다.
		// other.deposit(withdrawalMoney);
		other.deposit(withdrawal(money)); // 위에 두 줄짜리 코드랑 같다.
	}
	
	
	// 4. 계좌 정보 확인
	public void accInfo() {
		System.out.println("계좌번호 : " + accNo + ", 잔액 : " + balance + "원");
	}
	
	
	// 메인을 만들클래스를 만들 필요는 없지만, 추천하는 방법은 아님. 교육 할때만 ,, 헷갈리니까 일단 합침.
	public static void main(String[] args) {
		
		Bank me = new Bank("1234", 50000);		// 내 계좌, 1234, 50000원이 있음
		Bank mom = new Bank("4567", 100000);	// 엄마계좌 4567, 100000원이 있음
		
		mom.transfer(me, 50000); 		// 엄마가 나한테 오만원 이체.
		
		me.accInfo();					// 입금 정보확인
		mom.accInfo();					// 출금 정보확인
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
