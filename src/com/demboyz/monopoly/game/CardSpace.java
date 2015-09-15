package com.demboyz.monopoly.game;

import org.json.simple.JSONObject;

public class CardSpace extends Space {

	public CardSpace(JSONObject nextSpace) {
		setColor(nextSpace.get("color").toString()); 
		setName(nextSpace.get("name").toString()); 
	}

	@Override
	public boolean onLanding(Player player) {
		return false;
	}

}
