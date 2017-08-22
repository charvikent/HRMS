package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.GroupsBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseGroupsDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "GroupsDao")
public class GroupsDao extends BaseGroupsDao {
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	 
	public List<GroupsBean> getGroups(){
		jdbcTemplate = custom.getJdbcTemplate();
		String sql =" select * from groups gp";
		List<GroupsBean> retlist = jdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(GroupsBean.class));
		return retlist;
		
	}
	
	public List<Map<String,String>> getGroupUsers(){
		return getGroupUsers(0);
	}
	public List<Map<String,String>> getGroupUsers(int groupId){
		jdbcTemplate = custom.getJdbcTemplate();
		String select_query = "select u.empId, concat(emp.firstName,' ', emp.lastName) as empName, u.roleId, r.name as roleName from group_users u, employee emp, roles r where u.empId = emp.emp_id "
						+" and u.roleId = r.id";
		if(groupId!=0){
			select_query += " and u.group_id = "+groupId;
		}
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "empId","empName","roleId","roleName"});
			jdbcTemplate.query(select_query, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
	}
}

