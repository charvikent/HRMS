<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


		
		<br/><br/><br/>

<div id="calendar"></div>
<style>
body {
    margin: 0;
    padding: 50px 0 0 0;
    font-family:"Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
    font-size: 14px;
}
#calendar {
    width: 100%;
}
.holiday {
    background: lightgray;
}

.fc-sun { color:blue; background-color: ivory !important; }
.fc-other-month .fc-day-number { display:none;}
</style>

							

<!-- <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script> -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="assets/plugins/datatables/buttons.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="assets/plugins/datatables/responsive.bootstrap.min.js"></script>
<script src="assets/plugins/datatables/dataTables.colVis.js" type="text/javascript"></script>
	<script src="js/jquery-ui.min.js"></script>        
<script src="js/moment.min.js"></script> 
	<script src="js/fullcalendar.js"></script>        
<link href="css/fullcalendar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
$(document).ready(function () {
$('#calendar').fullCalendar({
	 disableDragging: true,
	 minTime: "08:00:00",
	  maxTime: "21:00:00",
	  theme: true,
      header: {
          left: 'prev,next today,prevYear,nextYear',
          center: 'title',
          right: 'month,agendaWeek,agendaDay'
      },
//       editable: true,
      
    events: function(start, end, timezone, callback) {
    	var formData = new FormData();
    	 $.fn.makeMultipartRequest('POST', 'getHolidays', false,
 				formData, false, 'text', function(data){
 			var jsonobj = $.parseJSON(data);
//  			alert(data);
 			var alldata = jsonobj.allOrders1;
 			var workingDetails = jsonobj.workingDetails;
 			 var events = [];
 			$.each(alldata,function(i, orderObj) {
 				events.push({
                    title: orderObj.title,
                    start: orderObj.start,
                    end: orderObj.end,
                    color  : '#9caed4'
                });
 			});
 			$.each(workingDetails,function(i, orderObj) {
 				events.push({
                    title: "CheckIn",
                    start: orderObj.checkIn,
                    color  : '#d084aa'
                });
 			});
 			$.each(workingDetails,function(i, orderObj) {
 				
 				events.push({
                    title: "CheckOut",
                    start: orderObj.checkOut,
                    color  : '#4444'
                });
 			});
             callback(events);
    	 });
    },
    /* events: function(start, end, timezone, callback) {
    	var formData = new FormData();
    	 $.fn.makeMultipartRequest('POST', 'getHolidays', false,
 				formData, false, 'text', function(data){
 			var jsonobj = $.parseJSON(data);
//  			alert(data);
 			var alldata = jsonobj.allOrders1;
 			 var events = [];
 			$.each(alldata,function(i, orderObj) {
 				events.push({
                    title: orderObj.title,
                    start: orderObj.start,
                    end: orderObj.end,
                    color  : 'blue'
                });
 			});
             callback(events);
    	 });
    } */
   
});
});
</script>
