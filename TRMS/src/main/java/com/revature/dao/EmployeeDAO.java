package com.revature.dao;

import java.util.List;

import com.revature.main.Employee;

public interface EmployeeDAO {
	Employee getEmployee(int eid);
	Employee getEmployeeByUsername(String username);
	List<Employee> getAllEmployees();
	boolean updateEmployee(Employee user);
}