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
                                    <li class="active">Holidays</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Jobs </h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="card-box">
                            <ul class="nav nav-tabs tabs-bordered">
                                <li class="active">
                                    <a href="#jobsTab" data-toggle="tab" aria-expanded="false">
                                        <span class="visible-xs"><i class="fa fa-home"></i></span>
                                        <span class="hidden-xs">Jobs</span>
                                    </a>
                                </li>
                                <li class="">
                                    <a href="#projectsTab" data-toggle="tab" aria-expanded="true">
                                        <span class="visible-xs"><i class="fa fa-bar-chart"></i></span>
                                        <span class="hidden-xs">Projects</span>
                                    </a>
                                </li>
                                <li class="">
                                    <a href="#clientsTab" data-toggle="tab" aria-expanded="true">
                                        <span class="visible-xs"><i class="fa fa-bar-chart"></i></span>
                                        <span class="hidden-xs">Clients</span>
                                    </a>
                                </li>
                            </ul>
                			<div class="tab-content">

								<!-- Add Jobs Form Starts Here -->
                                <div class="tab-pane active" id="jobsTab">
			                        <!-- BEGIN FORM-->
			                        <form:form commandName="jobsForm" method="post" id="addForm" class="form-horizontal" role="form">
			                                                        
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Job Name</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="name" placeholder="Enter Job Name" onkeydown="removeBorder(this.id);" class="form-control onlyCharacters" required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
<!-- 			                            created_time,name,projectId,startDate,endDate,hours,assignees,rateperhour,desicription,billableStatus -->
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Project </label>
			                                	<div class="col-md-8">
			                                    	<form:select path="projectId1" onkeydown="removeBorder(this.id);" class="form-control">
														<form:option value="">-- Choose Parent Department --</form:option>
														<form:options items="${projects}"></form:options> 
													</form:select>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Start Date</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="startDate1" placeholder="Enter From Date" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">End Date</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="endDate1" placeholder="Enter End Date"  class="form-control onlyCharacters" required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Hours</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="hours" placeholder="Enter Hours"  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Assignees</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="assignees" placeholder="Enter Assignees"  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Rate Per Hour</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="rateperhour" placeholder="Enter Rate Per Hour"  class="form-control onlyCharacters" required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Description</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="description" placeholder="Enter Desicription "  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Billable Status</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="billableStatus" placeholder="Enter Billable Status"  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
			                    	<div class="row">
										<div class="col-md-offset-4 col-md-8">
			                            	<div class="form-group">
			                                	<div class="col-md-offset-2 col-md-8">
			                                    	<input type="button" id="submitId" class="btn btn-success" value="Add Job" onclick="submitJobs()"/>
			                                    	<input type="button" class="btn btn-danger" id="cancel" onclick="resetForm();" value="Reset"/>
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
								<!-- Add Jobs Form Ends Here -->
								
								<!-- Add Projects Form Starts Here -->
								<div class="tab-pane" id="projectsTab">
                                	<h5>Projects Tab</h5>
                                	<div class="table-responsive">
			                            
									</div>
                                </div>
                                <!-- Add Projects Form Ends Here -->
                                
                                <!-- Add Clients Form Starts Here -->
                                <div class="tab-pane" id="clientsTab">
                                	<h5>Clients Tab</h5>
                                	<div class="table-responsive">
			                            
									</div>
                                </div>
                                <!-- Add Clients Form Ends Here -->
								
                            </div>
						</div>
					</div>
				</div>
                
            </div>
        </div>
        <!-- Body ends Here -->



							

<!-- <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script> -->
<script src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.orgchart.js"></script>
<script type="text/javascript" src="js/jobs.js"></script>
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="assets/plugins/datatables/buttons.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="assets/plugins/datatables/responsive.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.colVis.js" type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>        

<script type="text/javascript">
$(document).ready(function () {
	
	
	 $("#startDate1").datepicker({
	        minDate: 0,
	        dateFormat: "dd-MM-yy",
	        changeDate : true,
			changeMonth : true,
			changeYear : true,
	        onSelect: function (selected) {
	            var dt = new Date(selected);
	            dt.setDate(dt.getDate() + 1);
	            $("#endDate1").datepicker("option", "minDate", dt);
	        }
	    });
	    $("#endDate1").datepicker({
	        dateFormat: "dd-MM-yy",
	        changeDate : true,
			changeMonth : true,
			changeYear : true,
	        onSelect: function (selected) {
	            var dt = new Date(selected);
	            dt.setDate(dt.getDate() - 1);
	            $("#startDate1").datepicker("option", "maxDate", dt);
	        }
	    });
});

   /*  $("#fromDate1").datepicker({
        dateFormat: "dd-M-yy",
        minDate: 0,
        changeDate : true,
		changeMonth : true,
		changeYear : true,
        onSelect: function (date) {
            var dt2 = $('#toDate1');
            var startDate = $(this).datepicker('getDate');
            var minDate = $(this).datepicker('getDate');
            dt2.datepicker('setDate', minDate);
            startDate.setDate(startDate.getDate() + 30);
            //sets dt2 maxDate to the last day of 30 days window
            dt2.datepicker('option', 'maxDate', startDate);
            dt2.datepicker('option', 'minDate', minDate);
            $(this).datepicker('option', 'minDate', minDate);
        }
    });
    $('#toDate1').datepicker({
        dateFormat: "dd-M-yy",
        changeDate : true,
		changeMonth : true,
		changeYear : true
    });
}); */

	var listOrders1 = ${allOrders1};
 	if (listOrders1 != "") {
 		displayTable(listOrders1);
 	}
</script>