package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseHolidayDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "HolidayDao")
public class HolidayDao extends BaseHolidayDao {
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	 
	public List<Map<String, String>> getHolidays(){
		jdbcTemplate = custom.getJdbcTemplate();
		String sql =" select id,name,created_time , DATE_FORMAT(fromDate, '%d-%M-%Y') as fromDate , DATE_FORMAT(toDate, '%d-%M-%Y') as toDate,applicable,description,notifyapplicable ,holidaySectin from holiday   " ;

		//System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] {"id","name","created_time" , "fromDate","toDate","applicable","description","notifyapplicable" ,"holidaySectin"});
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;
		
	}
	public List<Map<String, String>> getHolidaysforCalender(){
		jdbcTemplate = custom.getJdbcTemplate();
		String sql =" select name as title, Date(fromDate) as start,Date(toDate) as end  from holiday   " ;

		//System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] {"title","start","end"});
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;
		
	}
	
}
