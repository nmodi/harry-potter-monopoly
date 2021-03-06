package com.demboyz.monopoly.game;

import org.json.simple.JSONObject;

public class GoToDetentionSpace extends Space {

	public GoToDetentionSpace(JSONObject nextSpace) {
		setColor(nextSpace.get("color").toString()); 
		setName(nextSpace.get("name").toString()); 
	}

	@Override
	public boolean onLanding(Player player) {
		player.setDetentionStatus(true);
		player.setCurrentSpaceIndex(Board.DETENTION_SPACE_INDEX);
		return false;
	}

}
