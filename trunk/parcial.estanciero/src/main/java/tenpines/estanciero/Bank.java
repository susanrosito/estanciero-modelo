/**
 * 23/08/2012 13:44:22 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public class Bank extends Owner {

	public Bank(Integer money) {
		super(money);
	}

	/**
	 * @see tenpines.estanciero.Owner#cayPlayer(tenpines.estanciero.Player)
	 */
	public void cayPlayer(Player player, Property property) {
		player.buyProperty(property);
	}

	/**
	 * @see tenpines.estanciero.Owner#charge(java.lang.Double)
	 */
	public void charge(Integer valueProperty) {
		this.money += valueProperty;
	}

	public void addProperty(Property property) {
		property.changeOwner(this);
		this.propertys.add(property);
	}

	/**
	 * @see tenpines.estanciero.Owner#subtractProperty(tenpines.estanciero.Property)
	 */
	public void subtractProperty(Property property) {
		this.getPropertys().remove(property);
	}

	/**
	 * @see tenpines.estanciero.Owner#isBank()
	 */
	public boolean isBank() {
		return true;
	}

	/**
	 * @see tenpines.estanciero.Owner#substractMoney()
	 */
	public void subtractMoney(Integer value) {
		this.money -= value;
	}

}
