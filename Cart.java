import java.util.*;
public class Cart {
	List<Item> items = new ArrayList<>();
	public void addProduct(Product product, int quantity){
		if (quantity <= product.getQuantity()){
			items.add(new Item(product, quantity));
		}else{
			 throw new IllegalArgumentException("Quantity exceeds stock for " + product.getName());
		}
	}
	 public List<Item> getItems() {
	        return items;
	    }

	    public boolean isEmpty() {
	        return items.isEmpty();
	    }
		
}

