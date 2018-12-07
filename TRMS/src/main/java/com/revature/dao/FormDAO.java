package com.revature.dao;

import com.revature.main.Form;

public interface FormDAO {
	Form getFormByEid(int eid);
	boolean createForm(Form form);
	boolean makeUrgent(int eid);
	boolean approvalEmail(int eid);
	boolean attachment(int eid);
}
