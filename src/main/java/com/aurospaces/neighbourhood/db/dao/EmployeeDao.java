package com.aurospaces.neighbourhood.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.DependentBean;
import com.aurospaces.neighbourhood.bean.EducationBean;
import com.aurospaces.neighbourhood.bean.EmployeeBean;
import com.aurospaces.neighbourhood.bean.WorkExperienceBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;
import com.aurospaces.neighbourhood.db.basedao.BaseEmployeeDao;


@Repository(value = "EmployeeDao")
public class EmployeeDao extends BaseEmployeeDao{
	
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate;
		
	public void saveOrUpdate(final EmployeeBean empBean, int expLength,int eduLength,int dependentsLengh){
		jdbcTemplate = custom.getJdbcTemplate();
		this.employeeSproc = new EmployeeSP(jdbcTemplate.getDataSource());
		String res = (String)employeeSproc.execute(empBean,expLength,eduLength,dependentsLengh);
		System.out.println("result:"+res);
	}
	
	public List<WorkExperienceBean> getallExperienceDetails(int empId){
		jdbcTemplate = custom.getJdbcTemplate();
		String select_query = "select id, emp_id, prevComp, prevJob, prevFromDate, "
							+"  prevToDate, prevJobDesc from work_experience where emp_id = ?";
		List<WorkExperienceBean> retlist = jdbcTemplate.query(select_query,
				new Object[]{empId},
				ParameterizedBeanPropertyRowMapper.newInstance(WorkExperienceBean.class));
			return retlist;
	}

	public List<EducationBean> getallEducationDetails(int empId){
		jdbcTemplate = custom.getJdbcTemplate();
		String select_query = "select id, emp_id, schoolName, qualification, qualifiedIn, schoolCompletionDate, "
								+" additionalNotes, interests from education where emp_id = ?";
		List<EducationBean> retlist = jdbcTemplate.query(select_query,
				new Object[]{empId},
				ParameterizedBeanPropertyRowMapper.newInstance(EducationBean.class));
			return retlist;
	}
	public
	List<DependentBean> getallDependentDetails(int empId){
		jdbcTemplate = custom.getJdbcTemplate();
		String select_query = "select id, emp_id, dependentName, dependentRelation, dependentDob from dependent_info where emp_id = ?";
		List<DependentBean> retlist = jdbcTemplate.query(select_query,
				new Object[]{empId},
				ParameterizedBeanPropertyRowMapper.newInstance(DependentBean.class));
			return retlist;
	}
	
	public List<EmployeeBean> getallEmployeeDetails(int empId,String lastName,String firstName,String emailId){
		jdbcTemplate = custom.getJdbcTemplate();
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select emp.id as id, emp_id, "//DATE_FORMAT(emp.created_time, '%d-%M-%Y') as created_time, "
				// +" DATE_FORMAT(emp.updated_time, '%d-%M-%Y') as updated_time, "
				 + " firstName, lastName, nickName, emailId, departmentId, designationId, workLocation, reportingTo, "
				 +" ifnull((select dep.name from department dep where dep.id = emp.departmentId),'') as departmentName, "
				 +" ifnull((select desig.name from designation desig where desig.id = emp.designationId),'') as designationName, "
				 +" ifnull((select concat(e.firstName,' ',e.lastName) from employee e where e.emp_id = emp.reportingTo),'') as reportingToName, " 
				 +" ifnull((select source.name from source_of_hire source where source.id = emp.sourceOfHire),'') as sourceOfHireName, " 
				 +" ifnull((select s.name from status s where s.id = emp.status),'') as statusName, " 
				 +" ifnull((select empType.name from employee_type empType where empType.id = emp.employeeType),'') as employeeTypeName, " 
				 +" ifnull((select r.name from roles r where r.id = emp.employeeRole),'') as employeeRoleName, " 
				 +" ifnull((select ms.name from marital_status ms where ms.id = emp.maritalStatus),'') as maritalStatusName, " 
				 +" ifnull((select g.name from gender g where g.id = emp.gender),'') as genderName, " 
				 +" ifnull(DATE_FORMAT(dateOfJoin, '%d-%M-%Y'),'') as dateOfJoin, sourceOfHire, status, seatingLocation, employeeType, workPhone, " 
				 +" phoneExtension, employeeRole, contactNum, address, alternateEmail, ifnull(DATE_FORMAT(dob, '%d-%M-%Y'),'') as dob, tags, maritalStatus, " 
				 +" jobDesc, aboutMe, expertise,  ifnull(DATE_FORMAT(dateOfExit, '%d-%M-%Y'),'') as dateOfExit, gender from employee emp where 1=1");
		
		if (empId != 0) {
			objStringBuffer.append(" and emp.emp_id=" + empId);
		}
		if (StringUtils.isNotBlank(lastName)) {
			objStringBuffer.append(" and emp.lastName=" + lastName);
		}
		if (StringUtils.isNotBlank(firstName)) {
			objStringBuffer.append(" and emp.firstName=" + firstName);
		}
		if (StringUtils.isNotBlank(emailId)) {
			objStringBuffer.append(" and emp.emailId=" + emailId);
		}
		String sql = objStringBuffer.toString();
		List<EmployeeBean> retlist = jdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(EmployeeBean.class));
			return retlist;
			
		}
	
	public int getNewEmpId(){
		jdbcTemplate = custom.getJdbcTemplate();
		String sql = "select max(emp_id) from employee";
		int maxId = jdbcTemplate.queryForInt(sql);
		return (maxId+1);
	}
	
	@Transactional
	public boolean delete(int id, int emp_id) {
		jdbcTemplate = custom.getJdbcTemplate();
		boolean isDeleted = false;
		try{
			
			SimpleJdbcCall simpleJdbcCall  = new SimpleJdbcCall(jdbcTemplate).withProcedureName("employee_delete_sproc");
			Map<String, Object> inParamMap = new HashMap<String, Object>();
			inParamMap.put("rec_id", id);
			inParamMap.put("employee_id", emp_id);
			SqlParameterSource in = new MapSqlParameterSource(inParamMap);
			Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
			isDeleted = Boolean.valueOf((String)simpleJdbcCallResult.get("isDeleted")).booleanValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return isDeleted;
	}
		

}
