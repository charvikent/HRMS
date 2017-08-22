package com.aurospaces.neighbourhood.bean;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class DesignationBean {
	
	private int id;
	@NotEmpty
	private String name;
	@Email
	private String mailAlias;
	private Date createdTime;
	private String email;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAlias() {
		return mailAlias;
	}
	public void setMailAlias(String mailAlias) {
		this.mailAlias = mailAlias;
	}
	
	
}
