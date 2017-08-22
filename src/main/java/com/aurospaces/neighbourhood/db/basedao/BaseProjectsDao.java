package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Date;
import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.ProjectsBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;

public class BaseProjectsDao {
	
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	private ProjectSproc  sproc;

	public void setDataSource(DataSource source){
		jdbcTemplate = custom.getJdbcTemplate();
		this.sproc = new ProjectSproc(jdbcTemplate.getDataSource());
	}
	public String save(final ProjectsBean objJobsBean){
		jdbcTemplate = custom.getJdbcTemplate();
		 if(objJobsBean.getCreated_time() == null)
			{
			 long millis=System.currentTimeMillis();  
		        java.sql.Date date=new java.sql.Date(millis);  
			 objJobsBean.setCreated_time(date);
			}
		
			this.sproc = new ProjectSproc(jdbcTemplate.getDataSource());
			 Map<String,Object> res = sproc.execute(objJobsBean.getId(),objJobsBean.getCreated_time(),objJobsBean.getName() ,
					 objJobsBean.getClientId(),objJobsBean.getProjectcost(),objJobsBean.getProjectManager());
			System.out.println("result:"+res);
			return (String) res.get("result");
		}
//	 id,created_time,name,clientId,projectcost,projectManager
		private class ProjectSproc extends StoredProcedure{
			private static final String SPROC_NAME = "projectsproc";
			public ProjectSproc( DataSource datasource ){
				super( datasource, SPROC_NAME );
				declareParameter( new SqlParameter( "inid", Types.INTEGER));
				declareParameter( new SqlParameter( "increatedtime", Types.DATE));
				declareParameter( new SqlParameter( "inname", Types.VARCHAR));
				declareParameter( new SqlParameter( "inclientId", Types.VARCHAR));
				declareParameter( new SqlParameter( "inprojectcost", Types.DOUBLE));
				declareParameter( new SqlParameter( "inprojectManager", Types.VARCHAR));
				declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
				compile();
			}
			 public  Map<String,Object> execute(Integer id,Date increatedtime,String inname,String inclientId,Double inprojectcost,String inprojectManager){
				 Map<String,Object> results = super.execute(id,increatedtime,inname,inclientId,inprojectcost,inprojectManager);
				 return results;
			 }
			
		}
		@Transactional
		public boolean delete(int id) {
			jdbcTemplate = custom.getJdbcTemplate();
			boolean delete = false;
			try{
			String sql = "DELETE FROM projects WHERE id=?";
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
