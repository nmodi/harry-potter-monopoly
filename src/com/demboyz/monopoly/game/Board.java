package com.demboyz.monopoly.game;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Board {
	ArrayList<Space> spaces; 
	ArrayList<Token> tokens; 
	HashSet<Card> cards; 
	
	
	public Board(){
		initSpaces();
		initCards(); 
		initTokens(); 
	}
	
	public void initSpaces(){
		
		
		spaces = new ArrayList<Space>(); 
	}
	
	public void initCards(){
		cards = new HashSet<Card>(); 
		
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader(Game.CARDS_JSON));
			JSONObject jsonObj = (JSONObject) obj;
			
			JSONArray cards = (JSONArray) jsonObj.get("cards");
			
			Iterator<JSONObject> iterator = cards.iterator();
			
			while(iterator.hasNext())
			{
				cards.add(new Card(iterator.next()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initTokens(){
		tokens = new ArrayList<Token>(); 
	}
	
	public ArrayList<Space> getSpaces(){ return spaces; }
	public HashSet<Card> getCards(){ return cards; }
	public ArrayList<Token> getTokens(){ return tokens; } 
}
