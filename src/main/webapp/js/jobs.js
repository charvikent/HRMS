function resetForm()
{
	removeBorder('name');
	$('#name').val("");
	$('#name').removeClass('your-class default-class');
	
	removeBorder('projectId1');
	$('#projectId1').val("");
	$('#projectId1').removeClass('your-class default-class');
	
	removeBorder('startDate1');
	$('#startDate1').val("");
	$('#startDate1').removeClass('your-class default-class');
	
	removeBorder('endDate1');
	$('#endDate1').val("");
	$('#endDate1').removeClass('your-class default-class');
	
	removeBorder('hours');
	$('#hours').val("");
	$('#hours').removeClass('your-class default-class');
	
	removeBorder('assignees');
	$('#assignees').val("");
	$('#assignees').removeClass('your-class default-class');
	
	removeBorder('rateperhour');
	$('#rateperhour').val("");
	$('#rateperhour').removeClass('your-class default-class');
	
	removeBorder('description');
	$('#description').val("");
	$('#description').removeClass('your-class default-class');
	
	removeBorder('billableStatus');
	$('#billableStatus').val("");
	$('#billableStatus').removeClass('your-class default-class');
}

function displayTable(listOrders) {
		$('#tableId').html('');
		var tableHead = '<table class="table table-striped table-hover table-bordered"	id="datatable-colvid">'
				+ '<thead><tr><th>Job Name</th><th>Description</th> <th style="text-align: center;">Action</th>	</tr></thead><tbody></tbody></table>';
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
									+ "<td style='text-align: center;'><a  onclick='editJob("
									+ orderObj.id
									+ ")'><i style='color: green;' class='fa fa-edit'></i></a>&nbsp;|&nbsp;"
									+ "<a  onclick='deleteJobs("
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
	function editJob(id) {
		$("#id").val(serviceUnitArray[id].id);
		$("#name").val(serviceUnitArray[id].name);
		$('#description').val(serviceUnitArray[id].description);
		$('#projectId').val(serviceUnitArray[id].projectId);
		$('#startDate1').val(serviceUnitArray[id].startDate);
		$('#endDate1').val(serviceUnitArray[id].endDate);
		$("#hours").val(serviceUnitArray[id].hours);
		$("#assignees").val(serviceUnitArray[id].assignees);
		$("#rateperhour").val(serviceUnitArray[id].rateperhour);
		$("#description").val(serviceUnitArray[id].description);
		$("#billableStatus").val(serviceUnitArray[id].billableStatus);
		}
	function submitJobs() {
		
		if($('#name').val() == "undefined" || $('#name').val().length == 0 || $('#name').val() == "" )
		{												   
	    	if($('#name').val().length == 0  || $('#name').val() == "" || $('#name').val() == "undefined") {
			    $('#name').css('color','red');
			    $("#name").css("border-color","#e73d4a");
			    $("#name").attr("placeholder","Please Enter Job Name");
			    $('#name').addClass('your-class');
			    $('#name').focus();
		    }
		    return false;												  
		} 
//		created_time,name,projectId,startDate,endDate,hours,assignees,rateperhour,desicription,billableStatus   
		var name =  $("#name").val();
		var id =  $("#id").val();
		var description = $("#description").val();
		var projectId1 = $("#projectId1").val();
		var startDate1 = $("#startDate1").val();
		var endDate1 = $("#endDate1").val();
		var hours = $("#hours").val();
		var assignees = $("#assignees").val();
		var rateperhour = $("#rateperhour").val();
		var billableStatus = $("#billableStatus").val();
		var formData = new FormData();
	    formData.append('id',id);
	     formData.append('name', name);
	    formData.append('description',description);
	    formData.append('projectId1', projectId1);
	    formData.append('startDate1', startDate1);
	    formData.append('endDate1', endDate1);
	    formData.append('hours', hours);
	    formData.append('assignees', assignees);
	    formData.append('rateperhour', rateperhour);
	    formData.append('billableStatus', billableStatus);
	    
	
	    $.fn.makeMultipartRequest('POST', 'addJobs', false,
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
	
	function deleteJobs(id){
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		var formData = new FormData();
	    
	     formData.append('id', id);
		$.fn.makeMultipartRequest('POST', 'deleteJobs', false,
				formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			alert(jsonobj.message);
			var alldata = jsonobj.allOrders1;
			console.log(jsonobj.allOrders1);
			displayTable(alldata);
		});
		}
		
	}
	