function resetForm()
{
	removeBorder('name');
	$('#name').val("");
	$('#name').removeClass('your-class default-class');
	
	removeBorder('mailAlias');
	$('#mailAlias').val("");
	$('#mailAlias').removeClass('your-class default-class');

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
									+ "<td  id='"+orderObj.id+"name'"+" title='"+orderObj.name+"'>"
									+ orderObj.name
									+ "</td>"
									+ "<td   id='"+orderObj.departmentId+"email'"+" title='"+orderObj.email+"'>"
									+ orderObj.email
									+ "</td>"
									+ "<td style='text-align: center;'><a  onclick='editDesignation("
									+ orderObj.id
									+ ")'><i style='color: green;' class='fa fa-edit'></i></a>&nbsp;|&nbsp;"
									+ "<a  onclick='deleteDepartment("
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
	function editDesignation(id) {
		var dummy = $("#parentid1").html();
		$("#id").val(serviceUnitArray[id].id);
		$("#name").val(serviceUnitArray[id].name);
		$('#mailAlias').val(serviceUnitArray[id].email);
		$(window).scrollTop($('#addForm').offset().top);
		}
	function submitDesignation() {
		
		$('#submitId1').css('border', 'solid 1px #862ab7');												    
		if($('#name').val() == "undefined" || $('#name').val().length == 0 || $('#name').val() == "" )
		{												   
	    	if($('#name').val().length == 0  || $('#name').val() == "" || $('#name').val() == "undefined") {
			    $('#name').css('color','red');
			    $("#name").css("border-color","#e73d4a");
			    $("#name").attr("placeholder","Please Enter Designation Name");
			    $('#name').addClass('your-class');
			    $('#name').focus();
		    }
		    return false;												  
		} 
		    
		var name =  $("#name").val();
		var id =  $("#id").val();
		var mailAlias = $("#mailAlias").val();
		var formData = new FormData();
	    
	     formData.append('name', name);
	    formData.append('mailAlias',mailAlias);
	    formData.append('id',id);
	    $.fn.makeMultipartRequest('POST', 'addDesignation', false,
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
	
	function deleteDepartment(departmentId){
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		var formData = new FormData();
	    
	     formData.append('id', departmentId);
		$.fn.makeMultipartRequest('POST', 'deleteDesignation', false,
				formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			alert(jsonobj.message);
			var alldata = jsonobj.allOrders1;
			console.log(jsonobj.allOrders1);
			displayTable(alldata);
		});
		}
		
	}
	