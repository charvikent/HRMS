package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseClientDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "ClientDao")
public class ClientDao extends BaseClientDao {
	@Autowired
	CustomConnection custom;
	JdbcTemplate jdbcTemplate;

	public List<Map<String, String>> getAllClients() {
		jdbcTemplate = custom.getJdbcTemplate();
		String sql = " select id,clientName, currency,billingMethod,emailId,firstName,lastName,phone,mobile,fax,streetAddress,city,state,pincode,country,industry, companySize, description  from client ";

		// System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id", "clientName", "currency",
				"billingMethod", "emailId", "firstName", "lastName", "phone", "mobile", "fax", "streetAddress", "city",
				"state", "pincode", "country", "industry", "companySize", "description" });
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;

	}

	public List<Map<String, String>> getWorkingDetails(int employeeId) {
		jdbcTemplate = custom.getJdbcTemplate();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT e.firstName ,DATE_FORMAT(ec.created_time, '%d-%M-%Y')  as workingDay ,SEC_TO_TIME(SUM(UNIX_TIMESTAMP(ec.updated_time) - UNIX_TIMESTAMP(ec.created_time))) AS sumtime  from employeecheckin ec ,employee e where e.id =ec.employeeId ");
		if(employeeId != 0){
			buffer.append(" and ec.employeeId = "+employeeId);
		}
		buffer.append(" group by Date(ec.created_time),ec.employeeId ");
		String sql = buffer.toString();

		 System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "firstName","workingDay" , "sumtime"});
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;

	}
	public List<Map<String, String>> getWorkingDetailsCalender(int employeeId) {
		jdbcTemplate = custom.getJdbcTemplate();
		StringBuffer buffer = new StringBuffer();
		buffer.append("select e1.employeeId as id,min(e1.created_time) as checkIn,max(e1.updated_time) as checkOut from employeecheckin e1 ,employeecheckin e2 where e1.employeeId=e2.employeeId   ");
		if(employeeId != 0){
			buffer.append(" and e1.employeeId = "+employeeId);
		}
		buffer.append(" group by e1.employeeId,Date(e1.created_time) order by  e1.created_time asc ");
		String sql = buffer.toString();

		 System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] {"id","checkIn", "checkOut"});
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;

	}
}
