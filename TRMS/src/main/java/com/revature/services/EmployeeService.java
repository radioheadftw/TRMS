package com.revature.services;

import com.revature.dao.EmployeeO;
import com.revature.main.Employee;

public class EmployeeService {
	EmployeeO eDao = new EmployeeO();
	
	public Employee readUser(String username) {
		return eDao.getEmployeeByUsername(username);
	}
}
