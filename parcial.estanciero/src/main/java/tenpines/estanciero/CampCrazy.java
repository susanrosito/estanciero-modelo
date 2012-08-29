package tenpines.estanciero;

/**
 * 24/08/2012 16:53:59 Copyright (C) 2011 10Pines S.R.L.
 */

/**
 * 
 * @author Susana
 */
public class CampCrazy extends Camp {

	private Double chargeBonus = 500.0;

	/**
	 * @param valor
	 * @param owner
	 * @param incomeFixed
	 * @param constructionCost
	 */
	public CampCrazy(Double valor, Double incomeFixed, Double constructionCost) {
		super(valor, incomeFixed, constructionCost);
		addPorcengeCrazy();
	}

	private Double crazyPorcenge = 0.20;

	public void addPorcengeCrazy() {
		Double porcengeOfValue = getIncomeFixed() * 0.2;
		this.setIncomeFixed(getIncomeFixed() + porcengeOfValue);
	}

	public Double getCrazyPorcenge() {
		return crazyPorcenge;
	}

	public void setCrazyPorcenge(Double crazyPorcenge) {
		this.crazyPorcenge = crazyPorcenge;
	}

	@Override
	public void step(Owner player) {
		if (!(player.equals(this.getOwner())) && player.countCompanys() > 5) {
			player.subtractMoney(chargeBonus);
			this.getOwner().charge(chargeBonus);
		}
	}

	public Double getChargeBonus() {
		return chargeBonus;
	}

	public void setChargeBonus(Double chargeBonus) {
		this.chargeBonus = chargeBonus;
	}
}
