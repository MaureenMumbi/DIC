<%-- 
    Document   : backdater
    Created on : Aug 24, 2015, 11:26:41 AM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@page import="java.util.ArrayList"%>

<%@page import="dbConnect.dbConnect" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Back Date </title>
 <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
<link rel="StyleSheet" href="css/main.css" type="text/css" />
   <style type="text/css">
            #container{
                height:300px;
                width:700px; 
    }
    .example{
         height:600px;
                width:700px; 
    }
    </style>
   <!--<link rel="StyleSheet" href="../main.css" type="text/css" />-->
     
 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

       <script src="js/datepicker.js"></script>
       <script src="admin/ui/jquery.ui.datepicker.js"></script>
          <!--<script type="text/javascript" src="js/jquery-1.9.1.js"></script>-->
<link rel="shortcut icon" href="images/dic.png"/>
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>

       <script src="js/DICHelp.js"></script>
 <script>	
                $(function() {
                        var dateToday = new Date(); 
                
        $( ".datepicker" ).datepicker({
                                dateFormat: "yy-mm-dd",
                                changeMonth: true,
                                changeYear: true, 
                                yearRange:'2011:2015',
                                maxDate: dateToday
                               
                        });
                    
                });
            </script>
    </head>
    <body>
        
    
<div class="example" style=" width:1350px;">
           <div class="login">
     <% String logStatus=(String)session.getAttribute("loggedIn");
              if(session.getAttribute("loggedIn")==null){
     
               response.sendRedirect("index.jsp");
                    } else{
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
   <div>
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
           
           <div id="container">
               <h3>Back Date the Last date data was backed</h3>
               <form action="backdater" method="post">
           <table>
               <tr></tr>
                <tr class="d1"> <td>BackDate </td><td><input type="text" name="lastdate" id="lastdate" class="datepicker" value="" required ="true"></td></tr>
                  <tr><td> <input type="submit"  name="submit" value="Backdate Date">  </td></tr>
           </table>
               </form>
           </div>
            </div>
    
    
</div>   
        


    </body>
</html>

