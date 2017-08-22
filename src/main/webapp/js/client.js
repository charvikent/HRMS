function resetForm()
{
	removeBorder('firstName');
	$('#firstName').val("");
	$('#firstName').removeClass('your-class default-class');
	
	removeBorder('clientName');
	$('#clientName').val("");
	$('#clientName').removeClass('your-class default-class');

	
	removeBorder('lastName');
	$('#lastName').val("");
	$('#lastName').removeClass('your-class default-class');

	removeBorder('emailId');
	$('#emailId').val("");
	$('#emailId').removeClass('your-class default-class');

	removeBorder('mobile');
	$('#mobile').val("");
	$('#mobile').removeClass('your-class default-class');

	removeBorder('phone');
	$('#phone').val("");
	$('#phone').removeClass('your-class default-class');
	
	removeBorder('currency');
	$('#currency').val("");
	$('#currency').removeClass('your-class default-class');
	
	
	removeBorder('billingMethod');
	$('#billingMethod').val("");
	$('#billingMethod').removeClass('your-class default-class');
	
	removeBorder('fax');
	$('#fax').val("");
	$('#fax').removeClass('your-class default-class');
	
	
	removeBorder('streetAddress');
	$('#streetAddress').val("");
	$('#streetAddress').removeClass('your-class default-class');
	
	
	removeBorder('city');
	$('#city').val("");
	$('#city').removeClass('your-class default-class');
	
	removeBorder('state');
	$('#state').val("");
	$('#state').removeClass('your-class default-class');
	
	removeBorder('pincode');
	$('#pincode').val("");
	$('#pincode').removeClass('your-class default-class');
	
	removeBorder('country');
	$('#country').val("");
	$('#country').removeClass('your-class default-class');

	removeBorder('companySize');
	$('#companySize').val("");
	$('#companySize').removeClass('your-class default-class');
	
	
	removeBorder('description');
	$('#description').val("");
	$('#description').removeClass('your-class default-class');

	
	
}
function displayTable(listOrders) {
		$('#tableId').html('');
		var tableHead = '<table class="table table-striped table-hover table-bordered"	id="datatable-colvid">'
				+ '<thead><tr><th>Client Name</th><th>FirstName</th> <th style="text-align: center;">Action</th>	</tr></thead><tbody></tbody></table>';
		$('#tableId').html(tableHead);
		serviceUnitArray = {};
		$
				.each(
						listOrders,
						function(i, orderObj) {
							serviceUnitArray[orderObj.id] = orderObj;
							var id = '"' + orderObj.id + '"';
							var tblRow = "<tr >"
									+ "<td   title='"+orderObj.clientName+"'>"
									+ orderObj.clientName
									+ "</td>"
									+ "<td   title='"+orderObj.firstName+"'>"
									+ orderObj.firstName
									+ "</td>"
									+ "<td style='text-align: center;'><a  onclick='editClient("
									+ orderObj.id
									+ ")'><i style='color: green;' class='fa fa-edit'></i></a>&nbsp;|&nbsp;"
									+ "<a  onclick='deleteClient("
									+ orderObj.id
									+ ")'><i style='color: red;' class='fa fa-trash'></i></a></td>" + "</tr >";
							$(tblRow).appendTo("#datatable-colvid tbody");
						});
		 $('#datatable-colvid').DataTable({
		        "dom": 'C<"clear">lfrtip',
		        "colVis": {
		            "buttonText": "Change columns",
		        "buttons": [{extend:"copy",className:"btn default"},{extend:"print",className:"btn default"},{extend:"pdf",className:"btn default"},{extend:"csv",className:"btn default"}]
		        }
		    });
	}
	function editClient(id) {
//		id,clientName, currency,billingMethod,emailId,firstName,lastName,phone,mobile,fax,streetAddress,city,state,pincode,country,industry, companySize, description
		$("#id").val(serviceUnitArray[id].id);
		$("#clientName").val(serviceUnitArray[id].clientName);
		$('#currency').val(serviceUnitArray[id].currency);
		$('#billingMethod').val(serviceUnitArray[id].billingMethod);
		$('#emailId').val(serviceUnitArray[id].emailId);
		$('#firstName').val(serviceUnitArray[id].firstName);
		$("#lastName").val(serviceUnitArray[id].lastName);
		$("#phone").val(serviceUnitArray[id].phone);
		$("#mobile").val(serviceUnitArray[id].mobile);
		$("#fax").val(serviceUnitArray[id].fax);
		$("#streetAddress").val(serviceUnitArray[id].streetAddress);
		$("#city").val(serviceUnitArray[id].city);
		$("#state").val(serviceUnitArray[id].state);
		$("#pincode").val(serviceUnitArray[id].pincode);
		$("#country").val(serviceUnitArray[id].country);
		$("#industry").val(serviceUnitArray[id].industry);
		$("#companySize").val(serviceUnitArray[id].companySize);
		$("#description").val(serviceUnitArray[id].description);
//		$(window).scrollTop($('#addForm').offset().top);
		}
	function submitClient() {
		
		if( $('#clientName').val().length == 0 || $('#clientName').val() =="" || $('#clientName').val()=="undefined"|| $('#lastName').val().length == 0 || $('#lastName').val() =="" || $('#lastName').val()=="undefined" ||$('#emailId').val().length == 0 || $('#emailId').val() =="" || $('#emailId').val()=="undefined"||$('#mobile').val() == null || $('#mobile').val() =="" || $('#mobile').val()=="undefined"||$('#firstName').val().length == 0 || $('#firstName').val() =="" || $('#firstName').val()=="undefined"||$('#phone').val() == null || $('#phone').val() =="" || $('#phone').val()=="undefined")
		{
			if($('#clientName').val().length == 0 || $('#clientName').val() =="" || $('#clientName').val()=="undefined") 
			{
				    $('#clientName').css('color','red');
				    $("#clientName").css("border-color","#e73d4a");
				    $("#clientName").attr("placeholder","Please Enter Client name");
				    $('#clientName').addClass('your-class');
			}
			if($('#firstName').val().length == 0 || $('#firstName').val() =="" || $('#firstName').val()=="undefined") 
			{
				    $('#firstName').css('color','red');
				    $("#firstName").css("border-color","#e73d4a");
				    $("#firstName").attr("placeholder","Please Enter first name");
				    $('#firstName').addClass('your-class');
			}
			if($('#lastName').val().length == 0 || $('#lastName').val() =="" || $('#lastName').val()=="undefined") 
			{
				    $('#lastName').css('color','red');
				    $("#lastName").css("border-color","#e73d4a");
				    $("#lastName").attr("placeholder","Please Enter last name");
				    $('#lastName').addClass('your-class');
			}
			if($('#emailId').val().length == 0 || $('#emailId').val() =="" || $('#emailId').val()=="undefined") 
			{
				    $('#emailId').css('color','red');
				    $("#emailId").css("border-color","#e73d4a");
				    $("#emailId").attr("placeholder","Please Enter emailId");
				    $('#emailId').addClass('your-class');
			}
			if($('#mobile').val() == null || $('#mobile').val() =="" || $('#mobile').val()=="undefined") {
			    $('#mobile').css('color','red');
			    $("#mobile").css("border-color","#e73d4a");
			    $("#mobile").attr("placeholder","Please Enter mobile");
			    $('#mobile').addClass('your-class');
		    }
			if($('#phone').val() == null || $('#phone').val() =="" || $('#phone').val()=="undefined") {
			    $('#phone').css('color','red');
			    $("#phone").css("border-color","#e73d4a");
			    $("#phone").attr("placeholder","Please Enter phone number");
			    $('#phone').addClass('your-class');
		    }
			
			return false;
		}
		var clientName =  $("#clientName").val();
		var id =  $("#id").val();
		var currency = $("#currency").val();
		var billingMethod = $("#billingMethod").val();
		var emailId = $("#emailId").val();
		var firstName = $("#firstName").val();
		var lastName = $("#lastName").val();
		var phone = $("#phone").val();
		var mobile = $("#mobile").val();
		var fax = $("#fax").val();
		var streetAddress = $("#streetAddress").val();
		var city = $("#city").val();
		var state = $("#state").val();
		var pincode = $("#pincode").val();
		var country = $("#country").val();
		var industry = $("#industry").val();
		var companySize = $("#companySize").val();
		var description = $("#description").val();
		
		var formData = new FormData();
	    
	     formData.append('clientName', clientName);
	    formData.append('id',id);
	    formData.append('currency', currency);
	    formData.append('billingMethod', billingMethod);
	    formData.append('emailId', emailId);
	    formData.append('firstName', firstName);
	    formData.append('lastName', lastName);
	    formData.append('phone', phone);
	    formData.append('mobile', mobile);
	    formData.append('fax', fax);
	    formData.append('state', state);
	    formData.append('streetAddress', streetAddress);
	    formData.append('city', city);
	    formData.append('pincode', pincode);
	    formData.append('country', country);
	    formData.append('industry', industry);
	    formData.append('companySize', companySize);
	    formData.append('description', description);
	    
	    $.fn.makeMultipartRequest('POST', 'addClient', false,
				formData, false, 'text', function(data){
	    	
			var jsonobj = $.parseJSON(data);
			alert(jsonobj.message);
			var alldata = jsonobj.allOrders1;
			if(typeof(alldata)  === "undefined" || jsonobj.message =="duplicate" ){
			
			}else{
				console.log(jsonobj.allOrders1);
				displayTable(alldata);
			}
			
			if(jsonobj.message =="duplicate"){
				
			}else{
				$("#id").val("0");
				$('#addForm').trigger("reset");
			}
		});
	    
	}
	
	function deleteClient(departmentId){
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		var formData = new FormData();
	    
	     formData.append('id', departmentId);
		$.fn.makeMultipartRequest('POST', 'deleteClient', false,
				formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			alert(jsonobj.message);
			var alldata = jsonobj.allOrders1;
			console.log(jsonobj.allOrders1);
			displayTable(alldata);
		});
		}
		
	}
	