public class NutMilk extends CoffeeDecorator {

	private double cost = .60;
	
	NutMilk(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee() + addMilk();
	}
	
	private double addMilk() {
		System.out.println(" + nut milk: $.60");
		cost = (double) Math.round(cost * 100) / 100; 
		return cost;
	}
}
