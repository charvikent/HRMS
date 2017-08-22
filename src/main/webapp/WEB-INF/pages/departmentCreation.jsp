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
                                    <li><a >HRMS</a></li>
                                    <li><a >Organization</a></li>
                                    <li class="active">Department</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Department</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->
                
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="card-box">
                            <ul class="nav nav-tabs tabs-bordered">
                                <li class="active">
                                    <a href="#departmentTab" data-toggle="tab" aria-expanded="false">
                                        <span class="visible-xs"><i class="fa fa-home"></i></span>
                                        <span class="hidden-xs">Department</span>
                                    </a>
                                </li>
                                <li class="">
                                    <a href="#hierarchicalTab" data-toggle="tab" aria-expanded="true">
                                        <span class="visible-xs"><i class="fa fa-bar-chart"></i></span>
                                        <span class="hidden-xs">Hierarchical</span>
                                    </a>
                                </li>
                            </ul>
                            <div class="tab-content">

								<!-- Add Department Form Starts Here -->
                                <div class="tab-pane active" id="departmentTab">
			                        <!-- BEGIN FORM-->
			                        <form:form commandName="packCmd" method="post" id="addForm" class="form-horizontal" role="form">
			                                                        
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Department Name</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="name" placeholder="Enter Department Name" onkeydown="removeBorder(this.id);" class="form-control onlyCharacters" required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Email</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="email" placeholder="Enter Deprtment Email" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
			                        <div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputPassword12" class="col-md-4 control-label">Department Head</label>
			                                    <div class="col-md-8">
			                                    	<form:select path="departmentHead" onkeydown="removeBorder(this.id);" class="form-control">
														<form:option value="">-- Choose Department Head --</form:option>
														<form:options items="${employee}"></form:options>
													</form:select>
			                                	</div>
			                         		</div>
			                          	</div>
			                        	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputPassword12" class="col-md-4 control-label">Parent Department</label>
			                                 	<div class="col-md-6 col-sm-9 col-xs-9">
			                                    	<form:select path="parentid" onkeydown="removeBorder(this.id);" class="form-control">
														<form:option value="">-- Choose Parent Department --</form:option>
														<form:options items="${department}"></form:options>
													</form:select>
																				
			                                   		<form:select path="parentid1" class="form-control" style="display:none">
														<form:option value="">-- Choose Parent Department --</form:option>
														<form:options items="${department}"></form:options>
													</form:select>
			                                	</div>
			                                	<div class="col-md-2 col-sm-3 col-xs-3">
			                                    	<i class="fa fa-plus-square-o fa-2x" aria-hidden="true" style="position: relative;top: 5px;cursor: pointer;"></i>
			                                 	</div>
			                               	</div>
			                           	</div>
			                       	</div>
			                    	<div class="row">
										<div class="col-md-offset-2 col-md-8">
			                            	<div class="form-group">
			                                	<div class="col-md-offset-4 col-md-6">
			                                    	<input type="button" id="submitId" class="btn btn-success" value="Add Department" onclick="submitDepartment()"/>
			                                    	<input type="button" onclick="resetForm()"  class="btn btn-danger" id="cancel" value="Reset"/>
<!-- 			                                    	<a class="btn btn-danger" href='DepartmentHome'>Cancel</a> -->
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
			                                    <th>Department Name</th>
												<th>Email</th>
												<th>Department Head</th>
												<th>Parent Department</th>
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
            
                                <div class="tab-pane" id="hierarchicalTab">
                                	<h5>Department Hierarchical</h5>
                                	<div class="table-responsive">
			                            <div id="orgChartContainer">
											<div id="orgChart"></div>
										</div>
									</div>
                                </div>
                            </div>
                        </div>
                    </div> <!-- end col -->
                </div>
                
            </div>
        </div>
        <!-- Body ends Here -->



							

<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- <script src="assets/js/jquery.min.js"></script> -->
<script type="text/javascript" src="js/jquery.orgchart.js"></script>
<script type="text/javascript" src="js/departmentcreation.js"></script>
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="assets/plugins/datatables/buttons.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="assets/plugins/datatables/responsive.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.colVis.js" type="text/javascript"></script>
        

<script type="text/javascript">


	var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}
	var test = ${allOrders};
    var testData = ${allOrders};
    $(function(){
        org_chart = $('#orgChart').orgChart({
            data: testData
        });
    });
   
</script>