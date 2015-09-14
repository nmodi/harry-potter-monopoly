package com.demboyz.monopoly.tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.demboyz.monopoly.game.Die;
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState.PassType;

public class DieTest {
	Die die; 
	
	@Before
	public void setUp() throws Exception {
		die = new Die(); 
	}

	@Test
	public void testDieExists() {
		assertNotNull(die); 
	}
	
	
	@Test
	public void testDefaultNumberOfSides(){
		assertEquals(die.getNumberOfSides(), Die.DEFAULT_NUMBER_OF_SIDES); 
	}
	
	@Test
	public void testDieRollArrayLength(){
		assertEquals(die.roll().length, 2); 
	}
	
	@Test 
	public void testDiceRollsValid(){
		boolean invalidValue = false; 
		for (int i = 0; i < 1000; i++){
			if (die.roll()[0] < 1 || die.roll()[1] < 1 || die.roll()[0] > 6 || die.roll()[1] > 6){
				invalidValue = true; 
			}
		}
		assertFalse(invalidValue); 
	}
	
}
