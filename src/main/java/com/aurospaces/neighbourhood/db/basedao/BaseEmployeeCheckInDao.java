
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.EmployeeCheckInBean;
import com.aurospaces.neighbourhood.bean.Proje;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;


public class BaseEmployeeCheckInDao{
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;

 

	public final String INSERT_SQL = "INSERT INTO employeecheckin( created_time, updated_time, employeeId, active) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public boolean save(final EmployeeCheckInBean objEmployeeCheckInBean) 
	{
		jdbcTemplate = custom.getJdbcTemplate();
	if(objEmployeeCheckInBean.getId()== 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(objEmployeeCheckInBean.getCreatedTime() == null)
					{
					objEmployeeCheckInBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(objEmployeeCheckInBean.getCreatedTime().getTime()); 
							
					if(objEmployeeCheckInBean.getUpdateTime() == null)
					{
					objEmployeeCheckInBean.setUpdateTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(objEmployeeCheckInBean.getUpdateTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, objEmployeeCheckInBean.getEmployeeId());
ps.setInt(4, objEmployeeCheckInBean.getActive());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				objEmployeeCheckInBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE employeecheckin  set employeeId = ? ,active = ?   where id =? ";
	
			jdbcTemplate.update(sql, new Object[]{objEmployeeCheckInBean.getEmployeeId(),objEmployeeCheckInBean.getActive(),objEmployeeCheckInBean.getId()});
		}
	return true;
	}
		
		@Transactional
		public boolean delete(int id) {
			jdbcTemplate = custom.getJdbcTemplate();
			boolean delete = false;
			try{
			String sql = "DELETE FROM employeecheckin WHERE id=?";
			int intDelete=jdbcTemplate.update(sql, new Object[]{id});
			if(intDelete != 0){
				delete = true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return delete;
		}
		

	 public List<EmployeeCheckInBean> getByEmployeeId(int id) {
		 jdbcTemplate = custom.getJdbcTemplate();
			String sql = " SELECT * from employeecheckin where employeeid = ?  and DATE(created_time) = DATE(Now()) order by updated_time desc limit 1 ";
			List<EmployeeCheckInBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(EmployeeCheckInBean.class));
			if(retlist.size() > 0)
				return  retlist;
			return null;
		}
	

}
