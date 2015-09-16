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
	private ArrayList<Integer> testArray; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameRunnerServlet() {
        super();

        
        
        Die die = new Die(); 
        testArray = new ArrayList<Integer>(); 
        for (int i = 0; i < 4; i++){
        	testArray.add(die.roll()[0]); 
        }
      game = new MonopolyGame(); 
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html"); 
		out.println("<p>GameRunnerServlet says hi</p>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
