package com.demboyz.monopoly.tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.demboyz.monopoly.game.Board;

public class BoardTest {
	Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board(); 
	}

	@Test
	public void testBoardExists() {
		assertNotNull(board);
	}
	
	@Test
	public void testBoardHasSpaces() {
		assertNotNull(board.getSpaces());
	}
	
	@Test
	public void testBoardHasCards() {
		assertNotNull(board.getCards()); 
	}
	
	@Test
	public void testBoardHasTokens() {
		assertNotNull(board.getTokens()); 
	}
	
	@Test 
	public void testMultipleCardsInitialized(){
		assertNotEquals(0, board.getCards().size());
	}
	
	@Test 
	public void testMultipleSpacesInitialized(){
		assertNotEquals(0, board.getSpaces().size());
	}

	

}
