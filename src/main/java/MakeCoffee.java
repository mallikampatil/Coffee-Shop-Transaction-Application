import java.util.ArrayList;

public class MakeCoffee {
	static double cost; 
    
    public static Coffee addCream(Coffee order) {
    	return order = new Cream(order); 
    }
    
    public static Coffee addSugar(Coffee order) {
    	return order = new Sugar(order); 
    }
    
    public static Coffee addSyrup(Coffee order) {
    	return order = new FlavorSyrup(order); 
    }
    
    public static Coffee addShot(Coffee order) {
    	return order = new ExtraShot(order); 
    }
    
    public static Coffee addMilk(Coffee order) {
    	return order = new NutMilk(order); 
    }
    
    public static void printTotal (double cost) {
    	System.out.println("Total: " + cost);
    }
}
