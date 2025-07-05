import java.util.*;
public class App {
	public static void main(String[] args) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 5); // not expired
            Date futureDate = cal.getTime();

            Customer customer = new Customer(1000);
            Product cheese = new Cheese("Cheese", 100, 5, 0.2, futureDate);
            Product biscuits = new Biscuits("Biscuits", 150, 3, 0.7, futureDate);
            Product tv = new TV("TV", 300, 4, 5.0);
            Product scratchCard = new MobileScratchCard("Scratch Card", 50, 10);

            Cart cart = new Cart();
            cart.addProduct(cheese, 2);
            cart.addProduct(biscuits, 1);
            cart.addProduct(tv, 1);
            cart.addProduct(scratchCard, 1);

            Checkout.checkout(customer, cart);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
