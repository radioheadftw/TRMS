package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.main.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeO implements EmployeeDAO {

	@Override
	public Employee getEmployee(int eid) {
		return null;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		Connection connection = ConnectionFactory.getConnectionFactory().createConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE username='" +username+"';");
			if(rs.next())
			{
				return extractEmployeeFromResultSet(rs);
			}
			connection.close();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployee(Employee user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Employee extractEmployeeFromResultSet(ResultSet rs) throws SQLException {
		Employee user = new Employee();
		user.setEid( rs.getInt("eid") );
		user.setRole(rs.getInt("role"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setDeptid(rs.getInt("deptid"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setSupervisor(rs.getInt("supervisor"));
		
		return user;
	}

}
