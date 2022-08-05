package quiz03_bank;

public class BankException extends Exception {
	
	private static final long serialVersionUID = -6507898939727359613L;
	private int errorCode;

	public BankException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	

}
