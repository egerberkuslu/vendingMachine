package vendingmachine;

public class Coin {
	private double value;

	public double getValue() {
		return this.value;
	}

	public CoinName getName() {
		if (this.value == 0.05) {
			return CoinName.Nickel;
		} else if (this.value == 0.1) {
			return CoinName.Dime;
		} else if (this.value == 0.25) {
			return CoinName.Quarter;
		} else {
			return CoinName.Dollar;
		}
	}

	public Coin(double value) {
	  if(value == 0.05) {
		this.value = value;  
	  }
	  else if(value == 0.1) {
		this.value = value;  
	  }
	  else if(value == 0.25) {
		this.value = value;  
	  }
	  else if(value == 1) {
		this.value = value;
	  }
	  else {
		  System.out.println("Invalid Coin");
	  }
	  
  }

}
