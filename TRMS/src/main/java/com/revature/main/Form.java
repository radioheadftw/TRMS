package com.revature.main;

public class Form {
	private int formId;
	private int empId;
	private String date;
	private String time;
	private String location;
	private String description;
	private double cost;
	private int gradingFormat;
	private boolean attach;
	private int workMissed;
	private int approvalStatus;
	private String startDate;
	private boolean approvalEmail;
	private int typeOfEvent;
	private boolean urgent;
	
	public Form(int formId, int empId, String date, String time, String location, String description, double cost,
			int gradingFormat, boolean attach, int workMissed, int approvalStatus, String startDate,
			boolean approvalEmail, int typeOfEvent, boolean urgent) {
		super();
		this.formId = formId;
		this.empId = empId;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.attach = attach;
		this.workMissed = workMissed;
		this.approvalStatus = approvalStatus;
		this.startDate = startDate;
		this.approvalEmail = approvalEmail;
		this.typeOfEvent = typeOfEvent;
		this.urgent = urgent;
	}

	public Form(int empId, String date, String time, String location, String description, double cost,
			int gradingFormat, boolean attach, int workMissed, int approvalStatus, String startDate,
			boolean approvalEmail, int typeOfEvent, boolean urgent) {
		super();
		this.empId = empId;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.attach = attach;
		this.workMissed = workMissed;
		this.approvalStatus = approvalStatus;
		this.startDate = startDate;
		this.approvalEmail = approvalEmail;
		this.typeOfEvent = typeOfEvent;
		this.urgent = urgent;
	}

	public Form() {
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(int gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public boolean isAttach() {
		return attach;
	}

	public void setAttach(boolean attach) {
		this.attach = attach;
	}

	public int getWorkMissed() {
		return workMissed;
	}

	public void setWorkMissed(int workMissed) {
		this.workMissed = workMissed;
	}

	public int getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public boolean isApprovalEmail() {
		return approvalEmail;
	}

	public void setApprovalEmail(boolean approvalEmail) {
		this.approvalEmail = approvalEmail;
	}

	public int getTypeOfEvent() {
		return typeOfEvent;
	}

	public void setTypeOfEvent(int typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	
	
}
