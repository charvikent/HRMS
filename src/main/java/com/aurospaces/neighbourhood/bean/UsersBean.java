package com.aurospaces.neighbourhood.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class UsersBean {
	protected int id = 0;
	protected Date createdTime;
	protected Date updatedTime;
	@NotEmpty
	protected String name;
	protected String email;
	@NotEmpty
	protected String password;
	protected String mobile;
	protected String rolId;
	protected int  empId;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRolId() {
		return rolId;
	}
	public void setRolId(String rolId) {
		this.rolId = rolId;
	}
	
	
}
