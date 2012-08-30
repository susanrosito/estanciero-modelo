/**
 * 29/08/2012 16:50:45 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public class BuilderExample {

	/** A given type of pizza being constructed. */
	public static void main(String[] args) {
		Cook cook = new Cook();

		PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
		PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

		cook.setPizzaBuilder(hawaiianPizzaBuilder);
		cook.constructPizza();

		Pizza pizza = cook.getPizza();
	}
}
