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
import com.aurospaces.neighbourhood.daosupport.CustomConnection;

public class BaseHolidayDao {
	
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	private HolidaySproc  sproc;

	public void setDataSource(DataSource source){
		jdbcTemplate = custom.getJdbcTemplate();
		this.sproc = new HolidaySproc(jdbcTemplate.getDataSource());
	}
	public String save(final HolidayBean objHolidayBean){
		jdbcTemplate = custom.getJdbcTemplate();
		 if(objHolidayBean.getCreatedTime() == null)
			{
			 long millis=System.currentTimeMillis();  
		        java.sql.Date date=new java.sql.Date(millis);  
			 objHolidayBean.setCreatedTime( date);
			}
			this.sproc = new HolidaySproc(jdbcTemplate.getDataSource());
			 Map<String,Object> res = sproc.execute(objHolidayBean.getId(),objHolidayBean.getCreatedTime(),objHolidayBean.getName() ,
					 objHolidayBean.getFromDate(),objHolidayBean.getToDate(),objHolidayBean.getApplicable(),objHolidayBean.getDescription(),
					 objHolidayBean.getNotifyapplicable(),objHolidayBean.getHolidaySection());
			System.out.println("result:"+res);
			return (String) res.get("result");
		}
		
		private class HolidaySproc extends StoredProcedure{
			private static final String SPROC_NAME = "holidayproc";
			public HolidaySproc( DataSource datasource ){
				super( datasource, SPROC_NAME );
				  
				declareParameter( new SqlParameter( "inid", Types.INTEGER));
				declareParameter( new SqlParameter( "increatedtime", Types.DATE));
				declareParameter( new SqlParameter( "inname", Types.VARCHAR));
				declareParameter( new SqlParameter( "infromdate", Types.DATE));
				declareParameter( new SqlParameter( "intodate", Types.DATE));
				declareParameter( new SqlParameter( "inapplicable", Types.VARCHAR));
				declareParameter( new SqlParameter( "indescription", Types.VARCHAR));
				declareParameter( new SqlParameter( "innotifyapplicable", Types.VARCHAR));
				declareParameter( new SqlParameter( "inholidaysection", Types.VARCHAR));
				declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
				compile();
			}
			 public  Map<String,Object> execute(Integer id,Date increatedtime,String inname,Date infromdate,Date intodate,String inapplicable,String indescription,String innotifyapplicable,String inholidaysection){
				 Map<String,Object> results = super.execute(id,increatedtime,inname,infromdate,intodate,inapplicable,indescription,innotifyapplicable,inholidaysection);
				 return results;
			 }
			
		}
		@Transactional
		public boolean delete(int id) {
			jdbcTemplate = custom.getJdbcTemplate();
			boolean delete = false;
			try{
			String sql = "DELETE FROM holiday WHERE id=?";
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
