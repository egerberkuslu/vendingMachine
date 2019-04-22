package vendingmachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VendingMachineInterface {

	Scanner scanner = new Scanner(System.in);
	Coin[] possibleCoins = new Coin[200];
	VendingMachine vm = new VendingMachine();
	ProductList p = new ProductList();

	public void getChoise() throws InsufficientMoneyException, InvalidMenuSelection {
		try {
			String choice = scanner.next();
			if (choice.matches("[abcdABCD]")) { // using regex for decreasing the controlls
				switch (choice) {
				case "A":
				case "a":
					System.out.println("Showing Product is processing");
					p.listAllProducts(); //show all products even we have a zero quantity of a product.... wanna show all products
					break;
				case "B":
				case "b":
					System.out.println("Inserting a coin is  processing");
					System.out.println("A) Nickel 0.05 ");
					System.out.println("B) Dime 0.1 ");
					System.out.println("C) Quarter 0.25 ");
					System.out.println("D) Dollar 1.0 ");
					choice = scanner.next();
					Coin c;
					CoinSet cs = new CoinSet();
					if (choice.matches("[abcdABCD]")) {
						switch (choice) {
						case "A":
						case "a":
							c = new Coin(0.05);
							vm.addCoin(c);
							System.out.println("INSERTTED 0.05");
							System.out.println("Total Inserted: " + cs.getTotalValue());
							break;
						case "B":
						case "b":
							c = new Coin(0.1);
							vm.addCoin(c);
							System.out.println("INSERTTED 0.1");
							System.out.println("Total Inserted: " + cs.getTotalValue());
							break;
						case "C":
						case "c":
							c = new Coin(0.25);
							vm.addCoin(c);
							System.out.println("INSERTTED 0.25");
							System.out.println("Total Inserted: " + cs.getTotalValue());
							break;
						case "D":
						case "d":
							c = new Coin(1);
							vm.addCoin(c);
							System.out.println("INSERTTED 1");
							System.out.println("Total Inserted: " + cs.getTotalValue());
							break;
						default:
							break;
						}
					} else {
						// throw exception wrong choice
						System.out.println("YOU CAN INSERT ONLY A B C D coins");
						throw new InvalidMenuSelection("INVALID MENU SELECTION ERROR");
					}
					break;

				case "C":
				case "c":
					System.out.println("Buying Product is processing");
					String pattern = "";

					for (int i = 0; i < ProductList.products.size(); i++) {
						pattern += (char) (65 + i);
						// dynamic regex with ascii
					}
					pattern = "[" + pattern + "]";
					p.listProductDetails();  // only show avaiable products which quantity are greater than zero.
					CoinSet coinset = new CoinSet();
					System.out.println("Total Inserted: " + coinset.getTotalValue());
					System.out.println("buy product press ex:a");
					choice = scanner.next();

					if ((choice.matches(pattern.toLowerCase())) || (choice.matches(pattern.toUpperCase()))) {
						Product p = vm.getProductTypes(choice, pattern);
						int index = vm.getProductIndex(choice, pattern);
						// if p.getQuantity != 0 then buy
						// else sout cant have this producy
						if (p.getQuantity() != 0) { // dont need to control it when products deleted if quantity is zero
													// buy checking again for any mistake
							vm.buyProduct(p, index);
						} else {
							System.out.println("Couldnt Buy" + p.getName() + " quantity is zero");
						}

					} else {
						// throw exception wrong choice
						System.out.println("YOU CAN buy" + " " + pattern.toLowerCase() + pattern.toUpperCase());
						throw new InvalidMenuSelection("INVALID MENU SELECTION ERROR");
					}

					break;
				case "D":
				case "d":
					System.out.println("quitting");
					System.exit(0);
					break;
				default:
					break;
				}
			} else {
				// wrong choice
				System.out.println("Please press A for show products");
				System.out.println("Please press B for  insert coin");
				System.out.println("Please press C for buy product");
				System.out.println("Please press D for Quit");
				throw new InvalidMenuSelection("INVALID MENU SELECTION ERROR");
			}

		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());

		}
	}

	public void run() {
		while (true) {
			try {
				System.out.println("A) Show Products B)Insert Coin C)Buy D)Exits");
				this.getChoise();

			} catch (InsufficientMoneyException e) {
				System.out.println(e.getMessage());
			} catch (InvalidMenuSelection e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
