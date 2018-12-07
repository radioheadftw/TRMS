package com.revature.dao;

import java.util.List;

import com.revature.main.Employee;

public interface EmployeeDAO {
	Employee getEmployeeByUsername(String username);
	int getEidByUsername(String username);
	List<Employee> getAllEmployees();
}