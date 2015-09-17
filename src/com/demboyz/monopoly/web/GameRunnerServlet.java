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
import com.demboyz.monopoly.game.Player;

/**
 * Servlet implementation class GameRunnerServlet
 */
public class GameRunnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MonopolyGame game; 

    @Override
    public void init() throws ServletException {
    	super.init();    	

		game = new MonopolyGame();
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html"); 
		
//		String sender = request.getParameter("sender").toString(); 
/*
 *  Check how to store parameters in the request or response objs
 */
			String clientHouse = (String) request.getParameter("house");
			String clientName = (String) request.getParameter("playerName");
			
			
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
