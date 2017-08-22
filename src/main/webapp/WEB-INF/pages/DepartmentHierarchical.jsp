<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link href="js/jquery.orgchart.css" media="all" rel="stylesheet" type="text/css" />
<style type="text/css">
#orgChart{
    width: auto;
    height: auto;
}

#orgChartContainer{
    width: 1000px;
    height: 500px;
    overflow: auto;
    background: #eeeeee;
}

    </style>
<h1 style="margin-top:150px;">Department Hierarchical </h1>
    <div id="orgChartContainer">
      <div id="orgChart"></div>
    </div>
    <!-- <div id="consoleOutput">
    </div> -->
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.orgchart.js"></script>
    <script type="text/javascript">
    var test = ${allOrders1};
    var testData = ${allOrders1};
    $(function(){
        org_chart = $('#orgChart').orgChart({
            data: testData
        });
    });

    // just for example purpose
    /* function log(text){
        $('#consoleOutput').append('<p>'+text+'</p>')
    } */
    </script>
    <!-- <script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script> -->
