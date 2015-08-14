<%-- 
    Document   : index
    Created on : Aug 5, 2013, 9:03:18 PM
    Author     : SIXTYFOURBIT
--%>

<%@page import="dbConnect.dbConnect"%>
<%@page import="java.util.Calendar"%>
<%!
dbConnect conn = new dbConnect();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Audit</title>
   <link rel="stylesheet" type="text/css" href="js/jquery-ui.css"/>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

      <script type="text/javascript" src="js/DICHelp.js"></script>  
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>
<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->
<script type="text/javascript" src="js/noty/themes/default.js"></script>
<link rel="StyleSheet" href="main.css" type="text/css" />
        <link rel="StyleSheet" href="css/geff_css.css" type="text/css" />
        
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    </head>
    
    <!-- Body page -->
    
       <div class="example " style=" width:1350px; height: 900px; margin-top: 0px; ">
       
     <div id="container" style=" width:1350px; height: 900px; margin-top: 0px; ">
      
   <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200" /></h1></div>
   <div id="header" style=" width:1350px;">
               <%@include file="/menu/adminmenu.html" %>  
            </div>
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
   <table>              
<tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[21]!=null){%>
         <%=Sectionshelp[21]%> 
         <%}%>
    </td>
    </tr>
     <h3>Audit Form <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="images/help_24.png"/> </a></h3>
           
                        </table>   
        
       
         

           

           
                
<!--
                <div id="midcontent">-->
                    
                    <iframe width="1100px" style="margin-left:25px;" height="550px"  src="audit_table.jsp"></iframe>
                    
       
                    
                    
                 
<!--                </div>-->
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