package com.demboyz.monopoly.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demboyz.monopoly.game.MonopolyGame; 

/**
 * Servlet implementation class HarryPotterMonopolyServlet
 */

public class GamePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(  ); 	
		response.setContentType("text/html"); 
		getServletContext().getRequestDispatcher("/header_fragment.html").include(request, response);
		
		String heading1; 
		

		String intent = request.getParameter("intent");
		
		
		if (intent.equals("options")){
			heading1 = "Play!";
		} else if (intent.equals("watch")){
			heading1 = "Watch!"; 
		} else {
			heading1 = "why are you here?";
		}
		
		out.println("<h1>" + heading1 + "</h1>");
		
		MonopolyGame game = MonopolyGame.getInstance(); 

		String clientHouse = request.getParameter("house"); 
		String clientName = request.getParameter("playerName"); 
		
		if (clientName.equals("")){
			clientName = "Harry Potter"; 
		}	
		game.replacePlayer(clientHouse, clientName); 
		

		
		getServletContext().getRequestDispatcher("/feed.jsp").include(request, response);
		
		

		out.println("<div class=\"pull-right\"> <a href=\"results\" class=\"btn btn-primary btn-lg\">Results >></a><//div>");
		
		
		getServletContext().getRequestDispatcher("/footer_fragment.html").include(request, response);
		out.flush(); 
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
