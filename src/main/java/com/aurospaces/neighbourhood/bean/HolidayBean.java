package com.aurospaces.neighbourhood.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class HolidayBean {
protected int id =0;
protected Date fromDate;
protected Date toDate;
protected Date createdTime ;
protected Date updatedTime ;
@NotEmpty
protected String name;
protected String description;
protected String applicable;
protected String notifyapplicable;
protected String holidaySection;

protected String fromDate1;
protected String toDate1;

public String getHolidaySection() {
	return holidaySection;
}
public void setHolidaySection(String holidaySection) {
	this.holidaySection = holidaySection;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getFromDate() {
	return fromDate;
}
public void setFromDate(Date fromDate) {
	this.fromDate = fromDate;
}
public Date getToDate() {
	return toDate;
}
public void setToDate(Date toDate) {
	this.toDate = toDate;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getApplicable() {
	return applicable;
}
public void setApplicable(String applicable) {
	this.applicable = applicable;
}
public String getNotifyapplicable() {
	return notifyapplicable;
}
public void setNotifyapplicable(String notifyapplicable) {
	this.notifyapplicable = notifyapplicable;
}
public String getFromDate1() {
	return fromDate1;
}
public void setFromDate1(String fromDate1) {
	this.fromDate1 = fromDate1;
}
public String getToDate1() {
	return toDate1;
}
public void setToDate1(String toDate1) {
	this.toDate1 = toDate1;
}


}
