<%-- 
    Document   : SummaryReport
    Created on : Jul 28, 2014, 3:36:28 PM
    Author     : Maureen
--%>


 <%-- 
    Document   : reportUI
    Created on : Nov 26, 2013, 9:21:06 AM
    Author     : Maureen
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbConnect.dbConnect"%>
<%! dbConnect conn= new dbConnect();%>
<%if(session.getAttribute("accessTrail")!=null){ %>
<%@page import="Maintenance.saveAccessTrail"%>
<%
saveAccessTrail access = new saveAccessTrail();
String task="Accessed Biometric reports ";
String username=session.getAttribute("accessTrail").toString();
access.addAccess(username,task);

%>
<%}%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DIC Biometric Reports</title>
        <link rel ='shortcut icon' href="../images/favicon.png">
        <link rel="stylesheet" type="text/css" href="../js/jquery-ui.css"/>
	<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.js"></script>
    <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="../js/jquery-1.7.2.js"></script>
	<script src="../js/jquery-ui-1.10.3.custom.js"></script>

      <script type="text/javascript" src="../js/DICHelp.js"></script>  

<script type="text/javascript" src="../js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="../js/noty/layouts/top.js"></script>
<script type="text/javascript" src="../js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="../js/noty/themes/default.js"></script>
        <script type="text/javascript" src="../js/DICHelp.js"></script> 

        <link rel="StyleSheet" href="../main.css" type="text/css" />
          

        <style type="text/css">
    #container{
                height:500px;
                width:900px; 
    }
    
    </style>
    <script src="../js/jquery-1.7.2.js"></script>
	<script src="../js/jquery-ui-1.10.3.custom.js"></script>
 <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
       <script src="../js/datepicker.js"></script>
       <script src="../admin/ui/jquery.ui.datepicker.js"></script>
       
	 <script>	
                $(function() {
        $( ".datepicker" ).datepicker({
                                dateFormat: "yy-mm-dd",
                                changeMonth: true,
                                changeYear: true
                               
                        });
                    
                });
            </script>
    <script type="text/javascript">
           
        </script> 
    <script type="text/javascript">
            function changeyear(){
                
             
                var year=document.getElementById("year").value;
                   alert(year);
//                var quarter=document.getElementById("quarter").value;
//alert("previous year : "+prev_year)
if(year!=""){
            
 document.getElementById("quarter").disabled=true;                
 document.getElementById("semi-annual").disabled=true;                
            }   
       if(year=="")     {
                
 document.getElementById("quarter").disabled=false;                
 document.getElementById("semi-annual").disabled=false;              
                         }
}
        </script> 
    <script type="text/javascript">
            function changequarter(){
                
             
                var quarter=document.getElementById("quarter").value;
                   alert(quarter);
//                var quarter=document.getElementById("quarter").value;
//alert("previous year : "+prev_year)
if(quarter!=""){
            
// document.getElementById("year").disabled=true;                
 document.getElementById("semi-annual").disabled=true;                
}   
       if(quarter=="")     {
                
// document.getElementById("year").disabled=false;                
 document.getElementById("semi-annual").disabled=false;              
            }
}
        </script> 
    <script type="text/javascript">
            function changesemi(){
                
             
                var semiannual=document.getElementById("semi-annual").value;
                   alert(semiannual);
//                var quarter=document.getElementById("quarter").value;
//alert("previous year : "+prev_year)
if(semiannual!=""){
            
// document.getElementById("year").disabled=true;                
 document.getElementById("quarter").disabled=true;                
}   
       if(semiannual=="")     {
                
// document.getElementById("year").disabled=false;                
 document.getElementById("quarter").disabled=false;              
            }
}
        </script> 
    
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen">
    </head>
    <body>
         

        <div class="example" style="width: 1350px; height: 700px;">
          
    
      <div><h1 style="text-align: center"><img src="../images/aphia_logo.png" height="70" width="200"/></h1></div>   
     
      
      <div style="width:1350px;"> 
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

%>
            
            
        <!--=====================================================================================--> 
            </div>
      
              <% 
 dbConnect conn = new dbConnect();
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

    
    
    <div id="container">
        <table>
        <tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[20]!=null){%>
         <%=Sectionshelp[20]%> 
         <%}%>
    </td>
    </tr>
                        </table>   
         <h3>BIOMETRICS REPORT </h3>
         <h4>(BASED ON THE DATE WHICH THE FINGERPRINT WAS CAPTURED AND NOT CLIENT ENROLLMENT DATE)</h4>
        <h4> Reports <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="../images/help_24.png"/> </a></h4>
       
        <form method="post" action="/DIC/bimetricreport">
        <table>
                <tr class="d1"> <td>Data from</td><td><input type="text" name="startdate" id="startdate" class="datepicker" value="" required ="true"></td></tr>
                <tr class="d0"><td>To</td><td><input type="text" name="enddate" id="enddate" class="datepicker" value="" required ="true"></td></tr>
                
                
                <tr><td> <input type="submit"  name="submit" value="Generate Report" style="height:35px;">  </td></tr>
            
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
