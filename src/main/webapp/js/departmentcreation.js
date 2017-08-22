 function resetForm()
    {
    	removeBorder('name');
    	$('#name').val("");
    	$('#name').removeClass('your-class default-class');
    	
    	removeBorder('email');
    	$('#email').val("");
    	$('#email').removeClass('your-class default-class');
    	
    	removeBorder('departmentHead');
    	$('#departmentHead').val("");
    	$('#departmentHead').removeClass('your-class default-class');
    	
    	removeBorder('parentid');
    	$('#parentid').val("");
    	$('#parentid').removeClass('your-class default-class');

    }

function displayTable(listOrders) {
		$('#tableId').html('');
		var tableHead = '<table class="table table-striped table-hover table-bordered"	id="datatable-colvid">'
				+ '<thead><tr><th>Department Name</th><th>Email</th> <th>Department Head</th><th>Parent Department</th><th style="text-align: center;">Action</th>	</tr></thead><tbody></tbody></table>';
		$('#tableId').html(tableHead);
		serviceUnitArray = {};
		$
				.each(
						listOrders,
						function(i, orderObj) {
							serviceUnitArray[orderObj.departmentId] = orderObj;
							var id = '"' + orderObj.departmentId + '"';
							var tblRow = "<tr >"
									+ "<td  id='"+orderObj.departmentId+"name'"+" title='"+orderObj.name+"'>"
									+ orderObj.name
									+ "</td>"
									+ "<td   id='"+orderObj.departmentId+"email'"+" title='"+orderObj.email+"'>"
									+ orderObj.email
									+ "</td>"
									+ "<td  id='"+orderObj.departmentId+"departmentHead'"+" title='"+orderObj.departmentHead+"'>"
									+ orderObj.departmentHead
									+ "</td>"
									+ "<td  id='"+orderObj.parentName+"parentid'"+" title='"+orderObj.parentName+"'>"
									+ orderObj.parentName
									+ "</td>"
									+ "<td style='text-align: center;'><a  onclick='updateDepartment("
									+ orderObj.departmentId
									+ ")'><i style='color: green;' class='fa fa-edit'></i></a>&nbsp;|&nbsp;"
									+ "<a  onclick='deleteDepartment("
									+ orderObj.departmentId
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
	function updateDepartment(id) {
		var dummy = $("#parentid1").html();
		$("#parentid").empty();
		$(dummy).appendTo("#parentid");	
		$("#parentid option[value="+serviceUnitArray[id].departmentId+"]").hide();
		$("#id").val(serviceUnitArray[id].departmentId);
		$("#name").val(serviceUnitArray[id].name);
		$('#email').val(serviceUnitArray[id].email);
		$('#departmentHead').val(serviceUnitArray[id].departmentHead);
		$('#parentid').val(serviceUnitArray[id].parentid);
		$('#parentid').trigger("chosen:updated");
		$(window).scrollTop($('#addForm').offset().top);
		}
	function submitDepartment() {
		
		$('#submitId1').css('border', 'solid 1px #862ab7');												    
		if( $('#name').val().length == 0 || $('#name').val() == "" || $('#name').val() == "undefined")
		{												   
	    	if($('#name').val().length == 0  || $('#name').val() == "" || $('#name').val() == "undefined") {
			    $('#name').css('color','red');
			    $("#name").css("border-color","#e73d4a");
			    $("#name").attr("placeholder","Please Enter Department Name");
			    $('#name').addClass('your-class');
			    $('#name').focus();
		    }
		    return false;												  
		} 
		    
		var name =  $("#name").val();
		var id =  $("#id").val();
		var email = $("#email").val();
		var departmentHead =$("#departmentHead").val();
		var parentid = $("#parentid").val();
		var formData = new FormData();
	    
	     formData.append('name', name);
	    formData.append('email',email);
	    formData.append('departmentHead',departmentHead);
	    formData.append('parentid',parentid);
	    formData.append('id',id);
	    $.fn.makeMultipartRequest('POST', 'updateDepartment', false,
				formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			alert(jsonobj.message);
			var alldata = jsonobj.allOrders1;
			if(typeof(alldata)  === "undefined" ){
			
			}else{
				console.log(jsonobj.allOrders1);
				displayTable(alldata);
			}
			var departnames = jsonobj.departnames
			var optionsForClass = "";
			if(jsonobj.message !="duplicate"){
			optionsForClass = $("#parentid").empty();
			optionsForClass.append(new Option("-- Choose Class --", ""));
			$.each(departnames, function(i, tests) {
				var id=tests.id;
				var departmentName=tests.name;
				optionsForClass.append(new Option(departmentName, id));
			});
			}
			$('#parentid').trigger("chosen:updated");
			if(jsonobj.message =="duplicate"){
				
			}else{
				$("#id").val("0");
				$("#cancel").click();
				
			}
		});
	    
	}
	
	function deleteDepartment(departmentId){
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		var formData = new FormData();
	    
	     formData.append('id', departmentId);
		$.fn.makeMultipartRequest('POST', 'deleteDepartment', false,
				formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			alert(jsonobj.message);
			var alldata = jsonobj.allOrders1;
			console.log(jsonobj.allOrders1);
			displayTable(alldata);
		});
		}
		
	}
	