<!-- http://javasampleapproach.com/spring-framework-tutorial/spring-core -->
<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme for HRMS">
        <meta name="author" content="CHARVIKENT">

         <link rel="shortcut icon" href="assets/images/favicon.ico"> 

        <title>HRMS | Admin</title>

        <!--Morris Chart CSS -->
<!-- 		<link rel="stylesheet" href="assets/plugins/morris/morris.css"> -->

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" rel="stylesheet" type="text/css" />
        
        <!-- App css -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/animate.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/datepicker1.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/core.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/components.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/menu.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/datatables/dataTables.colVis.css" rel="stylesheet" type="text/css" />
        
        <!-- DataTable css -->
        <link href="assets/plugins/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/datatables/dataTables.colVis.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/datatables/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/datatables/fixedColumns.dataTables.min.css" rel="stylesheet" type="text/css"/>
        
        <!-- Hierarchical css -->
        <link href="js/jquery.orgchart.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <script src="assets/js/modernizr.min.js"></script>
<style>
.alert{
text-align: -webkit-center;
position: absolute;
top: 0;left: 0;right: 0;
margin: 1px auto;
max-width: 420px;
text-align: center;
}

/* .dataTables_filter{text-align: right;}
.dataTables_paginate{text-align: right;}
.dataTables_empty{text-align: center;} */

.your-class::-webkit-input-placeholder {color: red !important;}
 .your-class::-moz-placeholder {color: red !important;}

.default-class::-webkit-input-placeholder {color: red !important;}
 .default-class::-moz-placeholder {color: red !important;} 


/* .multiselect-container{display: block;} */
span.has-error, #already_exist, .subjects_error
{
  font-weight:normal;
  border-color: #e73d4a;
  color:red;
  margin:0px;
  display: block !important;
  position: absolute;
}
#orgChart{
    width: auto;
    height: auto;
}

#orgChartContainer{
    width: 1000px;
    height: 500px;
    overflow: auto;
    background: #eeeeee;
}
@media (max-width:660px)
{
/* 	.dt-buttons{padding-right: 3em;} */
	.dataTables_length{text-align: center;}
	.dataTables_filter{text-align: center;}
	.dataTables_paginate{text-align: center;}
	.menu-extras ul.myTime
	{
		/* margin-top: 1em;margin-left: 28em;font-size: 18px;color: white; */
		display: none;
	}
	#txt{display: none;}
}

.modal1
        {
            position: fixed;
            z-index: 999;
            height: 100%;
            width: 100%;
            top: 0;
            left: 0;
            background-color: Black;
            filter: alpha(opacity=60);
            opacity: 0.6;
            -moz-opacity: 0.8;
        }
</style>

<!-- <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script> -->


    </head>


    <body onload="startTime()">
			<%
				 	HttpSession sess = request.getSession(false);
					
					if (sess.getAttribute("cacheUserBean") == null) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginHome");
						dispatcher.forward(request, response);
					}else{
						 String testId = (String)sess.getAttribute("rolId");
						 if(testId != null){
							 int  rolid22 = Integer.parseInt(testId);
						 System.out.println(rolid22);
						 if (rolid22 != 1 && rolid22 != 2 && rolid22 != 3) {
							RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginHome");
							dispatcher.forward(request, response);
						}  
						 }
					}
					
					response.setHeader("pragma", "no-cache");              
					  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");             
					  response.setHeader("Expires", "0"); 
			%>  

<!-- MyTime Counter Starts Here -->
							<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content" style="">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                                            <h4 class="modal-title" id="mySmallModalLabel" style="">MyTimer Count</h4>
                                        </div>
                                        <div class="modal-body">
                                        	<span id="h_timeId"></span>
                                        	<br/>
                                        	<div class="text-center">
                                        		<a href="checkIn" class="btn btn-primary waves-effect" data-dismiss="modal" id="h_checkInId" onclick="fun1()"></a>
                                        	</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
<!-- MyTime Counter Ends Here -->




        <!-- Navigation Bar-->
        <header id="topnav">
            <div class="topbar-main">
                <div class="container">

                    <!-- Logo container-->
                    <div class="logo">
                        <!-- Text Logo -->
                        <a href="DepartmentHome" class="logo">HRMS</a>
                        <!-- Image Logo -->
                        <!-- <a href="DepartmentHome" class="logo">
                            <img src="assets/images/logo.jpg" alt="" style="width: 30%;height: 50px;">
                        </a> -->
                        <!-- <span id="txt"></span> -->

                    </div>
                    <!-- End Logo container-->
                   <script>
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}
function loginCheck(){
	var formData = new FormData();
    $.fn.makeMultipartRequest('POST', 'loginCheck', false,
			formData, false, 'text', function(data){
    	
		var jsonobj = $.parseJSON(data);
		var message = jsonobj.message;
		alert(message);
		if(message == "login"){
			$("#h_checkInId").text("Check Out");
			alert(jsonobj.loginTime);
			$("#h_timeId").text(jsonobj.loginTime);
		}else{
			$("#h_checkInId").text("Check In");
		}
	});
}
function fun1(){
	var formData = new FormData();
    $.fn.makeMultipartRequest('POST', 'checkIn', false,
			formData, false, 'text', function(data){
    	var jsonobj = $.parseJSON(data);
		var alldata = jsonobj.data;
		
		 $.each( $.parseJSON(alldata), function(i, tests) {
			if(tests.active == 0){
				alert("CheckOut success fully")
			}else{
				alert("CheckIn success fully")
			}
			
		}); 
    	
    });
}
</script>


<!-- <span id="txt"></span> -->
             
       <div class="menu-extras">

                        <ul class="nav navbar-nav myTime" style="margin-top: 1em;margin-left: 28em;font-size: 18px;color: white;">
                        	<li class="navbar-c-items"><span id="txt"></span></li>
                        </ul>
                        
                        <ul class="nav navbar-nav navbar-right pull-right">
                            <!-- <li class="navbar-c-items">
                                <form role="search" class="navbar-left app-search pull-left hidden-xs">
                                     <input type="text" placeholder="Search..." class="form-control">
                                     <a href=""><i class="fa fa-search"></i></a>
                                </form>
                            </li> -->

                            <li class="dropdown navbar-c-items">
                                <a href="#" class="dropdown-toggle waves-effect waves-light profile" data-toggle="dropdown" aria-expanded="true">
                                	<i class="fa fa-user fa-2x img-circle"></i>
                                	<!-- <img src="assets/images/users/avatar-1.jpg" alt="user-img" class="img-circle"> -->
                                </a>
                                <ul class="dropdown-menu dropdown-menu-right arrow-dropdown-menu arrow-menu-right user-list notify-list">
                                    <li class="text-center">
                                    <c:if test="${not empty sessionScope.userName}">
									 <h5>Hi, ${sessionScope.userName}</h5>
								</c:if>
<%--                                         <h5>Hi, </h5> --%>
                                    </li>
                                    <!-- <li><a href="javascript:void(0)"><i class="ti-user m-r-5"></i> Profile</a></li>
                                    <li><a href="javascript:void(0)"><i class="ti-settings m-r-5"></i> Settings</a></li> -->
                                    <li><a href="logoutHome"><i class="ti-power-off m-r-5"></i> Logout</a></li>
                                </ul>

                            </li>
                        </ul>
                        <div class="menu-item">
                            <!-- Mobile menu toggle-->
                            <a class="navbar-toggle">
                                <div class="lines">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </div>
                            </a>
                            <!-- End mobile menu toggle-->
                        </div>
                    </div>
                    <!-- end menu-extras -->

                </div> <!-- end container -->
            </div>
            <!-- end topbar-main -->

            <div class="navbar-custom">
                <div class="container">
                    <div id="navigation">
                        <!-- Navigation Menu-->
                        <ul class="navigation-menu">

                            <li class="<!-- has-submenu -->">
                            	<!-- Time Counter Button -->
								<a data-toggle="modal" data-target=".bs-example-modal-sm" onclick="loginCheck();"><i class="mdi mdi-google-pages"></i>MyTime Counter</a>
                                
                                <!-- <a href="#"><i class="mdi mdi-view-dashboard"></i>Dashboard</a> -->
                                <!-- <ul class="submenu">
                                    <li><a href="index.html">Dashboard 01</a></li>
                                </ul> -->
                            </li>

                            <li class="has-submenu">
                                <a href="#"><i class="mdi mdi-home-map-marker"></i>Organization</a>
                                <ul class="submenu">
                                    <li><a href="DepartmentHome">Department</a></li>
                                    <li><a href="employeeHome">Employee</a></li>
                                    <li><a href="DesignationHome">Designation</a></li>
                                </ul>
                            </li>

                            <li class="has-submenu">
                                <a href="#"><i class="mdi mdi-book-multiple"></i>Leave Tracker</a>
                                <ul class="submenu">
                                    <li><a href="HolidayHome">Holidays</a></li>
                                    <li><a href="Calendar">Calendar</a></li>
                                </ul>
                            </li>

                            <li class="has-submenu">
                                <a href="#"><i class="mdi mdi-google-pages"></i>Time Tracker</a>
                                <ul class="submenu">
                                    <li><a href="timeLogsHome">Time-Logs</a></li>
                                    <li><a href="timeSheetHome">Time-Sheets</a></li>
                                    <li><a href="JobsHome">Jobs</a></li>
                                    <li><a href="ProjectHome">Projects</a></li>
                                    <li><a href="ClientHome">Client</a></li>
                                    <li><a href="AttendanceHome">Attendance</a></li>
                                </ul>
                            </li>
                        </ul>
                        <!-- End navigation menu -->
                    </div> <!-- end #navigation -->
                </div> <!-- end container -->
            </div> <!-- end navbar-custom -->
        </header>
        <!-- End Navigation Bar-->
 <div class="modal1" style="display: none">
        <div class="center">
            <img alt="" src="assets\images\loader.gif" />
        </div>
    </div>