<%-- 
    Document   : summaryVisit
    Created on : May 16, 2014, 4:13:19 PM
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
	<title>Summary</title>
		

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
                                  
									
                                                                        sUpdateURL: "UpdateClientLearnt",
                                                                        sAddURL: "AddClientLearnt",
                                                                        sDeleteURL: "DeleteClientLearnt",
                    							"aoColumns": [ null,
{},                                                                            
                    									
                    									null,null
											]									

										});
				
			} );
		</script>

<script>
    
//    function viewRecord(UniqueID){
//    var f=document.form;
//    f.method="post";
//    f.action="/DIC/viewLastVisit?UniqueID="+UniqueID; 
//    f.submit();
//}

</script>
<script>
 //=================load existing data============
            
            
            function viewRecord(UniqueID){
                
                          
                        var Uniqueids= UniqueID;   
                    
                  
                if(Uniqueids!=""){  
//                 alert(Uniqueids);
                 $.ajax({  
                        url:"viewLastVisit?UniqueID="+Uniqueids ,  
                        type:'post',  
                        dataType: 'json',  
                        success: function(data) {
                    
                            document.getElementById("demo").innerHTML=data.example;
                          
                          
                      
                       
                        
                        }}); 
                
                }//end of if
                
               
                
            }
            
            

        </script>
	<link rel="StyleSheet" href="css/main.css" type="text/css" />
 <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
     #container{
                height:700px;
                width:700px; 
    }
     .example {
  
    height:1000px;
     width:1350px; 
     }
    </style>
    </head>
	 <body id="dt_example">
         

<div class="example">
                   <div class="login">
            
     <%
              
        String username=(String)session.getAttribute("Username");
      
               if(username==null){
                     
               } else{
     %>
      <a class="button-1" href="../DIC/logoutServlet">LogOut</a>          
     <h5>Welcome <%=username%></h5>
     <%
               }
        
 
      %>
           </div>
             <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
   
<div style=" width:1350px;">
                <!--=========================================menu=========================================-->     
            
                     <%
if(session.getAttribute("AccessLevel")!=null){            

if (session.getAttribute("AccessLevel").equals("2")) {%>
            <%@include file="menu/adminmenu.html" %>
            <%}
else{%>

 <%@include file="menu/clerkmenu.html" %>

<%}

}

else{ %>
        
             <%@include file="menu/clerkmenu.html" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>

    

		<div id="container">
		
			<div id="demo">
  
                            <form name="form">
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th>UniqueID</th>
                       <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%><th>Full Name</th><%}}%><th>Client Initials</th>
			<th>DIC Name</th>
			<th>DOE</th>
			<th>LAST VISIT</th>
			
			
		</tr>
	</thead>
	<tfoot>
		<tr>

		        
		</tr>

	</tfoot>
   <tbody>
		 
        <c:forEach  var="today" items="${summary}"  >
          
          <c:set var="UniqueID"  value="${today.UNIQUEID}"></c:set>
          <c:set var="Name"  value="${today.NAME}"></c:set>
          <c:set var="clientInit"  value="${today.CLIENTINIT}"></c:set>
          <c:set var="dicname"  value="${today.DICNAME}"></c:set>
          <c:set var="doe"  value="${today.DOE}"></c:set>
           
        <input type="hidden" id="UniqueID" name="UniqueID" value="<%= pageContext.getAttribute("UniqueID")%>" />
        <input type="hidden" id="Name" name="Name" value="<%= pageContext.getAttribute("Name")%>" />
         
            <tr id="<%=pageContext.getAttribute("UniqueID")%>">
           
           <td class="sorting_1">  ${today.UNIQUEID} </td>
          <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%><td class="sorting_1">${today.NAME} </td><%}}%> 
           <td class="sorting_1">${today.CLIENTINIT} </td>
           <td class="sorting_1">${today.DICNAME} </td>
           <td class="sorting_1">${today.DOE} </td>
           <td class="sorting_1"><input type="button"  name="view" value="Last Visit" onclick="viewRecord('${today.UNIQUEID}')"> </td>
          
          </tr>
       
         </c:forEach>
               
	</tbody>
</table>
                                
                                
                                
                            </form>
                            
			</div>
                    
                    
                    <div id="assess"></div>
			<div class="spacer"></div>

			
			

			
                </div>
</div>
			
		
    
    
    
    

	</body>


</html>

