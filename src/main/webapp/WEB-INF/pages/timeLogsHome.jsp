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
                                    <li><a href="">Time Tracker</a></li>
                                    <li class="active">Time Logs</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Time Logs</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->
                
                <div class="tab-content">

								<!-- Add Department Form Starts Here -->
                                <div class="tab-pane active" id="departmentTab">
			                        <!-- BEGIN FORM-->
			                        <form:form action="addTimeLogs.htm" commandName="packCmd" method="post" id="addForm" class="form-horizontal" role="form">
			                                                        
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputProjectName" class="col-md-4 control-label">Project Name</label>
			                                	<div class="col-md-8">
			                                    <form:select path="projName" tabindex="1" class="form-control" >
														<form:option value="">-- Select --</form:option>
														<form:option value="proj1">proj1</form:option>
														<form:option value="project2">project2</form:option>
												</form:select>
						
			                                	</div>
			                            	</div>
			                            </div>
			                          
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputJobName" class="col-md-4 control-label">Job Name</label>
			                                	<div class="col-md-8">
			                                      <form:select path="jobName" tabindex="1" class="form-control" >
														<form:option value="">-- Select --</form:option>
														<form:option value="dev1">dev1</form:option>
														<form:option value="dev2">dev2</form:option>
							                     </form:select>
			                                 	</div>
			                            	 </div>
			                            </div>
									
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputWorkItem" class="col-md-4 control-label">Work Item</label>
			                                	<div class="col-md-8">
			                                     <form:input path="workItem" tabindex="5" placeholder="Enter Work Item" class="form-control  onlyCharacters" />
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputDate" class="col-md-4 control-label">Date</label>
			                                	<div class="col-md-8">
			                                      <form:input path="date1" tabindex="5" placeholder="Enter Date" class="form-control onlyCharacters" />
			                                 	</div>
			                            	 </div>
			                            </div>
									
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputDescription" class="col-md-4 control-label">Description</label>
			                                	<div class="col-md-8">
			                                      <form:textarea path="description" class="form-control onlyCharacters" rows="4" cols="10"/>			                                 	
			                                   </div>
			                            	 </div>
			                            </div>
			                          
			                          
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputDate" class="col-md-4 control-label">Hours</label>
			                                	<div class="col-md-8">
									                                     
													<form:radiobutton path="hours" value="HOURS" label="Hours" onclick="displayTimeField()"/>
													<form:radiobutton path="hours" value="START_END" label="Start&End" onclick="displayStartEndTime()"/>
													<form:radiobutton path="hours" value="START_TIMER" label="StartTimer" onclick="hideTimeFields()"/>
			                                     
							                    <div id="timeField1" hidden="true">
													
													 <div class="input-group clockpicker">
<form:input path="loggedHours" tabindex="5" placeholder="Enter name"  class="form-control" />

      <span class="input-group-addon">

        <span class="glyphicon glyphicon-time"></span>
     </span>
    </div>
												</div>
												<div id="timeField2" hidden="true">
													<form:input path="startTime" tabindex="5" placeholder="Enter name" class="form-control onlyCharacters timepicker" />
													<form:input path="endTime" tabindex="5" placeholder="Enter name" class="form-control onlyCharacters timepicker" />
												</div>
												
			                                 	</div>
			                            	 </div> 
			                            </div>
			                           </div>
			                           <div class="row">
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputBillableSatus" class="col-md-4 control-label">Billable Status</label>
			                                	<div class="col-md-8">
			                                      <form:select path="billableStatus" tabindex="1" class="form-control" >
													<form:option value="all">All</form:option>
													<form:option value="billable">Billable</form:option>
													<form:option value="nonbillable">Non-Billable</form:option>
							                     </form:select>                      
			                                     
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
			                    	<div class="row">
										<div class="col-md-offset-4 col-md-8">
			                            	<div class="form-group">
			                                	<div class="col-md-offset-2 col-md-8">
			                                    	<input type="Submit" class="btn btn-success" value="Add Time Logs " onclick="submitDesignation()"/>
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
			                                    <th>Designation Name</th>
												<th>Email</th>
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



							



  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
		<%-- <div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">Add Time Logs</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Spacer starts -->
	<form:form action="addTimeLogs.htm" commandName="packCmd" method="post" id="cls-form" class="form-horizontal">
		<div align="left"><h4>Time Log</h4>
			<table>
				<tbody>
					<tr>
						<td>Project Name</td>
						<td>
						
						
						
						
						<td></td>
						<td></td>
							<form:select path="projName" tabindex="1" class="form-control" >
								<form:option value="">-- Select --</form:option>
								<form:option value="proj1">proj1</form:option>
								<form:option value="project2">project2</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Job Name</td>
						<td>
							<form:select path="jobName" tabindex="1" class="form-control" >
								<form:option value="">-- Select --</form:option>
								<form:option value="dev1">dev1</form:option>
								<form:option value="dev2">dev2</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Work Item</td>
						<td>
							<form:input path="workItem" tabindex="5" placeholder="Enter name" class="form-control  onlyCharacters" />
						</td>
					</tr>
					<tr>
						<td>Date</td>						
						<td>
							<form:input path="date1" tabindex="5" placeholder="Enter Date" class="form-control  onlyCharacters" />
						</td>
					</tr>
					<tr>
						<td>Description</td>
						<td>
							<form:textarea path="description" rows="4" cols="10"/>
						</td>
					</tr>
					<tr>
						<td>Hours</td>
						<td>
							<form:radiobutton path="hours" value="HOURS" label="Hours" onclick="displayTimeField()"/>
							<form:radiobutton path="hours" value="START_END" label="Start&End" onclick="displayStartEndTime()"/>
							<form:radiobutton path="hours" value="START_TIMER" label="StartTimer" onclick="hideTimeFields()"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div id="timeField1" hidden="true">
								<form:input path="loggedHours" tabindex="5" placeholder="Enter name" class="form-control  onlyCharacters timepicker" />
							</div>
							<div id="timeField2" hidden="true">
								<table>
									<tr>
										<td>
											<form:input path="startTime" tabindex="5" placeholder="Enter name" class="form-control  onlyCharacters timepicker" />
										</td>
										<td>
											<form:input path="endTime" tabindex="5" placeholder="Enter name" class="form-control  onlyCharacters timepicker" />
										</td>
									</tr>
								</table>
							</div>
							
						</td>
					</tr>
					
					<tr>
						<td>Billable Status</td>
						<td>
							<form:select path="billableStatus" tabindex="1" class="form-control" >
								<form:option value="">-- Select --</form:option>
								<form:option value="billable">Billable</form:option>
								<form:option value="nonbillable">Non-Billable</form:option>
							</form:select>
						</td>
					</tr>
					
				</tbody>
			</table>
		</div><br>
		
				<div>
			<input type="submit" value="Submit">
			<input type="button" value="Cancel">
		</div>
	</form:form>
	
		
					<!-- Spacer ends -->

				</div>
				<!-- Container fluid ends -->

			</div>
			<!-- Main Container ends -->

		</div>
		
		
<!-- DataTable Starts Here -->
									<div class="card-box table-responsive">
			                            <div id="tableId">
			                            <table id="datatable-colvid" class="table table-striped table-bordered">
			                                <thead>
			                                <tr>
			                                    <th>Designation Name</th>
												<th>Email</th>
												<th style="text-align: center;">Action</th>
			                                </tr>
			                                </thead>
			
			                                <tbody>
			                                
			                                </tbody>
			                            </table>
			                            </div>
									</div>
									<!-- DataTable ends Here -->
 --%>									
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- <script src="assets/js/jquery.min.js"></script> -->
<script type="text/javascript" src="js/jquery.orgchart.js"></script>
<script type="text/javascript" src="js/timeLogs.js"></script>
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="assets/plugins/datatables/buttons.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="assets/plugins/datatables/responsive.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.colVis.js" type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>  
	<script type="text/javascript" src="dist/bootstrap-clockpicker.min.js"></script>

<link rel="stylesheet" type="text/css" href="dist/jquery-clockpicker.css">
<script type="text/javascript" src="dist/jquery-clockpicker.min.js"></script>
<script type="text/javascript">
$('.clockpicker').clockpicker({

placement: 'bottom', // clock popover placement

align: 'left',       // popover arrow align

donetext: 'Done',     // done button text

autoclose: false,    // auto close when minute is selected

vibrate: true        // vibrate the device when dragging clock hand

});

</script>

<script type="text/javascript">
var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}
function displayTimeField(){
	$("#timeField1").show();		
	$("#timeField2").hide();
}

function displayStartEndTime(){
	$("#timeField1").hide();		
	$("#timeField2").show();
		
	
}

function hideTimeFields(){
	$("#timeField1").hide();		
	$("#timeField2").hide();
		
	
}

$("#date1").datepicker({
    numberOfMonths: 1,
    minDate: 0,
    dateFormat: "dd-MM-yy",
    changeDate : true,
	changeMonth : true,
	changeYear : true,
});

// $('#timeField1').timepicker();
// $('#startTime').timepicker({
  
//   'interval': '15'
// });
// $('.timepicker').timepicker({
// 	timeFormat: 'HH:mm:ss',
//     startTime: new Date(0,0,0,15,0,0), // 3:00:00 PM - noon
//     interval: 15 // 15 minutes
// });
//     $('timepicker').timepicker('setTime', new Date());
    

</script>