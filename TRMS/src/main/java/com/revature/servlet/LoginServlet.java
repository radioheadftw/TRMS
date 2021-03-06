package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.main.Employee;
import com.revature.services.AuthService;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6763222963192428635L;
	private AuthService aServ = new AuthService();
       
    public LoginServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Employee user = aServ.validateUser(username, password);
		
		if(user != null) {
			//session
			HttpSession sess = request.getSession();
			sess.setAttribute("user",user);
			
			// send a forward to maintain Request Scope between Servlets
			if(user.getRole()==1) {
				RequestDispatcher rd = request.getRequestDispatcher("employee.html");
				rd.forward(request, response);
			}
			else if(user.getRole()==2) {
				RequestDispatcher rd = request.getRequestDispatcher("supervisor.html");
				rd.forward(request, response);
			}
			else if(user.getRole()==3) {
				RequestDispatcher rd = request.getRequestDispatcher("departmenthead.html");
				rd.forward(request, response);
			}
			else if(user.getRole()==4) {
				RequestDispatcher rd = request.getRequestDispatcher("benco.html");
				rd.forward(request, response);
			}
		}
		else {
			request.setAttribute("message", "Invalid login credentials.");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

}
