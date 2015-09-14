package com.demboyz.monopoly.game;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Game {
	String PLAYERS_JSON = "players.json"; 
	
	List<Player> players; 
	
	public Game(){
		initPlayers(); 
	}
	
	public void initPlayers(){
		players = new ArrayList<Player>(); 
		JSONParser parser = new JSONParser(); 
		try {
			Object obj = parser.parse(new FileReader(PLAYERS_JSON)); 
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
	
	
	
	public List<Player> getPlayers(){ return players; } 

}
