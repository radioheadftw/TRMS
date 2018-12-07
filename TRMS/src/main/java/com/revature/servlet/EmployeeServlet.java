package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
       
	private static final long serialVersionUID = -1044520479033297855L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String logout = request.getParameter("logoutButton");
		String form = request.getParameter("formButton");
		String view = request.getParameter("viewFormButton");
		
		if("Logout".equals(logout)) {
			RequestDispatcher rs = request.getRequestDispatcher("logout.html");
			rs.forward(request, response);
		}
		else if("Submit Form".equals(form)) {
			RequestDispatcher rs = request.getRequestDispatcher("form.html");
			rs.forward(request, response);
		}
		else if("View Form".equals(view)) {
			RequestDispatcher rs = request.getRequestDispatcher("view.html");
			rs.forward(request, response);
		}
		
	}
}
