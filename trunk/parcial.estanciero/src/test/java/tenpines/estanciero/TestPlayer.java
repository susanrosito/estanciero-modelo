/**
 * 23/08/2012 13:04:05 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author Susana
 */
public class TestPlayer {

	public static String no_Tiene_Plata_Suficiente_Para_Comprar = "No es posible hacer la compra porque no tienes dinero suficiente";

	@Test
	public void WhenAPlayerBuyAPropertyWithYourDinnerMajorWhatThePriceOfPropertyShouldAddThePropertyAYourList() {
		// set up falta hacer que el dueño de la property reciba e dinero
		Player player = new Player(50000);
		Player owner = new Player(60000);
		Camp camp = new Camp(2000, 100, 500);
		owner.addProperty(camp);

		player.buyProperty(camp);

		// pregunto si lo contiene
		Assert.assertTrue(player.getPropertys().contains(camp));

		// y me aseguro de que sea la unica property
		Assert.assertEquals(1, player.getPropertys().size());

		// asegurarme que me descontaron la plata
		Assert.assertEquals((Double) 48000.0, player.getMoney());

		Assert.assertFalse(owner.getPropertys().contains(camp));

		Assert.assertEquals((Double) 62000.0, owner.getMoney());

		Assert.assertEquals(player, camp.getOwner());

	}

	@Test
	public void WhenAPlayerBuyAPropertyWithYourDinerLessWhatThePriceOfPropertyDontAddThePropertyAYourList() {
		Player player = new Player(0);
		Player owner = new Player(60000);
		Camp camp = new Camp(2000, 100, 500);
		owner.addProperty(camp);
		try {
			player.buyProperty(camp);
			fail();
		} catch (RuntimeException exception) {

			// verificar que es la Exception esperada
			Assert.assertEquals(no_Tiene_Plata_Suficiente_Para_Comprar, exception.getMessage());
			// pregunto si no lo tiene. (no deberia)
			Assert.assertFalse(player.getPropertys().contains(camp));

			// y verifico que la lista esta vacia
			Assert.assertTrue(player.getPropertys().isEmpty());

			// verifico el estado de mi dinero
			Assert.assertEquals((Double) 0.0, player.getMoney());

		}
	}

	@Test
	public void WhenAPlayerBuyAPropertyAOtherPlayerShouldChangeOwnerOfPropertyForFirstPlayer() {
		Player player = new Player(50000);
		Player owner = new Player(60000);
		Camp camp = new Camp(2000, 100, 500);
		owner.addProperty(camp);

		player.buyProperty(camp);

		// verifico que sean distintos los duenios
		Assert.assertNotSame(player, owner);

		// verifico que cambio el dueño de la property
		Assert.assertEquals(player, player.getPropertys().get(0).getOwner());

	}

	@Test
	public void IfBuyOneCompanyShouldAddThePropertyATheListAndChangeOfOwner() {
		Player player = new Player(50000);
		Player owner = new Player(60000);
		Company empresa = new Company(2000);
		owner.addProperty(empresa);

		player.buyProperty(empresa);

		Integer cantidadDeEmpresas = player.countCompanys();

		// verificamos que al comprarla la tenemos en nuestra lista
		Assert.assertTrue(player.getPropertys().contains(empresa));

		// verificar que tenemos una empresa y es la unica
		Assert.assertEquals((Integer) 1, cantidadDeEmpresas);

		Assert.assertEquals(player, empresa.getOwner());

		Assert.assertEquals((Integer) 0, owner.countCompanys());
	}

	@Test
	public void IfLikeKnowTheIncomeOfPropertyCampWithOutStayShouldDoSame() {
		Player player = new Player(5000);
		Camp camp = new Camp(2000, 100, 500);

		Integer income = player.incomeToPay(camp);

		Assert.assertEquals((Integer) 0, camp.getAmountStay());

		// pregunto si la renta es correcta de acuerdo al valor de la property
		Assert.assertEquals((Double) 100.0, income);
	}

	@Test
	public void IfLikeKnowTheIncomeOfPropertyCampWithStayShouldDoNotSame() {
		Player player = new Player(50000);
		Camp camp = new Camp(2000, 150, 400);
		camp.setAmountStay(2);
		Integer income = camp.getIncomeFixed();

		Integer incomeReal = player.incomeToPay(camp);

		Assert.assertEquals((Integer) 2, camp.getAmountStay());

		// pregunto si la renta es correcta de acuerdo al valor de la property
		Assert.assertEquals((Double) 600.0, incomeReal);

		Assert.assertNotSame((Double) 600.0, income);

	}

	@Test
	public void IfLikeKnowTheIncomeOfPropertyCampCrazyWithStayShouldDoAreMajorWhatValueInit() {
		Player player = new Player(50000);
		CampCrazy camp = new CampCrazy(2000, 100, 500);
		camp.setAmountStay(2);
		Integer income = camp.getIncomeFixed();
		Integer incomeReal = player.incomeToPay(camp);

		Assert.assertEquals((Integer) 2, camp.getAmountStay());

		// pregunto si la renta es correcta de acuerdo al valor de la property
		Assert.assertEquals((Double) 480.0, incomeReal);

		Assert.assertNotSame(income, incomeReal);
	}

	@Test
	public void IfLikeKnowTheIncomeOfPropertyCampCrazyWithOutStayShouldDoAreMajorWhatValueInit() {
		Player player = new Player(50000);
		CampCrazy camp = new CampCrazy(2000, 150, 400);
		Integer income = camp.getIncomeFixed();

		Integer incomeReal = player.incomeToPay(camp);

		Assert.assertEquals((Integer) 0, camp.getAmountStay());

		// pregunto si la renta es correcta de acuerdo al valor de la property
		Assert.assertEquals((Double) 180.0, incomeReal);

		Assert.assertNotSame((Double) 600.0, income);

	}

	@Test
	public void ifAPlayerCayOfOneLockerItHaveAPropertyShouldPayOfIncome() {
		Player player = new Player(120000);
		player.pullDice();
		Player owner = new Player(60000);
		player.pullDice();
		Company company = new Company(2000);
		owner.addProperty(company);
		PropertyLocker locker = new PropertyLocker(company);

		locker.cay(player);

		Assert.assertEquals((Double) 120000.0, owner.getMoney());

		Assert.assertEquals((Double) 60000.0, player.getMoney());

	}

	@Test
	public void ifAPlayerCayOfOneLockerItHaveAAwardShouldChangeToAward() {
		Player player = new Player(50000);
		player.pullDice();
		Award locker = new Award();

		locker.cay(player);

		Assert.assertEquals((Double) 52500.0, player.getMoney());

	}

	@Test
	public void ifAPlayerStepOfOneLockerItAreExitShouldChangeToBonus() {
		Player player = new Player(50000);
		player.pullDice();
		Exit locker = new Exit();

		locker.step(player);

		Assert.assertEquals((Double) 55000.0, player.getMoney());

	}

	@Test
	public void ifAPlayerCayInLockerWithPropertyOfBankShouldBuyIt() {
		Player player = new Player(50000);
		player.pullDice();
		Bank owner = new Bank(40000);
		Camp camp = new Camp(3000, 300, 150);
		owner.addProperty(camp);

		PropertyLocker propertyLocker = new PropertyLocker(camp);

		propertyLocker.cay(player);

		Assert.assertEquals(player, camp.getOwner());

		Assert.assertEquals(1, player.getPropertys().size());

		Assert.assertFalse(owner.getPropertys().contains(camp));

		Assert.assertEquals((Double) 43000.0, owner.getMoney());

		Assert.assertEquals((Double) 47000.0, player.getMoney());

		Assert.assertTrue(player.getPropertys().contains(camp));

	}

	@Test
	public void IfAPlayerPullDiceShouldMoveToBoardThatNumberOfGetAndChangeYourPosition() {
		ArrayList<Locker> lockers = new ArrayList<Locker>();
		Bank bank = new Bank(500000);
		Camp camp = new Camp(2000, 200, 100);
		Camp campCrazy = new CampCrazy(2000, 200, 100);
		Company company = new Company(3000);
		bank.addProperty(camp);
		bank.addProperty(company);
		bank.addProperty(campCrazy);

		lockers.add(new Exit());
		lockers.add(new PropertyLocker(camp));
		lockers.add(new PropertyLocker(campCrazy));
		lockers.add(new Award());
		lockers.add(new PropertyLocker(company));

		Player player = new Player(30000);
		player.setNumberOfDice(2);

		player.moveTo(lockers);

		boolean contains = player.getPropertys().contains(camp);
		Assert.assertTrue(contains);

		Assert.assertEquals(1, player.getPropertys().size());

		Assert.assertTrue(2 == player.getPosition());

		Assert.assertEquals(28500.0, player.getMoney());

		Assert.assertEquals(504000.0, bank.getMoney());

		Assert.assertFalse(player.getPropertys().contains(camp));

		Assert.assertFalse(contains);

	}
}
