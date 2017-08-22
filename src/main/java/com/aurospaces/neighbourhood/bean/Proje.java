package com.aurospaces.neighbourhood.bean;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Proje {
	protected int id   = 0;
	protected Date createdTime ;
	protected String id1;
	protected Date updatedTime ;
	@NotEmpty
	private String name;
	@Email
	private String email;
	private String departmentHead;
	private String parentid;
	private String allParentIds;
	private int active =0;
	private String parentid1;
	
	
	public String getParentid1() {
		return parentid1;
	}
	public void setParentid1(String parentid1) {
		this.parentid1 = parentid1;
	}
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public String getAllParentIds() {
		return allParentIds;
	}
	public void setAllParentIds(String allParentIds) {
		this.allParentIds = allParentIds;
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
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartmentHead() {
		return departmentHead;
	}
	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	
	
}
