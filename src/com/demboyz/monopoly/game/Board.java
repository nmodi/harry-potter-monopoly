package com.demboyz.monopoly.game;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Board {
	private ArrayList<Space> spaces; 
	private ArrayList<Card> cards; 
	public static int TOTAL_NUM_OF_SPACES; 
	public static int DETENTION_SPACE_INDEX;
	public static int GO_SPACE_INDEX;
	public static int ROOM_OF_REQUIREMENT_SPACE_INDEX;


	public Board(){
		initSpaces();
		initCards();
	}

	public void initSpaces(){
		spaces = new ArrayList<Space>(); 

		JSONParser parser = new JSONParser();

		try {
			InputStream input = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(MonopolyGame.jsonFilePath + MonopolyGame.SPACES_JSON);
			InputStreamReader streamReader = new InputStreamReader(input); 	
			
			Object obj = parser.parse(streamReader);
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
					GO_SPACE_INDEX = spaces.size() - 1;
					break; 
				case "card":
					spaces.add(new CardSpace(nextSpace));
					break; 
				case "jail":
					spaces.add(new DetentionSpace(nextSpace));
					DETENTION_SPACE_INDEX = spaces.size() - 1;
					break;
				case "go_to_jail":
					spaces.add(new GoToDetentionSpace(nextSpace));
					break;
				case "free_parking":
					spaces.add(new RoomOfRequirementSpace(nextSpace));
					ROOM_OF_REQUIREMENT_SPACE_INDEX = spaces.size() - 1;
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
		cards = new ArrayList<Card>(); 

		JSONParser parser = new JSONParser();

		try {
			InputStream input = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(MonopolyGame.jsonFilePath + MonopolyGame.CARDS_JSON);
			InputStreamReader streamReader = new InputStreamReader(input); 	
			
			Object obj = parser.parse(streamReader);
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


	public ArrayList<Space> getSpaces(){ return spaces; }
	public ArrayList<Card> getCards(){ return cards; }
}
