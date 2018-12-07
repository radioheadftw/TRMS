package com.revature.servlet;

import java.io.IOException;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.main.Employee;
import com.revature.main.Form;
import com.revature.services.FormServices;

/**
 * Servlet implementation class EmployeeServlet
 */
public class FormServlet extends HttpServlet {
       
	private static final long serialVersionUID = -1044520479033297855L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
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
		String back = request.getParameter("backButton");
		String submit = request.getParameter("submitButton");
		
		if("Logout".equals(logout)) {
			RequestDispatcher rs = request.getRequestDispatcher("logout.html");
			rs.forward(request, response);
		}
		else if("Back".equals(back)) {
			RequestDispatcher rs = request.getRequestDispatcher("employee.html");
			rs.forward(request, response);
		}
		else if("Submit".equals(submit)) {
			Employee emp = (Employee) request.getSession(false).getAttribute("user");
			FormServices formServ = new FormServices();
			
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			int empId = emp.getEid();
			
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String location = request.getParameter("location");
			String description = request.getParameter("description");
			double cost = Double.parseDouble(request.getParameter("cost"));
			int gradingFormat = Integer.parseInt(request.getParameter("selectgradingformat"));
			int eventType = Integer.parseInt(request.getParameter("eventtype"));
			int workMissed = 0;
			if(!("").equals(request.getParameter("workmissed"))) {		
				workMissed = Integer.parseInt(request.getParameter("workmissed"));		
			}
			int typeOfApproval = 0;
			if(request.getParameter("typesofapproval") != null) {
				typeOfApproval = Integer.parseInt(request.getParameter("typeofapproval"));
			}
			
			Form form = new Form(empId,date,time,location,description,cost,gradingFormat,false,workMissed,typeOfApproval,date,false,eventType,false);
			
			if(request.getParameter("approvalfile") != null || request.getParameter("inputfile") != null) {
				if(request.getParameter("inputfile") != null && request.getParameter("approvalfile") != null) {
					form.setApprovalEmail(true);
					form.setAttach(true);
				}
				else if(request.getParameter("inputfile") != null) {
					form.setAttach(true);
				}
				else {
					form.setApprovalEmail(true);
				}
			}
			
			formServ.createForm(form);			
			
			RequestDispatcher rs = request.getRequestDispatcher("form.html");
			rs.forward(request, response);
		}
	}
}
