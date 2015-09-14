package com.demboyz.monopoly.game;

import org.json.simple.JSONObject;

public class Player {
	int DEFAULT_STARTING_POINTS = 200; 
	String name; 
	String house; 
	int points; 
	
	public Player(JSONObject jsonObject){
		String name = jsonObject.get("name").toString();
		setName(name);
		setPoints(DEFAULT_STARTING_POINTS);
	}

	private void setName(String name) { this.name = name; }
	private void setPoints(int points) { this.points = points; }
	public String getName() { return name; }
	public String getHouse() { return house; }

}
