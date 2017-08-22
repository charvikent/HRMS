package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Date;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.HolidayBean;
import com.aurospaces.neighbourhood.bean.JobsBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;

public class BaseJobsDao {
	
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	private JobsSproc  sproc;

	public void setDataSource(DataSource source){
		jdbcTemplate = custom.getJdbcTemplate();
		this.sproc = new JobsSproc(jdbcTemplate.getDataSource());
	}
	public String save(final JobsBean objJobsBean){
		jdbcTemplate = custom.getJdbcTemplate();
		 if(objJobsBean.getCreatedTime() == null)
			{
			 long millis=System.currentTimeMillis();  
		        java.sql.Date date=new java.sql.Date(millis);  
			 objJobsBean.setCreatedTime( date);
			}
			this.sproc = new JobsSproc(jdbcTemplate.getDataSource());
			 Map<String,Object> res = sproc.execute(objJobsBean.getId(),objJobsBean.getCreatedTime(),objJobsBean.getName() ,
					 objJobsBean.getProjectId1(),objJobsBean.getStartDate(),objJobsBean.getEndDate(),objJobsBean.getHours(),
					 objJobsBean.getAssignees(),objJobsBean.getRateperhour(),objJobsBean.getDescription(),objJobsBean.getBillableStatus());
			System.out.println("result:"+res);
			return (String) res.get("result");
		}
		
		private class JobsSproc extends StoredProcedure{
			private static final String SPROC_NAME = "jobs_sproc";
			public JobsSproc( DataSource datasource ){
				super( datasource, SPROC_NAME );
				declareParameter( new SqlParameter( "inid", Types.INTEGER));
				declareParameter( new SqlParameter( "increatedtime", Types.DATE));
				declareParameter( new SqlParameter( "inname", Types.VARCHAR));
				declareParameter( new SqlParameter( "inprojectId", Types.INTEGER));
				declareParameter( new SqlParameter( "instartDate", Types.DATE));
				declareParameter( new SqlParameter( "inendDate", Types.DATE));
				declareParameter( new SqlParameter( "inhours", Types.VARCHAR));
				declareParameter( new SqlParameter( "inassignees", Types.VARCHAR));
				declareParameter( new SqlParameter( "inrateperhour", Types.VARCHAR));
				declareParameter( new SqlParameter( "indesicription", Types.VARCHAR));
				declareParameter( new SqlParameter( "inbillableStatus", Types.VARCHAR));
				declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
				compile();
			}
			 public  Map<String,Object> execute(Integer id,Date increatedtime,String inname,Integer inprojectId,Date instartDate,Date inendDate,String inhours,String inassignees,String inrateperhour,String indesicription,String inbillableStatus){
				 Map<String,Object> results = super.execute(id,increatedtime,inname,inprojectId,instartDate,inendDate,inhours,inassignees,inrateperhour,indesicription,inbillableStatus);
				 return results;
			 }
			
		}
		@Transactional
		public boolean delete(int id) {
			jdbcTemplate = custom.getJdbcTemplate();
			boolean delete = false;
			try{
			String sql = "DELETE FROM jobs WHERE id=?";
			int intDelete=jdbcTemplate.update(sql, new Object[]{id});
			if(intDelete != 0){
				delete = true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return delete;
		}
		

	/* public DesignationBean getById(int id) {
			String sql = "SELECT * from designation where id = ? ";
			List<DesignationBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(DesignationBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}*/
}
