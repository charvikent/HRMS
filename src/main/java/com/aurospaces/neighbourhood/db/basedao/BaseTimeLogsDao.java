
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

import com.aurospaces.neighbourhood.bean.TimeLogBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;

public class BaseTimeLogsDao{

	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	
	public TimeLogsSP  timeLogsSP;
	
	public class TimeLogsSP extends StoredProcedure{
		private static final String SPROC_NAME = "time_logs_sproc";
		public TimeLogsSP( DataSource datasource ){
			super( datasource, SPROC_NAME );
			declareParameter( new SqlParameter( "id", Types.INTEGER));
			declareParameter( new SqlParameter( "created_time", Types.VARCHAR));
			declareParameter( new SqlParameter( "updated_time", Types.VARCHAR));
			declareParameter( new SqlParameter( "proj_name", Types.VARCHAR));
			declareParameter( new SqlParameter( "job_name", Types.VARCHAR));
			declareParameter( new SqlParameter( "work_item", Types.VARCHAR));
			declareParameter( new SqlParameter( "date", Types.DATE));
			declareParameter( new SqlParameter( "description", Types.VARCHAR));
			declareParameter( new SqlParameter( "hours", Types.VARCHAR));
			declareParameter( new SqlParameter( "billable_status", Types.VARCHAR));
			declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
			compile();
		}
		public Object execute(TimeLogBean timeLogBean){
			 Map<String,Object> results = super.execute(timeLogBean.getId(),
					 new java.sql.Timestamp(new Date().getTime()),//timeLogBean.getCreatedTime(),
					 new java.sql.Timestamp(new Date().getTime()),//timeLogBean.getUpdatedTime(),
					 timeLogBean.getProjName(),timeLogBean.getJobName(),timeLogBean.getWorkItem(),timeLogBean.getDate(),
					 timeLogBean.getDescription(),timeLogBean.getHours(),timeLogBean.getBillableStatus());
			 return results.get("result");
		 }
		
	}

 
/*	public final String INSERT_SQL = "INSERT INTO time_logs( created_time, updated_time, projName, jobName, workItem, date, description, hours, "
						+ "billableStatus) values (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	 this should be conditional based on whether the id is present or not 
	@Transactional
	public boolean save(final TimeLogBean timeLogsBean) 
	{
		if(timeLogsBean.getId() == 0)	{
	
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
						if(timeLogsBean.getCreatedTime() == null)
						{
							timeLogsBean.setCreatedTime( new Date());
						}
						java.sql.Timestamp createdTime = 
							new java.sql.Timestamp(timeLogsBean.getCreatedTime().getTime()); 
								
						if(timeLogsBean.getUpdatedTime() == null)
						{
							timeLogsBean.setUpdatedTime( new Date());
						}
						java.sql.Timestamp updatedTime = 
							new java.sql.Timestamp(new Date().getTime()); 
								
						PreparedStatement ps =
										connection.prepareStatement(INSERT_SQL,new String[]{"id"});
						ps.setTimestamp(1, createdTime);
						ps.setTimestamp(2, updatedTime);
						ps.setString(3,timeLogsBean.getProjName());//ps.setString(3, empBean.getEmailId());
						ps.setString(4, timeLogsBean.getJobName());
						ps.setString(5, timeLogsBean.getWorkItem());
						ps.setString(6, timeLogsBean.getDate());
						ps.setString(7, timeLogsBean.getDescription());
						ps.setString(8, timeLogsBean.getHours());
						ps.setString(9, timeLogsBean.getBillableStatus());
						
						return ps;
					}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				timeLogsBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE time_logs  set projName = ? ,jobName = ? ,workItem = ? ,date = ? ,description = ? ,hours = ? ,billableStatus = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{timeLogsBean.getProjName(),timeLogsBean.getJobName(),timeLogsBean.getWorkItem(),timeLogsBean.getDate(),timeLogsBean.getDescription(),timeLogsBean.getHours(),timeLogsBean.getBillableStatus(),timeLogsBean.getId()});
		}
	return true;
	}
*/		
	@Transactional
	public boolean delete(int id) {
		jdbcTemplate = custom.getJdbcTemplate();
		boolean delete =false;
		try{
			String sql = "DELETE FROM time_logs WHERE id=?";
			int i = jdbcTemplate.update(sql, new Object[]{id});
			if(i >0){
				delete =true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return delete;
	}
		

}
