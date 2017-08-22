package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class JobsBean {
	protected int id = 0;
	protected Date createdTime ;
	protected String projectId1 ;
	protected String name ;
	protected int projectId;
	protected String startDate1 ;
	protected String endDate1 ;
	protected String hours ;
	protected String assignees ;
	protected String rateperhour ;
	protected String description ;
	protected String billableStatus ;
	protected Date startDate ;
	protected Date endDate ;
	
	
	public String getProjectId1() {
		return projectId1;
	}
	public void setProjectId1(String projectId1) {
		this.projectId1 = projectId1;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate1() {
		return startDate1;
	}
	public void setStartDate1(String startDate1) {
		this.startDate1 = startDate1;
	}
	public String getEndDate1() {
		return endDate1;
	}
	public void setEndDate1(String endDate1) {
		this.endDate1 = endDate1;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getAssignees() {
		return assignees;
	}
	public void setAssignees(String assignees) {
		this.assignees = assignees;
	}
	public String getRateperhour() {
		return rateperhour;
	}
	public void setRateperhour(String rateperhour) {
		this.rateperhour = rateperhour;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desicription) {
		this.description = desicription;
	}
	public String getBillableStatus() {
		return billableStatus;
	}
	public void setBillableStatus(String billableStatus) {
		this.billableStatus = billableStatus;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
