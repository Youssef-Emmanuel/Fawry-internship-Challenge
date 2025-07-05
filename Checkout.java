import java.util.*;
public class Checkout {
	public static void checkout(Customer customer, Cart cart){
		if(cart.isEmpty()){
			 throw new IllegalStateException("Cart is empty, add some products ");
		}
	double total = 0;
	double shippingFee = 0;
	List<Shippable> toShip = new ArrayList<>();
	Map<String, Integer> shipCounts = new HashMap<>();
	for (Item item : cart.getItems()){
        Product p = item.product;
        int qty = item.quantity;
        if (p instanceof Expirable && ((Expirable)p).isExpired()){
            throw new IllegalStateException(p.getName() + " is expired");
        }
        if (p.getQuantity() < qty){
            throw new IllegalStateException("Not enough stock for " + p.getName());
        }
        p.reduceQuantity(qty);
        total += p.getPrice() * qty;
        if (p instanceof Shippable) {
            toShip.add((Shippable)p);
            shipCounts.put(p.getName(), shipCounts.getOrDefault(p.getName(), 0) + qty);
            shippingFee += ((Shippable)p).getWeight() * qty * 10; // Flat rate per kg
        }
    }
	total += shippingFee;
	 if (!customer.pay(total))
         throw new IllegalStateException("Insufficient balance");

     if (!toShip.isEmpty())
         ShippingService.ship(toShip, shipCounts);

     System.out.println("** Checkout receipt **");
     for (Item item : cart.getItems()) {
         System.out.println(item.quantity +" " + item.product.getName() + " " + item.product.getPrice() * item.quantity);
     }
     System.out.println("----------------------");
     System.out.println("Subtotal " + total);
     System.out.println("Shipping " + shippingFee);
     System.out.println("Amount " + total);
     System.out.println("Customer balance " + customer.getBalance());
}
}




