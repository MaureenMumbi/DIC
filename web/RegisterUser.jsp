<%-- 
    Document   : RegisterUser
    Created on : Aug 14, 2013, 12:35:05 PM
    Author     : Maureen
--%>

<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
dbConnect conn = new dbConnect();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Register User </title>
     
<script src="LiveValidation.js">    </script>
<link href="ValidationStyling.css" rel="stylesheet" >
 <link rel="StyleSheet" href="main.css" type="text/css" />
  <script type="text/javascript" src="js/jquery-1.9.1.js"></script>

<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>

<link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

      <script type="text/javascript" src="js/DICHelp.js"></script> 
<style type="text/css">
    #container{
                height:300px;
                width:300px; 
    }
    </style>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    </head>
    <body>
         

<div class="example" style="width:1350px;">
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
     
            <div id="container" style="width: 500px; height: 350px;">
            <% 
 
 //get the helps from the database.
 
 String Sectionshelp[]=new String [25];
int mcount=0;
 if(conn.state2.isClosed()){conn= new dbConnect();}
conn.rs2=conn.state2.executeQuery("Select * from help where help_id<='25'");
while(conn.rs2.next()){
    
Sectionshelp[mcount]=conn.rs2.getString(2);
if(mcount<=25){
mcount++;
}
}

%>
        <%
 
                            if ( session.getAttribute("clerk_added") != null)  { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("clerk_added")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 1800});
                    
                </script> <%
                
                session.removeAttribute("clerk_added");
                            }
                          else if ( session.getAttribute("clerk_added1") != null)  { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("clerk_added1")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 1800});
                    
                </script> <%
                
                session.removeAttribute("clerk_added1");
                          }
                        %>
        
                        <table>              
<tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[18]!=null){%>
         <%=Sectionshelp[18]%> 
         <%}%>
    </td>
    </tr>
                        </table>   
        
        
    
        <form  name="user" method="post" action="RegisterUser" >
            <h3>Register Users <a href="#" id="dialog-link1" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h3> 
        <table>
            <tr><td>Full Name</td><td><input type="text" name="Name" required value=""></td></tr>
            <tr><td>Username</td><td><input type="text" name="Username" required value=""></td></tr>
            <tr><td>Password</td><td><input type="password" name="Password" id="password" required value=""></td></tr>
            <tr><td>Confirm Password</td><td><input type="password" name="confirmPassword"  required id="confirmPassword" value=""></td></tr>
    <script type="text/javascript" >
    
var confirmPassword = new LiveValidation('confirmPassword');
confirmPassword.add(Validate.Confirmation, {match: 'password'});
confirmPassword.add( Validate.Presence );

</script>
            <tr><td>Phone Number</td><td><input type="text" required name="PhoneNo" value=""></td></tr>
            <tr><td>Email</td><td><input type="text" required name="Email" value=""></td></tr>
            <tr><td>Location</td><td><input type="text" required name="Location" value=""></td></tr>
            <tr><td>AccessLevel</td><td>
                    <select name="AccessLevel">
                        <option value=""></option> 
                        <option value="1">User</option> 
                        <option value="2">Admin</option> 
                   </select></td></tr>
            
            <tr><td><input type="submit"  name="submit" value="submit"></td></tr>
          </table>   
        </form>  
      </div>
</div>
  
    
            
            
            
       
    </body>
</html>
<%

  if(conn.rs!=null){ conn.rs.close();}
         if(conn.rs1!=null){ conn.rs1.close();}
         if(conn.rs2!=null){ conn.rs2.close();}
         if(conn.rs3!=null){ conn.rs3.close();}
         if(conn.rs4!=null){ conn.rs4.close();}
         if(conn.rs5!=null){ conn.rs5.close();}
         if(conn.rs6!=null){ conn.rs6.close();}
         if(conn.rs7!=null){ conn.rs7.close();}
        
         if(conn.state!=null){ conn.state.close();}
         if(conn.state1!=null){ conn.state1.close();}
         if(conn.state2!=null){ conn.state2.close();}
         if(conn.state3!=null){ conn.state3.close();}
         if(conn.state4!=null){ conn.state4.close();}
         if(conn.state5!=null){ conn.state5.close();}
         if(conn.state6!=null){ conn.state6.close();}
         if(conn.state7!=null){ conn.state7.close();}



%>