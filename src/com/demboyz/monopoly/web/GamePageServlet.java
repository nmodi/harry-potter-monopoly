package com.demboyz.monopoly.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

/**
 * Servlet implementation class HarryPotterMonopolyServlet
 */

@WebServlet("/HarryPotterMonopolyServlet")
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
