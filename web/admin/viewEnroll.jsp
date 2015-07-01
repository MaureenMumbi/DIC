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
String username="";
   %>

<html><head>
	<title>Enrollments</title>
		

        <script src="scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <!--<script src="media/js/jquery-ui.js" type="text/javascript"></script>-->
<!--   <script src="media/js/jquery.validate.js" type="text/javascript"></script>-->
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
<script src="scripts/jquery.validate.js" type="text/javascript"></script>
<link href="../media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="../media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="../media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="../media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="../media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
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
    
     function editRecord(UniqueID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/admin/editWorkers.jsp?UniqueID='"+UniqueID+"'";
    window.open("/DIC/admin/editWorkers.jsp?UniqueID='"+UniqueID+"'",'_blank')
    f.submit();
    
}
function deleteRecord(UniqueID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
    f.submit();
}

</script>
<script type="text/javascript">
    
    
   function  capturefingerprint(UniqueID){
        
        //alert(id +"::"+fname);l
       var id= UniqueID; 
       // alert(id)
        var handid="capturedhand"+id;
       // alert(handid);
       var hand= document.getElementById(handid).value;
       // alert(hand);
        var xmlhttp;  
                
               
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange=function()
                {
                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                    {
                        
         document.getElementById("msg").innerHTML=xmlhttp.responseText;
          //refresh page              
       // window.location.reload();
                    }
                }
                xmlhttp.open("POST","/DIC/Selection?uniqueid="+id+"&hand="+hand,true);
                xmlhttp.send();
//                document.getElementById("example").innerHTML="";
   document.getElementById("msg").innerHTML="<img src=\"images/sending.gif\" alt=\"searching\">Adding fingerprint";
        
        
    }
    
     
                    
         
             
    
</script>

<link rel="StyleSheet" href="css/main.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
   #container{
                height:500px;
                width:1200px; 
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
          if(session.getAttribute("Username")!=null){
        String username=(String)session.getAttribute("Username");
      %>
          
       <a class="button-1" href="../DIC/logoutServlet">LogOut</a>          
     <h5>Welcome <%=username%></h5>
     <% }else{
//               response.sendRedirect("/DIC/index.jsp"); 
     }
     %>
           </div>
             <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
   
       <!--=========================================menu=========================================-->     
              <div style="width:1550px;"> 
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
    
    
    
           <div id="container" style="width: 1300px;">
		
			<div id="demo">
<!--  <button id="btnAddNewRow" value="Ok">Add new code...</button> 
  <button id="btnDeleteRow" value="cancel">Delete selected code</button>-->
    <form name="form">
     <p id="msg" style="color:red; font-size:15px;"><p>
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		
			<tr>
			<th>UniqueID</th>
   <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%><th>Full Name</th><%}}%>
                        <th>Client Initials</th>
			<th>DIC Name</th>
			<th>DOE</th>
			<th>EDIT</th>
			<th>Hand Used</th>
                        <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%><th>CAPTURE FINGERPRINT</th><%}}%>
			<th>DELETE FSW</th>
			
			
			
			
		</tr>
			

			
		</thead>
	<tfoot>
		<tr>

		        
		</tr>

	</tfoot>
   <tbody>
		 
        <c:forEach  var="today" items="${enrollments}"  >
         
                   
          <c:set var="UniqueID"  value="${today.UNIQUEID}"></c:set>
          <c:set var="Name"  value="${today.NAME}"></c:set>
          <c:set var="clientInit"  value="${today.CLIENTINIT}"></c:set>
          <c:set var="dicname"  value="${today.DICNAME}"></c:set>
          <c:set var="doe"  value="${today.DOE}"></c:set>
          <c:set var="hand"  value="${today.HAND}"></c:set>
           
        <input type="hidden" id="UniqueID" name="UniqueID" value="<%= pageContext.getAttribute("UniqueID")%>" />
        <input type="hidden" id="Name" name="Name" value="<%= pageContext.getAttribute("Name")%>" />
        <input type="hidden" id="Hand" name="Hand" value="<%= pageContext.getAttribute("hand")%>" />
         
             <tr id="<%=pageContext.getAttribute("UniqueID")%>">
           
           <td class="sorting_1">  ${today.UNIQUEID} </td>
         <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%><td class="sorting_1">${today.NAME} </td><%}}%>
           <td class="sorting_1">${today.CLIENTINIT} </td>
           <td class="sorting_1">${today.DICNAME} </td>
           <td class="sorting_1">${today.DOE} </td>
          
                      <td class="sorting_1">
                        <a href=""  style="background-color: #E0E0E0; height: 12px; width:20px; font-size: 14px; " onclick="editRecord('${today.UNIQUEID}')">Edit</a>  
                        
                      </td>
                     
                     
                       <td>  <select name="capturedhand" required id="capturedhand${today.UNIQUEID}">
                                    <option value="">used hand</option>
                                    <option value="right hand" title="default hand">right hand</option>
                                    <option value="left hand">left hand</option>
                                    <option value="left and right">both hands</option>
                                </select> ${today.HAND} </td>
                      
              <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%><td class="sorting_1"><input type="button"  name="capture" value="Capture Fingerprint" onclick="capturefingerprint('${today.UNIQUEID}')"></td><%}}%>
               
               <% session.setAttribute("UniqueID", pageContext.getAttribute("UniqueID"));%>

            <% if (session.getAttribute("AccessLevel").equals("2")){%>
                <td class="sorting_1"><input type="button"  name="delete" value="Delete" onclick="deleteRecord('${today.UNIQUEID}')"></td>
              <%
            }
%>
          </tr>
       
         </c:forEach>
               
	</tbody>
</table>
    </form>
			</div>
			<div class="spacer"></div>

			
			

			
			
			
		</div>
    
    </div>
    
    
  

	</body>


</html>
