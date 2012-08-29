/**
 * 23/08/2012 13:33:46 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 * 
 * @author Susana
 */
public class Player implements Owner {

	private ArrayList<Property> propertys;
	private Double money;
	private Double numberOfDice;
	private Integer position;

	public Player(Double money) {
		this.setPropertys(new ArrayList<Property>());
		this.setMoney(money);
		this.setPosition(0);
		this.setNumberOfDice(0.0);

	}

	/**
	 * @param property
	 */
	public void buyProperty(Property property) {
		Double valorProperty = property.getValue();
		this.verifyIfMoneyIsValid(valorProperty);
		payThePropertyACreditor(property);
		property.changeOwner(this);
		this.addProperty(property);
		this.subtractMoney(valorProperty);
	}

	/**
	 * @see tenpines.estanciero.Owner#subtractMoney(java.lang.Double)
	 */
	public void subtractMoney(Double money) {
		this.setMoney(this.getMoney() - money);
	}

	/**
	 * contar las cantidad de empresas que tiene un jugador
	 */
	public Integer countCompanys() {
		Collection<Property> selected = CollectionUtils.select(propertys, this.isCompanyPredicate());
		return selected.size();
	}

	/**
	 * @return
	 */
	private Predicate isCompanyPredicate() {
		return new Predicate() {
			public boolean evaluate(Object object) {
				Property aProperty = (Property) object;
				return aProperty.isCompany();
			}
		};
	}

	public void addProperty(Property property) {
		property.changeOwner(this);
		this.propertys.add(property);
	}

	// lo que me hace un poco de chispa es la idea de pasar player por parametro
	// (hace falta?)
	public Double incomeToPay(Property property) {
		return property.rentaACobrar(this);
	}

	public void payThePropertyACreditor(Property property) {
		Owner oldOwner = property.getOwner();
		Double value = property.getValue();
		oldOwner.charge(value);
		oldOwner.subtractProperty(property);
	}

	public void payTheIncomeACreditor(Property property) {
		Owner owner = property.getOwner();
		Double income = incomeToPay(property);
		this.verifyIfMoneyIsValid(income);
		this.subtractMoney(income);
		owner.charge(income);
	}

	public void charge(Double valueProperty) {
		this.setMoney(this.getMoney() + valueProperty);
	}

	public void subtractProperty(Property property) {
		this.getPropertys().remove(property);
	}

	public void verifyIfMoneyIsValid(Double valueProperty) {
		if (!(this.getMoney() > 0) || this.getMoney() < valueProperty) {
			throw new RuntimeException("No es posible hacer la compra porque no tienes dinero suficiente");
		}
	}

	// fixme!!
	public void moveTo(ArrayList<Locker> lockers) {
		Double valueDice = getNumberOfDice();
		Integer i = getPosition();
		while (i < lockers.size() && valueDice > 0) {
			Locker locker = lockers.get(i);
			if (valueDice == 1) {
				locker.cay(this);
			} else {
				locker.step(this);
			}
			valueDice -= 1;
			i++;
			// setPosition(i);
		}
		// setPosition(i);
	}

	public void pullDice() {
		Dices dices = new Dices();
		Double value = dices.valueDices();
		setNumberOfDice(value);
	}

	/**
	 * @see tenpines.estanciero.Owner#cayPlayer(tenpines.estanciero.Player,
	 *      tenpines.estanciero.Property)
	 */
	public void cayPlayer(Player player, Property property) {
		if (!(isSame(player))) {
			player.payTheIncomeACreditor(property);
		}
	}

	public boolean isSame(Owner player) {
		return this.equals(player);
	}

	public ArrayList<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(ArrayList<Property> propertys) {
		this.propertys = propertys;
	}

	public Double getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(Double numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public boolean isBank() {
		return false;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
