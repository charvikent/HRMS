package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class ProjectsBean {
	protected int id=0; 
	protected Date  created_time ;
	protected Date  updated_time ;
	protected String  name; 
	protected String  clientId ;
	protected double  projectcost ;
	protected String projectManager ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public Date getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public double getProjectcost() {
		return projectcost;
	}
	public void setProjectcost(double projectcost) {
		this.projectcost = projectcost;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	
}
