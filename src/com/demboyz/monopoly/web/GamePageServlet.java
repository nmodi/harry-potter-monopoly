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
		
		String intent = request.getParameter("intent");
		
		String heading1; 
		
		if (intent.equals("options")){
			heading1 = "Play!";
		} else if (intent.equals("watch")){
			heading1 = "Watch!"; 
		} else {
			heading1 = "why are you here?";
		}
		
		out.println("<h1>" + heading1 + "</h1>");
				
		
		getServletContext().getRequestDispatcher("/runner").include(request, response);

		
		getServletContext().getRequestDispatcher("/feed.jsp").include(request, response);
		
		

		out.println("<p><a href=\"results\">CLICK HERE TO VIEW RESULTS (temporary link, will eventually be a redirect)</a></p>");
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
