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
                xmlhttp.open("POST","searchFP",true);
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
conn.rs2=conn.state2.executeQuery("Select * from help where help_id<='12'");
while(conn.rs2.next()){
    
Sectionshelp[mcount]=conn.rs2.getString(2);
if(mcount<=12){
mcount++;
}
}

%>
<h2>Verify Fingerprint</h2>
<table> 
<!--    <a href="#" onclick="newuser();" class="button blue" id="capturefp" style="">
        <b><font color="white">Detect New User</font></b>
    </a> -->
     <td class="sorting_1"><input type="button"  name="capture"  id="capturefp" value="Capture Fingerprint" onclick="newuser();"></td>
              
</table>  
                    <table class="viewpdt" id="presentmembers" style="width:800px;margin-left: 50px;">
                       <tr><td colspan="6"><p id="replymsg"></p></td></tr>
                       
<!--                       <tr><td colspan="6" style="background-color:yellow;height:60px;"><h4> Attendance List for  chws Present at the meeting held</h4></td></tr>
                        <tr><td>Number</td><td>First Name</td><td>Last Name</td><td>Id Number</td><td>Time in</td><td>Location id</td></tr>-->
                    </table>
                        
    
               
      
 
      </div>
</div>      
      
</body>
</html>