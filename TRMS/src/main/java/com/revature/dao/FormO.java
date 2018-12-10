package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.main.Employee;
import com.revature.main.Form;
import com.revature.util.ConnectionFactory;

public class FormO implements FormDAO{

	@Override
	public Form getFormByEid(int eid) {
		Connection connection = ConnectionFactory.getConnectionFactory().createConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM form WHERE eid='" +eid+"';");
			if(rs.next())
			{
				return extractFormFromResultSet(rs);
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
	public boolean createForm(Form form) {
		Connection connection = ConnectionFactory.getConnectionFactory().createConnection();
	    try {	
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO form (empid,date,time,location,description,cost,gradingformat,attachment,workmissed,approvalstatus,coursestartdate,approvalemail,typeofevent,urgent) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
	        ps.setInt(1,form.getEmpId());	        
	        ps.setString(2, form.getDate()); 
	        ps.setString(3, form.getTime());
	        ps.setString(4, form.getLocation());
	        ps.setString(5, form.getDescription());
	        ps.setDouble(6, form.getCost());
	        ps.setInt(7,form.getGradingFormat());
	        ps.setBoolean(8, form.isAttach());
	        ps.setInt(9, form.getWorkMissed());
	        ps.setInt(10, form.getApprovalStatus());
	        ps.setString(11, form.getStartDate());
	        ps.setBoolean(12, form.isApprovalEmail());
	        ps.setInt(13, form.getTypeOfEvent());
	        ps.setBoolean(14, form.isUrgent());
	        
	        int i = ps.executeUpdate();
	        if(i == 1) {
	    	  connection.commit();
	    	  connection.close();
	    	  return true;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;
	}

	@Override
	public boolean makeUrgent(int eid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approvalEmail(int eid) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Form extractFormFromResultSet(ResultSet rs) throws SQLException {
		Form form = new Form();
		form.setFormId( rs.getInt("formid") );
		form.setEmpId(rs.getInt("empid"));
		form.setDate(rs.getString("date"));
		form.setTime(rs.getString("time"));
		form.setLocation(rs.getString("location"));
		form.setDescription(rs.getString("description"));
		form.setCost(rs.getDouble("cost"));
		form.setGradingFormat(rs.getInt("gradingformat"));
		form.setAttach(rs.getBoolean("attachment"));
		form.setWorkMissed(rs.getInt("workmissed"));
		form.setApprovalStatus(rs.getInt("approvalstatus"));
		form.setStartDate(rs.getString("coursestartdate"));
		form.setApprovalEmail(rs.getBoolean("approvalemail"));
		form.setTypeOfEvent(rs.getInt("typeofevent"));
		form.setUrgent(rs.getBoolean("urgent"));
		
		return form;
	}

	@Override
	public boolean attachment(int eid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Form> getPendingSupervisor() {
		Connection connection = ConnectionFactory.getConnectionFactory().createConnection();
		try {
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM form where approvalstatus=0;");
	        List<Form> formList = new ArrayList<>();
	        
	        while(rs.next())
	        {
	            Form form = extractFormFromResultSet(rs); 
	            formList.add(form);
	        }
	        connection.close();
	        return formList;
	    } catch (SQLException ex) {
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
	public List<Form> getPendingDepartmentHead() {
		Connection connection = ConnectionFactory.getConnectionFactory().createConnection();
		try {
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM form where approvalstatus=1;");
	        List<Form> formList = new ArrayList<>();
	        
	        while(rs.next())
	        {
	            Form form = extractFormFromResultSet(rs); 
	            formList.add(form);
	        }
	        connection.close();
	        return formList;
	    } catch (SQLException ex) {
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
	public List<Form> getPendingBenco() {
		Connection connection = ConnectionFactory.getConnectionFactory().createConnection();
		try {
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM form where approvalstatus=2;");
	        List<Form> formList = new ArrayList<>();
	        
	        while(rs.next())
	        {
	            Form form = extractFormFromResultSet(rs); 
	            formList.add(form);
	        }
	        connection.close();
	        return formList;
	    } catch (SQLException ex) {
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
	public boolean changeStatus(Form form) {
		Connection connection = ConnectionFactory.getConnectionFactory().createConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("UPDATE form SET approvalstatus = ? where empid = ?;");
	        ps.setInt(1, form.getApprovalStatus());
	        ps.setInt(2, form.getEmpId());
	          
	        int i = ps.executeUpdate();
	        if(i == 1) {
	    	  connection.commit();
	    	  connection.close();
	          return true;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;
	}

	@Override
	public List<Form> getPending(Employee emp) {
		Connection connection = ConnectionFactory.getConnectionFactory().createConnection();
		try {
	        Statement stmt = connection.createStatement();
	        int id = emp.getEid();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM form where empid="+id+";");
	        List<Form> formList = new ArrayList<>();
	        
	        while(rs.next())
	        {
	            Form form = extractFormFromResultSet(rs); 
	            formList.add(form);
	        }
	        connection.close();
	        return formList;
	    } catch (SQLException ex) {
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
	
	

}
