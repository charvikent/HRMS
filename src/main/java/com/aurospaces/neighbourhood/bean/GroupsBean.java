package com.aurospaces.neighbourhood.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.NotEmpty;

public class GroupsBean {
private int id;
private Date createdTime ;
private Date updatedTime ;
@NotEmpty
private String name;
private String description;
private String groupEmailId;
private String roleIds;
private String userIds;
private String[] userId;
private String[] roleId;

private List<Map<String,String>> usersList;

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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getGroupEmailId() {
	return groupEmailId;
}
public void setGroupEmailId(String groupEmailId) {
	this.groupEmailId = groupEmailId;
}
public String[] getUserId() {
	return userId;
}
public void setUserId(String[] userId) {
	this.userId = userId;
}
public String[] getRoleId() {
	return roleId;
}
public void setRoleId(String[] roleId) {
	this.roleId = roleId;
}
public String getRoleIds() {
	return roleIds;
}
public void setRoleIds(String roleIds) {
	this.roleIds = roleIds;
}
public String getUserIds() {
	return userIds;
}
public void setUserIds(String userIds) {
	this.userIds = userIds;
}
public List<Map<String, String>> getUsersList() {
	return usersList;
}
public void setUsersList(List<Map<String, String>> usersList) {
	this.usersList = usersList;
}


}
