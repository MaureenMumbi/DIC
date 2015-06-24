<%-- 
    Document   : OperationArea
    Created on : Aug 20, 2013, 2:48:22 PM
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
	<title>OPERATION AREA</title>
		

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
                                  
									
                                                                        sUpdateURL: "UpdateOperation",
                                                                        sAddURL: "AddOperation",
                                                                        sDeleteURL: "DeleteOperation",
                    							"aoColumns": [  null,                 									
                    									
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
                    									}
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
  <button id="btnAddNewRow" value="Ok">Add new operation area...</button> 
  <button id="btnDeleteRow" value="cancel">Delete selected operation area</button>

<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th>Operation ID</th>
			<th>Operation</th>
			
			
		</tr>
	</thead>
	<tfoot>
		<tr>

		        
		</tr>

	</tfoot>
   <tbody>
		 
        <c:forEach  var="today" items="${list6}"  >
          
          <c:set var="ID"  value="${today.ID}"></c:set>
          <c:set var="OParea"  value="${today.OPAREA}"></c:set>
           
        <input type="hidden" id="OpID" name="OpID" value="<%= pageContext.getAttribute("ID")%>" />
        <input type="hidden" id="Oparea" name="Oparea" value="<%= pageContext.getAttribute("OParea")%>" />
         
            <tr id="<%=pageContext.getAttribute("ID")%>">
           
           <td>  ${today.ID} </td>
           <td class="sorting_1">${today.OPAREA} </td>
          
          </tr>
       
         </c:forEach>
               
	</tbody>
</table>
 
			</div>
			<div class="spacer"></div>

			
			

			
                </div>	
			
		</div>
    
    
    
     <form id="formAddNewRow" action="#" title="Add new Operation Area">
			    <input type="hidden" id="id" name="id" rel="0" />
			    <label for="name">Code</label><input type="text" name="OperationArea" id="OperationArea" class="required" rel="1" />
			    
			                                      
			    <br />         
			</form>

	</body>


</html>
