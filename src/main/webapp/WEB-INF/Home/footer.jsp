



<script type="text/javascript">

window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);

function removeBorder(el){	
	  $("#"+el).css("border", ""); 	
	  $("#"+el).css('color','black');
	  $('#'+el).addClass('default-class');
}


$(document).ready(function () {
    $('#datatable-colvid').DataTable({
        "dom": 'C<"clear">lfrtip',
        "colVis": {
            "buttonText": "Change columns",
        "buttons": [{extend:"copy",className:"btn default"},{extend:"print",className:"btn default"},{extend:"pdf",className:"btn default"},{extend:"csv",className:"btn default"}]
        }
    });
    
});
$.fn.dataTableExt.sErrMode = 'console';
$('#datatable-colvid').dataTable();
</script>

        <!-- jQuery  -->
        
       
          <script src="js/ajax.js"></script>
          
          

	
<!--         <script src="assets/js/jquery.min.js"></script> -->
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/detect.js"></script>
        <script src="assets/js/fastclick.js"></script>
        <script src="assets/js/jquery.blockUI.js"></script>
        <script src="assets/js/waves.js"></script>
        <script src="assets/js/jquery.slimscroll.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
<!--         <script src="plugins/switchery/switchery.min.js"></script> -->

        <!-- Dashboard init -->
<!--         <script src="assets/pages/jquery.dashboard.js"></script> -->

        <!-- App js -->
        <script src="assets/js/jquery.core.js"></script>
        <script src="assets/js/jquery.app.js"></script>
        
        
<!--         <link rel="stylesheet" href="http:http//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css"> -->
<!--   <script src="http//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script> -->
</body>
</html>