package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ProjectsBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseProjectsDao;
@Repository(value="ProjectsDao")
public class ProjectsDao extends BaseProjectsDao {
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	public List<ProjectsBean> getAllProjects() {
		jdbcTemplate = custom.getJdbcTemplate();
		String sql = "SELECT * from projects  ";
		List<ProjectsBean> retlist = jdbcTemplate.query(sql, new Object[] {  },
				ParameterizedBeanPropertyRowMapper.newInstance(ProjectsBean.class));
		if (retlist.size() > 0)
			return retlist;
		return null;
	}
}
