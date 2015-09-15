package com.demboyz.monopoly.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HarryPotterMonopolyServlet
 */

//@WebServlet("/HarryPotterMonopolyServlet")
public class HarryPotterMonopolyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int count; 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HarryPotterMonopolyServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter();
		PrintWriter out = response.getWriter(  ); 
		response.setContentType("text/html"); 
		out.println("<html><h1>Hello</h1>");
		out.println("<p>this webpage has been accessed " + ++count + " times!</p></html>");
		out.flush(); 
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
