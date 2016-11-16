package by.vasilevich.controller;

import by.vasilevich.navigation.CommandFactory;
import by.vasilevich.navigation.commands.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.vasilevich.resources.constants.Constants.PARAM_PAGE;

/**
 * Servlet implementation class NewsController
 */

public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performAction(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		performAction(request, response);
	}
	
	private void performAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter(PARAM_PAGE);
		if (page != null) {
			ICommand command = CommandFactory.getCommand(page);
			String nextPage = command.executeCommand(request, response);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
			requestDispatcher.forward(request, response);
			
		} else {
			throw new IllegalArgumentException("Param PAGE is empty");
		}
	}
	

}
