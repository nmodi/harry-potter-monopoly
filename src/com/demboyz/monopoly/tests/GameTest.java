package com.demboyz.monopoly.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.demboyz.monopoly.game.Game;
import com.demboyz.monopoly.game.Player;

public class GameTest {
	Game game; 
	
	@Before
	public void setUp() throws Exception {
		game = new Game(); 
	}

	@Test
	public void testGameHasPlayers() {
		assertNotNull(game.getPlayers()); 
	}
	
	@Test
	public void testPlayersHaveNames() {
		for (Player p : game.getPlayers()){
			assertNotNull(p.getName()); 
		}
	}
	
	@Test 
	public void testGameHasADie() {
		assertNotNull(game.getDie()); 
	}
}

