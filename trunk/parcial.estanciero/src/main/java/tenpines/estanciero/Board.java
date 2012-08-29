/**
 * 23/08/2012 13:44:02 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

import java.util.ArrayList;

/**
 * 
 * @author Susana
 */
public class Board {

	private ArrayList<Locker> lockers;

	public Board(ArrayList<Locker> lockers) {
		this.lockers = lockers;
	}

	public ArrayList<Locker> casilleroDesdeHasta(Locker locker, Double distance) {
		ArrayList<Locker> road = new ArrayList<Locker>();
		int indexOfLockerNext;
		for (int i = lockers.indexOf(locker); i < lockers.size() && distance > 0; i++) {
			indexOfLockerNext = i + 1;
			Locker lockerNext = lockers.get(indexOfLockerNext);
			road.add(lockerNext);
			distance -= 1;
		}
		return road;
	}

	public ArrayList<Locker> getLockers() {
		return lockers;
	}

	public void setLockers(ArrayList<Locker> lockers) {
		this.lockers = lockers;
	}

}
