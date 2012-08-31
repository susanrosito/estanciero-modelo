/**
 * 23/08/2012 17:46:17 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public class Exit extends Locker {

	/**
	 * @param bank
	 */
	public Exit(Bank bank) {
		super(bank);
	}

	public Integer credit = 5000;

	/**
	 * @see tenpines.estanciero.Locker#step(tenpines.estanciero.Player)
	 */
	@Override
	public void step(Player player) {
		bank.amountPaidToCreditor(credit, player);
	}

	@Override
	public void cay(Player player) {
	}

}
