package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.EmployeeBean;
import com.aurospaces.neighbourhood.daosupport.CustomConnection;



public class BaseEmployeeDao{
	
	@Autowired CustomConnection custom;
	JdbcTemplate jdbcTemplate;
	
	public EmployeeSP  employeeSproc;
	
	public class EmployeeSP extends StoredProcedure{
		private static final String SPROC_NAME = "employee_sproc";
		public EmployeeSP( DataSource datasource){
			super( datasource, SPROC_NAME );
			declareParameter( new SqlParameter( "id", Types.INTEGER));
			declareParameter( new SqlParameter( "employee_id", Types.INTEGER));
			declareParameter( new SqlParameter( "prev_employee_id", Types.INTEGER));
			declareParameter( new SqlParameter( "created_time", Types.TIMESTAMP));
			declareParameter( new SqlParameter( "updated_time", Types.TIMESTAMP));
			declareParameter( new SqlParameter( "f_name", Types.VARCHAR));
			declareParameter( new SqlParameter( "l_name", Types.VARCHAR));
			declareParameter( new SqlParameter( "nick_name", Types.VARCHAR));
			declareParameter( new SqlParameter( "email_id", Types.VARCHAR));
			declareParameter( new SqlParameter( "dept_id", Types.VARCHAR));
			declareParameter( new SqlParameter( "designation_id", Types.VARCHAR));
			declareParameter( new SqlParameter( "work_loc", Types.VARCHAR));
			declareParameter( new SqlParameter( "reporting_to", Types.VARCHAR));
			declareParameter( new SqlParameter( "date_of_join", Types.DATE));
			declareParameter( new SqlParameter( "source_of_hire", Types.VARCHAR));
			declareParameter( new SqlParameter( "emp_status", Types.VARCHAR));
			declareParameter( new SqlParameter( "seating_loc", Types.VARCHAR));
			declareParameter( new SqlParameter( "emp_type", Types.VARCHAR));
			declareParameter( new SqlParameter( "work_phone", Types.VARCHAR));
			declareParameter( new SqlParameter( "phone_ext", Types.VARCHAR));
			declareParameter( new SqlParameter( "empRole", Types.VARCHAR));
			declareParameter( new SqlParameter( "contact_num", Types.VARCHAR));
			declareParameter( new SqlParameter( "emp_address", Types.VARCHAR));
			declareParameter( new SqlParameter( "alt_email", Types.VARCHAR));
			declareParameter( new SqlParameter( "d_o_b", Types.DATE));
			declareParameter( new SqlParameter( "tags", Types.VARCHAR));
			declareParameter( new SqlParameter( "marital_status", Types.VARCHAR));
			declareParameter( new SqlParameter( "job_desc", Types.VARCHAR));
			declareParameter( new SqlParameter( "about_me", Types.VARCHAR));
			declareParameter( new SqlParameter( "expertise", Types.VARCHAR));
			declareParameter( new SqlParameter( "d_o_e", Types.DATE));
			declareParameter( new SqlParameter( "gender", Types.VARCHAR));
			declareParameter( new SqlParameter( "prev_comp", Types.VARCHAR));
			declareParameter( new SqlParameter( "prev_job", Types.VARCHAR));
			declareParameter( new SqlParameter( "p_from_date", Types.VARCHAR));
			declareParameter( new SqlParameter( "p_to_date", Types.VARCHAR));
			declareParameter( new SqlParameter( "p_job_desc", Types.VARCHAR));
			declareParameter( new SqlParameter( "school_name", Types.VARCHAR));
			declareParameter( new SqlParameter( "qualification", Types.VARCHAR));
			declareParameter( new SqlParameter( "qualified_in", Types.VARCHAR));
			declareParameter( new SqlParameter( "s_c_d", Types.VARCHAR));
			declareParameter( new SqlParameter( "add_notes", Types.VARCHAR));
			declareParameter( new SqlParameter( "interests", Types.VARCHAR));
			declareParameter( new SqlParameter( "d_name", Types.VARCHAR));
			declareParameter( new SqlParameter( "d_relation", Types.VARCHAR));
			declareParameter( new SqlParameter( "d_dob", Types.VARCHAR));
			declareParameter( new SqlParameter( "exp_length", Types.INTEGER));
			declareParameter( new SqlParameter( "edu_length", Types.INTEGER));
			declareParameter( new SqlParameter( "dependents_lengh", Types.INTEGER));
			declareParameter( new SqlParameter( "password", Types.VARCHAR));
			declareParameter( new SqlOutParameter( "result", Types.VARCHAR));
			compile();
		}
		 public Object execute(EmployeeBean empBean, int expLength,int eduLength,int dependentsLengh){
			if(empBean.getCreated_time() == null){
				empBean.setCreated_time( new Date());
			}
			Map<String,Object> results = super.execute(empBean.getId(),empBean.getEmp_id(),empBean.getPrev_emp_id(),
					 new java.sql.Timestamp(empBean.getCreated_time().getTime()),
					 new java.sql.Timestamp(new Date().getTime()),
					 empBean.getFirstName(),empBean.getLastName(),empBean.getNickName(),empBean.getEmailId(),empBean.getDepartmentId(),
					 empBean.getDesignationId(),empBean.getWorkLocation(),empBean.getReportingTo(),
					 empBean.getDateOfJoinDateType(),
					 empBean.getSourceOfHire(),empBean.getStatus(),empBean.getSeatingLocation(),empBean.getEmployeeType(),
					 empBean.getWorkPhone(),empBean.getPhoneExtension(),
					 empBean.getEmployeeRole(),empBean.getContactNum(),empBean.getAddress(),empBean.getAlternateEmail(),
					 empBean.getDobDateType(),
					 empBean.getTags(),empBean.getMaritalStatus(),
					 empBean.getJobDesc(),empBean.getAboutMe(),empBean.getExpertise(),
					 empBean.getDateOfExitDateType(),
					 empBean.getGender(),
					 empBean.getPrevComp(),empBean.getPrevJob(),
					 empBean.getPrevFromDate(),
					 empBean.getPrevToDate(),
					 empBean.getPrevJobDesc(),empBean.getSchoolName(),empBean.getQualification(),empBean.getQualifiedIn(),
					 empBean.getDoc(),
					 empBean.getAdditionalNotes(),empBean.getInterests(),empBean.getDependentName(),
					 empBean.getDependentRelation(),
					 empBean.getDependentDob(),expLength,eduLength,dependentsLengh,empBean.getPassword()
					 );
			 return results.get("result");
		 }
		
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
