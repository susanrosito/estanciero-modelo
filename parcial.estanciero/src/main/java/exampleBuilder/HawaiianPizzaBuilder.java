/**
 * 29/08/2012 16:48:25 Copyright (C) 2011 10Pines S.R.L.
 */
package exampleBuilder;

/**
 * 
 * @author Susana
 */
public class HawaiianPizzaBuilder extends PizzaBuilder {

	public void buildDough() {
		pizza.setDough("cross");
	}

	public void buildSauce() {
		pizza.setSauce("mild");
	}

	public void buildTopping() {
		pizza.setTopping("ham+pineapple");
	}
}
