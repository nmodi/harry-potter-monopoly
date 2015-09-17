package com.demboyz.monopoly.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
	
	List<Player> players; 
	Die die; 
	
	public MonopolyGame(){
		die = new Die(); 
		initPlayers(); 
	}
	
	public MonopolyGame(String userHouse, String userName) throws FileNotFoundException, UnsupportedEncodingException{
		new MonopolyGame();
		
		// iterate through players 
		// remove premade player with given house 
		// add new player with same house 
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
	
	public String getTestString(){
		return "this is a test string from the monopoly game!";
	}
	
	
	public List<Player> getPlayers(){ return players; } 
	public Die getDie(){ return die; } 

}
