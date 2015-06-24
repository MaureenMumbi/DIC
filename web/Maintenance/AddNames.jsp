<%-- 
    Document   : AddNames
    Created on : Sep 3, 2013, 11:00:58 AM
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
	<title>Names</title>
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
                                  
									
                                                                        sUpdateURL: "UpdateNameServlet",
                                                                        sAddURL: "AddName",
                                                                        sDeleteURL: "DeleteNames",
                    							"aoColumns": [ null,                  									
                    									
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
  <button id="btnAddNewRow" value="Ok">Add Name...</button> 
  <button id="btnDeleteRow" value="cancel">Delete Selected Name</button>

<table style="width:800px;" cellspacing="0"  class="display" id="example">
	<thead>
		<tr>
			<th>Name ID </th>
			<th>First Name</th>
			<th>Second Name</th>
			<th>Last Name</th>
			
			
		</tr>
	</thead>
	<tfoot>
		<tr>

		        
		</tr>

	</tfoot>
   <tbody>
		 
        <c:forEach  var="today" items="${names}"  >
          
          <c:set var="NameID"  value="${today.ID}"></c:set>
          <c:set var="FName"  value="${today.FNAME}"></c:set>
          <c:set var="SName"  value="${today.SNAME}"></c:set>
          <c:set var="LName"  value="${today.LNAME}"></c:set>
           
        <input type="hidden" id="id" name="id" value="<%= pageContext.getAttribute("NameID")%>" />
        <input type="hidden" id="FName" name="Name" value="<%= pageContext.getAttribute("FName")%>" />
        <input type="hidden" id="SName" name="Name" value="<%= pageContext.getAttribute("SName")%>" />
        <input type="hidden" id="LName" name="Name" value="<%= pageContext.getAttribute("LName")%>" />
       
         
            <tr id="<%=pageContext.getAttribute("NameID")%>">
           
           <td>  ${today.ID} </td>
           <td>${today.FNAME} </td>
           <td>${today.LNAME} </td>
           <td>${today.SNAME} </td>
          
          
          </tr>
       
         </c:forEach>

               
	</tbody>
</table>
 
			</div>
			<div class="spacer"></div>

			
			

			
			
			
		</div>
    
    
    
     <form id="formAddNewRow" action="#" title="Add new name">
         <table>		    
                 <input type="hidden" id="id" name="id" rel="0" />
                            
                 <tr> <td>Unique ID</td><td><input type="text" name="UniqueID" id="UniqueID" class="required" rel="1" /><td></tr>
                 <tr> <td>First Name</td><td><input type="text" name="FirstName" id="FirstName" class="required" rel="1" /></td></tr>
                 <tr><td>Second Name</td><td><input type="text" name="SecondName" id="SecondName" class="required" rel="1" /></td></tr>
                 <tr> <td>Last Name</td><td><input type="text" name="LastName" id="LastName" class="required" rel="1" /></td></tr>
			    
			                                      
         </table>	    <br />         
			</form>

	</body>


</html>


