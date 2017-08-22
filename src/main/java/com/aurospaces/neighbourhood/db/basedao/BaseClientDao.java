package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.ClientBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;

public class BaseClientDao {
	
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	private ClientSproc  sproc;

	public void setDataSource(DataSource source){
		jdbcTemplate = custom.getJdbcTemplate();
		this.sproc = new ClientSproc(jdbcTemplate.getDataSource());
	}
	public String save(final ClientBean objClientBean){
		jdbcTemplate = custom.getJdbcTemplate();
		 if(objClientBean.getCreatedTime() == null)
			{
			 long millis=System.currentTimeMillis();  
		        java.sql.Date date=new java.sql.Date(millis);  
			 objClientBean.setCreatedTime( date);
			}java.sql.Timestamp createdTime = 
					new java.sql.Timestamp(objClientBean.getCreatedTime().getTime()); 
			this.sproc = new ClientSproc(jdbcTemplate.getDataSource());
			 Map<String,Object> res = sproc.execute(objClientBean.getId(),createdTime,objClientBean.getClientName() ,
					 objClientBean.getCurrency(),objClientBean.getBillingMethod(),objClientBean.getEmailId(),objClientBean.getFirstName(),
					 objClientBean.getLastName(),objClientBean.getPhone(),objClientBean.getMobile(),objClientBean.getFax(),objClientBean.getStreetAddress(),
					 objClientBean.getCity(),objClientBean.getState(),objClientBean.getPincode(),objClientBean.getCountry(),objClientBean.getIndustry(),objClientBean.getCompanySize(),objClientBean.getDescription());
			System.out.println("result:"+res);
			return (String) res.get("result");
		}
		
		private class ClientSproc extends StoredProcedure{
			private static final String SPROC_NAME = "clientproc";
			public ClientSproc( DataSource datasource ){
				super( datasource, SPROC_NAME );
				
				
				declareParameter( new SqlParameter( "inid", Types.INTEGER));
				declareParameter( new SqlParameter( "increatedtime", Types.TIMESTAMP));
				declareParameter( new SqlParameter( "inclientName", Types.VARCHAR));
				declareParameter( new SqlParameter( "incurrency", Types.VARCHAR));
				declareParameter( new SqlParameter( "inbillingMethod", Types.VARCHAR));
				declareParameter( new SqlParameter( "inemailId", Types.VARCHAR));
				declareParameter( new SqlParameter( "infirstName", Types.VARCHAR));
				declareParameter( new SqlParameter( "inlastName", Types.VARCHAR));
				declareParameter( new SqlParameter( "inphone", Types.VARCHAR));
				declareParameter( new SqlParameter( "inmobile", Types.VARCHAR));
				declareParameter( new SqlParameter( "infax", Types.VARCHAR));
				declareParameter( new SqlParameter( "instreetAddress", Types.VARCHAR));
				declareParameter( new SqlParameter( "incity", Types.VARCHAR));
				declareParameter( new SqlParameter( "instate", Types.VARCHAR));
				declareParameter( new SqlParameter( "inpincode", Types.VARCHAR));
				declareParameter( new SqlParameter( "incountry", Types.VARCHAR));
				declareParameter( new SqlParameter( "inindustry", Types.VARCHAR));
				declareParameter( new SqlParameter( "incompanySize", Types.VARCHAR));
				declareParameter( new SqlParameter( "indescription", Types.VARCHAR));
				declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
				compile();
			}
			 public  Map<String,Object> execute(Integer id,Timestamp  increatedtime,String inclientName,String incurrency,String inbillingMethod,String inemailId,String infirstName,String inlastName,String inphone,String inmobile,String infax,String instreetAddress
					 ,String incity,String instate,String inpincode,String incountry,String inindustry,String incompanySize,String indescription){
				 Map<String,Object> results = super.execute(id,increatedtime,inclientName,incurrency,inbillingMethod,inemailId,infirstName,inlastName,inphone,inmobile,infax,instreetAddress
						 ,incity,instate,inpincode,incountry,inindustry,incompanySize,indescription);
				 return results;
			 }
			
		}
		@Transactional
		public boolean delete(int id) {
			jdbcTemplate = custom.getJdbcTemplate();
			boolean delete = false;
			try{
			String sql = "DELETE FROM client WHERE id=?";
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
