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
	private Integer incomeFixed;
	private Integer constructionCost;
	private Integer amountStay;

	/**
	 * @param valor
	 */
	public Camp(Integer valor, Integer incomeFixed, Integer constructionCost) {
		super(valor);
		this.setIncomeFixed(incomeFixed);
		this.setConstructionCost(constructionCost);
		this.setAmountStay(0);
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
	public Integer income(Player player) {
		return calculateIncomeWithStays() * getIncomeFixed();
	}

	public Integer calculateIncomeWithStays() {
		Integer powResoult = 1;
		Integer amountStay = getAmountStay();
		while (amountStay > 0) {
			powResoult = powResoult * 2;
			amountStay -= 1;
		}
		return powResoult;
	}

	public void buildEstancia() {
		if (getProvince().validateIfIsValidBuildEstancia(this)) {
			getOwner().subtractMoney(getConstructionCost());
			amountStay += 1;
		}
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Integer getIncomeFixed() {
		return incomeFixed;
	}

	public void setIncomeFixed(Integer incomeFixed) {
		this.incomeFixed = incomeFixed;
	}

	public Integer getConstructionCost() {
		return constructionCost;
	}

	public void setConstructionCost(Integer constructionCost) {
		this.constructionCost = constructionCost;
	}

	public Integer getAmountStay() {
		return amountStay;
	}

	public void setAmountStay(Integer countStay) {
		this.amountStay = countStay;
	}

	/**
	 * @see tenpines.estanciero.Property#step(tenpines.estanciero.Player)
	 */
	@Override
	public void step(Owner player) {
	}

}
