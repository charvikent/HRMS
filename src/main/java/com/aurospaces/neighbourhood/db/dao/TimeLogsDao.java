package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.TimeLogBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseTimeLogsDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "TimeLogsDao")
public class TimeLogsDao extends BaseTimeLogsDao {
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	public void saveOrUpdate(final TimeLogBean timeLogBean){
		jdbcTemplate = custom.getJdbcTemplate();
		this.timeLogsSP = new TimeLogsSP(jdbcTemplate.getDataSource());
		String result = (String)timeLogsSP.execute(timeLogBean);
		System.out.println("result:"+result);
	}
	
	public List<Map<String, String>> getAllTimeLogs(){
		jdbcTemplate = custom.getJdbcTemplate();
		
		String sql =" select id, projName,jobName,workItem,date,description,hours,billableStatus from time_logs" ;

		//System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","projName","jobName","workItem","date","description","hours","billableStatus"});
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;
		
	}
	
}
