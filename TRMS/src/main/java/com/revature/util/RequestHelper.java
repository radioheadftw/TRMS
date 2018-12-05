package com.revature.util;

import javax.servlet.http.HttpServlet;

import com.revature.servlet.EmployeeServlet;
import com.revature.servlet.LoginServlet;
import com.revature.servlet.LogoutServlet;


public class RequestHelper {
	private static HttpServlet loginServlet = new LoginServlet();
	private static HttpServlet employeeServlet = new EmployeeServlet();
	private static HttpServlet logoutServlet = new LogoutServlet();
	
	public HttpServlet dispatchRequest(String path) {
		HttpServlet nextServlet = null;
		
		switch(path) {
			case "/TRMS/login":
				nextServlet = loginServlet;
				break;
			case "/TRMS/employee":
				nextServlet = employeeServlet;
				break;
			case "/TRMS/logout":
				nextServlet = logoutServlet;
				break;
		}
		return nextServlet;
	}
}
