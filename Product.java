
public abstract class Product {
	String name;
	double price;
	int quantity;
	
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void reduceQuantity(int quan){
		quantity -=quan;
	}
}
