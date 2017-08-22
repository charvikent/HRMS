 	function displayTable(listEmployees) {
			$("#basicExample tr td").remove();
			$("#basicExample td").remove();
			serviceUnitArray = {};
			$
					.each(
							listEmployees,
							function(i, employeeObj) {
								
								if(employeeObj.imagePath == null){
									employeeObj.imagePath="img/default.png"
								}
								serviceUnitArray[employeeObj.id] = employeeObj;
								var id = '"' + employeeObj.id + '"emp_id';
								var tblRow = "<tr>"
										+ "<td title='"+employeeObj.emp_id+"'>"
										+ employeeObj.emp_id
										+ "</td>"
										+ "<td title='"+employeeObj.firstName+"'>"
										+ employeeObj.firstName
										+ "</td>"
										+ "<td title='"+employeeObj.lastName+"'>"
										+ employeeObj.lastName
										+ "</td>"
										+ "<td title='"+employeeObj.emailId+"' >"
										+ employeeObj.emailId
										+ "</td>"
										+ "<td  title='"+employeeObj.departmentName+"'>"
										+ employeeObj.departmentName
										+ "</td>"
										+ "<td title='"+employeeObj.dateOfJoin+"'>"
										+ employeeObj.dateOfJoin
										+ "</td>"
										+ "<td  title='"+employeeObj.workLocation+"' >"
										+ employeeObj.workLocation
										+ "</td>"
										+ "<td  title='"+employeeObj.workPhone+"'>"
										+ employeeObj.workPhone
										+ "</td>"
										+ "<td  title='"+employeeObj.phoneExtension+"'>"
										+ employeeObj.phoneExtension
										+ "</td>"
										+ "<td  title='"+employeeObj.alternateEmail+"'>"
										+ employeeObj.alternateEmail
										+ "</td>"
										+ "<td  title='"+employeeObj.reportingToName+"'>"
										+ employeeObj.reportingToName
										+ "</td>"
										+ "<td  title='"+employeeObj.dob+"'>"
										+ employeeObj.dob
										+ "</td>"
										+ "<td  title='"+employeeObj.contactNum+"'>"
										+ employeeObj.contactNum
										+ "</td>"
										+ "<td  title='"+employeeObj.address+"'>"
										+ employeeObj.address
										+ "</td>"
										+ "<td  title='"+employeeObj.statusName+"'>"
										+ employeeObj.statusName
										+ "</td>"
										+ "<td  title='"+employeeObj.employeeTypeName+"'>"
										+ employeeObj.employeeTypeName
										+ "</td>"
										+ "<td  title='"+employeeObj.sourceOfHireName+"'>"
										+ employeeObj.sourceOfHireName
										+ "</td>"
										+ "<td  title='"+employeeObj.maritalStatusName+"'>"
										+ employeeObj.maritalStatusName
										+ "</td>"
										+ "<td  title='"+employeeObj.employeeRoleName+"'>"
										+ employeeObj.employeeRoleName
										+ "</td>"
										+ "<td  title='"+employeeObj.designationName+"'>"
										+ employeeObj.designationName
										+ "</td>"
										+ "<td  title='"+employeeObj.aboutMe+"'>"
										+ employeeObj.aboutMe
										+ "</td>"
										+ "<td  title='"+employeeObj.tags+"'>"
										+ employeeObj.tags
										+ "</td>"
										+ "<td  title='"+employeeObj.nickName+"'>"
										+ employeeObj.nickName
										+ "</td>"
										+ "<td  title='"+employeeObj.jobDesc+"'>"
										+ employeeObj.jobDesc
										+ "</td>"
										+ "<td  title='"+employeeObj.dateOfExit+"'>"
										+ employeeObj.dateOfExit
										+ "</td>"
										+ "<td  title='"+employeeObj.expertise+"'>"
										+ employeeObj.expertise
										+ "</td>"
										+ "<td  title='"+employeeObj.genderName+"'>"
										+ employeeObj.genderName
										+ "</td>"
										+ "<td style='text-align: center;'><a  onclick='editEmployee("
										+ employeeObj.id
										+ ")'><i style='color: green;' class='fa fa-edit'></i></a>&nbsp;|&nbsp;"
										+ "</tr >";
								$(tblRow).appendTo("#datatable-colvid tbody");
							});
	}
 	
 	var rowCount = 1;
 	function editEmployee(id) {
		var transactionId = serviceUnitArray[id].id;
		$("#id").val(serviceUnitArray[id].id);
		$("#emp_id").val(serviceUnitArray[id].emp_id);
		$("#prev_emp_id").val(serviceUnitArray[id].prev_emp_id);
		$('#firstName').val(serviceUnitArray[id].firstName);
		$('#lastName').val(serviceUnitArray[id].lastName);
		$('#emailId').val(serviceUnitArray[id].emailId);
		$('#nickName').val(serviceUnitArray[id].nickName);
		$('#departmentId').val(serviceUnitArray[id].departmentId);
		$('#departmentId').trigger("chosen:updated");
		$('#designationId').val(serviceUnitArray[id].designationId);
		$('#designationId').trigger("chosen:updated");
		$('#dateOfJoin').val(serviceUnitArray[id].dateOfJoin);
		$('#seatingLocation').val(serviceUnitArray[id].seatingLocation);
		$('#workPhone').val(serviceUnitArray[id].dateOfJoin);
		$('#phoneExtension').val(serviceUnitArray[id].phoneExtension);
		$('#contactNum').val(serviceUnitArray[id].contactNum);
		$('#address').val(serviceUnitArray[id].address);
		$('#alternateEmail').val(serviceUnitArray[id].alternateEmail);
		$('#dob').val(serviceUnitArray[id].dob);
		$('#tags').val(serviceUnitArray[id].tags);
		$('#jobDesc').val(serviceUnitArray[id].jobDesc);
		$('#aboutMe').val(serviceUnitArray[id].aboutMe);
		$('#expertise').val(serviceUnitArray[id].expertise);
		$('#dateOfExit').val(serviceUnitArray[id].dateOfExit);
		$('#workLocation').val(serviceUnitArray[id].workLocation);
		$('#workLocation').trigger("chosen:updated");
		$('#reportingTo').val(serviceUnitArray[id].reportingTo);
		$('#reportingTo').trigger("chosen:updated");
		$('#sourceOfHire').val(serviceUnitArray[id].sourceOfHire);
		$('#sourceOfHire').trigger("chosen:updated");
		$('#status').val(serviceUnitArray[id].status);
		$('#status').trigger("chosen:updated");
		$('#employeeType').val(serviceUnitArray[id].employeeType);
		$('#employeeType').trigger("chosen:updated");
		$('#employeeRole').val(serviceUnitArray[id].employeeRole);
		$('#employeeRole').trigger("chosen:updated");
		$('#gender').val(serviceUnitArray[id].gender);
		$('#gender').trigger("chosen:updated");
		$('#maritalStatus').val(serviceUnitArray[id].maritalStatus);
		$('#maritalStatus').trigger("chosen:updated");
		
		 var listExperience = serviceUnitArray[id].experienceDetails;
		 
		 if (listExperience != "") {
			$("#experience_table tbody").remove();
			$.each(listExperience,function(i, experienceObj) {
						var experienceRow ="<tr role='row' id='rowCount"+rowCount+"'>"
						+"<td><input name='pprevComp' type='text'  value='"+experienceObj.prevComp+"'/></td>"
						+"<td><input name='pprevJob' type='text'  value='"+experienceObj.prevJob+"'/></td>"
						+"<td><input name='pprevFromDate' type='text'  value='"+experienceObj.prevFromDate+"'/></td>"
						+"<td><input name='pprevToDate' type='text'  value='"+experienceObj.prevToDate+"'/></td>"
						+"<td><textarea  name='pprevJobDesc' rows='4' cols='10'>"+experienceObj.prevJobDesc+"</textarea></td>"
						+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
						+"</tr>";
						$(experienceRow).appendTo("#experience_table");
						rowCount++;
					});
			
		}else if (listExperience == "") {
			$("#experience_table tbody").remove();
			
			var experienceRow ="<tr role='row' id='rowCount"+rowCount+"'>"
			+"<td><input name='pprevComp' type='text'  value='"+experienceObj.prevComp+"'/></td>"
			+"<td><input name='pprevJob' type='text'  value='"+experienceObj.prevJob+"'/></td>"
			+"<td><input name='pprevFromDate' type='text'  value='"+experienceObj.prevFromDate+"'/></td>"
			+"<td><input name='pprevToDate' type='text'  value='"+experienceObj.prevToDate+"'/></td>"
			+"<td><textarea  name='pprevJobDesc' rows='4' cols='10'>"+experienceObj.prevJobDesc+"</textarea></td>"
			+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
			+"</tr>";
			$(experienceRow).appendTo("#experience_table");
			rowCount++;
		

}
		// to display education row
		 var listEducation = serviceUnitArray[id].educationDetails;
		 if (listEducation != "") {
			 $("#education_table tbody").remove(); 
			$.each(listEducation,function(i, educationObj) {
						var educationRow ="<tr role='row' id='rowCount"+rowCount+"'>"
						+"<td><input name='school_name' type='text'  value='"+educationObj.schoolName+"'/></td>"
						+"<td><input name='qualification' type='text'  value='"+educationObj.qualification+"'/></td>"
						+"<td><input name='qualified_in' type='text'  value='"+educationObj.qualifiedIn+"'/></td>"
						+"<td><input name='sch_completion_date' type='text'  value='"+educationObj.schoolCompletionDate+"'/></td>"
						+"<td><textarea  name='add_notes' rows='4' cols='10' >"+educationObj.additionalNotes+"</textarea></td>"
						+"<td><textarea  name='interests' rows='4' cols='10' >"+educationObj.interests+"</textarea></td>"
						+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
						+"</tr>";
						$(educationRow).appendTo("#education_table");
						rowCount++;
					});
			
		} else if (listEducation == "") {
			 $("#education_table tbody").remove(); 
				var educationRow ="<tr role='row' id='rowCount"+rowCount+"'>"
				+"<td><input name='school_name' type='text'  value='"+educationObj.schoolName+"'/></td>"
				+"<td><input name='qualification' type='text'  value='"+educationObj.qualification+"'/></td>"
				+"<td><input name='qualified_in' type='text'  value='"+educationObj.qualifiedIn+"'/></td>"
				+"<td><input name='sch_completion_date' type='text'  value='"+educationObj.schoolCompletionDate+"'/></td>"
				+"<td><textarea  name='add_notes' rows='4' cols='10' >"+educationObj.additionalNotes+"</textarea></td>"
				+"<td><textarea  name='interests' rows='4' cols='10' >"+educationObj.interests+"</textarea></td>"
				+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
				+"</tr>";
				$(educationRow).appendTo("#education_table");
				rowCount++;
	
}

		 
		// to display dependent row
		 var listDependent = serviceUnitArray[id].dependentDetails;
		 if (listDependent != "") {
			 $("#dependent_table tbody").remove();
			 $.each(listDependent,function(i, dependentObj) {
						var dependentRow ="<tr role='row' id='rowCount"+rowCount+"'>"
						+"<td><input name='dependent_name' type='text'  value='"+dependentObj.dependentName+"'/></td>"
						+'<td><select id="select_rowCount'+rowCount+'" name="dependent_relation">'
						+'<option value="">-- Select --</option>'
						+'<option value="Father">Father</option>'
						+'<option value="Mother">Mother</option>'
						+'<option value="Brother">Brother</option>'
						+'<option value="Sister">Sister</option>'
						+'<option value="Husband">Husband</option>'
						+'<option value="Wife">Wife</option>'
						+'<option value="Child">Child</option>'
						+'</select></td>'
						+"<td><input name='dependent_dob' type='text'  value='"+dependentObj.dependentDob+"'/></td>"
						+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
						+"</tr>";
						$(dependentRow).appendTo("#dependent_table");
						rowCount++;
					});
			
		}else if (listDependent == "") {
			 $("#dependent_table tbody").remove();
				var dependentRow ="<tr role='row' id='rowCount"+rowCount+"'>"
				+"<td><input name='dependent_name' type='text'  value='"+dependentObj.dependentName+"'/></td>"
				+'<td><select id="select_rowCount'+rowCount+'" name="dependent_relation">'
				+'<option value="">-- Select --</option>'
				+'<option value="Father">Father</option>'
				+'<option value="Mother">Mother</option>'
				+'<option value="Brother">Brother</option>'
				+'<option value="Sister">Sister</option>'
				+'<option value="Husband">Husband</option>'
				+'<option value="Wife">Wife</option>'
				+'<option value="Child">Child</option>'
				+'</select></td>'
				+"<td><input name='dependent_dob' type='text'  value='"+dependentObj.dependentDob+"'/></td>"
				+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
				+"</tr>";
				$(dependentRow).appendTo("#dependent_table");
				rowCount++;
}
		
 	
	}  	
 	
 	function updateReportingTo(deptId) {
 		var formData = new FormData();
	    
		formData.append('deptId', deptId);
		$.fn.makeMultipartRequest('POST', 'populateReportingTo', false,
				formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			alert(jsonobj.message);
			var empMap = jsonobj.empMap;
			if(typeof(empMap)  === "undefined" ){
			
			}else{
				var optionsForClass = "";
				optionsForClass = $("#reportingTo").empty();
				optionsForClass.append(new Option("-- Select --", ""));
				$.each(empMap, function(i, emp) {
					var empId=emp.id;
					var empName=emp.name;
					optionsForClass.append(new Option(empName, empId));
				});
				$('#reportingTo').trigger("chosen:updated");
			}
			
		});
 	}

	function addMoreRowsForExperience() {
		rowCount ++;
		var recRow = "<tr role='row' id='rowCount"+rowCount+"'>"
		+"<td><input name='pprevComp' type='text'  value=' '/></td>"
		+"<td><input name='pprevJob' type='text'  value=' '/></td>"
		+"<td><input name='pprevFromDate' type='text'  value=''/></td>"
		+"<td><input name='pprevToDate' type='text'  value=' '/></td>"
		+"<td><textarea  name='pprevJobDesc' rows='4' cols='10' placeholder=' '/></textarea></td>"
		+"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"
		+"</tr>";
			//jQuery('#experience_rows').append(recRow);
			$(recRow).appendTo("#experience_table");
			//$('#experience_table tr:last').after(recRow);
		}
	
	function addMoreRowsForEducation(frm) {
		
		rowCount ++;
		var recRow = '<tr role="row" id="rowCount'+rowCount+'">'+
		'<td><input name="school_name" type="text"  value=""/></td>'+
		'<td><input name="qualification" type="text"  value=""/></td>'+
		'<td><input name="qualified_in" type="text"  value=""/></td>'+
		'<td><input name="sch_completion_date" type="text"  value=""/></td>'+
		'<td><textarea name="add_notes" rows="4" cols="10"></textarea></td>'+
		'<td><textarea name="interests" rows="4" cols="10"></textarea></td>'+
		"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"+
		"</tr>";
			$(recRow).appendTo("#education_table");
	}
		
	function addMoreRowsForDependent() {
		rowCount ++;
		var recRow1 = '<tr role="row" id="rowCount'+rowCount+'">'+
		'<td><input name="dependent_name" type="text"  value=""/></td>'+
		'<td><select name="dependent_relation">'+
		'<option value="Father">-- Select --</option>'+
		'<option value="Father">Father</option>'+
		'<option value="Mother">Mother</option>'+
		'<option value="Brother">Brother</option>'+
		'<option value="Sister">Sister</option>'+
		'<option value="Husband">Husband</option>'+
		'<option value="Wife">Wife</option>'+
		'<option value="Child">Child</option>'+
		'</select>'+
		'</td>'+
		'<td><input name="dependent_dob" type="text"  value=""/></td>'+
		"<td><a href='javascript:void(0);' onclick='removeRow("+rowCount+");'>x</a></td>"+
		"</tr>";
			$(recRow1).appendTo("#dependent_table");
	}

		function removeRow(removeNum) {
			jQuery('#rowCount'+removeNum).remove();
}
		

