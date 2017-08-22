
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.Proje;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;


public class BaseDepartmentDao{
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;

 
private DepartmentSproc  sproc;

public void setDataSource(DataSource source){
	jdbcTemplate = custom.getJdbcTemplate();
	this.sproc = new DepartmentSproc(jdbcTemplate.getDataSource());
}
	public final String INSERT_SQL = "INSERT INTO department( created_time, updated_time, name, email, departmentHead,parent_id) values (?, ?, ?, ?, ?,?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public boolean saveback(final Proje objDepartmentBean) 
	{
		jdbcTemplate = custom.getJdbcTemplate();
	if(objDepartmentBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(objDepartmentBean.getCreatedTime() == null)
					{
					objDepartmentBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(objDepartmentBean.getCreatedTime().getTime()); 
							
					if(objDepartmentBean.getUpdatedTime() == null)
					{
					objDepartmentBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(objDepartmentBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, objDepartmentBean.getName());
ps.setString(4, objDepartmentBean.getEmail());
ps.setString(5, objDepartmentBean.getDepartmentHead());
ps.setString(6, objDepartmentBean.getParentid());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				objDepartmentBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE department  set name = ? ,email = ? ,departmentHead = ?,parent_id=?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{objDepartmentBean.getName(),objDepartmentBean.getEmail(),objDepartmentBean.getDepartmentHead(),objDepartmentBean.getParentid(),objDepartmentBean.getId()});
		}
	return true;
	}
		
		@Transactional
		public boolean delete(int id) {
			jdbcTemplate = custom.getJdbcTemplate();
			boolean delete = false;
			try{
			String sql = "DELETE FROM department WHERE id=?";
			int intDelete=jdbcTemplate.update(sql, new Object[]{id});
			if(intDelete != 0){
				delete = true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return delete;
		}
		

	 public Proje getById(int id) {
		 jdbcTemplate = custom.getJdbcTemplate();
			String sql = "SELECT * from department where id = ? ";
			List<Proje> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Proje.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 public String save(final Proje departmentBean){
		 jdbcTemplate = custom.getJdbcTemplate();
		/* if(departmentBean.getCreatedTime() == null)
			{
			 departmentBean.setCreatedTime( new Date());
			}
			java.sql.Timestamp createdTime = 
				new java.sql.Timestamp(departmentBean.getCreatedTime().getTime());*/
			this.sproc = new DepartmentSproc(jdbcTemplate.getDataSource());
			 Map<String,Object> res = sproc.execute(departmentBean.getId(),departmentBean.getName(),departmentBean.getEmail(),departmentBean.getDepartmentHead(),
					 departmentBean.getParentid(),
					 new java.sql.Timestamp(new Date().getTime()));//sproc.execute(inParamMapper);
			System.out.println("result:"+res);
			return (String) res.get("result");
		}
		
		private class DepartmentSproc extends StoredProcedure{
			private static final String SPROC_NAME = "departmentproc";
			public DepartmentSproc( DataSource datasource ){
				super( datasource, SPROC_NAME );
				declareParameter( new SqlParameter( "inid", Types.INTEGER));
				declareParameter( new SqlParameter( "inname", Types.VARCHAR));
				declareParameter( new SqlParameter( "inemail", Types.VARCHAR));
				declareParameter( new SqlParameter( "indepartmentHead", Types.VARCHAR));
				declareParameter( new SqlParameter( "inparent_id", Types.VARCHAR));
				declareParameter( new SqlParameter( "increationtime", Types.VARCHAR));
				
				declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
				compile();
			}
			 public  Map<String,Object> execute(Integer id,String inname,String inemail,String indepartmentHead,String inparent_id,String createdtime){
				 Map<String,Object> results = super.execute(id,inname,inemail,indepartmentHead,inparent_id,createdtime);
				 return results;
			 }
			
		}

}
