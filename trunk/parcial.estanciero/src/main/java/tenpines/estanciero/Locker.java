/**
 * 23/08/2012 16:08:52 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public abstract class Locker {

	protected Bank bank;

	/**
	 * constructor recibe como parametro el banco
	 */
	public Locker(Bank bank) {
		this.bank = bank;
	}

	abstract public void step(Player player);

	abstract public void cay(Player player);

}
