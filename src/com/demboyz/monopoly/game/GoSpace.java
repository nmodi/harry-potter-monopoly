package com.demboyz.monopoly.game;

import org.json.simple.JSONObject;

public class GoSpace extends Space {


	public GoSpace(JSONObject nextSpace) {
		setColor(nextSpace.get("color").toString()); 
		setName(nextSpace.get("name").toString()); 
	}

	@Override
	public boolean onLanding(Player player) {
		//player.setCurrentSpaceIndex(0);
		return false;
	}

}
