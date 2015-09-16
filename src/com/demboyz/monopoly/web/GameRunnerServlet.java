package com.demboyz.monopoly.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demboyz.monopoly.game.Die;
import com.demboyz.monopoly.game.MonopolyGame;

/**
 * Servlet implementation class GameRunnerServlet
 */
public class GameRunnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MonopolyGame game; 

    @Override
    public void init() throws ServletException {
    	super.init();    	

		// game = new MonopolyGame();
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html"); 
		
//		String sender = request.getAttribute("sender").toString(); 
		
		out.println("<p>before the if statement</p>");
		
//		if (sender.equals("gamePageServlet")){
			
			// verify that the game has been created
			// start the game using parameters from request 

			String clientHouse = (String) request.getParameter("house");
			String clientName = (String) request.getParameter("playerName");
			
			
			
			
			out.println("<p>" + clientName + " of House " + clientHouse + "</p>");
			
		//	request.setAttribute("returnString", game.getTestString());
//		} else if (sender.equals("feed.jsp")){
//
//			out.println("<p>in the 2nd if statement</p>");
//			// retrieve game.getGameState()
//			// send game state to feed.jsp 
//		}
//		
		out.println("<p>after the ifs</p>");

		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
