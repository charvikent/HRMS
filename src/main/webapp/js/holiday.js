function resetForm()
{
	removeBorder('name');
	$('#name').val("");
	$('#name').removeClass('your-class default-class');
	
	removeBorder('fromDate1');
	$('#fromDate1').val("");
	$('#fromDate1').removeClass('your-class default-class');
	
	removeBorder('toDate1');
	$('#toDate1').val("");
	$('#toDate1').removeClass('your-class default-class');
	
	removeBorder('applicable');
	$('#applicable').val("");
	$('#applicable').removeClass('your-class default-class');
	
	removeBorder('description');
	$('#description').val("");
	$('#description').removeClass('your-class default-class');

}

function displayTable(listOrders) {
		$('#tableId').html('');
		var tableHead = '<table class="table table-striped table-hover table-bordered"	id="datatable-colvid">'
				+ '<thead><tr><th>Designation Name</th><th>Email</th> <th style="text-align: center;">Action</th>	</tr></thead><tbody></tbody></table>';
		$('#tableId').html(tableHead);
		serviceUnitArray = {};
		$
				.each(
						listOrders,
						function(i, orderObj) {
							serviceUnitArray[orderObj.id] = orderObj;
							var id = '"' + orderObj.id + '"';
							var tblRow = "<tr >"
									+ "<td   title='"+orderObj.name+"'>"
									+ orderObj.name
									+ "</td>"
									+ "<td   title='"+orderObj.description+"'>"
									+ orderObj.description
									+ "</td>"
									+ "<td style='text-align: center;'><a  onclick='editHoliday("
									+ orderObj.id
									+ ")'><i style='color: green;' class='fa fa-edit'></i></a>&nbsp;|&nbsp;"
									+ "<a  onclick='deleteHoliday("
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
	function editHoliday(id) {
		var dummy = $("#parentid1").html();
		$("#id").val(serviceUnitArray[id].id);
		$("#name").val(serviceUnitArray[id].name);
		$('#description').val(serviceUnitArray[id].description);
		$('#fromDate1').val(serviceUnitArray[id].fromDate);
		$('#toDate1').val(serviceUnitArray[id].toDate);
		$('#notifyapplicable').val(serviceUnitArray[id].notifyapplicable);
		$("#applicable").val(serviceUnitArray[id].applicable);
//		$(window).scrollTop($('#addForm').offset().top);
		}
	function submitHoliday() {
		
		if($('#name').val() == "undefined" || $('#name').val().length == 0 || $('#name').val() == "" )
		{												   
	    	if($('#name').val().length == 0  || $('#name').val() == "" || $('#name').val() == "undefined") {
			    $('#name').css('color','red');
			    $("#name").css("border-color","#e73d4a");
			    $("#name").attr("placeholder","Please Enter Holiday Name");
			    $('#name').addClass('your-class');
			    $('#name').focus();
		    }
		    return false;												  
		} 
		    
		var name =  $("#name").val();
		var id =  $("#id").val();
		var description = $("#description").val();
		var applicable = $("#applicable").val();
		var fromDate1 = $("#fromDate1").val();
		var toDate1 = $("#toDate1").val();
		var notifyapplicable = 0
		if ($('#notifyapplicable').is(":checked"))
	    {
			 notifyapplicable = $("#notifyapplicable").val();
	    }
		
		var formData = new FormData();
	    
	     formData.append('name', name);
	    formData.append('description',description);
	    formData.append('applicable', applicable);
	    formData.append('fromDate1', fromDate1);
	    formData.append('toDate1', toDate1);
	    

	    formData.append('notifyapplicable', notifyapplicable);
	    formData.append('id',id);
	    $.fn.makeMultipartRequest('POST', 'addHoliday', false,
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
	
	function deleteHoliday(departmentId){
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		var formData = new FormData();
	    
	     formData.append('id', departmentId);
		$.fn.makeMultipartRequest('POST', 'deleteHoliday', false,
				formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			alert(jsonobj.message);
			var alldata = jsonobj.allOrders1;
			console.log(jsonobj.allOrders1);
			displayTable(alldata);
		});
		}
		
	}
	