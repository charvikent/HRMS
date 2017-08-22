<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


            <div class="page-wrapper-row full-height">
                <div class="page-wrapper-middle">
                    <!-- BEGIN CONTAINER -->
                    <div class="page-container">
                        <!-- BEGIN CONTENT -->
                        <div class="page-content-wrapper">
                            <!-- BEGIN PAGE CONTENT BODY -->
                            <div class="page-content">
                                <div class="container">
                                	<!-- BEGIN PAGE BREADCRUMBS -->
									<ul class="page-breadcrumb breadcrumb">
										<li><a href="index.html">Home</a> <i class="fa fa-circle"></i></li>
										<li><a href="">More</a> <i class="fa fa-circle"></i></li>
										<li><a href="">Tables</a> <i class="fa fa-circle"></i></li>
										<li><span>Department</span></li>
									</ul>
						<%-- <form:form action="updateDepartment" commandName="packCmd" method="post" id="student-form">
						<form:hidden path="id"  />
						Department name <form:input path="name" placeholder="Enter Department Name" class="form-control onlyCharacters" tabindex="1"/>
						Department email <form:input path="email" placeholder="Enter Deprtment Email " class="form-control onlyCharacters" tabindex="2" />
						Department Head <form:input path="departmentHead" placeholder="Enter Department Head" class="form-control onlyCharacters" tabindex="3" />
						Parent Department <form:select path="parentid" tabindex="4" class="form-control">
															<form:option value="">-- Choose Parent Department --</form:option>
															<form:options items="${department}"></form:options>
														</form:select>
														<br>
						<input type="submit" id="submitId" class="btn btn-success" value="Register" tabindex="5"/>
						</form:form>
						<br> --%>
									
									<!-- END PAGE BREADCRUMBS -->
                                    <!-- BEGIN PAGE CONTENT INNER -->
                                    <div class="page-content-inner">
                                    	<div class="row">
                                    		<div class="col-md-12">
                                    			<div class="portlet light portlet-fit portlet-form ">
<script>
$(document).ready(function() {
	/* function chosenDropDown(){
		  var config = {
			      '.some-select'           : {},
			      '.some-select-theme'     : {},
			      '.some-select-state'  : {allow_single_deselect:true}
			    }
			    for (var selector in config) {
			      $(selector).chosen(config[selector]);
			    }
		  }
	  $("#parentid").customselect(); */
	});
	
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);

</script>

                                                    <div class="portlet-body">
                                                    	<div class="tabbable-line">
                                                            <ul class="nav nav-tabs ">
                                                                <li class="active">
                                                                    <a href="#tab_15_1" data-toggle="tab" aria-expanded="false"> Department </a>
                                                                </li>
                                                                <li class="">
                                                                    <a href="#tab_15_2" data-toggle="tab" aria-expanded="false"> Directory </a>
                                                                </li>
                                                                <li class="">
                                                                    <a href="#tab_15_3" data-toggle="tab" aria-expanded="true"> Section 3 </a>
                                                                </li>
                                                            </ul>
                                                            <div class="tab-content">
                                                                <div class="tab-pane active" id="tab_15_1">
                                                                
                                                <!-- BEGIN EXAMPLE TABLE PORTLET-->
                                                <div class="portlet box green">
                                                    <div class="portlet-title">
                                                        <div class="caption">
                                                            <i class="fa fa-globe"></i>Department Details </div>
                                                        <div class="tools"> </div>
                                                    </div>
                                                    <div class="portlet-body">
                                                    <div id="tableId">
                                                        <table class="table table-striped table-bordered table-hover dt-responsive" width="100%" id="sample_3" cellspacing="0">
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
                                                </div>
                                                <!-- END EXAMPLE TABLE PORTLET-->
                                                        
                                                        <!-- BEGIN FORM-->
                                                        <form:form commandName="packCmd" method="post" id="addForm">
														<form:hidden path="id"  />
															<div class="form-body">
                                                                <div class="form-group form-md-line-input">
                                                                    <label class="col-md-2 col-sm-12 col-xs-12 control-label" for="form_control_1">Department Name
                                                                        <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-4 col-sm-12 col-xs-12">
                                                                    	<form:input path="name" placeholder="Enter Department Name" onkeydown="removeBorder(this.id);" class="form-control onlyCharacters" tabindex="1" required="true"/>
                                                                        <div class="form-control-focus"> </div>
                                                                        <!-- <span class="help-block">Please Enter Department Name</span> -->
                                                                    </div>
                                                                 </div>
                                                                 <div class="form-group form-md-line-input">
                                                                    <label class="col-md-2 col-sm-12 col-xs-12 control-label" for="form_control_1">Email
                                                                        <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-4 col-sm-12 col-xs-12">
                                                                    	<form:input path="email" placeholder="Enter Deprtment Email" onkeydown="removeBorder(this.id);" class="form-control" tabindex="2" required="true"/>
                                                                        <div class="form-control-focus"> </div>
                                                                        <!-- <span class="help-block">Please Enter Department Email-ID</span> -->
                                                                    </div>
                                                                </div>
                                                                
                                                                <div class="form-group form-md-line-input">
                                                                    <label class="col-md-2 col-sm-12 col-xs-12 control-label" for="form_control_1">Department Head
                                                                        <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-4 col-sm-12 col-xs-12">
                                                                    	<form:input path="departmentHead" placeholder="Enter Department Head" onkeydown="removeBorder(this.id);" class="form-control onlyCharacters" tabindex="3" required="true"/>
                                                                        <div class="form-control-focus"> </div>
                                                                        <!-- <span class="help-block">Please Enter Department Head</span> -->
                                                                    </div>
                                                                 </div>
                                                                 <div class="form-group form-md-line-input">
                                                                    <label class="col-md-2 col-sm-12 col-xs-12 control-label" for="form_control_1">Parent Department
                                                                        <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-4 col-sm-12 col-xs-12">
                                                                    	<form:select path="parentid" onkeydown="removeBorder(this.id);" tabindex="4" class="chosen-select form-control" required="true">
																			<form:option value="">-- Choose Parent Department --</form:option>
																			<form:options items="${department}"></form:options>
																		</form:select>
                                                                        <div class="form-control-focus"> </div>
                                                                        <!-- <span class="help-block">Please Choose Parent Department</span> -->
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            
                                                            <div class="form-actions">
                                                                <div class="row">
                                                                    <div class="col-sm-offset-2 col-sm-4">
                                                                		<input type="submit" id="submitId" class="btn btn-success" value="Register" tabindex="5"/>
                                                                		<input type="reset" class="btn btn-danger" id="cancel" tabindex="6" value="Reset"/>
                                                                	</div>
                                                                </div>
                                                            </div>
														</form:form>
														<!-- END FORM-->
														
                                                                </div>
                                                                <div class="tab-pane" id="tab_15_2">
                                                                    <p> Howdy, I'm in Section 2. </p>
                                                                    <p> Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate
                                                                        velit esse molestie consequat. Ut wisi enim ad minim veniam, quis nostrud exerci tation. </p>
                                                                    <p>
                                                                        <a class="btn green" href="ui_tabs_accordions_navs.html#tab_15_2" target="_blank"> Activate this tab via URL </a>
                                                                    </p>
                                                                </div>
                                                                <div class="tab-pane" id="tab_15_3">
                                                                    <p> Howdy, I'm in Section 3. </p>
                                                                    <p> Duis autem vel eum iriure dolor in hendrerit in vulputate. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
                                                                        Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat </p>
                                                                    <p>
                                                                        <a class="btn yellow" href="ui_tabs_accordions_navs.html#tab_15_3" target="_blank"> Activate this tab via URL </a>
                                                                    </p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        
                                    		</div>
                                    	</div>
                                    </div>
                                    <!-- END PAGE CONTENT INNER -->
                                </div>
                            </div>
                            <!-- END PAGE CONTENT BODY -->
                            <!-- END CONTENT BODY -->
                        </div>
                        <!-- END CONTENT -->
					</div>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript">



$('#submitId').click(function(e){
	  
	$('#submitId').css('border', 'solid 3px #862ab7');												    
// 	if( $('#name').val().length == 0 ||  $('#email').val().length == 0 ||  $('#departmentHead').val().length == 0 ||  $('#parentid').val().length == 0)
	if( $('#name').val().length == 0)
	{												   
    	if($('#name').val().length == 0 ) {
		    $('#name').css('color','red');
		    $("#name").css("border-color","#e73d4a");
		    $("#name").attr("placeholder","Please Enter Department Name");
		    $('#name').addClass('your-class');
		    $('#name').focus();
	    }
    	/* if($('#email').val().length == 0 ) {
		    $('#email').css('color','red');
		    $("#email").css("border-color","#e73d4a");
		    $("#email").attr("placeholder","Please Enter Department Email-ID");
		    $('#email').addClass('your-class');
	    }
    	if($('#departmentHead').val().length == 0 ) {
		    $('#departmentHead').css('color','#e73d4a');
		    $("#departmentHead").css("border-color","red");
		    $("#departmentHead").attr("placeholder","Please Enter Department Head");
		    $('#departmentHead').addClass('your-class');
	    }
    	if($('#parentid').val() == "" ) {
		    $('#parentid').css('color','red');
		    $("#parentid").css("border-color","#e73d4a");
// 		    $("#parentid").attr("placeholder","Please Choose Parent Department");
		    $('#parentid').addClass('your-class');
	    } */
	    return false;												  
	} 
	    
$('#addForm').attr('action',"updateDepartment");
$("#addForm").submit();											
event.preventDefault();
// document.getElementById("dupMessage").style.display = "none";
});

function removeBorder(el){	
	  $("#"+el).css("border", ""); 	
	  $("#"+el).css('color','black');
	  $('#'+el).addClass('default-class');
}


	var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}
	function displayTable(listOrders) {
		$('#sample_3').html('');
		var tableHead = '<table class="table table-striped table-hover table-bordered"	id="sample_3">'
				+ '<thead><tr><th>Department Name</th><th>Email</th> <th>Department Head</th><th>Parent Department</th><th style="text-align: center;">Action</th></tr></thead><tbody></tbody></table>';
		$('#sample_3').html(tableHead);
		serviceUnitArray = {};
		$
				.each(
						listOrders,
						function(i, orderObj) {
							serviceUnitArray[orderObj.departmentId] = orderObj;
							var id = '"' + orderObj.departmentId + '"';
							var tblRow = "<tr >"
									+ "<td id='"+orderObj.departmentId+"name'"+" title='"+orderObj.name+"'>"
									+ orderObj.name
									+ "</td>"
									+ "<td   id='"+orderObj.departmentId+"email'"+" title='"+orderObj.email+"'>"
									+ orderObj.email
									+ "</td>"
									+ "<td  id='"+orderObj.departmentId+"departmentHead'"+" title='"+orderObj.departmentHead+"'>"
									+ orderObj.departmentHead
									+ "</td>"
									+ "<td  id='"+orderObj.parentName+"parentid'"+" class='hidden-sm hidden-xs' title='"+orderObj.parentName+"'>"
									+ orderObj.parentName
									+ "</td>"
									+ "<td style='text-align: center;'><a  onclick='updateDepartment("
									+ orderObj.departmentId
									+ ")'>edit </a>&nbsp;|&nbsp;"
									+ "<a  onclick='deleteDepartment("
									+ orderObj.departmentId
									+ ")'>Delete </a></td>" + "</tr >";
							$(tblRow).appendTo("#sample_3 tbody");
						});
	}
	function updateDepartment(id) {
		$("#id").val(serviceUnitArray[id].departmentId);
		$("#name").val(serviceUnitArray[id].name);
		$('#email').val(serviceUnitArray[id].email);
		$('#departmentHead').val(serviceUnitArray[id].departmentHead);
		$('#parentid').val(serviceUnitArray[id].parentid);
		$('#parentid').trigger("chosen:updated");
	}
	/* $(function() {
		$("td").dblclick(function() {
							var OriginalContent = $(this).text();
							$(this).addClass("cellEditing");
							$(this)
									.html(
											"<input type='text' value='" + OriginalContent + "' />");
							$(this).children().first().focus();
							$(this).children().first().keypress(
									function(e) {
										if (e.which == 13) {
											var newContent = $(this).val();
											$(this).parent().text(newContent);
											$(this).parent().removeClass(
													"cellEditing");
										}
									});
							$(this).children().first().blur(function() {
								$(this).parent().text(OriginalContent);
								$(this).parent().removeClass("cellEditing");
							});
						});
	}); */
</script>