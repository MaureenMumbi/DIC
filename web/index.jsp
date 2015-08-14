<%-- 
    Document   : Login
    Created on : Aug 14, 2013, 1:21:17 PM
    Author     : Maureen
--%>

<%@page import="DBCREDENTIALSFILE.InternetThreadClass"%>
<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%!
 dbConnect conn=new dbConnect();
 %>
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DIC</title>
        <link rel="StyleSheet" href="main.css" type="text/css" />
           <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<link rel="shortcut icon" href="images/dic.png"/>
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
       <script>
        
          $.ajax({
                    
//                      f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
                    url:"checkbackup",
                    type:'post',
                    dataType:'html',
                    success:function (data){
                   
                  
   if(data.trim()==="Lock"){
       $("#container").hide(); 
         $("#synclock").html  ("<p style='color: yellow; font-size:15px;'>Connect to internet for system to unlock</p>");
  


 } else{}                      
                    }
                        
                            
                                    
                                    
                
          })
        
          $.ajax({
                    
//                      f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
                    url:"update_lockDate",
                    type:'post',
                    dataType:'html',
                    success:function (data){
//                        alert("enterd");
                    }
          })
          $.ajax({
                    
//                      f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
                    url:"saveLastInternectConn",
                    type:'post',
                    dataType:'html',
                    success:function (data){
//                        alert("enterd");
                    }
          })
    </script>
    <script>
        
          $.ajax({
                    
//                      f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
                    url:"AutoBackup",
                    type:'post',
                    dataType:'html',
                    success:function (data){}
                        
                            
                                    
                                    
                
          })
    </script>
 
    </head>
    <body>
  
<div class="example">
     
    
      <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/>
          </h1></div>   
    
    <H3 style="text-align: center;">DIC SYSTEM</h3>
     <%
 
                            if ( session.getAttribute("backupsms") != null)  { %>
                                <script type="text/javascript"> 
                              
                    var n = noty({text: '<%=session.getAttribute("backupsms")%>',
                                        layout: 'center',
                                        type: 'Success'
                                    });
                    
                </script> <%
                
                session.removeAttribute("backupsms");
                            }%> 
    <div id="container">
        
           
                            
                            
      <form name=login id="login" method="post"  action="LoginServlet">
                        <h2>Login</h2>
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
                      
                       
                              <table >
                                  <tr class="d0"><td >Username</td><td><input type="text" name="Username" value=""></td></tr>  
                                  <tr class="d1"><td >Password</td><td><input type="password" name="Password" value=""></td></tr>  
                                 
                                  
                                  <tr><td><input type="submit" name="Login" value="Login"></td></tr>  
                               
                              </table>
                        
                         
                            </form>
      </div>
                            <h3 id="synclock" style=" text-align:center;"></h3>
                            <div id="versionChecker" style="font-weight: bolder; text-align:center;">
                         </div><br>
               <p align="center" title="Version 1.27 Last Updated 15/07/2015."> &copy DIC System Version 1.27 Last Updated on  16/07/2015. Aphia Plus | USAID </p>
               
</div>
  
 <script>
  $(document).ready(function(){
//      CHECK FOR NEWER VERSION PERIODICALLY....
checkVersion();
 });   
 function checkVersion(){
//    CHECK Version------------------- 
$("#versionChecker").html("<p>Checking for newer Version...</p>");
var versionText="",daysRemaining,warningText="",sentOn="",version_name="";
 $.ajax({
                    url:"version",
                    type:'post',
                    dataType:'html',
                    success:function (data){
                        if(data.trim()==="no_internet"){
                          $("#versionChecker").html  ("<p style='color: blue; font-size:10px;'>Unable to check if there is a newer version of DIC system due to limited or no internet connection.</p>");
      setInterval(function(){ checkVersion(); }, 60000);          
        }
                        else{
                            
                         if(!('contains' in String.prototype)) {
       String.prototype.contains = function(str, startIndex) {
                return -1 !== String.prototype.indexOf.call(this, str, startIndex);
       };
 }   
                      if(data.contains("outdated version")){
                          $("#container").hide();   
                      }
$("#versionChecker").html(data);
                        }
  }  
  });   
      }
 
      
      function updateSystem(){
          var status="";
       $.ajax({
                    url:"downloadUpdates",
                    type:'post',
                    dataType:'html',
                    success:function (data){
                      status=data.trim();
                      if(status==="success"){
                          
                      alert("Please restart the browser for changes to take effect");    
                      }
                      else{
                          
                      alert("download failed");    
                      }
                      
                      
                    }
                    });    
      }



      
     </script>
 
      
    </body>
</html>
