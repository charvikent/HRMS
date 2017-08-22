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
                                    <li class="active">Client</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Client</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->
                
                <div class="tab-content">

								<!-- Add Department Form Starts Here -->
                                <div class="tab-pane active" id="departmentTab">
			                        <!-- BEGIN FORM-->
			                        <form:form commandName="clientForm" method="post" id="addForm" class="form-horizontal" role="form">
			                                                        
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">

			                                	<label for="inputEmail1" class="col-md-4 control-label">Client Name</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="clientName" placeholder="Enter Client Name" onkeydown="removeBorder(this.id);" class="form-control onlyCharacters" required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Currency</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="currency" placeholder="Enter Currency" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Billing Method</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="billingMethod" placeholder="Enter Billing Method" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">EmailId</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="emailId" placeholder="Enter EmailId"  class="form-control onlyCharacters" onkeydown="removeBorder(this.id);"/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">First Name</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="firstName" placeholder="Enter First Name"  onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Last Name</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="lastName" placeholder="Enter Last Name" onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Phone</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="phone" placeholder="Enter Phone Number" onkeydown="removeBorder(this.id);"  class="form-control "/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Mobile</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="mobile" placeholder="Enter Mobile Number"  onkeydown="removeBorder(this.id);" class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Fax</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="fax" placeholder="Enter Fax Number"  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Street Address</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="streetAddress" placeholder="Enter Street Address"  class="form-control " required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">City</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="city" placeholder="Enter City"  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">State/Province</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="state" placeholder="Enter State/Province"  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">ZIP/PIN Code</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="pincode" placeholder="Enter ZIP/PIN Code"  class="form-control " required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
			                        	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Country</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="country" placeholder="Enter Country"  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
			                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Company Size</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="companySize" placeholder="Enter State/Province"  class="form-control"/>
			                                 	</div>
			                            	 </div>
			                            </div>
									</div>
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			                            	<form:hidden path="id"  />
			                            	<div class="form-group">
			                                	<label for="inputEmail1" class="col-md-4 control-label">Description</label>
			                                	<div class="col-md-8">
			                                    	<form:input path="description" placeholder="Enter Description"  class="form-control " required="true"/>
			                                	</div>
			                            	</div>
			                            </div>
									</div>
			                    	<div class="row">
										<div class="col-md-offset-4 col-md-8">
			                            	<div class="form-group">
			                                	<div class="col-md-offset-2 col-md-8">
			                                    	<input type="button" id="submitId" class="btn btn-success" value="Add Client" onclick="submitClient()"/>
			                                    	<input type="button" class="btn btn-danger" id="cancel" onclick="resetForm()" value="Reset"/>
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

<spring:url value="assets/js/jquery.min.js"
	var="jqueryJs" />
<script src="${jqueryJs}"></script>

<spring:url value="js/client.js"
	var="clientJs" />
<script src="${clientJs}"></script>

<!-- <script src="assets/js/jquery.min.js"></script> -->
<script type="text/javascript" src="js/client.js"></script>
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="assets/plugins/datatables/buttons.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="assets/plugins/datatables/responsive.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.colVis.js" type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>        

<script type="text/javascript">
	
	
	 

 	var listOrders1 = ${allOrders1};
 	if (listOrders1 != "") {
 		displayTable(listOrders1);
 	} 
</script>