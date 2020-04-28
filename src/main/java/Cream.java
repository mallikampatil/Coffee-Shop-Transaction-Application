
public class Cream extends CoffeeDecorator{

	private double cost = .50;
	Cream(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee() + addCream();
	}
	
	private double addCream() {
		
		System.out.println(" + cream: $.50");
		cost = (double) Math.round(cost * 100) / 100; 
		return cost;
	}
}
