<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


		<!-- Body Starts Here -->
        <div class="wrapper">
            <div class="container">

                <!-- Page-Title -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="page-title-box">
                            <div class="btn-group pull-right">
                                <ol class="breadcrumb hide-phone p-0 m-0">
                                    <li><a href="">HRMS</a></li>
                                    <li><a href="">Organization</a></li>
                                    <li class="active">Groups</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Groups</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->
                
                <div class="tab-content">

								<!-- Add Department Form Starts Here -->
                                <div class="tab-pane active" id="departmentTab">
			                        <!-- BEGIN FORM-->
			                        <form:form commandName="addGroupForm" method="post" id="addForm" class="form-horizontal" role="form">
			                        <div class="row">
				                      <h5>Add Group</h5>
				                    </div>                                
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Group Name</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="name" placeholder="Enter Group Name" onkeydown="removeBorder(this.id);" class="form-control onlyCharacters" required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Description</label>
			                                	<div class="col-md-8">
			                                		<form:textarea path="description" placeholder="Enter description" rows="4" cols="6" onkeydown="removeBorder(this.id);" class="form-control onlyCharacters"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Group Email ID</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="groupEmailId" placeholder="Enter email id" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
			                        <div class="row">
				                      <h5>Add Users</h5>
				                    </div>                                
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<div class="col-md-8">
			                                    	<table id="users_table" class="table table-responsive row">
									                    <thead>
											                 <tr>
															 	<th align="left">Add Users</th>
																<th align="right"><span style="font:normal 12px agency, arial; color:blue; text-decoration:underline; cursor:pointer;" onclick="addMoreUsers();">
																		Add new user
												                  	</span>
												              	</th>
											                </tr>
														</thead>
														<tbody>
														<tr>
															<td valign="top">
																<form:select path="userIds" >
																	<form:option value="">-- Select --</form:option>
																	<form:options items="${usersList}" itemValue="emp_id" itemLabel="firstName" />
																</form:select>
															</td>
															<td valign="top">
																<form:select path="roleIds" >
																	<form:option value="">-- Select --</form:option>
																	<form:options items="${rolesList}" itemValue="id" itemLabel="name" />
																</form:select>
															</td>
													</tr>
													</tbody>
											</table>
			                                	</div>
			                            	</div>
			                            </div>
			                            <div class="row">
										<div class="col-md-offset-4 col-md-8">
			                            	<div class="form-group">
			                                	<div class="col-md-offset-2 col-md-8">
			                                    	<input type="button" class="btn btn-success" value="Add Time Logs" onclick="submitGroup()" />
			                                    	<!-- <input type="reset" class="btn btn-danger" id="cancel" value="Reset"/> -->
			                                    	<a class="btn btn-danger">Cancel</a>
												</div>
			                                </div>
			                        	</div>
			                       	</div>
			                		</form:form>
									<!-- END FORM-->
									
									<!-- DataTable Starts Here -->
									<div class="card-box table-responsive">
			                            <div id="tableId">
			                            <table id="datatable-colvid" class="table table-striped table-bordered">
			                                <thead>
			                                <tr>
			                                    <th>Group Name</th>
			                                    <th>Description</th>
												<th>Group Email ID</th>
												<th style="text-align: center;">Action</th>
			                                </tr>
			                                </thead>
			
			                                <tbody>
			                                
			                                </tbody>
			                            </table>
			                            </div>
									</div>
									<!-- DataTable ends Here -->
									
                                </div>
								<!-- Add Department Form Ends Here -->
            
                               
                            </div>
                
            </div>
        </div>
        <!-- Body ends Here -->



							

<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- <script src="assets/js/jquery.min.js"></script> -->
<script type="text/javascript" src="js/jquery.orgchart.js"></script>
<script type="text/javascript" src="js/holiday.js"></script>
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="assets/plugins/datatables/buttons.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="assets/plugins/datatables/responsive.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.colVis.js" type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>        

<script type="text/javascript">
var serviceUnitArray = {};
var baseUrl2 =$("#baseUrl1").val();

	 var listGroups = ${listGroupBeans};
	if (listGroups != "") {
		displayTable(listGroups);
	}

	
var rowCount = 1;
var dummy1 = $("#userIds").html();
var dummy2 = $("#roleIds").html();

function addMoreUsers() {
	rowCount ++;
	var recRow = "<tr role='row' id='rowCount"+rowCount+"'>"
	 +"<td>"
	 +"<select name='userId' id ='"+rowCount+"select1'></select>"
	+"</td>"
	+"<td>"
	 +"<select name='roleId' id ='"+rowCount+"select2'></select>"
	+"</td>"
	+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
	+"</tr>";
	 	/* var dummy1 = $("#userIds").html();
	 	if(typeof(dummy1)  === "undefined" ){
	 		dummy1 = $("#userId").html();
	 	}
	 	var dummy2 = $("#roleIds").html();
	 	if(typeof(dummy2)  === "undefined" ){
	 		dummy2 = $("#roleId").html();
	 	} */
		$('#users_table tbody').append(recRow);
		$('#'+rowCount+'select1').append(dummy1);
		$('#'+rowCount+'select2').append(dummy2);
}
function removeRow(removeNum) {
	jQuery('#rowCount'+removeNum).remove();
}

function updateGroup(id) {
	var transactionId = serviceUnitArray[id].id;
	$("#id").val(serviceUnitArray[id].id);
	$("#name").val(serviceUnitArray[id].name);
	$("#description").val(serviceUnitArray[id].description);
	$("#groupEmailId").val(serviceUnitArray[id].groupEmailId);
	var listUsers = serviceUnitArray[id].usersList;
	$("#users_table tbody").remove();
	if (listUsers == "") {
		rowCount ++;
		var recRow = "<tr role='row' id='rowCount"+rowCount+"'>"
		 +"<td>"
		 +"<select name='userId' id ='"+rowCount+"select1'></select>"
		+"</td>"
		+"<td>"
		 +"<select name='roleId' id ='"+rowCount+"select2'></select>"
		+"</td>"
		+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
		+"</tr>";
		
	 	$(recRow).appendTo("#users_table");
		$('#'+rowCount+'select1').append(dummy1);
		$('#'+rowCount+'select2').append(dummy2);
	}
	else if (listUsers != "") {
		 rowCount ++;
		 
		 $.each(listUsers,function(i, userObj) {
			
			/*var userRow ="<tr role='row' id='rowCount"+rowCount+"'>"
			 +"<td><input name='userId' type='text'  value='"+userObj.empName+"'/></td>"
			+"<td><input name='roleId' type='text'  value='"+userObj.roleName+"'/></td>"
			+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>" 
			+"</tr>";*/
			var recRow = "<tr role='row' id='rowCount"+rowCount+"'>"
			 +"<td>"
			 +"<select name='userId' id ='"+rowCount+"select1'></select>"
			+"</td>"
			+"<td>"
			 +"<select name='roleId' id ='"+rowCount+"select2'></select>"
			+"</td>"
			+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
			+"</tr>";
			
		 	$(recRow).appendTo("#users_table");
			$('#'+rowCount+'select1').append(dummy1);
			$('#'+rowCount+'select2').append(dummy2);
			$('#'+rowCount+'select1').val(userObj.empId);
			$('#'+rowCount+'select1').trigger("chosen:updated");
			$('#'+rowCount+'select2').val(userObj.roleId);
			$('#'+rowCount+'select2').trigger("chosen:updated");
					/* var userRow ="<tr role='row' id='rowCount"+rowCount+"'>"
					+"<td>"
					+"<select name='userId'>"
						+"<option value='"+userObj.empId+"'>"+userObj.empName+"</option>"
					+"</select>"
					+"</td>"
					+"<td>"
					+"<select name='roleId'>"
						+"<option value='"+userObj.roleId+"'>"+userObj.roleName+"</option>"
					+"</select>"
					+"</td>"
					+"</tr>";
					
					var optionsForClass = "",optionsForClass2 = "";
					optionsForClass = $("#userId");
					optionsForClass2 = $("#roleId");
					//optionsForClass.append(new Option("-- Select --", ""));
					//optionsForClass2.append(new Option("-- Select --", ""));
					var userid=userObj.empId;
					var username=userObj.empName;
					optionsForClass.append(new Option(username, userid));
					var roleid=userObj.roleId;
					var rolename=userObj.roleName;
					optionsForClass2.append(new Option(rolename, roleid));
					$('#userId').trigger("chosen:updated");
					$('#roleId').trigger("chosen:updated"); */
					/* $("#userId").val(userObj[id].empId);
					$('#userId').trigger("chosen:updated");
					$("#roleId").val(userObj[id].roleId);
					$('#roleId').trigger("chosen:updated"); */
					//$(userRow).appendTo("#users_table");
					rowCount++;
				});
		
	}
	
}

function deleteGroup(id){
	var checkstr =  confirm('Are you sure you want to delete this?');
	if(checkstr == true){
	var formData = new FormData();
    
     formData.append('group_id', id);
	$.fn.makeMultipartRequest('POST', 'deleteGroup', false,
			formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
		alert(jsonobj.message);
		var alldata = jsonobj.listOfGroups;
		$("#datatable-colvid tbody").remove();
		displayTable(alldata);
	});
	}
	
}

	function displayTable(listGroups) {
 		//$("#datatable-colvid tbody").remove();
		serviceUnitArray = {};
		$.each(listGroups,
							function(i, groupObj) {
								serviceUnitArray[groupObj.id] = groupObj;
								var id = '"' + groupObj.id + '"id';
								var tblRow =  "<tr>"
									+ "<td title='"+groupObj.name+"'>"
									+ groupObj.name
									+ "</td>"
									+ "<td title='"+groupObj.description+"'>"
									+ groupObj.description
									+ "</td>"
									+ "<td title='"+groupObj.groupEmailId+"'>"
									+ groupObj.groupEmailId
									+ "</td>"
									+ "<td style='text-align: center;'><a  onclick='updateGroup("
									+ groupObj.id
									+ ")'><i style='color: green;' class='fa fa-edit'></i></a>&nbsp;|&nbsp;"
									+ "<a  onclick='deleteGroup("
									+ groupObj.id
									+ ")'><i style='color: red;' class='fa fa-trash'></i></a></td>" + "</tr >";
							$(tblRow).appendTo("#datatable-colvid tbody");

							//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
						});
	}

 function submitGroup() {
	
	var name =  $("#name").val();
	var description =  $("#description").val();
	var emailId = $("#groupEmailId").val();
	var userids="" , roleids="" ;
	for(var i=2;i<=rowCount;i++){
		userids += $('#'+i+'select1').val()+"##";
		roleids += $('#'+i+'select2').val()+"##";
	}
	
	var userid = $("#userIds").val();
	var roleid = $("#roleIds").val();
	if(typeof(userid)  != "undefined" ){
		userids = userids + userid + "##";
	}
	if(typeof(roleid)  != "undefined" ){
		roleids = roleids + roleid+"##";
	}
	
	var formData = new FormData();
    
    formData.append('name', name);
    formData.append('description',description);
    formData.append('groupEmailId',emailId);
    formData.append('userIds',userids);
    formData.append('roleIds',roleids);
    $.fn.makeMultipartRequest('POST', 'addGroup', false,
			formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
		alert(jsonobj.message);
		var alldata = jsonobj.allGroupsList;
		if(typeof(alldata)  === "undefined" ){
		
		}else{
			$("#datatable-colvid tbody").remove();
			displayTable(alldata);
		}
		if(jsonobj.message =="duplicate" ){
			
		}else{
			$("#id").val("0");
			$('#addForm').trigger("reset");
			
		}
	});
    
} 



</script>