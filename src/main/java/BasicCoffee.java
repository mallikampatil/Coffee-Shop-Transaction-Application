
public class BasicCoffee implements Coffee {

	private double cost = 3.99;
	
	@Override
	public double makeCoffee() {
		System.out.println("Black Coffee: $3.99");
		cost = (double) Math.round(cost * 100) / 100; 
		return cost;
	}
	

}
