<%-- 
    Document   : home1
    Created on : Aug 7, 2013, 4:19:10 PM
    Author     : Maureen
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbConnect.dbConnect" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
         <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="StyleSheet" href="main.css" type="text/css" />
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
   <link rel="StyleSheet" href="../main.css" type="text/css" />
        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<link rel="shortcut icon" href="images/dic.png"/>
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>

  <script>
        
          $.ajax({
                    
//                      f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
                    url:"checkbackup",
                    type:'post',
                    dataType:'html',
                    success:function (data){}
                        
                            
                                    
                                    
                
          })
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
            <%
 
                            if ( session.getAttribute("backupsms") != null)  { %>
                                <script type="text/javascript"> 
                                
                    var n = noty({text: '<%=session.getAttribute("backupsms")%>',
                                        layout: 'center',
                                        type: 'Success'
                                    });
                    
                </script> <%
                
                session.removeAttribute("backupsms");
                            }%> 
             
            
        <!--=====================================================================================--> 
            </div>
    
    
</div>   
        


    </body>
</html>
