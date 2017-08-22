package com.aurospaces.neighbourhood.bean;

import java.util.Date;
import java.util.List;

public class EmployeeBean {
	private int id   = 0;
	private int emp_id;
	private int prev_emp_id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String nickName;
	private String departmentId;
	private String designationId;
	private String designationName;
	private String departmentName;
	private String reportingToName;
	private String sourceOfHireName;
	private String statusName;
	private String employeeTypeName;
	private String employeeRoleName;
	private String maritalStatusName;
	private String genderName;
	private String workLocation;
	private String reportingTo;
	private String dateOfJoin ;
	private Date dateOfJoinDateType ;
	private String sourceOfHire;
	private String status;
	private String seatingLocation;
	private String employeeType;
	private String workPhone;
	private String phoneExtension;
	private String employeeRole;
	private String title;
	private String contactNum;
	private String address;
	private String alternateEmail;
	private String dob;
	private Date dobDateType ;
	private String maritalStatus;
	private String tags;
	private String jobDesc;
	private String aboutMe;
	private String expertise;
	private String dateOfExit;
	private Date dateOfExitDateType ;
	private String gender;
	private List<WorkExperienceBean> experienceDetails;
	private List<EducationBean> educationDetails;
	private List<DependentBean> dependentDetails;
	private String prevComp;
	private String prevJob;
	private String prevFromDate;
	private Date prevFromDate2 ;
	private String prevToDate;
	private Date prevToDate2 ;
	private String prevJobDesc;
	private String schoolName;
	private String qualification;
	private String qualifiedIn;
	private String doc;
	private Date schoolCompletionDate;
	private String additionalNotes;
	private String interests;
	private String dependentName;
	private String dependentRelation;
	private String dependentDob;
	private Date dependentDobDateType ;
	private Date created_time;
	private Date updated_time;
	private String  name;
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getPrev_emp_id() {
		return prev_emp_id;
	}
	public void setPrev_emp_id(int prev_emp_id) {
		this.prev_emp_id = prev_emp_id;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public String getReportingTo() {
		return reportingTo;
	}
	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getPhoneExtension() {
		return phoneExtension;
	}
	public void setPhoneExtension(String phoneExtension) {
		this.phoneExtension = phoneExtension;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public List<WorkExperienceBean> getExperienceDetails() {
		return experienceDetails;
	}
	public void setExperienceDetails(List<WorkExperienceBean> experienceDetails) {
		this.experienceDetails = experienceDetails;
	}
	public List<EducationBean> getEducationDetails() {
		return educationDetails;
	}
	public void setEducationDetails(List<EducationBean> educationDetails) {
		this.educationDetails = educationDetails;
	}
	public List<DependentBean> getDependentDetails() {
		return dependentDetails;
	}
	public void setDependentDetails(List<DependentBean> dependentDetails) {
		this.dependentDetails = dependentDetails;
	}
	public String getPrevComp() {
		return prevComp;
	}
	public void setPrevComp(String prevComp) {
		this.prevComp = prevComp;
	}
	public String getPrevJob() {
		return prevJob;
	}
	public void setPrevJob(String prevJob) {
		this.prevJob = prevJob;
	}
	public String getPrevFromDate() {
		return prevFromDate;
	}
	public void setPrevFromDate(String prevFromDate) {
		this.prevFromDate = prevFromDate;
	}
	public String getPrevToDate() {
		return prevToDate;
	}
	public void setPrevToDate(String prevToDate) {
		this.prevToDate = prevToDate;
	}
	public String getPrevJobDesc() {
		return prevJobDesc;
	}
	public void setPrevJobDesc(String prevJobDesc) {
		this.prevJobDesc = prevJobDesc;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getQualifiedIn() {
		return qualifiedIn;
	}
	public void setQualifiedIn(String qualifiedIn) {
		this.qualifiedIn = qualifiedIn;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getDependentName() {
		return dependentName;
	}
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	public String getDependentRelation() {
		return dependentRelation;
	}
	public void setDependentRelation(String dependentRelation) {
		this.dependentRelation = dependentRelation;
	}
	public String getDependentDob() {
		return dependentDob;
	}
	public void setDependentDob(String dependentDob) {
		this.dependentDob = dependentDob;
	}
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public String getSourceOfHire() {
		return sourceOfHire;
	}
	public void setSourceOfHire(String sourceOfHire) {
		this.sourceOfHire = sourceOfHire;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSeatingLocation() {
		return seatingLocation;
	}
	public void setSeatingLocation(String seatingLocation) {
		this.seatingLocation = seatingLocation;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	public String getDateOfExit() {
		return dateOfExit;
	}
	public void setDateOfExit(String dateOfExit) {
		this.dateOfExit = dateOfExit;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public Date getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}
	public Date getDateOfJoinDateType() {
		return dateOfJoinDateType;
	}
	public void setDateOfJoinDateType(Date dateOfJoinDateType) {
		this.dateOfJoinDateType = dateOfJoinDateType;
	}
	public Date getDobDateType() {
		return dobDateType;
	}
	public void setDobDateType(Date dobDateType) {
		this.dobDateType = dobDateType;
	}
	public Date getDateOfExitDateType() {
		return dateOfExitDateType;
	}
	public void setDateOfExitDateType(Date dateOfExitDateType) {
		this.dateOfExitDateType = dateOfExitDateType;
	}
	public Date getPrevFromDate2() {
		return prevFromDate2;
	}
	public void setPrevFromDate2(Date prevFromDate2) {
		this.prevFromDate2 = prevFromDate2;
	}
	public Date getPrevToDate2() {
		return prevToDate2;
	}
	public void setPrevToDate2(Date prevToDate2) {
		this.prevToDate2 = prevToDate2;
	}
	public Date getSchoolCompletionDate() {
		return schoolCompletionDate;
	}
	public void setSchoolCompletionDate(Date schoolCompletionDate) {
		this.schoolCompletionDate = schoolCompletionDate;
	}
	public Date getDependentDobDateType() {
		return dependentDobDateType;
	}
	public void setDependentDobDateType(Date dependentDobDateType) {
		this.dependentDobDateType = dependentDobDateType;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getReportingToName() {
		return reportingToName;
	}
	public void setReportingToName(String reportingToName) {
		this.reportingToName = reportingToName;
	}
	public String getSourceOfHireName() {
		return sourceOfHireName;
	}
	public void setSourceOfHireName(String sourceOfHireName) {
		this.sourceOfHireName = sourceOfHireName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getEmployeeTypeName() {
		return employeeTypeName;
	}
	public void setEmployeeTypeName(String employeeTypeName) {
		this.employeeTypeName = employeeTypeName;
	}
	public String getEmployeeRoleName() {
		return employeeRoleName;
	}
	public void setEmployeeRoleName(String employeeRoleName) {
		this.employeeRoleName = employeeRoleName;
	}
	public String getMaritalStatusName() {
		return maritalStatusName;
	}
	public void setMaritalStatusName(String maritalStatusName) {
		this.maritalStatusName = maritalStatusName;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getDesignationId() {
		return designationId;
	}
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	
}
