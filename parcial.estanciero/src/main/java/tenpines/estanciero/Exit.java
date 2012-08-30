/**
 * 23/08/2012 17:46:17 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public class Exit extends Locker {

	public Integer credit = 5000;

	/**
	 * @see tenpines.estanciero.Locker#step(tenpines.estanciero.Player)
	 */
	@Override
	public void step(Player player) {
		player.charge(credit);
	}

	@Override
	public void cay(Player player) {
	}

}
