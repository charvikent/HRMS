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
                            <h4 class="page-title">Holidays</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->
                
                <div class="tab-content">

								<!-- Add Department Form Starts Here -->
                                <div class="tab-pane active" id="departmentTab">
			                        <!-- BEGIN FORM-->
			                        <form:form commandName="holidayForm" method="post" id="addForm" class="form-horizontal" role="form">
			                                                        
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Holiday Name</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="name" placeholder="Enter Holiday Name" onkeydown="removeBorder(this.id);" class="form-control onlyCharacters" required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">From Date</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="fromDate1" placeholder="Enter From Date" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">To Date</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="toDate1" placeholder="Enter To Date" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Applicable</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="applicable" placeholder="Enter Applicable"  class="form-control onlyCharacters" />
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Description</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="description" placeholder="Enter Description"  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-8 control-label">Notify Applicable Employees</label>
			                                	<div class="col-md-2">
			                                    	<input type="checkbox" style="height: inherit;margin: 10px 0;" id="notifyapplicable" value="1" name="notifyapplicable" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
			                    	<div class="row">
										<div class="col-md-offset-4 col-md-8">
			                            	<div class="form-group">
			                                	<div class="col-md-offset-2 col-md-8">
			                                    	<input type="button" id="submitId" class="btn btn-success" value="Add Holiday" onclick="submitHoliday()"/>
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
								<!-- Add Department Form Ends Here -->
            
                               
                            </div>
                
            </div>
        </div>
        <!-- Body ends Here -->


							

<!-- <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script> -->
<script src="assets/js/jquery.min.js"></script>
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
<script src="https://cdn.jsdelivr.net/momentjs/2.18.1/moment.min.js"></script> 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.js"></script>        
<link href="css/fullcalendar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function () {
	
	
	 $("#fromDate1").datepicker({
		 beforeShowDay: function(date) {
		        var day = date.getDay();
		        return [(day != 0), ''];
		    },
	        numberOfMonths: 1,
	        dateFormat: "dd-MM-yy",
	        changeDate : true,
			changeMonth : true,
			changeYear : true,
	        onSelect: function (selected) {
	            var dt = new Date(selected);
	            dt.setDate(dt.getDate());
	            $("#toDate1").datepicker("option", "minDate", dt);
	        }
	    });
	    $("#toDate1").datepicker({
	    	beforeShowDay: function(date) {
	            var day = date.getDay();
	            return [(day != 0), ''];
	        },
	        numberOfMonths: 1,
	        dateFormat: "dd-MM-yy",
	        changeDate : true,
			changeMonth : true,
			changeYear : true,
	        onSelect: function (selected) {
	            var dt = new Date(selected);
	            dt.setDate(dt.getDate() );
	            $("#fromDate1").datepicker("option", "maxDate", dt);
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