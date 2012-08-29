/**
 * 23/08/2012 16:13:23 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

import java.util.ArrayList;

/**
 * 
 * @author Susana
 */
public class Province {

	public ArrayList<Camp> camps;

	public void addCamp(Camp camp) {
		camp.setProvince(this);
		this.camps.add(camp);
	}

	public ArrayList<Owner> playerOwnerOfCamps() {
		ArrayList<Owner> ownerSearch = new ArrayList<Owner>();
		for (Camp field : camps) {
			if (!(field.getOwner().isBank()) && !(ownerSearch.contains(field.getOwner()))) {
				ownerSearch.add(field.getOwner());
			}
		}
		return ownerSearch;
	}

	public boolean validateIfIsValidBuildEstancia(Camp camp) {
		return verifyIfIsOwnerAllProvince(camp.getOwner());
	}

	/**
	 * @param player
	 */
	private boolean verifyIfIsOwnerAllProvince(Owner player) {
		ArrayList<Owner> owners = playerOwnerOfCamps();
		return owners.contains(owners) && owners.size() == 1;

	}
}
