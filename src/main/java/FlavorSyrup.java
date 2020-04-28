public class FlavorSyrup extends CoffeeDecorator{

private double cost = .70;
	
	FlavorSyrup(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addSyrup();
	}
	
	private double addSyrup() {
		
		System.out.println(" + syrup: $.70");
		cost = (double) Math.round(cost * 100) / 100; 
		return cost;
	}
}
