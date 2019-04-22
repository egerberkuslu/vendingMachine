package vendingmachine;

import java.util.ArrayList;

public class ProductList {
	 static ArrayList<Product> products = new ArrayList<Product>();
	 static ArrayList<Product> allProducts = new ArrayList<Product>();
	 
	 
	public void listProductDetails(){
		Product temp;
		System.out.println("Product Details");
		for (int i = 0; i < products.size(); i++) {
			temp = products.get(i);
			System.out.println( (char)(65+i)+ ")" + " " +"Name" + " " + temp.getName());
			System.out.println("Description" + " " + temp.getDescription());
			System.out.println("Price" + " " + temp.getPrice());
		}
	    
	}
	
	public void listAllProducts() {
		Product temp;
		System.out.println("Product Details");
		for (int i = 0; i < allProducts.size(); i++) {
			temp = allProducts.get(i);
			System.out.println( (char)(65+i)+ ")" + " " +"Name" + " " + temp.getName());
			System.out.println("Description" + " " + temp.getDescription());
			System.out.println("Price" + " " + temp.getPrice());
		}
	}
	
	public Product getProduct(int ID) {
		try {
			 products.addAll(ProductReader.readProducts());
			return products.get(ID);
		} catch (IndexOutOfBoundsException e) {
		   System.out.println(e.getMessage());
		   return null;
		}
	}
	
	public void addProduct(Product p) {
		 products.addAll(ProductReader.readProducts());
		products.add(p);
	}
	
	public void UptadeAvaiblityNow(Product P, int index) {
		P.setQuantity(P.getQuantity()-1);
		if(P.getQuantity() == 0) {
			ProductList.products.remove(index);
		}
	}

}
