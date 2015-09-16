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
	private ArrayList<Space> spaces; 
	private ArrayList<Token> tokens; 
	private HashSet<Card> cards; 
	public int TOTAL_NUM_OF_SPACES; 


	public Board(){
		initSpaces();
		initCards(); 
		initTokens(); 
	}

	public void initSpaces(){
		spaces = new ArrayList<Space>(); 

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader(MonopolyGame.SPACES_JSON));
			JSONObject jsonObj = (JSONObject) obj;

			JSONArray jsonSpaceArray = (JSONArray) jsonObj.get("spaces");

			Iterator<JSONObject> iterator = jsonSpaceArray.iterator();

			int propertySpaceCount = 0; 
			while(iterator.hasNext())
			{				
				JSONObject nextSpace = iterator.next();
				String spaceType = nextSpace.get("type").toString(); 
				switch(spaceType){
				case "property":
				case "rr":	
				case "util": 	
					PropertySpace tempSpace = new PropertySpace(nextSpace);									
					tempSpace.setBaseRent(++propertySpaceCount); 
					spaces.add(tempSpace);
					break; 
				case "go":		
					spaces.add(new GoSpace(nextSpace));
					break; 
				case "card":
					spaces.add(new CardSpace(nextSpace));
					break; 
				case "jail":
					spaces.add(new DetentionSpace(nextSpace));
					break;
				case "go_to_jail":
					spaces.add(new GoToDetentionSpace(nextSpace));
					break;
				case "free_parking":
					spaces.add(new RoomOfRequirementSpace(nextSpace));
					break; 
				default:
					break; 
				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		TOTAL_NUM_OF_SPACES = spaces.size(); 
		
		

	}

	public void initCards(){
		cards = new HashSet<Card>(); 

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader(MonopolyGame.CARDS_JSON));
			JSONObject jsonObj = (JSONObject) obj;

			JSONArray jsonCardArray = (JSONArray) jsonObj.get("cards");

			Iterator<JSONObject> iterator = jsonCardArray.iterator();

			while(iterator.hasNext())
			{				
				cards.add(new Card(iterator.next()));
			}
		} catch (IOException | ParseException e) {
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
