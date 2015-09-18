package com.demboyz.monopoly.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demboyz.monopoly.game.GameState;

import com.demboyz.monopoly.game.Player;
import com.demboyz.monopoly.game.MonopolyGame;

/**
 * Servlet implementation class GameRunnerServlet
 */
public class GameRunnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();    	

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MonopolyGame game = MonopolyGame.getInstance();

		game.playRound(); 
		
		GameState currentState = game.getGameState(); 

		StringBuilder sb = new StringBuilder(); 
		String param = request.getParameter("reqType");
		if (param.equals("names")){
			for (Player p : currentState.getPlayers()){
				sb.append(p.getName());
				sb.append(","); 
				sb.append(p.getHouse()); 
				sb.append(","); 
			}
		} else if (param.equals("personal")){
			for (Player p : currentState.getPlayers()){
				sb.append(p.getPoints());
				sb.append(",");
				
				if (p.getDetentionStatus()){
					sb.append("In Detention with Umbridge"); 					
				} else {
					sb.append("A Free Elf"); 
				}
				sb.append(","); 
				String currentSpaceName = currentState.getBoard().getSpaces().get(p.getCurrentSpaceIndex()).getName();
				sb.append(currentSpaceName); 
				sb.append(","); 
			}
		} else {
			sb.append("reqType missing."); 
		}

		
		String state = sb.toString(); 
        response.setContentType("text/plain");
        response.getWriter().write(state);
	}
		
//		else if (param.equals("property")) {
//		
//			

//		} else if (param.equals("won")) {
//			
//		}
		
		
		
		
//
////  	  
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
