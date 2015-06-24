<%-- 
    Document   : viewRed
    Created on : May 18, 2014, 12:26:20 AM
    Author     : Maureen
--%>

<%-- 
    Document   : CondomCode
    Created on : Aug 20, 2013, 5:04:02 PM
    Author     : Maureen
--%>


<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %> 

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%! HttpSession session;

   %>

<html><head>
	<title>Risk Reductions</title>
		

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
                                  
									
                                                                        sUpdateURL: "UpdateCondomCode",
                                                                        sAddURL: "AddCondomCode",
                                                                        sDeleteURL: "DeleteCondomCode",
                    							"aoColumns": [ null,                  									
                    									
                    									null,null
//                    									
											]									

										});
				
			} );
		</script>

 <script language="javascript" type="text/javascript" >
//     var idw = document.getElementById("UID").value(); 
     function editRecord(idw,unq){
         
//     alert(idw,unq);
    var f=document.form;
    f.method="post";
//    f.action="/DIC/RiskReductionServlet?UniqueID1="+idw+"&UniqueID="+unq;
    f.action="/DIC/admin/editRiskRed.jsp?UniqueID1="+idw+"&UniqueID="+unq;
    f.submit();
    
}
function deleteRecord(UniqueID1){
    var f=document.form;
    f.method="post";
    f.action="/DIC/DeleteRiskRed?UniqueID="+UniqueID1; 
    f.submit();
}

</script>
<link rel="StyleSheet" href="css/main.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
   #container{
                height:500px;
                width:1000px; 
    }
     .example {
    width:1350px;
    height:900px;
     }
    </style>
    </head>
	 <body id="dt_example">
         

<div class="example">
            <div class="login">
      <%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server

    String username=(String)session.getAttribute("Username");
      
               if(session.getAttribute("Username")==null){
                    response.sendRedirect("/DIC/index.jsp"); 
               }           
     
        else{
     %>
      <a class="button-1" href="../logoutServlet">LogOut</a>         
     <h5>Welcome <%=username%></h5>
     <%
               }
        
 
      %>
           </div>
             <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
   
       <!--=========================================menu=========================================-->     
              <div style="width:1350px;"> 
                     <%
if(session.getAttribute("AccessLevel")!=null){            

if (session.getAttribute("AccessLevel").equals("2")) {%>
            <%@include file="../menu/adminmenu.html" %>
            <%}
else{%>

 <%@include file="../menu/clerkmenu.html" %>

<%}

}

else{ %>
        
             <%@include file="../menu/clerkmenu.html" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>
    
    
    
		<div id="container">
		
			<div id="demo">
<!--  <button id="btnAddNewRow" value="Ok">Add new code...</button> 
  <button id="btnDeleteRow" value="cancel">Delete selected code</button>-->
    <form name="form">
    
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th>ID</th>
			<th>Date of Assessment </th>
			<th>Unique Id </th>
			<th>Edit </th>
			<th>Delete </th>
			
			
			
		</tr>
	</thead>
	<tfoot>
		<tr>

		        
		</tr>

	</tfoot>
   <tbody>
		 
        <c:forEach  var="assessment" items="${reduction}"  >
          
          <c:set var="assessID"  value="${assessment.ASSESSMENTID}"></c:set>
          <c:set var="UniqueID"  value="${assessment.UNIQUEID}"></c:set>
          <c:set var="assessDate"  value="${assessment.ASSESSMENTDATE}"></c:set>
           
        <input type="hidden" id="id" name="id" value="<%= pageContext.getAttribute("assessID")%>" />
        <input type="hidden" id="UniqueID" name="UniqueID" value="<%= pageContext.getAttribute("UniqueID")%>" />
        <input type="hidden" id="CondomCode" name="CondomCode" value="<%= pageContext.getAttribute("assessDate")%>" />
         
            <tr id="<%=pageContext.getAttribute("assessID")%>">
           
           <td>  ${assessment.ASSESSMENTID} </td>
           <td class="sorting_1">${assessment.ASSESSMENTDATE} </td>
           <td class="sorting_1">${assessment.UNIQUEID} </td>
            <td><input type="button" name="Edit" value="Edit" id="UID" onclick="editRecord('${assessment.ASSESSMENTID}','${assessment.UNIQUEID}')"></td>
           <td><input type="button"  name="delete" value="Delete" onclick="deleteRecord('${assessment.ASSESSMENTID}')"></td>
              
             
               <% session.setAttribute("UniqueID", pageContext.getAttribute("assessID"));%>
              
          </tr>
       
         </c:forEach>
               
	</tbody>
</table>
    </form>
			</div>
			<div class="spacer"></div>

			
			

			
			
			
		</div>
    
    </div>
    </div>
    
  

	</body>


</html>

