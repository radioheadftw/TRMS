package com.revature.services;

import java.util.List;

import com.revature.dao.FormO;
import com.revature.main.Employee;
import com.revature.main.Form;

public class FormServices {
	FormO formDao = new FormO();
	
	public boolean createForm(Form form) {
		return formDao.createForm(form);
	}
	
	public List<Form> getPending(Employee emp){
		return formDao.getPending(emp);
	}
}
