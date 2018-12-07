package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.main.Attachment;
import com.revature.util.ConnectionFactory;

public class AttachO implements AttachDAO{

	@Override
	public boolean createAttachment(Attachment attach) {	
		Connection connection = ConnectionFactory.getConnectionFactory().createConnection();
	    try {	
	    	
	    	File file = new File(attach.getFilename());
	    	FileInputStream fis = null;;
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO attachments VALUES (NULL, ?, ?, ?, ?);");
	        ps.setBinaryStream(1, fis,(int)file.length());	        
	        ps.setString(2, attach.getFilename()); 
	        ps.setInt(3, attach.getEid());
	        ps.setInt(4, attach.getFormid());
	        
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
	public Attachment getAttachmentByFormId(int formid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attachment getAttachmentByEid(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

}
