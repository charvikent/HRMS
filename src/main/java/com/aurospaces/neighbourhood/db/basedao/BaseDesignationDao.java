package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
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

import com.aurospaces.neighbourhood.bean.DesignationBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;

public class BaseDesignationDao {
	
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	private DesignationStoreproc  sproc;

	public void setDataSource(DataSource source){
		jdbcTemplate = custom.getJdbcTemplate();
		this.sproc = new DesignationStoreproc(jdbcTemplate.getDataSource());
	}
	public String save(final DesignationBean designationBean){
		jdbcTemplate = custom.getJdbcTemplate();
		 if(designationBean.getCreatedTime() == null)
			{
			 long millis=System.currentTimeMillis();  
		        java.sql.Date date=new java.sql.Date(millis);  
			 designationBean.setCreatedTime( date);
			}
			this.sproc = new DesignationStoreproc(jdbcTemplate.getDataSource());
			 Map<String,Object> res = sproc.execute(designationBean.getId(),
					 designationBean.getName(),
					 designationBean.getMailAlias() ,
					 new java.sql.Timestamp(new Date().getTime()));//sproc.execute(inParamMapper);
			System.out.println("result:"+res);
			return (String) res.get("result");
		}
		
		private class DesignationStoreproc extends StoredProcedure{
			private static final String SPROC_NAME = "designationproc";
			public DesignationStoreproc( DataSource datasource ){
				super( datasource, SPROC_NAME );
				declareParameter( new SqlParameter( "inid", Types.INTEGER));
				declareParameter( new SqlParameter( "inname", Types.VARCHAR));
				declareParameter( new SqlParameter( "inemail", Types.VARCHAR));
				declareParameter( new SqlParameter( "increatedtime", Types.VARCHAR));
				declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
				compile();
			}
			 public  Map<String,Object> execute(Integer id,String inname,String inemail,Timestamp increatedtime){
				 Map<String,Object> results = super.execute(id,inname,inemail,increatedtime);
				 return results;
			 }
			
		}
		@Transactional
		public boolean delete(int id) {
			jdbcTemplate = custom.getJdbcTemplate();
			boolean delete = false;
			try{
			String sql = "DELETE FROM designation WHERE id=?";
			int intDelete=jdbcTemplate.update(sql, new Object[]{id});
			if(intDelete != 0){
				delete = true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return delete;
		}
		

	 public DesignationBean getById(int id) {
		 jdbcTemplate = custom.getJdbcTemplate();
			String sql = "SELECT * from designation where id = ? ";
			List<DesignationBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(DesignationBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
}
