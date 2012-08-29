/**
 * 23/08/2012 15:13:37 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public class Company extends Property {

	/**
	 * Constructor
	 */
	public Company(Double valor) {
		super(valor);
	}

	/**
	 * @see tenpines.estanciero.Property#isCompany()
	 */
	@Override
	public boolean isCompany() {
		return true;
	}

	/**
	 * @see tenpines.estanciero.Property#rentaACobrar()
	 */
	@Override
	public Double rentaACobrar(Owner player) {
		return player.getNumberOfDice() * 30000 * this.getOwner().countCompanys().doubleValue();
	}

	/**
	 * @see tenpines.estanciero.Property#step(tenpines.estanciero.Player)
	 */
	@Override
	public void step(Owner player) {
	}

}
