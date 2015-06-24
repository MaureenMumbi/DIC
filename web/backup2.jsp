<%-- 
    Document   : backup2
    Created on : May 17, 2014, 11:06:42 PM
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

          
    
 
    
      
          <div style="clear:both" style="padding-top: 50px;">
                 <%if (session.getAttribute("datasend") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("datasend")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 4800});
                    
                </script> <%
                session.removeAttribute("datasend");
                            }

                        %>     
                 <%if (session.getAttribute("network_error") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("network_error")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 4800});
                    
                </script> <%
                session.removeAttribute("network_error");
                            }

                        %>     
                <form  action="Back_up_SQL" style="margin-left: 200px; margin-right: 100px;margin-top: 100px; height: 110px; width: 700px; background-color: #F5F5F5;">
                    <table><tr><td><h3>Press button to backup data</h3> </td>
                            <td><input type="submit" value="Backup Data" name="submit" style="width:100px;height: 60px; background-color: #1c94c4;"></td>
                        
                        
                        </tr></table>  
        
    </form>                
        
        
       </div>

    </body>
</html>


