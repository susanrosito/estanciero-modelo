/**
 * 23/08/2012 17:47:10 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public class Award extends Locker {

	private Integer award = 2500;

	/**
	 * @see tenpines.estanciero.Locker#step(tenpines.estanciero.Player)
	 */
	@Override
	public void step(Player player) {
	}

	@Override
	public void cay(Player player) {
		player.charge(award);
	}

	public Integer getAward() {
		return award;
	}

	public void setAward(Integer award) {
		this.award = award;
	}

}
