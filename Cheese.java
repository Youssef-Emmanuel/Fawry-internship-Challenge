import java.util.*;
public class Cheese extends Product implements Shippable, Expirable {
	double weight;
	Date expiryDate;
	public Cheese(String name, double price, int quantity, double weight, Date expiryDate) {
		super(name, price, quantity);
		this.weight = weight;
		this.expiryDate = expiryDate;
	}
	@Override
	public boolean isExpired() {
		return new Date().after(expiryDate);
	}
	@Override
	public double getWeight() {
		return weight;
	}
	
	
}
