
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

import com.aurospaces.neighbourhood.bean.UsersBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;


public class BaseUsersDao{

	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;
 
	public final String INSERT_SQL = "INSERT INTO users( created_time, updated_time, name, email, password,mobile,rolId) values (?, ?, ?, ?, ?,?,?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public boolean save(final UsersBean objUsersBean) 
	{
		jdbcTemplate = custom.getJdbcTemplate();
	if(objUsersBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(objUsersBean.getCreatedTime() == null)
					{
					objUsersBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(objUsersBean.getCreatedTime().getTime()); 
							
					if(objUsersBean.getUpdatedTime() == null)
					{
					objUsersBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(objUsersBean.getUpdatedTime().getTime()); 
					
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, objUsersBean.getName());
ps.setString(4, objUsersBean.getEmail());
ps.setString(5, objUsersBean.getPassword());
ps.setString(6, objUsersBean.getMobile());
ps.setString(7, objUsersBean.getRolId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				objUsersBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE users  set name = ? , date =?, applicable =?,description =?,notifyapplicable=?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{objUsersBean.getName(),objUsersBean.getEmail(),objUsersBean.getPassword(),objUsersBean.getMobile(),objUsersBean.getRolId(),objUsersBean.getId()});
		}
	return true;
	}
		
		@Transactional
		public void delete(int id) {
			jdbcTemplate = custom.getJdbcTemplate();
			String sql = "DELETE FROM users WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public UsersBean getById(int id) {
		 jdbcTemplate = custom.getJdbcTemplate();
			String sql = "SELECT * from users where id = ? ";
			List<UsersBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(UsersBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
