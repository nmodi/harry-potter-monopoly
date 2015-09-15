package com.demboyz.monopoly.game;

public abstract class Space {
	
	String name; 
	String color; 
	
	
	
	public abstract boolean onLanding(Player player); 
	
	public void setName(String name){ this.name = name; }
	public void setColor(String color){ this.color = color; } 
	
	public String getName(){ return name; } 
	public String getColor(){ return color; } 
}
