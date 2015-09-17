package com.demboyz.monopoly.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demboyz.monopoly.game.GameState;
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
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html"); 
		
		MonopolyGame game = MonopolyGame.getInstance(); 
		String intent = request.getParameter("intent");
		if (intent.equals("options")){
			String clientHouse = request.getParameter("house"); 
			String clientName = request.getParameter("playerName"); 
			
			if (clientName.equals("")){
				clientName = "Harry Potter"; 
			}	
			game.replacePlayer(clientHouse, clientName); 
		} else if (intent.equals("feed")) {
			out.println("<p> Sender was feed.</p>");	
			GameState state = game.getGameState(); 
			
			request.getSession().setAttribute("state", state);
			getServletContext().setAttribute("state", state);
			
		} else if (intent.equals("watch")){
			out.println("<h2>watch a game here</h2>"); 			
		} else {
			out.println("<h1><a href=\"..\\playhp\\\">GO BACK HOME</a></h1>"); 						
		}
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
