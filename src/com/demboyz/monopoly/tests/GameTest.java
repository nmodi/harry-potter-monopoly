package com.demboyz.monopoly.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.demboyz.monopoly.game.MonopolyGame;
import com.demboyz.monopoly.game.Player;

public class GameTest {
	MonopolyGame monopolyGame; 
	
	@Before
	public void setUp() throws Exception {
		monopolyGame = MonopolyGame.getInstance(); 
	}

	@Test
	public void testGameHasPlayers() {
		assertNotNull(monopolyGame.getPlayers()); 
	}
	
	@Test
	public void testPlayersHaveNames() {
		for (Player p : monopolyGame.getPlayers()){
			assertNotNull(p.getName()); 
		}
	}
	
	@Test 
	public void testGameHasADie() {
		assertNotNull(monopolyGame.getDie()); 
	}
}

