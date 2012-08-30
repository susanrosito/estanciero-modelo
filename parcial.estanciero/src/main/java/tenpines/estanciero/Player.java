/**
 * 23/08/2012 13:33:46 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

import java.util.ArrayList;

/**
 * 
 * @author Susana
 */
public class Player extends Owner {

	private Integer numberOfDice;
	private Integer position;

	public Player(Integer money) {
		super(money);
		this.setPosition(0);
		this.setNumberOfDice(0);

	}

	/**
	 * @param property
	 */
	public void buyProperty(Property property) {
		Integer valorProperty = property.getValue();
		this.verifyIfMoneyIsValid(valorProperty);
		payThePropertyACreditor(property);
		property.changeOwner(this);
		this.addProperty(property);
		this.subtractMoney(valorProperty);
	}

	/**
	 * @see tenpines.estanciero.Owner#subtractMoney(java.lang.Double)
	 */
	public void subtractMoney(Integer money) {
		this.setMoney(this.getMoney() - money);
	}

	public void addProperty(Property property) {
		property.changeOwner(this);
		this.propertys.add(property);
	}

	public Integer incomeToPay(Property property) {
		return property.income(this);
	}

	public void payThePropertyACreditor(Property property) {
		Owner oldOwner = property.getOwner();
		Integer value = property.getValue();
		oldOwner.charge(value);
		oldOwner.subtractProperty(property);
	}

	public void payTheIncomeACreditor(Property property) {
		Owner owner = property.getOwner();
		Integer income = incomeToPay(property);
		this.verifyIfMoneyIsValid(income);
		this.subtractMoney(income);
		owner.charge(income);
	}

	public void charge(Integer valueProperty) {
		this.setMoney(this.getMoney() + valueProperty);
	}

	public void subtractProperty(Property property) {
		this.getPropertys().remove(property);
	}

	public void verifyIfMoneyIsValid(Integer valorProperty) {
		if (!(this.getMoney() > 0) || this.getMoney() < valorProperty) {
			throw new RuntimeException("No es posible hacer la compra porque no tienes dinero suficiente");
		}
	}

	// fixme!!
	public void moveTo(ArrayList<Locker> lockers) {
		Integer valueDice = getNumberOfDice();
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
		Integer value = dices.valueDices();
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

	public Integer getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(Integer numberOfDice) {
		this.numberOfDice = numberOfDice;
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
