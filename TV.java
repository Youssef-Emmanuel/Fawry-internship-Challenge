
public class TV extends Product implements Shippable {
	double weight;
	TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}
	

}
