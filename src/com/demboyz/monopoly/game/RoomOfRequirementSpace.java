package com.demboyz.monopoly.game;

import org.json.simple.JSONObject;

public class RoomOfRequirementSpace extends Space {

	public RoomOfRequirementSpace(JSONObject nextSpace) {
		setColor(nextSpace.get("color").toString()); 
		setName(nextSpace.get("name").toString()); 
	}

	@Override
	public boolean onLanding(Player player) {
		return false;
	}

}
