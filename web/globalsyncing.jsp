<%@page import="dbConnect.dbConnect"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%!

dbConnect conn = new dbConnect();
%>

<%if(session.getAttribute("accessTrail")!=null){ %>
<%@page import="Maintenance.saveAccessTrail"%>
<%
saveAccessTrail access = new saveAccessTrail();
String task="Accessed global syncing module. Users are required to sync data from online server using this module.";
String username=session.getAttribute("accessTrail").toString();
access.addAccess(username,task);

%>
<%}%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DIC</title>
    <link rel="shortcut icon" href="images/favicon.png">
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


function togglesearchtype(){
 
        if($("#synctype").val()==='fingerprint'){
            
            $(".displayfirst").css("display","block");
            $(".hidefirst").css("display","none");
        }
        else if($("#synctype").val()==='uniqid'){
            
            $(".displayfirst").css("display","none");
            $(".hidefirst").css("display","block");
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
    
    
    <!----------------------button style----------------------->
       <style>
       .btn {
  background: #d9344f;
  background-image: -webkit-linear-gradient(top, #d9344f, #b82b2b);
  background-image: -moz-linear-gradient(top, #d9344f, #b82b2b);
  background-image: -ms-linear-gradient(top, #d9344f, #b82b2b);
  background-image: -o-linear-gradient(top, #d9344f, #b82b2b);
  background-image: linear-gradient(to bottom, #d9344f, #b82b2b);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Georgia;
  color: #ffffff;
  font-size: 13px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}

.displayfirst{
    
 display:block;   
}

.hidefirst{
    
   display:none;    
}
</style>
       
       <!--------------------------------------------------------->
       
    
    
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
         
         <script>   
         function newuser(){
    
    
                     
                    
            
    

                // window.open("districtchooser?county="+dist.value);     
                var xmlhttp;  
       
                
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
                        
         //document.getElementById("replymsg").innerHTML="Added to the system";
               document.getElementById("presentmembers").innerHTML=xmlhttp.responseText;
                        //doOnLoad();
  document.getElementById("capturefp").innerHTML="<font color=\"white\"><b>Detect New User</b></font></p>";
                    }
                }
                xmlhttp.open("POST","invokeglobalsyncing",true);
                xmlhttp.send();
                document.getElementById("replymsg").innerHTML="<img src=\"images/sending.gif\" alt=\"searching\"> Launching fingerprint scanner!!";
//               
           document.getElementById("capturefp").innerHTML="";
    
    
}

//a function to dynamically add rows



  
</script>
    	

    </head>
    
    
    <body>
      

        <div class="example" style=" width:1350px;">
           <div class="login">
     <% String logStatus=(String)session.getAttribute("loggedIn");
               if(session.getAttribute("loggedIn")==null){
     
//               response.sendRedirect("index.jsp");
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
            <%@include file="menu/adminmenu.jsp" %>
            <%}
else{%>

 <%@include file="menu/clerkmenu.jsp" %>

<%}

}

else{ %>
        
             <%@include file="menu/clerkmenu.jsp" %>
            
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

      
<h2>Requires Internet Connectivity</h2><h3>(Sync data for a specific Client from online database)</h3>
<table> 
<!--    <a href="#" onclick="newuser();" class="button blue" id="capturefp" style="">
        <b><font color="white">Detect New User</font></b>
    </a> -->
    <tr><td><h3>Choose Syncing method</h3></td>
        <td class="sorting_1">
            <select style="height:35px;" onchange="togglesearchtype();" name="synctype" id="synctype" >
            <option value="fingerprint">Use Client Fingerprint</option>
            <option value="uniqid">Use Client Unique Id</option>
            </select></td>
        <td></td></tr>   
    <tr class="displayfirst"><td><h3>Start Fingerprint Scanner</h3></td> <td class="sorting_1"><input type="button" class="btn" name="capture"  id="capturefp" value="Start Scanner" onclick="newuser();"></td></tr>
    
    <tr class="hidefirst"><td ><h3>Enter  Unique Identifier</h3></td>
    <td><input placeholder="e.g Nakuru/n.k/08/2015/37" type="text" value="" required style="height:32px;width:230px;" id="value"  name="value"></td><td><input onclick="searchbyuniqueid();"  class="btn" type="text" style="cursor:" name="search" value="Search" ></td>
    </tr>         
</table>  
                    <table class="viewpdt" id="replymsg"  style="width:800px;margin-left: 50px;">
                       <tr><td colspan="6"></td></tr>
                       
<!--                       <tr><td colspan="6" style="background-color:yellow;height:60px;"><h4> Attendance List for  chws Present at the meeting held</h4></td></tr>
                        <tr><td>Number</td><td>First Name</td><td>Last Name</td><td>Id Number</td><td>Time in</td><td>Location id</td></tr>-->
                    </table>
                        
    
               
      
 
      </div>
</div>      
                        <script>
                            togglesearchtype();
                            
                            function searchbyuniqueid(){
                              var val=$("#value").val(); 
                              if(val.trim()!==''){
                                    document.getElementById("replymsg").innerHTML="<tr><td><h3 style='color:red;'>Loading..<img src='images/utube.gif' alt='loading'></h3></td></tr>";
                             $.ajax({
                              url:"syncbyuniqueid?value="+val,   
                              type:'post',
                              dataType:'html',
                              success:function (data){
                                  
                                  var responsemsg=data.split('%');
                                  document.getElementById("replymsg").innerHTML=responsemsg[1];
                                  //$("#replymsg").html(responsemsg[1]);
                                  
                        var n = noty({text:"<font color=\"green\">"+ responsemsg[0]+"</font>",
                        layout: 'center',
                        type: 'Success'});
                                  
                              }
                             });   
                         } 
                            }
                        </script>   
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