package com.aurospaces.neighbourhood.bean;

public class DependentBean {
	
	private int id;
	private String empId;
	private String dependentName;
	private String dependentRelation;
	private String dependentDob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getDependentName() {
		return dependentName;
	}
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	public String getDependentRelation() {
		return dependentRelation;
	}
	public void setDependentRelation(String dependentRelation) {
		this.dependentRelation = dependentRelation;
	}
	public String getDependentDob() {
		return dependentDob;
	}
	public void setDependentDob(String dependentDob) {
		this.dependentDob = dependentDob;
	}
}
