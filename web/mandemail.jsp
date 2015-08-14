<%@page import="dbConnect.dbConnect"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%!

dbConnect conn = new dbConnect();
%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DIC</title>

 <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
 <link rel="StyleSheet" href="main.css" type="text/css" />
 <style type="text/css">
            #container{
                height:300px;
                width:700px; 
    }
    .example{
         height:600px;
                width:900px; 
    }
    </style>
 
    <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

      <script type="text/javascript" src="js/DICHelp.js"></script> 
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>
  
   <link rel="stylesheet" href="themes/base/jquery.ui.all.css"/>
         <link rel="stylesheet" href="themes/smoothness/jquery.ui.all.css"/>
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
<!--    <h1 class="logo"><a href="#">FHI-360</a></h1>-->
  <div>
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
   
    

  <%
 
                            if ( session.getAttribute("msg") != null)  { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("msg")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 1800});
                    
                </script> <%
                
                session.removeAttribute("msg");
                            }

                        %>

       <% 
 
 //get the helps from the database.
 
 String Sectionshelp[]=new String [12];
int mcount=0;
 if(conn.state2.isClosed()){conn= new dbConnect();}
conn.rs2=conn.state2.executeQuery("Select * from help where help_id<='12'");
while(conn.rs2.next()){
    
Sectionshelp[mcount]=conn.rs2.getString(2);
if(mcount<=12){
mcount++;
}
}

%>
 
<div style=" position: absolute; left: 370px; width: 500px; background: #ffffff; padding-top:70px;">

                    <%if (session.getAttribute("mailchanged") != null) {



                    %>
                    <script type="text/javascript"> 
                    
                                       var n = noty({
                                           text: '<%=session.getAttribute("mailchanged")%>',
                                           layout: 'center',
                                           type: 'Success',
                                           timeout:3000});
                    
                    </script>
                    <%
                            session.removeAttribute("mailchanged");
                        }

                    %>
                    <!--creating random user id-->






            

                    <form action="editEmail" method="post" style="height:90px; ">
                        <br/>

                        <%

                            dbConnect conn = new dbConnect();
                            conn.rs = conn.state.executeQuery("select email from mail where mailid='1'");

                            String mandemail = "enter mail";
                            if (conn.rs.next()) {

                                mandemail = conn.rs.getString(1);

                            } else {
                                mandemail = "no email";

                            }


                            conn.state.close();

                        %>
                        <table>                 
                            <tr>          
                                <td><input type="email" name="mandemail" required  value="<%=mandemail%>" class="textbox1" style="height:40px;" /></td>
                                <td>

                                </td>
                                <td>
                                    <input type="submit" value="Update" style="height:40px;"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                        
</div>               
   
      
     
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