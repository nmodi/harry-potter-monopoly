package com.demboyz.monopoly.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.*; 

/**
 * Servlet implementation class HarryPotterMonopolyServlet
 */

public class GamePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int count; 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(  ); 	
		response.setContentType("text/html"); 
		getServletContext().getRequestDispatcher("/header_fragment.html").include(request, response);

		out.println("<h1>Play!</h1>");
				
		
//		request.setAttribute("sender", "gamePageServlet");	
		getServletContext().getRequestDispatcher("/runner").include(request, response);

//		String ooga = request.getAttribute("returnString").toString();

//		out.println("<p>test string from java class: " + ooga + "</p>");

		out.println("<p>this webpage has been accessed " + ++count + " times!</p>"
				+ "<p><a href=\"results\">CLICK HERE TO VIEW RESULTS (temporary link, will eventually be a redirect)</a></p>");

		
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
