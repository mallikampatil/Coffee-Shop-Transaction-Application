
public class Sugar extends CoffeeDecorator{

private double cost = .50;
	
	Sugar(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addSugar();
	}
	
	private double addSugar() {
		
		System.out.println(" + sugar: $.50");
		cost = (double) Math.round(cost * 100) / 100; 
		return cost;
	}
}
