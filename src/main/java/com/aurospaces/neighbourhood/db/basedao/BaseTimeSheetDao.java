
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Types;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.TimeSheetBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;

public class BaseTimeSheetDao{

	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	
	public TimeSheetSP  timeSheetSP;
	
	public class TimeSheetSP extends StoredProcedure{
	private static final String SPROC_NAME = "time_sheet_sproc";
	public TimeSheetSP( DataSource datasource ){
		super( datasource, SPROC_NAME );
		declareParameter( new SqlParameter( "id", Types.INTEGER));
		declareParameter( new SqlParameter( "created_time", Types.VARCHAR));
		declareParameter( new SqlParameter( "updated_time", Types.VARCHAR));
		declareParameter( new SqlParameter( "period", Types.VARCHAR));
		declareParameter( new SqlParameter( "emp_name", Types.VARCHAR));
		declareParameter( new SqlParameter( "clients", Types.VARCHAR));
		declareParameter( new SqlParameter( "projects", Types.VARCHAR));
		declareParameter( new SqlParameter( "jobs", Types.VARCHAR));
		declareParameter( new SqlParameter( "billable_status", Types.VARCHAR));
		declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
		compile();
	}
	public Object execute(TimeSheetBean timeSheetBean){
		 Map<String,Object> results = super.execute(timeSheetBean.getId(),
				 new java.sql.Timestamp(new Date().getTime()),//designationBean.getCreatedTime(),
				 new java.sql.Timestamp(new Date().getTime()),//designationBean.getUpdatedTime(),
				 timeSheetBean.getPeriod(),timeSheetBean.getEmpName(),timeSheetBean.getClients(),timeSheetBean.getProjects(),
				 timeSheetBean.getJobs(),timeSheetBean.getBillableStatus());
		 return results.get("result");
	 }
	
	}



 
	/*public final String INSERT_SQL = "INSERT INTO time_sheets( created_time, updated_time, period, empName, clients, projects, jobs, billableStatus) "
						+ " values (?, ?, ?, ?, ?, ?, ?, ?)"; 





	 this should be conditional based on whether the id is present or not 
	@Transactional
	public boolean save(final TimeSheetBean timeSheetBean) 
	{
		if(timeSheetBean.getId() == 0)	{
	
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
						if(timeSheetBean.getCreatedTime() == null)
						{
							timeSheetBean.setCreatedTime( new Date());
						}
						java.sql.Timestamp createdTime = 
							new java.sql.Timestamp(timeSheetBean.getCreatedTime().getTime()); 
								
						if(timeSheetBean.getUpdatedTime() == null)
						{
							timeSheetBean.setUpdatedTime( new Date());
						}
						java.sql.Timestamp updatedTime = 
							new java.sql.Timestamp(new Date().getTime()); 
								
						PreparedStatement ps =
										connection.prepareStatement(INSERT_SQL,new String[]{"id"});
						ps.setTimestamp(1, createdTime);
						ps.setTimestamp(2, updatedTime);
						ps.setString(3,timeSheetBean.getPeriod());//ps.setString(3, empBean.getEmailId());
						ps.setString(4, timeSheetBean.getEmpName());
						ps.setString(5, timeSheetBean.getClients());
						ps.setString(6, timeSheetBean.getProjects());
						ps.setString(7, timeSheetBean.getJobs());
						ps.setString(8, timeSheetBean.getBillableStatus());
						
						return ps;
					}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				timeSheetBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE time_sheets  set period = ? ,empName = ? ,clients = ? ,projects = ? ,jobs = ? ,billableStatus = ? where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{timeSheetBean.getPeriod(), timeSheetBean.getEmpName(), timeSheetBean.getClients(), timeSheetBean.getProjects(), timeSheetBean.getJobs(), timeSheetBean.getBillableStatus(), timeSheetBean.getId()});
		}
	return true;
	}
*/		
	@Transactional
	public void delete(int id) {
		jdbcTemplate = custom.getJdbcTemplate();
		String sql = "DELETE FROM time_sheets WHERE id=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}
		

}
