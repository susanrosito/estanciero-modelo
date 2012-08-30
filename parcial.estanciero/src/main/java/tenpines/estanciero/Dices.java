/**
 * 24/08/2012 11:38:05 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

import java.util.Random;

/**
 * 
 * @author Susana
 */
public class Dices {

	private Random random = new Random(7);

	public Integer valueDices() {
		Integer valueOneValid = verifyIfNumberIsValid(random.nextInt());
		Integer valueTwoValid = verifyIfNumberIsValid(random.nextInt());
		return valueOneValid + valueTwoValid;
	}

	public Integer verifyIfNumberIsValid(Integer value) {
		Integer valueValid = 1;
		if (value > 1 && value < 7) {
			return value;
		} else {
			return valueValid;
		}
	}
}
