package com.revature.services;

import com.revature.dao.EmployeeO;
import com.revature.main.Employee;

public class AuthService {
	EmployeeO edao = new EmployeeO();
	public Employee validateUser(String username, String password) {
		Employee user = edao.getEmployeeByUsername(username);
		if(user == null || !user.getPassword().equals(password)){
			return null;
		}
		return user;
	}
}