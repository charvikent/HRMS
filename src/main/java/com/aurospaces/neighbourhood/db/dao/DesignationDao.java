package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.DesignationBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseDesignationDao;

@Repository(value = "DesignationDao")
public class DesignationDao extends BaseDesignationDao {
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	public List<DesignationBean> getAllDesignations() {
		jdbcTemplate = custom.getJdbcTemplate();
		String sql = "SELECT * from designation  ";
		List<DesignationBean> retlist = jdbcTemplate.query(sql, new Object[] {  },
				ParameterizedBeanPropertyRowMapper.newInstance(DesignationBean.class));
		if (retlist.size() > 0)
			return retlist;
		return null;
	}
}
