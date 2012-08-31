/**
 * 29/08/2012 16:44:50 Copyright (C) 2011 10Pines S.R.L.
 */
package exampleBuilder;

/**
 * 
 * @author Susana
 */
/** "Abstract Builder" */

abstract public class PizzaBuilder {

	protected Pizza pizza;

	public Pizza getPizza() {
		return pizza;
	}

	public void createNewPizzaProduct() {
		pizza = new Pizza();
	}

	public abstract void buildDough();

	public abstract void buildSauce();

	public abstract void buildTopping();
}
