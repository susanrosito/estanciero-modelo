/**
 * 24/08/2012 11:15:37 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public class PropertyLocker extends Locker {

	private Property property;

	public PropertyLocker(Bank bank, Property property) {
		super(bank);
		this.property = property;
	}

	/**
	 * @see tenpines.estanciero.Locker#step(tenpines.estanciero.Player)
	 */
	@Override
	public void step(Player player) {
		property.step(player);
	}

	/**
	 * @see tenpines.estanciero.Locker#cay(tenpines.estanciero.Player)
	 */
	@Override
	public void cay(Player player) {
		Owner owner = getProperty().getOwner();
		owner.cayPlayer(player, getProperty());
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
}
