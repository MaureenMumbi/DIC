<%-- 
    Document   : audit_table
    Created on : Sep 4, 2013, 3:44:00 PM
    Author     : SIXTYFOURBIT
--%>
<%@page import="dbConnect.dbConnect"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="css/divCss_1.css"/>
         <% dbConnect conn= new dbConnect();

String adt="select * from taskauditor limit 10";
 if(conn.state.isClosed()){conn= new dbConnect();}
conn.rs=conn.state.executeQuery(adt);




%>
    </head>
    <body>
        <table  cellpadding="0px" class="viewpdt" cellspacing="0px" border="1px" style="width:1350px;" id="viewpdt">
<tr><th>Action</th><th>Time</th><th>User</th><th>Host Machine</th></tr>
<%
while(conn.rs.next()){
     String Action=conn.rs.getString(3);
    String Time=conn.rs.getString(4);
    String HostMachine=conn.rs.getString(2);
    String users="Select * from user where Username='"+conn.rs.getString(5) +"'";
   
    conn.rs2=conn.state2.executeQuery(users);
   while( conn.rs2.next()){
%>
<tr><td> <%= Action %> </td><td> <%= Time %></td><td> <%=conn.rs2.getString(2)%></td><td> <%= HostMachine %></td></tr>



<%
}
       }
%>

                    </table>
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