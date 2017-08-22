
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
									+ "<td   title='"+orderObj.projName+"'>"
									+ orderObj.projName
									+ "</td>"
									+ "<td    title='"+orderObj.jobName+"'>"
									+ orderObj.jobName
									+ "</td>"
								
									+ "<td style='text-align: center;'><a  onclick='editDesignation("
									+ orderObj.id
									+ ")'><i style='color: green;' class='fa fa-edit'></i></a>&nbsp;|&nbsp;"
									+ "<a  onclick='deleteTimeLog("
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

function deleteTimeLog(id){
	var checkstr =  confirm('Are you sure you want to delete this?');
	if(checkstr == true){
	var formData = new FormData();
    
     formData.append('id', id);
	$.fn.makeMultipartRequest('POST', 'deleteTimeLog', false,
			formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
		alert(jsonobj.message);
		
		var alldata = jsonobj.allOrders1;
		if(typeof(alldata)  === "undefined"  ){
		
		}else{
			console.log(jsonobj.allOrders1);
			displayTable(alldata);
		}
	});
	}
	
}