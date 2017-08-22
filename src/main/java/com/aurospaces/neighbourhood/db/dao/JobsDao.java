package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseJobsDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "JobsDao")
public class JobsDao extends BaseJobsDao {
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	public List<Map<String, String>> getJobs() {
		jdbcTemplate = custom.getJdbcTemplate();
		String sql = " select id,name,projectId,DATE_FORMAT(startDate, '%d-%M-%Y') as startDate, DATE_FORMAT(endDate, '%d-%M-%Y') as endDate,hours,assignees,rateperhour,description,billableStatus from jobs ";

		// System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id", "name", "projectId",
				"startDate", "endDate", "hours", "assignees", "rateperhour", "description","billableStatus" });
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;

	}
}
