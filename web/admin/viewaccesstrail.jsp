<%-- 
    Document   : viewaccesstrail
    Created on : Aug 24, 2015, 2:58:11 PM
    Author     : Maureen
--%>

<%@page import="dbConnect.dbConnect"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %> 

<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%! HttpSession session;
String username="";
   %>

   <%if(session.getAttribute("accessTrail")!=null){ %>
<%@page import="Maintenance.saveAccessTrail"%>
<%
saveAccessTrail access = new saveAccessTrail();
String task="Accessed module for viewing access trails. ";
String username=session.getAttribute("accessTrail").toString();
access.addAccess(username,task);

%>
<%}%>

<html><head>
	<title>Access Trail</title>
		

        <!--<script src="scripts/jquery-2.0.0.min.js" type="text/javascript"></script>-->
   
        <script src="scripts/jquery-1.7.2.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
      
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
    
     

 <script language="javascript" type="text/javascript" >
    
     function editRecord(UniqueID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/WorkerServlet?UniqueID='"+UniqueID+"'";
    window.open("/DIC/WorkerServlet?UniqueID='"+UniqueID+"'",'_blank')
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
               
//                jQuery(document).ready(function() {   
            function loaddata(){
//           document.getElementById("loading").innerHTML="<img src='images/loading.gif'>"; 

            var type=document.getElementById("DICName").value;
        
             $.ajax({
                    url:"../getData?type="+type,
                    type:'post',
                    dataType:'html',
                    success:function (data){
//                       alert("enetered"); 
                      window.location.reload();
//                            $("#example").html(data);

                
                    }
                    
                    
                    
                });
            
            } 
//            });
</script>
    
<script>
function filter_districts(District){
 var dist = document.getElementById("district").value;
   var distr = new Array();
// this will return an array with strings "1", "2", etc.
distr = dist.split(",");
var districtsName=distr[0];
//
// window.open("districtselector?county="+dist.value);     
var xmlhttp;    
if (districtsName=="")
{
//filter the districts    



document.getElementById("DICName").innerHTML="<option value=\"\">Choose DIC Name</option>";
return;
}
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
document.getElementById("DICName").innerHTML=xmlhttp.responseText;
}
}
xmlhttp.open("POST","/DIC/districtselector?district="+districtsName,true);

xmlhttp.send();


}//end of filter 
    
            </script>
               <!--<script src="jquery.dataTables.js" type="text/javascript"></script>-->
             <script type="text/javascript">
			$(document).ready( function () {
				$('#example').dataTable().makeEditable({
                                  
									
                                                                       
                    							"aoColumns": [ null,                  									
                    									
                    									null,null,null
//                    									
											]									

										});
				
			} );
		</script>
       

<link rel="StyleSheet" href="css/main.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
   #container{
                height:1500px;
                width:1500px; 
    }
     .example {
    width:1350px;
    height:1500px;
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
          
       <a class="button-1" href="/DIC/logoutServlet">LogOut</a>          
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
            <%@include file="../menu/adminmenu.jsp" %>
            <%}
else{%>

 <%@include file="../menu/clerkmenu.jsp" %>

<%}

}

else{ %>
        
             <%@include file="../menu/clerkmenu.jsp" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>
    
    
    
		<div id="container">
		
			<div id="demo">
<!--  <button id="btnAddNewRow" value="Ok">Add new code...</button> 
  <button id="btnDeleteRow" value="cancel">Delete selected code</button>-->
<!--    <form name="form">
        -->
        
         <br/>
         <h3 style="text-align: center; background-color: orange;"> Access Trails  </h3>



            <div id="header">
              
                
<!--            <form style="width:980px;margin-left: 100px;" name="form" >-->
                   
                    <!--<table  class="table_form1" style="width:880px; height:50px;" id="example" >-->
<table cellpadding="0" cellspacing="0" border="1px" class="display" id="example">

                        <thead>
                        <th>Username</th>
                        <th>Task</th>
                        <th>Host Comp</th>
                        <th>Timestamp</th>
                            
                        </thead>
                        <tbody>
<% 
dbConnect conn = new dbConnect();
String getaccesstrials="select * from access_trail ";
conn.rs2 = conn.state2.executeQuery(getaccesstrials);
while(conn.rs2.next()){
%>
                         
<tr>
    <td><%= conn.rs2.getString("username") %></td> 
    <td><%= conn.rs2.getString("task") %></td> 
    <td><%= conn.rs2.getString("hostcomp") %></td> 
    <td><%= conn.rs2.getString("timestamp") %></td> 
   
</tr>                          
            
  

<%}%>
                        </tbody> 	
</table>
    <!--</form>-->
			</div>
			<div class="spacer"></div>

			
			

			
			
			
		</div>
    
    </div>
    
    
  

	</body>
       
               
         
             
    
<!--</script>-->
</html>
