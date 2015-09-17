package com.demboyz.monopoly.game;

import org.json.simple.JSONObject;

public class PropertySpace extends Space {
	private int baseRent; 
	private int price; 

	public PropertySpace(JSONObject nextSpace) {
		setColor(nextSpace.get("color").toString()); 
		setName(nextSpace.get("name").toString()); 
	}

	public boolean onLanding(Player player) {
		
		
		return false;
	}

	public void changeOwner(Player owner) {
	}

	public int calculateRentCharge() {
		return 0;
	}

	public void setBaseRent(int rent) {
		this.baseRent = rent; 
		setPrice(rent); 
	}

	public void setPrice(int rent){
		this.price = rent * 4; 
	}
	
	public int getBaseRent(){
		return baseRent;
	}
	
	public int getPrice(){
		return price;
	}
}
