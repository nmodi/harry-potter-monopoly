package com.demboyz.monopoly.game;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Player {
	int DEFAULT_STARTING_POINTS = 200; 
	String name; 
	String house; 
	int points; 
	int breakOutOfDetentionAttemptsCount = 0;
	int doublesCount = 0;
	int currentSpaceIndex = 0;
	boolean detentionStatus = false;
	boolean hasGetOutOfDetentionCard = false;
	ArrayList<PropertySpace> properties;
	
	public Player(String playerName){
		name = playerName;
		house = null;
		points = 100000;
	}
	
	public Player(JSONObject jsonObject){
		String name = jsonObject.get("name").toString();
		setName(name);
		
		String house = jsonObject.get("house").toString(); 
		setHouse(house); 
		
		setPoints(DEFAULT_STARTING_POINTS);
		setDetentionStatus(false);
	}
	
	public void passGo(){
		if(getCurrentSpaceIndex() == Board.GO_SPACE_INDEX){
			points += 50;
		}
	}
	
	
	// When a player lands on a property space, he/she will automatically buy the property (if he/she has sufficient points)
	public void buyProperty(PropertySpace property){
		if(getPoints() > property.getPrice()){
			points -= property.getPrice();
		}
		else{
			// declare bankruptcy
		}
	}
	
	// When a player lands on a property space that is owned, he/she will automatically pay rent (if he/she has sufficient points)
	public void payBaseRent(PropertySpace property){
		points -= property.getBaseRent();
	}
	
	public void drawCard(Card drawnCard){
		if(drawnCard.getType().equals("gain")){
			points += drawnCard.pointValue;
		}
		
		else if(drawnCard.getType().equals("lose")){
			points -= drawnCard.pointValue;
		}
		else if(drawnCard.getType().equals("jail")){
			setDetentionStatus(true);
			setCurrentSpaceIndex(Board.DETENTION_SPACE_INDEX);
		}
		
		else if(drawnCard.getType().equals("free")){
			setHasGetOutOfDetentionCard(true);
		}
	}
	
	public void goToDetention(){
		if(getHasGetOutOfDetentionCard() == false){
			setDetentionStatus(true);
			setCurrentSpaceIndex(Board.DETENTION_SPACE_INDEX);
		}
		else if(getHasGetOutOfDetentionCard() == true){
			setHasGetOutOfDetentionCard(false);
		}
	}


	public void tryToBreakOutOfDetention(){
		Die die = new Die();
		int dieValueSum;
		int[] dieValues = die.roll();
		dieValueSum = dieValues[0] + dieValues[1];
		// If the player rolls doubles, then they can get out of detention.  The player gets three chances.
		if(dieValues[0] == dieValues[1]){
			breakOutOfDetentionAttemptsCount = 0;
			setCurrentSpaceIndex(currentSpaceIndex + dieValueSum);
			doublesCount++;
		}
		// The player gets three chances to roll doubles.  If they can't do it, then they have to lose 10 house points to get out of
		// detention.
		else if(breakOutOfDetentionAttemptsCount == 3){
			setPoints(points - 10);
			setCurrentSpaceIndex(currentSpaceIndex + dieValueSum);
		}
	}

	public void setName(String name) { this.name = name; }
	public void setPoints(int points) { this.points = points; }
	public void setDetentionStatus(boolean b) { this.detentionStatus = b; }
	public void setCurrentSpaceIndex(int i) { this.currentSpaceIndex = i % Board.TOTAL_NUM_OF_SPACES; }
	public void setDoublesCount(int i) {this.doublesCount = i; }
	public void setHouse(String house) { this.house = house; }
	public void setHasGetOutOfDetentionCard(boolean b) { this.hasGetOutOfDetentionCard = b;}
	
	
	public String getName() { return name; }
	public String getHouse() { return house; }
	public int getPoints() { return points; }
	public int getCurrentSpaceIndex() { return currentSpaceIndex; }
	public boolean getDetentionStatus() { return detentionStatus; }
	public ArrayList<PropertySpace> getProperties() { return properties; }
	public int getDoublesCount() { return doublesCount; }
	public boolean getHasGetOutOfDetentionCard(){ return hasGetOutOfDetentionCard; }
}
