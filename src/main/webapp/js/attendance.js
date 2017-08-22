
function displayTable(listOrders) {
		$('#tableId').html('');
		var tableHead = '<table class="table table-striped table-hover table-bordered"	id="datatable-colvid">'
				+ '<thead><tr><th>Employee Name</th><th>Working Day</th> <th style="text-align: center;">Total Time</th>	</tr></thead><tbody></tbody></table>';
		$('#tableId').html(tableHead);
		serviceUnitArray = {};
		$.each(listOrders,function(i, orderObj) {
							serviceUnitArray[orderObj.id] = orderObj;
							var id = '"' + orderObj.id + '"';
							var tblRow = "<tr >"
									+ "<td   title='"+orderObj.firstName+"'>"
									+ orderObj.firstName
									+ "</td>"
									+ "<td   title='"+orderObj.workingDay+"'>"
									+ orderObj.workingDay
									+ "</td>"
									+ "<td   title='"+orderObj.sumtime+"'>"
									+ orderObj.sumtime
									+ "</td>"
									 "</tr >";
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
	
	function submitSearch() {
		
		/*if($('#name').val() == "undefined" || $('#name').val().length == 0 || $('#name').val() == "" )
		{												   
	    	if($('#name').val().length == 0  || $('#name').val() == "" || $('#name').val() == "undefined") {
			    $('#name').css('color','red');
			    $("#name").css("border-color","#e73d4a");
			    $("#name").attr("placeholder","Please Enter Department Name");
			    $('#name').addClass('your-class');
			    $('#name').focus();
		    }
		    return false;												  
		} */
		var id =  $("#name").val();
		
		
		var formData = new FormData();
	    
	    formData.append('id',id);
	    
	    $.fn.makeMultipartRequest('POST', 'searchWorkingEmployee', false,
				formData, false, 'text', function(data){
	    	
			var jsonobj = $.parseJSON(data);
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
	