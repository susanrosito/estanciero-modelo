package tenpines.estanciero;

public interface Owner {

	public void charge(Double valueProperty);

	public void subtractProperty(Property property);

	public Integer countCompanys();

	public boolean isBank();

	public Double getNumberOfDice();

	public void cayPlayer(Player player, Property property);

	public void subtractMoney(Double money);

	public void addProperty(Property property);

}
