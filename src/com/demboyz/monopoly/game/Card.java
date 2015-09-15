package com.demboyz.monopoly.game;

import org.json.simple.JSONObject;

public class Card {
	String name; 
	String desc; 
	String type; 
	int pointValue; 
	
	
	public Card(JSONObject cardObject){
		setName(cardObject.get("name").toString()); 
		setDesc(cardObject.get("desc").toString()); 
		setType(cardObject.get("type").toString());	
		int value = (int) (long) cardObject.get("amt"); 
		setPointValue(value); 
	}

	public void setName(String name){ this.name = name; }
	public void setDesc(String desc){ this.desc = desc; }
	public void setType(String type){ this.type = type; }
	public void setPointValue(int pointValue){ this.pointValue = pointValue; }
	
	public String getName(){ return name; }
	public String getDesc(){ return desc; }
	public String getType(){ return type; }
	public int getPointValue(){ return pointValue; }

}
