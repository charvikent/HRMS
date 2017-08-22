package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Date;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.GroupsBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;

public class BaseGroupsDao {
	
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
	private GroupsSproc  sproc;

	public String save(final GroupsBean objGroupsBean, int usersLength){
		jdbcTemplate = custom.getJdbcTemplate();
		 if(objGroupsBean.getCreatedTime() == null)
			{
			 long millis=System.currentTimeMillis();  
		        java.sql.Date date=new java.sql.Date(millis);  
		        objGroupsBean.setCreatedTime( date);
			}
			this.sproc = new GroupsSproc(jdbcTemplate.getDataSource());
			 Map<String,Object> res = sproc.execute(objGroupsBean.getId(),objGroupsBean.getCreatedTime(),objGroupsBean.getName() ,
					 objGroupsBean.getDescription(),objGroupsBean.getGroupEmailId(),
					 objGroupsBean.getUserIds() ,objGroupsBean.getRoleIds(),usersLength);
			return (String) res.get("result");
		}
		
		private class GroupsSproc extends StoredProcedure{
			private static final String SPROC_NAME = "groups_sproc";
			public GroupsSproc( DataSource datasource ){
				super( datasource, SPROC_NAME );
				  
				declareParameter( new SqlParameter( "id", Types.INTEGER));
				declareParameter( new SqlParameter( "createdtime", Types.DATE));
				declareParameter( new SqlParameter( "name", Types.VARCHAR));
				declareParameter( new SqlParameter( "description", Types.VARCHAR));
				declareParameter( new SqlParameter( "email", Types.VARCHAR));
				declareParameter( new SqlParameter( "userids", Types.VARCHAR));
				declareParameter( new SqlParameter( "roleids", Types.VARCHAR));
				declareParameter( new SqlParameter( "users_length", Types.INTEGER));
				declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
				compile();
			}
			 /*public  Map<String,Object> execute(Integer id,Date createdtime,String name,String description,String email,
					 							String userid,String roleid){
				 Map<String,Object> results = super.execute(id,createdtime,name,description,email,userid,roleid);
				 return results;
			 }*/
			
		}
		
		
		@Transactional
		public boolean delete(int groupId) {
			jdbcTemplate = custom.getJdbcTemplate();
			boolean isDeleted = false;
			try{
				
				SimpleJdbcCall simpleJdbcCall  = new SimpleJdbcCall(jdbcTemplate).withProcedureName("groups_delete_sproc");
				Map<String, Object> inParamMap = new HashMap<String, Object>();
				inParamMap.put("groupId", groupId);
				SqlParameterSource in = new MapSqlParameterSource(inParamMap);
				Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
				//isDeleted = Boolean.valueOf((String)simpleJdbcCallResult.get("isDeleted")).booleanValue();
				isDeleted = ((Boolean)simpleJdbcCallResult.get("isDeleted")).booleanValue();
				//if(result == 1)
				//	isDeleted = true;
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return isDeleted;
		}
		
		
		/*@Transactional
		public boolean delete(int id) {
			jdbcTemplate = custom.getJdbcTemplate();
			boolean delete = false;
			try{
			String sql = "DELETE FROM groups WHERE id=?";
			int intDelete=jdbcTemplate.update(sql, new Object[]{id});
			if(intDelete != 0){
				delete = true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return delete;
		}*/
		

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
