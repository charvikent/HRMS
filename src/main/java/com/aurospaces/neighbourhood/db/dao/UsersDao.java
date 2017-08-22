package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.UsersBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseUsersDao;

@Repository(value="UsersDao")
public class UsersDao extends BaseUsersDao {
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	 public UsersBean getUserDetails(UsersBean objUsersBean) {
		 jdbcTemplate = custom.getJdbcTemplate();
			String sql = "SELECT * from users where name = ? and password=?";
			List<UsersBean> retlist = jdbcTemplate.query(sql,
			new Object[]{objUsersBean.getName(),objUsersBean.getPassword()},
			ParameterizedBeanPropertyRowMapper.newInstance(UsersBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
}
