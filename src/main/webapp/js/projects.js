function resetForm()
{
	removeBorder('name');
	$('#name').val("");
	$('#name').removeClass('your-class default-class');
	
	removeBorder('clientId');
	$('#clientId').val("");
	$('#clientId').removeClass('your-class default-class');
	
	removeBorder('projectcost');
	$('#projectcost').val("");
	$('#projectcost').removeClass('your-class default-class');
	
	removeBorder('projectManager');
	$('#projectManager').val("");
	$('#projectManager').removeClass('your-class default-class');
	
}

function displayTable(listOrders) {
		$('#tableId').html('');
		var tableHead = '<table class="table table-striped table-hover table-bordered"	id="datatable-colvid">'
				+ '<thead><tr><th>Designation Name</th><th>Project Cost</th> <th style="text-align: center;">Action</th>	</tr></thead><tbody></tbody></table>';
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
									+ "<td   title='"+orderObj.projectcost+"'>"
									+ orderObj.projectcost
									+ "</td>"
									+ "<td style='text-align: center;'><a  onclick='editProject("
									+ orderObj.id
									+ ")'><i style='color: green;' class='fa fa-edit'></i></a>&nbsp;|&nbsp;"
									+ "<a  onclick='deleteProject("
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
	function editProject(id) {
		name,clientId,projectcost,projectManager 
		$("#id").val(serviceUnitArray[id].id);
		$("#name").val(serviceUnitArray[id].name);
		$('#clientId').val(serviceUnitArray[id].clientId);
		$('#projectcost').val(serviceUnitArray[id].projectcost);
		$('#projectManager').val(serviceUnitArray[id].projectManager);
		$(window).scrollTop($('#addForm').offset().top);
		}
	function submitProjects() {
		
		if($('#name').val() == "undefined" || $('#name').val().length == 0 || $('#name').val() == "" )
		{												   
	    	if($('#name').val().length == 0  || $('#name').val() == "" || $('#name').val() == "undefined") {
			    $('#name').css('color','red');
			    $("#name").css("border-color","#e73d4a");
			    $("#name").attr("placeholder","Please Enter Project Name");
			    $('#name').addClass('your-class');
			    $('#name').focus();
		    }
		    return false;												  
		} 
//		id,created_time,name,clientId,projectcost,projectManager
		var name =  $("#name").val();
		var id =  $("#id").val();
		var clientId = $("#clientId").val();
		var projectcost = $("#projectcost").val();
		var projectManager = $("#projectManager").val();
		
		var formData = new FormData();
		
	    formData.append('id',id);
	     formData.append('name', name);
	    formData.append('clientId',clientId);
	    formData.append('projectcost', projectcost);
	    formData.append('projectManager', projectManager);
	
	    $.fn.makeMultipartRequest('POST', 'addProject', false,
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
	
	function deleteProject(id){
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		var formData = new FormData();
	    
	     formData.append('id', id);
		$.fn.makeMultipartRequest('POST', 'deleteProject', false,
				formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			alert(jsonobj.message);
			var alldata = jsonobj.allOrders1;
			console.log(jsonobj.allOrders1);
			displayTable(alldata);
		});
		}
		
	}
	