package com.demboyz.monopoly.game;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Player {
	int DEFAULT_STARTING_POINTS = 200; 
	String name; 
	String house; 
	int points; 
	int currentSpaceIndex;
	boolean detentionStatus;
	ArrayList<PropertySpace> properties;
	
	public Player(JSONObject jsonObject){
		String name = jsonObject.get("name").toString();
		setName(name);
		setPoints(DEFAULT_STARTING_POINTS);
		setDetentionStatus(false);
	}

	public void setName(String name) { this.name = name; }
	public void setPoints(int points) { this.points = points; }
	public void setDetentionStatus(boolean b) { this.detentionStatus = b; }
	public void setCurrentSpaceIndex(int i) { this.currentSpaceIndex = i; }
	public String getName() { return name; }
	public String getHouse() { return house; }
	public boolean getDetentionStatus() { return detentionStatus; }
	public ArrayList<PropertySpace> getProperties() { return properties; }
}
