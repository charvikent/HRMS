package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class TimeSheetBean {
	
	private int id;
	protected Date createdTime ;
	protected Date updatedTime ;
	private String period;
	private String empName;
	private String clients;
	private String projects;
	private String jobs;
	private String billableStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getClients() {
		return clients;
	}
	public void setClients(String clients) {
		this.clients = clients;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	public String getJobs() {
		return jobs;
	}
	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	public String getBillableStatus() {
		return billableStatus;
	}
	public void setBillableStatus(String billableStatus) {
		this.billableStatus = billableStatus;
	}
}
