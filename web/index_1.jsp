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
<script type="text/javascript">
function myFunction()
{
var x;
var r=confirm("Do you want carry out a Risk Assessment of the client?");
if (r==true)
  {
      window.open("../DIC/Counter")
      window.close("../DIC/Search")
  }
else
  {
  window.open("home1.jsp")
   window.close("../DIC/Search")
  }

}

</script>
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
 <script type="text/javascript">
     function alerts(){
         alert("Client not enrolled");
     }
     
     
 </script>
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
 <form action ="/DIC/Search"><table align="center">
         
<tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[5]!=null){%>
         <%=Sectionshelp[5]%> 
         <%}%>
    </td>
    </tr>
         <tr><td style="font-size: 20px;">Enter Unique Identifier   <a href="#" id="dialog-link1" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></td>
                    <td><input type="text" value="" required  name="value"></td>
                    <td><input type="submit" name="search" value="Search" ></td>
                </tr>
     </table>
    </form>
               
      
 
      <% 
       
          
List userlist=new ArrayList();
   userlist=(ArrayList)request.getAttribute("userlist");
   if(userlist!=null && userlist.size()>0 ){
   
   for(int i=0;i<userlist.size();i++){
     List users=(List)userlist.get(i);
 %>
      
      <form method="post" name="form" >
            <table> 
                <tr><th>Client Details</th></tr>
                <tr class="d0">
                    <%
                    dbConnect conn = new dbConnect();
                   String query = "select * from districts where DistrictID='"+users.get(2) +"'";
                  conn.rs = conn.state.executeQuery(query);
                       if(conn.state.isClosed()){conn= new dbConnect();}
                  String district = "";
                  while(conn.rs.next()){
                 district= conn.rs.getString("District");
                  
              %>
              
                <td> District </td><td><input type="text" name="District" value="<%= district %>" readonly></td>     
                    
                    <%   }
                    
                    
%>
                   
                     <td>DIC Name</td><td><input type="text" value="<%= users.get(3) %>" name="DICName"></td>
                </tr>
                <tr class="d1">
                    <td>Unique Identifier</td>
                    <td><input type="text" name="UniqueID" value="<%= users.get(0) %>" readonly></td>
                    <td>Client Initials</td><td><input type="text" name="ClientInit" value="<%= users.get(1) %>" readonly></td>
                </tr>
                
                <tr class="d0">
                   
                    <td>Sex</td>
                    <td><input type="text" name="Sex" value="<%= users.get(4)%>" readonly></td>
                    
                <tr><td style="font-size:19px;"><a href="" onclick="myFunction()" style="color:red"> Risk Assessment</a></td><td></td>   

                    
                                       <%
                                                                            
session= request.getSession(true);
 session.setAttribute("UniqueID", users.get(0));
 session.setAttribute("ClientInit", users.get(1));
 session.setAttribute("District", users.get(2));
 session.setAttribute("DICName", users.get(3));
 session.setAttribute("Sex", users.get(4));
   }} 
     
   
  
  
   %>
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