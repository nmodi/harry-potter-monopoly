package com.demboyz.monopoly.game;

import java.util.Random;

public class Die {
	public static int DEFAULT_NUMBER_OF_SIDES = 6; 
	
	private int sides; 
	
	public Die(){
		setNumberOfSides(DEFAULT_NUMBER_OF_SIDES);
	}

	private void setNumberOfSides(int sides) {
		this.sides = sides; 
	}

	public int getNumberOfSides() {
		return sides; 
	}

	public int[] roll() {
		int[] rolls = new int[2]; 	
		int dieValue = 0;
		for (int i = 0; i < rolls.length; i++){
			dieValue = rollSingle(); 
			rolls[i] = dieValue;
		}
		return rolls;
	}
	
	private int rollSingle(){
		Random r = new Random();
		return r.nextInt(6) + 1; 		
	}
	
	
}
