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
	 * @see HttpServlet#HttpServlet()
	 */
	public GamePageServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(  ); 
		response.setContentType("text/html"); 
		out.println("<html><h1>Hello, play monopoly on this page</h1>");
		out.println("<p>this webpage has been accessed " + ++count + " times!</p>"
				+ "<p><a href=\"results\">CLICK HERE TO VIEW RESULTS</a></p>"
				+ " </html>");
		
		
		
		getServletContext().getRequestDispatcher("/runner").forward(request, response);
		
		
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
