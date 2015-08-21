<%-- 
    Document   : index_admin
    Created on : Aug 14, 2013, 1:03:28 PM
    Author     : Maureen
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="StyleSheet" href="main.css" type="text/css" />
        <style type="text/css">
    #container{
                height:200px;
                width:300px; 
    }
    </style>
   <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen"/>
<link rel="StyleSheet" href="../main.css" type="text/css" />

<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/noty/jquery.noty.js"></script>


<script type="text/javascript" src="../js/noty/layouts/top.js"></script>
<script type="text/javascript" src="../js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="../js/noty/themes/default.js"></script>

  <script>
        
          $.ajax({
                    
//                      f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
                    url:"/DIC/checkbackup",
                    type:'post',
                    dataType:'html',
                    success:function (data){}
                        
                            
                                    
                                    
                
          })
    </script>
    </head>
    <body>
         

<div class="example" style=" width:1350px;">
           
    
    
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
              
<!--    <h1 class="logo"><a href="#">FHI-360</a></h1>-->
 <div><h1 style="text-align: center"><img src="../images/aphia_logo.png" height="70" width="200"/></h1></div>
         
   <div> 
       <!--=========================================menu=========================================-->     
            
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
            
        <!--=====================================================================================--> 
            </div>
    
    
   
</div>
      </body>
</html>


