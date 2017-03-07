package com.kidfriendlystl;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserLoginDAO userLoginDAO;
	
	@Resource(name="jdbc/kid_friendly_stl")
	private DataSource dataSource;
       
	// work you'd normally do in a constructor, when you work with
	// servlets, go in an init() method
	@Override
    public void init() throws ServletException{
		super.init();
		
    	//create DAOs ... pass connection pool/dataSource
		try {
			this.userLoginDAO = new UserLoginDAO(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");
                    
            // route to the appropriate method
            switch (theCommand) {
                            
            case "LOGOUT":
                userLogout(request, response);
                break;
            }
        } catch (Exception e) {
        	throw new ServletException(e);
        }
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");
                    
            // route to the appropriate method
            switch (theCommand) {
                            
            case "VALIDATE":
                validateUser(request, response);
                break;
            }
        } catch (Exception e) {
        	throw new ServletException(e);
        }
				
	}

	private void userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();  
        session.invalidate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("FriendlyControllerServlet");
		dispatcher.forward(request, response);
	}

	private void validateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// validate input
		String errorMessage = "";
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");

		// if user exists - check password
		if (userLoginDAO.verifyEmail(userEmail)) {
			if (userLoginDAO.verifyPassword(userEmail, userPassword)) {
				
				// send home, logged in
				User validUser = userLoginDAO.get(userEmail, userPassword);
				HttpSession session=request.getSession();  
		        session.setAttribute("USER", validUser); 
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("FriendlyControllerServlet");
				dispatcher.forward(request, response);
				
			} else {
				// increase login attempts
				userLoginDAO.increaseLoginAttempts(userEmail);
				errorMessage = "Email or Password invaild. Please try again or Create a New Account.";
				request.setAttribute("ERROR_MESSAGE", errorMessage);

				// send back to login.jsp with ERROR_MESSAGE
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
			
		} else {
			// set error message for user not found
			errorMessage = "Email or Password invaild. Please try again or Create a New Account.";
			request.setAttribute("ERROR_MESSAGE", errorMessage);
			
			// send back to login.jsp with ERROR_MESSAGE
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		// 
		
	}

}
