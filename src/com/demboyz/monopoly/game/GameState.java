package com.demboyz.monopoly.game;

import java.util.ArrayList;

public class GameState {
	private ArrayList<Player> players; 
	private Board board; 
	private boolean gameWon; 
	
	public GameState(ArrayList<Player> players, Board b, boolean gameWon){
		this.players = players; 
		this.board = b; 
		this.gameWon = gameWon; 
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public Board getBoard() {
		return board;
	}

	public boolean isGameWon() {
		return gameWon;
	}
}
