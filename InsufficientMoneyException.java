package vendingmachine;

public class InsufficientMoneyException extends Exception {
	InsufficientMoneyException() {
		super("INSUFFICINET MONEY ERROR");
	}
	InsufficientMoneyException(String Message) {
	    super(Message);
	}
}
