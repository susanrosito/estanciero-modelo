/**
 * 23/08/2012 13:49:19 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public abstract class Property {

	private Integer value;
	private Owner owner;

	public Property(Integer valor) {
		this.setValue(valor);
	}

	abstract public boolean isCompany();

	abstract public Integer income(Player player);

	abstract public void step(Owner player);

	public void changeOwner(Owner player) {
		this.setOwner(player);
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return true;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 9;
	}
}
