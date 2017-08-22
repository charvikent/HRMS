package com.aurospaces.neighbourhood.bean;

import java.io.File;
import java.util.Date;

public class TimeLogBean {
	
	private int id;
	protected Date createdTime ;
	protected Date updatedTime ;
	private String projName;
	private String jobName;
	private String workItem;
	private String date1;
	private String description;
	private String hours;
	private String billableStatus;
	private String loggedHours;
	private String startTime;
	private String endTime;
	private File attachment;
	private Date date;
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
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getWorkItem() {
		return workItem;
	}
	public void setWorkItem(String workItem) {
		this.workItem = workItem;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getBillableStatus() {
		return billableStatus;
	}
	public void setBillableStatus(String billableStatus) {
		this.billableStatus = billableStatus;
	}
	public String getLoggedHours() {
		return loggedHours;
	}
	public void setLoggedHours(String loggedHours) {
		this.loggedHours = loggedHours;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public File getAttachment() {
		return attachment;
	}
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
