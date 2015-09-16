package com.demboyz.monopoly.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultsPageServlet
 */
public class ResultsPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(  ); 
		response.setContentType("text/html"); 
		
		getServletContext().getRequestDispatcher("/header_fragment.html").include(request, response);

		
		out.println("<h1>Results</h1>");
		
		/*
		 * 
		 * Results go here!
		 * Maybe in a JSP or HTML fragment? 
		 * 
		 * 
		 */
		
		out.println("<p>Click here to go back to the home page: <a href=\"..\\playhp\\\">GO</a>  </p> </html>");
		
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
