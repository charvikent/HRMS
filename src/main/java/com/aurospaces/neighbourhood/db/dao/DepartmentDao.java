package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.Proje;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseDepartmentDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "DepartmentDao")
public class DepartmentDao extends BaseDepartmentDao {
	
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate ;

	 public List<Map<String, String>> getAllDepartments(){
		 jdbcTemplate = custom.getJdbcTemplate();
			
			String sql =" select d1.id as departmentId,d1.name,d1.email,d1.departmentHead,d1.parent_id as parentid,d2.name as parentName from department d1 LEFT JOIN department d2 on d1.parent_id = d2.id" ;

			//System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "departmentId","name","email","departmentHead","parentid","parentName"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	 public Proje testParentId(int id){
		 jdbcTemplate = custom.getJdbcTemplate();
		 String sql = "SELECT id,GetParentIDByID(id) as parentid,GetAncestry(id) as allParentIds FROM department where id= "+id;
			List<Proje> retlist = jdbcTemplate.query(sql,
			new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(Proje.class));
			System.out.println(sql);
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 public List<Proje> populate(String sql ){
		 jdbcTemplate = custom.getJdbcTemplate();
				List<Proje> retlist = jdbcTemplate.query(sql,ParameterizedBeanPropertyRowMapper.newInstance(Proje.class));
					return retlist;
		 }
	 public Proje getByName(String  name){
		 jdbcTemplate = custom.getJdbcTemplate();
		 String sql = "SELECT lower(name) as name,id,parent_id,departmentHead  FROM department  where name= '"+name+"'";
			List<Proje> retlist = jdbcTemplate.query(sql,
			new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(Proje.class));
			System.out.println(sql);
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 public List<Map<String, String>> getDepartments(){
		 jdbcTemplate = custom.getJdbcTemplate();
			String sql =" select id,name,parent_id  as parent from department " ;

			//System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","name","parent"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	 public List<Proje> getDepartmentNames() {
		 jdbcTemplate = custom.getJdbcTemplate();
			String sql = "SELECT id,name from department  ";
			List<Proje> retlist = jdbcTemplate.query(sql,
			new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(Proje.class));
			if(retlist.size() > 0)
				return retlist;
			return null;
		}
	 public List<Proje> getChaildDepartments(int id) {
		 jdbcTemplate = custom.getJdbcTemplate();
			String sql = "SELECT * from department where parent_id=? ";
			List<Proje> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Proje.class));
			if(retlist.size() > 0)
				return retlist;
			return null;
		}
}
