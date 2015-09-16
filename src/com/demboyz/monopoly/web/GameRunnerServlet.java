package com.demboyz.monopoly.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demboyz.monopoly.game.MonopolyGame;

/**
 * Servlet implementation class GameRunnerServlet
 */
public class GameRunnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MonopolyGame game; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameRunnerServlet() {
        super();
        
        
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	
    	game = new MonopolyGame(); 
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
