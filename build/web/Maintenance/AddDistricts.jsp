<%-- 
    Document   : AddDistricts
    Created on : Aug 16, 2013, 1:32:53 PM
    Author     : Maureen
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<html><head>
	<title>COUNTY</title>
		

        <script src="scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <!--<script src="media/js/jquery-ui.js" type="text/javascript"></script>-->
<!--   <script src="media/js/jquery.validate.js" type="text/javascript"></script>-->
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
<script src="scripts/jquery.validate.js" type="text/javascript"></script>
<link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />

		<script type="text/javascript">
			$(document).ready( function () {
				$('#example').dataTable().makeEditable({
                                  
									
                                                                        sUpdateURL: "UpdataCounty",
                                                                        sAddURL: "AddDistrict",
                                                                        sDeleteURL: "DeleteDistrict",
                    							"aoColumns": [                   									
                    									null,
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving...',
                                                            					tooltip: 'Click to edit ',
												type: 'textarea',
                                                 						submit:'Save changes',
                                                                                                 callback : function(value, settings)
                                                                                                                        { 
                                                                                                                            alert(value);
                                                                                                                            window.location.reload();
                                                                                                                        
                                                                                                                        },
												fnOnCellUpdated: function(sStatus, sValue, row, column, settings){
													alert("(Cell Callback): Cell["+row+","+column+"] is updated with value " + sValue);
												}
                    									},
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving ...',
                                                            					tooltip: 'Click to edit ',
												type: 'textarea',
                                                 						submit:'Save changes',
                                                                                                callback : function(value, settings)
                                                                                                                        { 
                                                                                                                            alert(value);
                                                                                                                            window.location.reload();
                                                                                                                        // settings involing plugin parameters
//                                                                                                                        alert('Element Changed : '+value);											
                                                                                                                        //alert(settings.cssclass);
                                                                                                                        },
												fnOnCellUpdated: function(sStatus, sValue, row, column, settings){
													alert("(Cell Callback): Cell["+row+","+column+"] is updated with value " + sValue);
												}
                    									},
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving platforms...',
                                                            					tooltip: 'Click to edit',
												type: 'textarea',
                                                 						submit:'Save changes',
                                                                                                callback : function(value, settings)
                                                                                                                        { 
                                                                                                                            alert(value);
                                                                                                                            window.location.reload();
                                                                                                                        // settings involing plugin parameters
//                                                                                                                        alert('Element Changed : '+value);											
                                                                                                                        //alert(settings.cssclass);
                                                                                                                        },
												fnOnCellUpdated: function(sStatus, sValue, row, column, settings){
													alert("(Cell Callback): Cell["+row+","+column+"] is updated with value " + sValue);
												}
                    									},
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving...',
                                                            					tooltip: 'Click to edit',
												type: 'textarea',
                                                 						submit:'Save changes',
                                                                                                callback : function(value, settings)
                                                                                                                        { 
                                                                                                                            alert(value);
                                                                                                                            window.location.reload();
                                                                                                                        // settings involing plugin parameters
//                                                                                                                        alert('Element Changed : '+value);											
                                                                                                                        //alert(settings.cssclass);
                                                                                                                        },
												fnOnCellUpdated: function(sStatus, sValue, row, column, settings){
													alert("(Cell Callback): Cell["+row+","+column+"] is updated with value " + sValue);
												}
                    									},
//                    									
											]									

										});
				
			} );
		</script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-17838786-2']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
<link rel="StyleSheet" href="css/main.css" type="text/css" />
 <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
    #container{
                height:500px;
                width:1000px; 
    }
     .example {
    width:1000px;
    height:900px;
     }
    </style>
	</head>



<body id="dt_example">
    
   <div class="example">
           <div class="login">
     <% String logStatus=(String)session.getAttribute("loggedIn");
               if(logStatus==null){
     %>
                   <a class="button-1" href="Login.jsp">Login</a>
     <%        } else{
     %>
                    <a class="button-1" href="../DIC/logoutServlet">LogOut</a>
     <%
               }
        String username=(String)session.getAttribute("Username");
      
               if(username==null){
                   
               } else{
     %>
               <h5>Welcome <%=username%></h5>
     <%
               }
        
 
      %>
           </div>
             <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
   
    <%@include file="../menu/adminmenu.html" %>
     
    
    
    
		<div id="container">
		
			<div id="demo">
  <button id="btnAddNewRow" value="Ok">Add new county...</button> 
  <button id="btnDeleteRow" value="cancel">Delete selected company</button>

<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th>County ID</th>
			<th>County</th>
			
			
		</tr>
	</thead>
	<tfoot>
		<tr>

			<th>County ID</th>
			<th>County</th>
			
		</tr>

	</tfoot>
   <tbody>
		 
         <c:forEach  var="today" items="${list1}"  >
            <c:set var="CountyID"  value="${today.ID}"></c:set>
            <c:set var="County"  value="${today.COUNTY}"></c:set>
            
              <input type="hidden" id="countyid" name="countyid" value="<%= pageContext.getAttribute("CountyID")%>" />
           <input type="hidden" id="county" name="county" value="<%= pageContext.getAttribute("County")%>" />
             <tr id="<%=pageContext.getAttribute("CountyID")%>">
           
           <td>  ${today.ID} </td>
           <td class="sorting_1">${today.COUNTY} </td>
          
          
          </tr>
       
         </c:forEach>
               
	</tbody>
</table>
 
			</div>
			<div class="spacer"></div>
		

			
			
			
		</div>
    
    
    
     <form id="formAddNewRow" action="#" title="Add new County">
			    <input type="hidden" id="id" name="id" rel="0" />
			    <label for="name">County Name</label><input type="text" name="county" id="county" class="required" rel="1" />
			    
			                                        </select>   
			    <br />         
			</form>

		
	
	</body>


</html>




<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="jquery-1.9.1.js" type="text/javascript"></script>
        <script src="jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="jquery.dataTables.editable.js" type="text/javascript"></script>
        <script src="jquery.jeditable.js" type="text/javascript"></script>
        <script src="jquery.validate.js" type="text/javascript"></script>
        <script src="jquery-ui.js" type="text/javascript"></script>
    </head>
    <body>
         <button id="btnAddNewRow" value="Ok">Add new company...</button> 
        <form name="form" method="post" action="http://localhost:8080/DIC/AddDistrict">
        <table>
            <tr>
                <td>District </td>
                <td><input type="text" value="" name="Districts"></td>
                <td><input type="submit" value="Save" name="Submit"></td>
            </tr>
     </table>
            </form>
    </body>
    
</html>-->
