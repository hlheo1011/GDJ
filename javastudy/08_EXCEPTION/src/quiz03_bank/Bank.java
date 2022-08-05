package quiz03_bank;

public class Bank {
	
	private String accNo;
	private long balance;
	
	
	public Bank(String accNo, long balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}

	public void deposit(long money) throws BankException {
		if (money < 0) {
			throw new BankException("마이너스 입금 불가", 1000);
		}
		balance += money;	
	}
	
	public long withdrawal(long money) throws BankException {
		if (money < 0) {
			throw new BankException("마이너스 출금 불가", 2000);
		} else if (balance < money) {
			throw new BankException("잔액부족", 3000);
		}
		balance -= money;
		return money;
	}
	
	public void transfer(Bank acc, long money) throws BankException {
		//acc.deposit(withdrawal(money));
	}
	
	public void inquiry() {
		System.out.println(this);	// 객체를 toString 한다 . . .?
	}


	@Override
	public String toString() {
		return "Bank [accNo=" + accNo + ", balance=" + balance + "]";
	}
	


}
