package com.revature.dao;

import java.util.List;

import com.revature.main.Employee;
import com.revature.main.Form;

public interface FormDAO {
	Form getFormByEid(int eid);
	boolean createForm(Form form);
	boolean makeUrgent(int eid);
	boolean approvalEmail(int eid);
	boolean attachment(int eid);
	boolean changeStatus(Form form);
	List<Form> getPendingSupervisor();
	List<Form> getPendingDepartmentHead();
	List<Form> getPendingBenco();
	List<Form> getPending(Employee emp);
}
