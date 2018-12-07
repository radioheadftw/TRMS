package com.revature.util;

import javax.servlet.http.HttpServlet;

import com.revature.servlet.EmployeeServlet;
import com.revature.servlet.FormServlet;
import com.revature.servlet.LoginServlet;
import com.revature.servlet.LogoutServlet;
import com.revature.servlet.ViewServlet;


public class RequestHelper {
	private static HttpServlet loginServlet = new LoginServlet();
	private static HttpServlet employeeServlet = new EmployeeServlet();
	private static HttpServlet logoutServlet = new LogoutServlet();
	private static HttpServlet formServlet = new FormServlet();
	private static HttpServlet viewServlet = new ViewServlet();
	
	public HttpServlet dispatchRequest(String path) {
		HttpServlet nextServlet = null;
		
		switch(path) {
			case "/TRMS/Login":
				nextServlet = loginServlet;
				break;
			case "/TRMS/Employee":
				nextServlet = employeeServlet;
				break;
			case "/TRMS/Logout":
				nextServlet = logoutServlet;
				break;
			case "/TRMS/View":
				nextServlet = viewServlet;
				break;
			case "/TRMS/Form":
				nextServlet = formServlet;
				break;
		}
		return nextServlet;
	}
}
