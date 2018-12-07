package com.revature.services;

import com.revature.dao.FormO;
import com.revature.main.Form;

public class FormServices {
	FormO formDao = new FormO();
	
	public boolean createForm(Form form) {
		return formDao.createForm(form);
	}
}
