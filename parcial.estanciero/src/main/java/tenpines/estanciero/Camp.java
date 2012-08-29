/**
 * 23/08/2012 15:35:51 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

/**
 * 
 * @author Susana
 */
public class Camp extends Property {

	private Province province;
	private Double incomeFixed;
	private Double constructionCost;
	private Integer countStay;

	/**
	 * @param valor
	 */
	public Camp(Double valor, Double incomeFixed, Double constructionCost) {
		super(valor);
		this.setIncomeFixed(incomeFixed);
		this.setConstructionCost(constructionCost);
		this.setCountStay(0);
	}

	/**
	 * @see tenpines.estanciero.Property#isCompany()
	 */
	@Override
	public boolean isCompany() {
		return false;
	}

	/**
	 * @see tenpines.estanciero.Property#rentaACobrar()
	 */
	@Override
	public Double rentaACobrar(Owner player) {
		return Math.pow(2, getCountStay()) * getIncomeFixed();
	}

	public void buildEstancia() {
		if (getProvince().validateIfIsValidBuildEstancia(this)) {
			getOwner().subtractMoney(getConstructionCost());
			countStay += 1;
		}
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Double getIncomeFixed() {
		return incomeFixed;
	}

	public void setIncomeFixed(Double incomeFixed) {
		this.incomeFixed = incomeFixed;
	}

	public Double getConstructionCost() {
		return constructionCost;
	}

	public void setConstructionCost(Double constructionCost) {
		this.constructionCost = constructionCost;
	}

	public Integer getCountStay() {
		return countStay;
	}

	public void setCountStay(Integer countStay) {
		this.countStay = countStay;
	}

	/**
	 * @see tenpines.estanciero.Property#step(tenpines.estanciero.Player)
	 */
	@Override
	public void step(Owner player) {
	}

}
