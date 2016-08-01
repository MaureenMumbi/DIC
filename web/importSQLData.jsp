<%-- 
    Document   : importSQLData
    Created on : Mar 26, 2014, 9:30:44 AM
    Author     : AphiaPlus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%if(session.getAttribute("accessTrail")!=null){ %>
<%@page import="Maintenance.saveAccessTrail"%>
<%
saveAccessTrail access = new saveAccessTrail();
String task="Accessed module for importing / merging data. ";
String username=session.getAttribute("accessTrail").toString();
access.addAccess(username,task);

%>
<%}%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB BACKUP</title>
         <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>
 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
       <script src="js/datepicker.js"></script>
       <script src="admin/ui/jquery.ui.datepicker.js"></script>
       
	 <script>	
                $(function() {
        $( ".datepicker" ).datepicker({
                                dateFormat: "yy/mm/dd",
                                changeMonth: true,
                                changeYear: true
                               
                        });
                    
                });
            </script>
            <link rel="StyleSheet" href="main.css" type="text/css" />
         
<link rel="shortcut icon" href="images/dic.png"/>
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>
        
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    </head>
    <body>
        <div class="example" style="width: 1350px; height: 620px;">   
    <div class="login">
   <%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server

    String username=(String)session.getAttribute("Username");
      
               if(session.getAttribute("Username")==null){
//                    response.sendRedirect("index.jsp"); 
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

          <div style="clear:both" style="padding-top: 50px;">
                 <%if (session.getAttribute("datasend1") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("datasend1")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 4800});
                    
                </script> <%
                session.removeAttribute("datasend1");
                            }

                        %>     
        <%if (session.getAttribute("msg") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n1 = noty({text: '<%=session.getAttribute("msg")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 4800});
                    
                </script> <%
                session.removeAttribute("msg");
                            }

                        %>        
                <form action="importSQLData"  method="post"  enctype="multipart/form-data"  >   
                <table border="0" cellpadding="4px" cellspacing="6px" style="margin-left: 200px; margin-right: 100px;margin-top: 100px; height: 210px; width: 700px; background-color: #F5F5F5;" >

                    
                    <tr> <td style="font-size: 20px;"><h4>Upload Database</h4></td></tr>
                    <tr>  <td>Choose file to upload
                      </td>
                        <td><input type="file" style="width:350px;" name="fname" id="fname" /></td>
<!--                        <input type="file" name="file" required id="file">-->
                    </tr>
                    
                            <tr><td>
                         <%if (session.getAttribute("importprogress") != null) { %>
                               
                    
                   <p font color='green'><%=session.getAttribute("importprogress")%><font></p>
                      
                    
              <%
                //session.removeAttribute("importprogress");
                            }

                        %> 
                                    
                        </td></tr>
                    
                    <tr>
<!--                        <td>
                                  <img src="images/blguide.png" title="Navigate to the folder C:/MHC_UPLOADS of the host computer, then choose the excel file(.xls) with the data that you want to import. Rows that contains ANC numbers which have already been added to the System will not be uploaded.All new ANC numbers will be added."/>
                            
                        </td>-->
                        <td>
                            <input type="submit" value="submit" style="height:38px;width:150px;" />

                            </td> </tr><tr>
                        <td style="width:200px;" colspan="2"><p id="loading" style="text-align: center;"></p></td>
                   </tr>
                    
                </table> 
                </form>           
        
        
       </div>

    </body>
</html>


