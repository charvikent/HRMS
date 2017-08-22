package com.aurospaces.neighbourhood.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.TimeSheetBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseTimeSheetDao;

@Repository(value = "TimeSheetDao")
public class TimeSheetDao extends BaseTimeSheetDao {
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	public void saveOrUpdate(final TimeSheetBean timeSheetBean){
		jdbcTemplate = custom.getJdbcTemplate();
		this.timeSheetSP = new TimeSheetSP(jdbcTemplate.getDataSource());
		String result = (String)timeSheetSP.execute(timeSheetBean);
		System.out.println("result:"+result);
	}

}
