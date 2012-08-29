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

	public Double valueDices() {
		Double valueOneValid = verifyIfNumberIsValid(random.nextDouble());
		Double valueTwoValid = verifyIfNumberIsValid(random.nextDouble());
		return valueOneValid + valueTwoValid;
	}

	public Double verifyIfNumberIsValid(Double value) {
		Double valueValid = 1.0;
		if (value > 1 && value < 7) {
			return value;
		} else {
			return valueValid;
		}
	}
}
