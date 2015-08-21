<%-- 
    Document   : date_selection
    Created on : Feb 20, 2014, 12:08:36 PM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB BACKUP</title>
         <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>
 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
       <script src="js/datepicker.js"></script>
       <script src="admin/ui/jquery.ui.datepicker.js"></script>
       
	 <script>	
                $(function() {
        $( ".datepicker" ).datepicker({
                                dateFormat: "yy/mm/dd",
                                changeMonth: true,
                                changeYear: true
                               
                        });
                    
                });
            </script>
            <link rel="StyleSheet" href="main.css" type="text/css" />
         
<link rel="shortcut icon" href="images/dic.png"/>
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>
        
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    </head>
    <body>
        <div class="example" style="width: 1350px; height: 620px;">   
    <div class="login">
   <%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server

    String username=(String)session.getAttribute("Username");
      
               if(session.getAttribute("Username")==null){
                    response.sendRedirect("index.jsp"); 
               }           
     
        else{
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
            <%@include file="menu/adminmenu.jsp" %>
            <%}
else{%>

 <%@include file="menu/clerkmenu.jsp" %>

<%}

}

else{ %>
        
             <%@include file="menu/clerkmenu.jsp" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>

          
    
 
    
       <div id="container" style="width:800px; height:400px;">
      <form action="Back_up_SQL" method="post">
     <p align="center" style="font-size: 16px;"> Select a date for a data backup </p>
     <table style="margin-left:30px;width:680px ;height:170px;" cellpadding="8px" cellspacing="6px">
            <tr>
             <th>Data from</th><td><input type="text" name="startdate" id="startdate" class="datepicker" value=""></td>
             <th>To</th><td><input type="text" name="enddate" id="enddate" class="datepicker" value=""></td>
             </tr>
             <tr><td><input type="submit" name="submit" value="Backup" ></td></tr>
     </table>
      </form>
       </div>
</div>
    </body>
</html>
