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
                                    <li class="active">Time Sheet</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Time Sheet</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->
                
                <div class="tab-content">

								<!-- Add Department Form Starts Here -->
                                <div class="tab-pane active" id="departmentTab">
			                        <!-- BEGIN FORM-->
			                        <form:form action="addTimeSheet.htm" commandName="packCmd" method="post" id="addForm" class="form-horizontal" role="form">
			                                                        
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputPeriod" class="col-md-4 control-label">Period</label>
			                                	<div class="col-md-8">
			                                    	<form:select path="period" tabindex="1" class="form-control" >
															<form:option value="thisWeek">This Week</form:option>
															<form:option value="today">Today</form:option>
															<form:option value="lastWeek">Last Week</form:option>
															<form:option value="yesterday">Yesterday</form:option>
															<form:option value="thisMonth">This Month</form:option>
															<form:option value="lastMonth">Last Month</form:option>
															<form:option value="custom">Custom</form:option>
							                         </form:select>
			                                	</div>
			                            	</div>
			                            </div>
			                          
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmployeeName" class="col-md-4 control-label">Employee Name</label>
			                                	<div class="col-md-8">
			                                       <form:select path="empName" tabindex="1" class="form-control" >
								                      <form:option value="1sri">1sri</form:option>
							                       </form:select>
			                                 	</div>
			                            	 </div>
			                            </div>
									
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputClients" class="col-md-4 control-label">Clients</label>
			                                	<div class="col-md-8">
			                                      <form:select path="clients" tabindex="1" class="form-control" >
								                     <form:option value="allClients">All Clients</form:option>
							                      </form:select>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputProjects" class="col-md-4 control-label">Projects</label>
			                                	<div class="col-md-8">
			                                      <form:select path="projects" tabindex="1" class="form-control" >
								                    <form:option value="allProjs">All Projects</form:option>
							                       </form:select>
			                                     
			                                 	</div>
			                            	 </div>
			                            </div>
									
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputJobs" class="col-md-4 control-label">Jobs</label>
			                                	<div class="col-md-8">
			                                      <form:select path="jobs" tabindex="1" class="form-control" >
								                    <form:option value="allJobs">All Jobs</form:option>
							                      </form:select>                      
			                                     
			                                 	</div>
			                            	 </div>
			                            </div>
									
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
										<div class="col-md-offset-4 col-md-7">
			                            	<div class="form-group">
			                                	<div class="col-md-offset-4 col-md-8">
			                                    	<input type="Submit" class="btn btn-success" value="Add Time Sheet " onclick="submitDesignation()"/>
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



							

<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- <script src="assets/js/jquery.min.js"></script> -->
<script type="text/javascript" src="js/jquery.orgchart.js"></script>
<script type="text/javascript" src="js/designation.js"></script>
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="assets/plugins/datatables/buttons.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="assets/plugins/datatables/responsive.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.colVis.js" type="text/javascript"></script>
        

<%-- <!--  <script type="text/javascript">


	var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}
</script>






























		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">Create Timesheet</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Spacer starts -->
<form:form action="addTimeSheet.htm" commandName="packCmd" method="post" id="cls-form" class="form-horizontal">

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<div align="left"><h4>Time Sheet</h4>
			<table>
				<tbody>
					<tr>
						<td>Period</td>
						<td>
							<form:select path="period" tabindex="1" class="form-control" >
								<form:option value="thisWeek">This Week</form:option>
								<form:option value="today">Today</form:option>
								<form:option value="lastWeek">Last Week</form:option>
								<form:option value="yesterday">Yesterday</form:option>
								<form:option value="thisMonth">This Month</form:option>
								<form:option value="lastMonth">Last Month</form:option>
								<form:option value="custom">Custom</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Employee Name</td>
						<td>
							<form:select path="empName" tabindex="1" class="form-control" >
								<form:option value="1sri">1sri</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Clients</td>
						<td>
							<form:select path="clients" tabindex="1" class="form-control" >
								<form:option value="allClients">All Clients</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Projects</td>						
						<td>
							<form:select path="projects" tabindex="1" class="form-control" >
								<form:option value="allProjs">All Projects</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Jobs</td>
						<td>
							<form:select path="jobs" tabindex="1" class="form-control" >
								<form:option value="allJobs">All Jobs</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Billable Status</td>
						<td>
							<form:select path="billableStatus" tabindex="1" class="form-control" >
								<form:option value="all">All</form:option>
								<form:option value="billable">Billable</form:option>
								<form:option value="nonbillable">Non-Billable</form:option>
							</form:select>
						</td>
					</tr>
				</tbody>
			</table>
		</div><br>
		
				<div>
			<input type="submit" value="Next">
			<input type="button" value="Cancel">
		</div>
	</form:form>
	
		
					<!-- Spacer ends -->

				</div>
				<!-- Container fluid ends -->

			</div>
			<!-- Main Container ends -->

		</div>
 --%>
