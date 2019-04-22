package vendingmachine;

import java.util.Objects;

public class Product {
    private String Name;
    private double Price;
    private String description;
    private int quantity;

    public Product(String Name, double Price, String description) {
        this.Name = Name;
        this.Price = Price;
        this.description = description;
        this.quantity = 1;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public String getDescription() {
        return description;
    }
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }
    public int getQuantity() {
    	return quantity;
    }

    @Override
    public String toString() {
        String str = this.Name+"\n";
        str += this.description+"\n";
        str+= this.Price+" $";
        return str;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (Double.doubleToLongBits(this.Price) != Double.doubleToLongBits(other.Price)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
