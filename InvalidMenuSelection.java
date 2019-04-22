package vendingmachine;

public class InvalidMenuSelection extends Exception {
	InvalidMenuSelection() {
		super("INVALID MENU ERROR");
	}
	InvalidMenuSelection(String Message){
		super(Message);
	}
}
