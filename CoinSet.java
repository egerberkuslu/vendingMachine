package vendingmachine;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

public class CoinSet {

	static ArrayList<Coin> Coins = new ArrayList<>();

	static HashMap<CoinName, Integer> map = new HashMap<>();

	public void addCoin(Coin c) {
		Coins.add(c);
	}

	public double getTotalValue() {
		double sum = 0.0;
		for (int i = 0; i < CoinSet.Coins.size(); i++) {
			sum = sum + Coins.get(i).getValue();
		}
		BigDecimal bd = new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP);
		return  bd.doubleValue();
	}

	public void removeAllCoins() {
		CoinSet.Coins.removeAll(CoinSet.Coins);
	}

	public void TotalCoinInMachine() {
		System.out.println(CoinSet.map);
		double sum = ((0.05) * map.get(CoinName.Nickel)) + ((0.1) * map.get(CoinName.Dime))
				+ ((0.25) * map.get(CoinName.Quarter)) + ((1) * map.get(CoinName.Dollar));
		System.out.println("TOTAL COIN IN MACHINE: " + sum);
	}

	public void CoinSeperator() {
		int nickel = 0;
		int dime = 0;
		int quarter = 0;
		int dollar = 0;
		for (int i = 0; i < CoinSet.Coins.size(); i++) {
			CoinName temp = CoinSet.Coins.get(i).getName();
			switch (temp) {
			case Nickel:
				nickel++;
				break;
			case Dime:
				dime++;
				break;
			case Quarter:
				quarter++;
				break;
			case Dollar:
				dollar++;
				break;
			default:
				break;
			}

		}
		System.out.println(nickel);
		System.out.println(dime);
		System.out.println(quarter);
		System.out.println(dollar);

		map.put(CoinName.Nickel, map.get(CoinName.Nickel) + nickel);
		map.put(CoinName.Dime, map.get(CoinName.Dime) + dime);
		map.put(CoinName.Quarter, map.get(CoinName.Quarter) + quarter);
		map.put(CoinName.Dollar, map.get(CoinName.Dollar) + dollar);

	}

	public void change(Product P) {
		double tempchange = this.getTotalValue() - P.getPrice();
		BigDecimal tempchangedouble = new BigDecimal(tempchange).setScale(2, RoundingMode.HALF_UP);	
	
		double changeMoney = this.getTotalValue() - P.getPrice();
		BigDecimal cm = new BigDecimal(changeMoney).setScale(2, RoundingMode.HALF_UP);	
		
		System.out.println("Changing Money " + cm.doubleValue());
		 
		
		while (changeMoney != 0.0) {
			cm = new BigDecimal(changeMoney).setScale(2, RoundingMode.HALF_UP);	
			changeMoney =  cm.doubleValue();
			System.out.println(changeMoney);
			if (changeMoney >= 1.0) {
				if (map.get(CoinName.Dollar) != 0) {
					changeMoney = changeMoney - 1.00;
					map.put(CoinName.Dollar, map.get(CoinName.Dollar) - 1);
				} else {
					if (map.get(CoinName.Quarter) != 0) {
						changeMoney = changeMoney - 0.25;
						map.put(CoinName.Quarter, map.get(CoinName.Quarter) - 1);
					} else if (map.get(CoinName.Dime) != 0) {
						changeMoney = changeMoney - 0.1;
						map.put(CoinName.Dime, map.get(CoinName.Dime) - 1);
					} else if (map.get(CoinName.Nickel) != 0) {
						changeMoney = changeMoney - 0.05;
						map.put(CoinName.Nickel, map.get(CoinName.Nickel) - 1);
					} else {
						System.out.println("CAN NOT AFFORD THAT MONEY YOU CANT TAKE CHANGE MONEY");
						break;
					}
				}
			} else if (changeMoney >= 0.25 && changeMoney < 1.00) {
				if (map.get(CoinName.Quarter) != 0) {
					changeMoney = changeMoney - 0.25;
					map.put(CoinName.Quarter, map.get(CoinName.Quarter) - 1);
				} else {
					if (map.get(CoinName.Dime) != 0) {
						changeMoney = changeMoney - 0.1;
						map.put(CoinName.Dime, map.get(CoinName.Dime) - 1);
					} else if (map.get(CoinName.Nickel) != 0) {
						changeMoney = changeMoney - 0.05;
						map.put(CoinName.Nickel, map.get(CoinName.Nickel) - 1);
					} else {
						System.out.println("CAN NOT AFFORD THAT MONEY YOU CANT TAKE CHANGE MONEY");
						break;
					}
				}
			} else if (changeMoney >= 0.1 && changeMoney < 0.25) {
				if (map.get(CoinName.Dime) != 0) {
					changeMoney = changeMoney - 0.1;
					map.put(CoinName.Dime, map.get(CoinName.Dime) - 1);
				} else if (map.get(CoinName.Nickel) != 0) {
					changeMoney = changeMoney - 0.05;
					map.put(CoinName.Nickel, map.get(CoinName.Nickel) - 1);
				} else {
					System.out.println("CAN NOT AFFORD THAT MONEY YOU CANT TAKE CHANGE MONEY");
					break;
				}
			} else if (changeMoney >= 0.05 && changeMoney < 0.1) {
				if (map.get(CoinName.Nickel) != 0) {
					changeMoney = changeMoney - 0.05;
					map.put(CoinName.Nickel, map.get(CoinName.Nickel) - 1);
				} else {
					System.out.println("CAN NOT AFFORD THAT MONEY YOU CANT TAKE CHANGE MONEY");
					break;
				}
			} else {
				System.out.println("Odenebilen : " + (tempchangedouble.doubleValue()-changeMoney));
				System.out.println("Ödenemeyen : " + changeMoney);
				break;
			}
		}

	}

}
