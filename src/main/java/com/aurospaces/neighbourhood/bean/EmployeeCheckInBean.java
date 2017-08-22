package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class EmployeeCheckInBean {
   protected int id=0;
   protected Date createdTime;
   protected Date updateTime;
   protected int active;
   protected int employeeId;
   
public Date getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(Date updateTime) {
	this.updateTime = updateTime;
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
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
   
		   
}
