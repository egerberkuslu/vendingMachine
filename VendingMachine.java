package vendingmachine;

 
public class VendingMachine {
	

    ProductList pl = new ProductList();
	CoinSet cs = new CoinSet();
	

	public void loadProducts() {
		ProductList.products.addAll(ProductReader.readProducts());
		this.loadProductsForShowAll();
	}
	
	public void loadProductsForShowAll() {
		ProductList.allProducts.addAll(ProductReader.readProducts());
	}

	public void buyProduct(Product P,int index) throws InsufficientMoneyException {

		CoinSet cs = new CoinSet();
		if (P.getPrice() < cs.getTotalValue()) {
			System.out.println(P.getName() + " BUYED");
			cs.CoinSeperator();
			cs.change(P);
			cs.removeAllCoins();
			pl.UptadeAvaiblityNow(P, index);
			cs.TotalCoinInMachine();
		
		} else if (P.getPrice() == cs.getTotalValue()) {
			System.out.println(P.getName() + " BUYED");
			cs.CoinSeperator();
			System.out.println("Para ustu" + " " + (cs.getTotalValue() - P.getPrice()));
			cs.removeAllCoins();
			pl.UptadeAvaiblityNow(P, index);
			cs.TotalCoinInMachine();
		
		} else {
			// throw exception
			cs.TotalCoinInMachine();
			System.out.println(P.getName() + " COULDNT BUY IT ");
			throw new InsufficientMoneyException("INSUFFICIENT MONEY ERROR");
		}

	}

	public void addCoin(Coin c) {
		cs.addCoin(c);
	}
    
	public int getProductIndex(String choice, String pattern) {
		int index = 0;

		for (int i = 0; i < ProductList.products.size(); i++) {
			if (choice.equals(pattern.toLowerCase().substring(i + 1, i + 2))
					|| choice.equals(pattern.toUpperCase().substring(i + 1, i + 2))) {
				index = i; // string substring begins with i+1 cause of [ ends with ]
				break;
			}
		}
		return index;
	}
	
	
	public Product getProductTypes(String choice, String pattern) {
		int index = 0;

		for (int i = 0; i < ProductList.products.size(); i++) {
			if (choice.equals(pattern.toLowerCase().substring(i + 1, i + 2))
					|| choice.equals(pattern.toUpperCase().substring(i + 1, i + 2))) {
				index = i; // string substring begins with i+1 cause of [ ends with ]
				break;
			}
		}
		return ProductList.products.get(index);
	}

	public void loadCoinSetDefault() {
		CoinSet.map.put(CoinName.Nickel, 5);
		CoinSet.map.put(CoinName.Dime, 5);
		CoinSet.map.put(CoinName.Quarter, 5);
		CoinSet.map.put(CoinName.Dollar, 5);
	}
}
