package com.demboyz.monopoly.game;

import org.json.simple.JSONObject;

public class PropertySpace extends Space implements Ownable {

	public PropertySpace(JSONObject nextSpace) {
		setColor(nextSpace.get("color").toString()); 
		setName(nextSpace.get("name").toString()); 
	}

	@Override
	public boolean onLanding(Player player) {
		return false;
	}

	@Override
	public boolean isPurchased() {
		return false;
	}

	@Override
	public void isPurchased(boolean isPurchased) {
	}

	@Override
	public void changeOwner(Player owner) {
	}

	@Override
	public int calculateRentCharge() {
		return 0;
	}

}
