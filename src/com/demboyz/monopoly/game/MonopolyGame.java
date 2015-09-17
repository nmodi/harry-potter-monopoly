package com.demboyz.monopoly.game;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MonopolyGame {
	static String jsonFilePath = "com/demboyz/monopoly/json/"; 
	static String PLAYERS_JSON = "players.json"; 
	static String CARDS_JSON = "cards.json"; 
	static String SPACES_JSON = "spaces.json"; 

	private ArrayList<Player> players; 
	private ArrayList<Card> cards;
	private Die die; 
	
	private Board board; 
	
	private boolean gameWon = false; 
	

	private static final MonopolyGame instance = new MonopolyGame(); 
	
		
	public static MonopolyGame getInstance() { 
		return instance; 
	}
	
	private MonopolyGame() {
		Player hogwarts = new Player("Hogwarts");
		die = new Die(); 
		initPlayers(); 
		playGame();
		}
	
	private void playGame() {
		for(Player p : players){
			int[] dieValues = die.roll();
			int rollValue = dieValues[0] + dieValues[1];
			p.setCurrentSpaceIndex(p.getCurrentSpaceIndex() + rollValue);
			Space currentSpace = board.getSpaces().get(p.currentSpaceIndex);
			if(currentSpace.getColor().equals("white")){
				
			}
			else if(currentSpace.getColor().equals("purple")){
				p.drawCard(Board.getCards().);
			}
		}
		
	}

	public GameState getGameState(){
		return new GameState(players, board, gameWon); 		
	}
	
	public void resetGame() { 
		
	}

	public void initPlayers(){
		players = new ArrayList<Player>(); 
		JSONParser parser = new JSONParser(); 
		try {
			InputStream input = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(MonopolyGame.jsonFilePath + MonopolyGame.PLAYERS_JSON);
			InputStreamReader streamReader = new InputStreamReader(input); 			
			Object obj = parser.parse(streamReader); 
			JSONObject jsonObj = (JSONObject) obj; 
			JSONArray jsonPlayers = (JSONArray) jsonObj.get("players"); 
			Iterator<JSONObject> iterator = jsonPlayers.iterator(); 
			while(iterator.hasNext()){
				players.add(new Player(iterator.next())); 
			} 
		} catch (IOException | ParseException e){
			e.printStackTrace();
		}
	}

	public void replacePlayer(String house, String name){
		for (Player p : getPlayers()){
			if (p.getHouse().equals(house)){
				p.setName(name);
			}
		}
	}

	public String getTestString(){
		return "this is a test string from the monopoly game!";
	}


	public List<Player> getPlayers(){ return players; } 
	public Die getDie(){ return die; } 

}
