<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->

    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
<script src="js/jquery-2.1.3.min.js"></script>
        <meta charset="utf-8" />
        <title>HRMS | User Sign In Page</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #3 for " name="description" />
        <meta content="" name="author" />
        
       <link rel="shortcut icon" href="assets/images/favicon.ico"> 
        <script type="text/javascript" src="js/ajax.js"></script>
        
        <!-- App css -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/core.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/components.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/menu.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <script src="assets/js/modernizr.min.js"></script>
        
<style>
    .error {
        color: red; font-weight: bold;
    }
    
.alert{
text-align: -webkit-center;
position: absolute;
top: 0;left: 0;right: 0;
margin: 1px auto;
max-width: 420px;
text-align: center;
}
.your-class::-webkit-input-placeholder {color: red !important;}
/* .your-class::-moz-input-placeholder {color: red !important;} */

.default-class::-webkit-input-placeholder {color: red !important;}
/* .default-class::-moz-input-placeholder {color: red !important;} */


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
body {
    background-image: url("assets/images/HRMS.jpg");
   height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>

<script type="text/javascript">
$( document ).ready(function() {
    $("#msg").hide();
});
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);
</script>
</head>
    <!-- END HEAD -->


    <body class="bg-transparent" >

        <!-- HOME -->
        <section>
            <div class="container-alt">
                <div class="row">
                    <div class="col-sm-12">
                    	<div id="msg" class='alert alert-danger alert-dismissable fadeIn animated infinite' ></div>

                        <div class="wrapper-page">

                            <div class="m-t-40 account-pages">
                                <div class="text-center account-logo-box">
                                    <h2><a href="" style="color: white !important;cursor: pointer;text-decoration: none;">HRMS</a></h2>
                                    <!--<h4 class="text-uppercase font-bold m-b-0">Sign In</h4>-->
                                </div>
                                <div class="account-content">
                                    <form:form  commandName="userForm" method="post" id="cls-form" class="form-horizontal" >

                                        <div class="form-group ">
                                            <div class="col-xs-12">
                                                <form:input path="name" onkeydown="removeBorder(this.id);" class="form-control form-control-solid placeholder-no-fix" type="text" required="true" autocomplete="off" placeholder="Enter Username"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <form:input path="password" onkeydown="removeBorder(this.id);" class="form-control form-control-solid placeholder-no-fix" type="password" required="true" autocomplete="off" placeholder="Enter Password" />
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <button type="button" onclick="loginUser();" class="btn w-md btn-bordered btn-success">Login</button>
                                                <input type="button" class="btn w-md btn-bordered btn-danger" id="cancel" onclick="resetForm()" value="Reset"/>
                                            </div>
                                        </div>
                                        
                                        <%-- <div class="form-group">
                                            <div class="col-xs-12">
                                                <c:if test="${not empty error}">
													<div class="error">${error}</div>
												</c:if>
												<c:if test="${not empty msg}">
													<div class="error">${msg}</div>
												</c:if>
                                            </div>
                                        </div> --%>

                                    </form:form>

                                    <div class="clearfix"></div>

                                </div>
                            </div>
                            <!-- end card-box-->

                        </div>
                        <!-- end wrapper -->

                    </div>
                </div>
            </div>
          </section>
          <!-- END HOME -->
        
<script>
function resetForm()
{
	removeBorder('name');
	$('#name').val("");
	$('#name').removeClass('your-class default-class');
	
	removeBorder('password');
	$('#password').val("");
	$('#password').removeClass('your-class default-class');


}

function loginUser() {
		if( $('#name').val().length == 0 || $('#name').val() =="" || $('#name').val()=="undefined"|| $('#password').val().length == 0 || $('#password').val() =="" || $('#password').val()=="undefined")
		{
			if($('#name').val().length == 0 || $('#name').val() =="" || $('#name').val()=="undefined") 
			{
				    $('#name').css('color','red');
				    $("#name").css("border-color","#e73d4a");
				    $("#name").attr("placeholder","Please Enter User Name");
				    $('#name').addClass('your-class');
			}
			if($('#password').val().length == 0 || $('#password').val() =="" || $('#password').val()=="undefined") 
			{
				    $('#password').css('color','red');
				    $("#password").css("border-color","#e73d4a");
				    $("#password").attr("placeholder","Please Enter Password");
				    $('#password').addClass('your-class');
			}

			return false;
		}	

	var name = null;
	name = $("#name").val();
	var password = $("#password").val();
var formData = new FormData();
    
     formData.append('name', name);
    formData.append('password',password);
    
	jQuery.fn.makeMultipartRequest('POST', 'loginAction', false,
			formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
// 		alert(jsonobj.message);
		 $("#msg").show();
		$("#msg").text(jsonobj.message);
		if(jsonobj.message == "success"){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href= baseUrl+'/DepartmentHome'
//  history.pushState({urlPath:baseUrl+'/DepartmentHome'},"",baseUrl+'/DepartmentHome')
// 		history.pushState({urlPath:'/DepartmentHome'},"",'/DepartmentHome');
		}else{
			alert(jsonobj.message);
		}
	});
	/* jQuery.fn.makeRequest('POST', "loginAction", formData, function(data) {
		console.log(data);
	}); */
}
function removeBorder(el){	
	  $("#"+el).css("border", ""); 	
	  $("#"+el).css('color','black');
	  $('#'+el).addClass('default-class');
}

</script>
		
		<!-- jQuery  -->
        <!-- <script src="assets/js/jquery.min.js"></script> -->
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/detect.js"></script>
        <script src="assets/js/fastclick.js"></script>
        <script src="assets/js/jquery.blockUI.js"></script>
        <script src="assets/js/waves.js"></script>
        <script src="assets/js/jquery.slimscroll.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>

        <!-- App js -->
        <script src="assets/js/jquery.core.js"></script>
        <script src="assets/js/jquery.app.js"></script>

</body>
</html>