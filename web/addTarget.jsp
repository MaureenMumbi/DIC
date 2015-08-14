<%-- 
    Document   : addTarget
    Created on : Oct 8, 2014, 7:41:27 AM
    Author     : Maureen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbConnect.dbConnect"%>
<%! dbConnect conn= new dbConnect();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add target</title>
         <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>
 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
          <link rel="StyleSheet" href="main.css" type="text/css" />
         
<link rel="shortcut icon" href="images/dic.png"/>
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>
        
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    
    
    <script type="text/javascript">
// a function that filters the districts in the passed county as per the county drop down.

function filter_districts(DICName){
 
     
   var dist = document.getElementById("county").value;
   var distr = new Array();
// this will return an array with strings "1", "2", etc.
distr = dist.split(",");
var districtsName=distr[0];
//
// window.open("districtselector?county="+dist.value);     
var xmlhttp;    
if (districtsName=="")
{
//filter the districts    



document.getElementById("DICName").innerHTML="<option value=\"\">Choose DIC Name</option>";
return;
}
if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
xmlhttp.onreadystatechange=function()
{
if (xmlhttp.readyState==4 && xmlhttp.status==200)
{
document.getElementById("DICName").innerHTML=xmlhttp.responseText;
}
}
xmlhttp.open("POST","/DIC/districtselector?district="+districtsName,true);

xmlhttp.send();


}//end of filter districts
</script> 
    </head>
    <body>
        <div class="example" style="width: 1350px; height: 920px;">   
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
                <form  action="AddTarget " style="margin-left: 200px; margin-right: 100px;margin-top: 100px; height: 200px; width: 700px; background-color: #F5F5F5;">
                    <table>
                        <tr class="d0">
                    <td>Year</td>
                    <td><select  name="year" id="year" required="true" >
                            <option value="">Select Year</option>
                             
                            <option value="2011">2011</option> 
                            <option value="2012">2012</option> 
                            <option value="2013">2013</option>
                            <option value="2014">2014</option>
                            <option value="2015">2015</option>
                            
                           
                        </select></td>
                </tr>
                
                <tr class="d1"><td>county </td><td>

                        <select  name="county" id="county" onchange="filter_districts(this);" required="true" >
                            <option value="">Select County</option>
  <%
             
                                                      String QueryDist= "SELECT * FROM districts";
                                                      if(conn.state.isClosed()){conn= new dbConnect();}
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryDist);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value=<%=conn.rs.getString("DistrictID")%>><%=conn.rs.getString("District")%></option>
                                                   <%
                                                      
 
                                System.out.println(conn.rs.getString("District"));                                                      }
                                
                               
                                                   %>


                                 </select></td>
                </tr>
                
                
                <tr class="d0"> <td>DIC Name <font style="color: blue">*</font></td>
                                 <td>
                                 <select id="DICName"  name="DICName" required="true">
                                 <option value="">Choose DIC Name</option>  
                                 </select>
                                 </td>
                 </tr>
                
                <tr  class="d1">
                    <td>Target</td><td><input type="text" name="target" value="" required="true"></td>
                    
                </tr>
                <tr>    <td><input type="submit" value="Add Target" name="submit" ></td></tr>
                        
                        
                        </tr></table>  
        
    </form>                
        
        
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
