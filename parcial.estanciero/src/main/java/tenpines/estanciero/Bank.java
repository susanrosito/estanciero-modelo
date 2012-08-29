/**
 * 23/08/2012 13:44:22 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

import java.util.ArrayList;

/**
 * 
 * @author Susana
 */
public class Bank implements Owner {

	private ArrayList<Property> propertys;
	private Double money;

	public Bank(Double money) {
		this.money = money;
		this.propertys = new ArrayList<Property>();
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
	public void charge(Double valueProperty) {
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
	 * @see tenpines.estanciero.Owner#countCompanys()
	 */
	public Integer countCompanys() {
		Integer cantEmpresas = 0;
		for (Property property : this.getPropertys()) {
			if (property.isCompany()) {
				cantEmpresas++;
			}
		}
		return cantEmpresas;
	}

	/**
	 * @see tenpines.estanciero.Owner#isBank()
	 */
	public boolean isBank() {
		return true;
	}

	/**
	 * @see tenpines.estanciero.Owner#getNumberOfDice()
	 */
	public Double getNumberOfDice() {
		return 1.0;
	}

	/**
	 * @see tenpines.estanciero.Owner#substractMoney()
	 */
	public void subtractMoney(Double value) {
		this.money -= value;
	}

	public ArrayList<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(ArrayList<Property> propertys) {
		this.propertys = propertys;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
