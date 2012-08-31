/**
 * 29/08/2012 16:49:36 Copyright (C) 2011 10Pines S.R.L.
 */
package exampleBuilder;

/**
 * 
 * @author Susana
 */
public class Cook {

	/** "Director" */
	private PizzaBuilder pizzaBuilder;

	public void setPizzaBuilder(PizzaBuilder pb) {
		pizzaBuilder = pb;
	}

	public Pizza getPizza() {
		return pizzaBuilder.getPizza();
	}

	public void constructPizza() {
		pizzaBuilder.createNewPizzaProduct();
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSauce();
		pizzaBuilder.buildTopping();
	}
}
