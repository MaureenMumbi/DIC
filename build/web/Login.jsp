<%-- 
    Document   : Login
    Created on : Aug 14, 2013, 1:21:17 PM
    Author     : Maureen
--%>

<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="StyleSheet" href="main.css" type="text/css" />
         <script type="text/javascript" src="js/jquery-1.9.1.js"></script>

<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>
        <style type="text/css">
    #container{
                height:200px;
                width:300px; 
    }
    #example{
        
             height:300px;
                width:400px; 
    }
    </style>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    </head>
    <body>
         

<div class="example">
           
    
    <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
    
    
    <div id="container">
      <form name=login id="login" method="post"  action="LoginServlet">
          
          
          
          <%
 
                            if ( session.getAttribute("login") != null)  { %>
                                <script type="text/javascript"> 
                    var n = noty({text: '<%=session.getAttribute("login")%>',
                                        layout: 'center',
                                        type: 'Success',
 
                         timeout: 1800});
                    
                </script> <%
                
                session.removeAttribute("login");
                            }%>
                        <h2>Login:</h2>
                         
                        	 
                       
                              <table >
                                  <tr class="d0"><td >Username</td><td><input type="text" name="Username" value=""></td></tr>  
                                  <tr class="d1"><td >Password</td><td><input type="password" name="Password" value=""></td></tr>  
                                  <tr><td><input type="submit" name="Login" value="Login"></td></tr>  
                               
                              </table>
                        
                         
                            </form>
      </div>
</div>
   <div>
              <!--  <h2 align="left"> <img src="images/Coat of arms.JPG" alt="logo" height="76px" /></h2>-->
              
               <%
  
             
                      
               dbConnect conn=new dbConnect();
                if(conn.state.isClosed()){conn= new dbConnect();}
conn.rs=conn.state.executeQuery("select * from version");          
conn.rs.next();
%>
               <p align="center"> &copy <a href="#" title="<%=conn.rs.getString(2)%>">DIC</a> Aphia Plus | USAID </p>
            </div>
  <!--END OF HEADER SECTION -->   
  
 
      
    </body>
</html>
