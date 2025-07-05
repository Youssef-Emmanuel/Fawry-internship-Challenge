import java.util.*;
public class ShippingService {
	public static void ship(List<Shippable> shippables, Map<String, Integer> count){
		System.out.println("** Shipment Notice **");
		double totalWeight = 0;
		for(Shippable shipItem : shippables){
			int c = count.getOrDefault(shipItem.getName(), 1);
			double totalItemWeight = c*shipItem.getWeight();
			System.out.println(count + "x" + shipItem.getName() + " " + (int)(shipItem.getWeight()) + "g");
		totalWeight += totalItemWeight;
		}
		System.out.println("Total package weight" + totalWeight);
		
		
	}
		
		
	

}
