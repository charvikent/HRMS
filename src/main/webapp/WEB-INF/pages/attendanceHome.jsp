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
                                    <li class="active">Attendance</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Attendance</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->
                
                <div class="tab-content">

								<!-- Add Department Form Starts Here -->
                                <div class="tab-pane active" id="departmentTab">
			                        <!-- BEGIN FORM-->
			                        <form:form commandName="attendanceForm" method="post" id="searchForm" class="form-horizontal" role="form">
			                                                        
									<div class="row">
										<%-- <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">

			                                	<label for="inputEmail1" class="col-md-4 control-label">Client Name</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="clientName" placeholder="Enter Client Name" onkeydown="removeBorder(this.id);" class="form-control onlyCharacters" required="true"/>
			                                	</div>
			                            	</div>
			                            </div> --%>
			                        	<%-- <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Currency</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="currency" placeholder="Enter Currency" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div> --%>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Employee Name</label>
			                                	<div class="col-md-8">
			                                    	<form:select path="name" tabindex="1" class="form-control" >
														<form:option value="">-- Select --</form:option>
																<form:options items="${employee}"></form:options>
														</form:select>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
			                    	<div class="row">
										<div class="col-md-offset-4 col-md-8">
			                            	<div class="form-group">
			                                	<div class="col-md-offset-2 col-md-8">
			                                    	<input type="button" id="submitId" class="btn btn-success" value="Search" onclick="submitSearch()"/>
			                                    	<input type="reset" class="btn btn-danger" id="cancel" value="Reset"/>
<!-- 			                                    	<a class="btn btn-danger" href=''>Cancel</a> -->
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
			                                    <th>Employee Name</th>
			                                    <th>Working Day</th> 
			                                    <th style="text-align: center;">Total Time</th>
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

<spring:url value="http://code.jquery.com/jquery-1.11.1.min.js"
	var="jqueryJs" />
<script src="${jqueryJs}"></script>

<%-- <spring:url value="js/client.js"
	var="clientJs" />
<script src="${clientJs}"></script> --%>

<!-- <script src="assets/js/jquery.min.js"></script> -->

<script type="text/javascript" src="js/attendance.js"></script>
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="assets/plugins/datatables/buttons.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="assets/plugins/datatables/responsive.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.colVis.js" type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>  
	<script>
 /* 	var listOrders1 = ${allOrders1};
 	if (listOrders1 != "") {
 		displayTable(listOrders1);
 	}  */
</script>