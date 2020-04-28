import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoffeeDecoratorTest {

	Coffee order; 
	double cost; 
	@BeforeEach
	void init() {
		order = new BasicCoffee();
	}
	
	/* Test Case 1: Coffee Object */ 
	@Test
	void initCoffee() {
		assertEquals("BasicCoffee", order.getClass().getName(), "did not initialize Coffee object.");
	}

	/* Test Case 2: Basic Coffee Cost */ 
	@Test
	void basicCoffeeCost() {
		cost = order.makeCoffee(); 
		assertEquals(3.99, cost, "incorrect cost of Basic Coffee.");
	}
	
	/* Test Case 3: Basic Coffee with Cream Cost */ 
	@Test
	void addCreamCost() {
		order = new Cream(order); 
		cost = order.makeCoffee(); 
		assertEquals(4.49, cost, "incorrect cost of Basic Coffee with Cream.");
	}
	
	/* Test Case 4: Basic Coffee Cost with Sugar Cost */ 
	@Test
	void addSugarCost() {
		order = new Sugar(order); 
		cost = order.makeCoffee(); 
		assertEquals(4.49, cost, "incorrect cost of Basic Coffee with Sugar.");
	}
	
	/* Test Case 5: Basic Coffee Cost with Extra Shot */ 
	@Test
	void addExtraShotCost() {
		order = new ExtraShot(order); 
		cost = order.makeCoffee(); 
		assertEquals(5.19, cost, "incorrect cost of Basic Coffee with Extra Shot.");
	}
	
	/* Test Case 6: Basic Coffee Cost with Nut Milk */ 
	@Test
	void addNutMilkCost() {
		order = new NutMilk(order); 
		cost = order.makeCoffee(); 
		assertEquals(4.59, cost, "incorrect cost of Basic Coffee with Nut Milk");
	}
	
	/* Test Case 7: Basic Coffee Cost with Nut Milk */ 
	@Test
	void addFlavorSyrupCost() {
		order = new FlavorSyrup(order); 
		cost = order.makeCoffee(); 
		assertEquals(4.69, cost, "incorrect cost of Basic Coffee with Flavor Syrup.");
	}
	
	/* Test Case 8: Basic Coffee Cost with Cream and Sugar */ 
	@Test
	void addCreamSugarCost() {
		order = new Sugar(new Cream(order)); 
		cost = order.makeCoffee(); 
		assertEquals(4.99, cost, "incorrect cost of Basic Coffee with Flavor Syrup.");
	}
	
	/* Test Case 9: Basic Coffee Cost with Extra Shot and Nut Milk and Flavor Syrup */ 
	@Test
	void multipleAddOnsCost() {
		order = new FlavorSyrup( new NutMilk(new ExtraShot(order))); 
		cost = order.makeCoffee(); 
		assertEquals(6.49, cost, "incorrect cost of Basic Coffee with Flavor Syrup.");
	}
	
	/* Test Case 10: Basic Coffee Cost with Extra Shot and Nut Milk and Flavor Syrup in a different order */ 
	@Test
	void differentOrderMultipleAddOns() {
		order = new NutMilk( new ExtraShot(new FlavorSyrup(order))); 
		cost = order.makeCoffee(); 
		assertEquals(6.49, cost, "incorrect cost of Basic Coffee with Flavor Syrup.");
	}

}
