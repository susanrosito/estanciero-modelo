package tenpines.estanciero;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

abstract public class Owner {

	protected ArrayList<Property> propertys = new ArrayList<Property>();
	protected Integer money;

	/**
	 * 
	 */
	public Owner(Integer money) {
		this.money = money;
	}

	public void charge(Integer income) {

	}

	public void subtractProperty(Property property) {

	}

	/**
	 * contar las cantidad de empresas que tiene un jugador
	 */
	public Integer countCompanys() {
		@SuppressWarnings("unchecked")
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

	public boolean isBank() {
		return false;
	}

	public Integer getNumberOfDice() {
		return 1;
	}

	public void cayPlayer(Player player, Property property) {

	}

	public void subtractMoney(Integer money) {

	}

	public void addProperty(Property property) {

	}

	public ArrayList<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(ArrayList<Property> propertys) {
		this.propertys = propertys;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
