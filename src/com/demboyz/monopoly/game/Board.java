package com.demboyz.monopoly.game;

import java.util.ArrayList;
import java.util.HashSet;

import javax.smartcardio.Card;

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
	}
	
	public void initTokens(){
		tokens = new ArrayList<Token>(); 
	}
	
	public ArrayList<Space> getSpaces(){ return spaces; }
	public HashSet<Card> getCards(){ return cards; }
	public ArrayList<Token> getTokens(){ return tokens; } 
}
