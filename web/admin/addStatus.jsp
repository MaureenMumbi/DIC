<%-- 
    Document   : addStatus
    Created on : Jan 27, 2015, 3:10:34 PM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STATUS</title>
        <link rel="StyleSheet" href="main.css" type="text/css" />
        <style type="text/css">
    #container{
                height:200px;
                width:300px; 
    }
    </style>
   <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen"/>
<link rel="StyleSheet" href="../main.css" type="text/css" />

<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/noty/jquery.noty.js"></script>


<script type="text/javascript" src="../js/noty/layouts/top.js"></script>
<script type="text/javascript" src="../js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

 <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="../js/jquery-1.7.2.js"></script>
	<script src="../js/jquery-ui-1.10.3.custom.js"></script>

       <script src="../js/datepicker.js"></script>
       <script src="admin/ui/jquery.ui.datepicker.js"></script>
    <script>	
                $(function() {
        $( "#datepicker" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'2011:2015'
                               
                        });
                    
                });
            </script>   
    </head>
    <body>
         

<div class="example" style=" width:1350px; height: 500px;">
           
    
    
    <div class="login">
        
       <%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server

    String username=(String)session.getAttribute("Username");
      
               if(session.getAttribute("Username")==null){
//                    response.sendRedirect("../index.jsp"); 
               }           
     
        else{
     %>
      <a class="button-1" href="../logoutServlet">LogOut</a>         
     <h5>Welcome <%=username%></h5>
     <%
               }
        
 
      %>
           </div>
              
<!--    <h1 class="logo"><a href="#">FHI-360</a></h1>-->
 <div><h1 style="text-align: center"><img src="../images/aphia_logo.png" height="70" width="200"/></h1></div>
         
   <div> 
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

else{ %>
        
             <%@include file="../menu/clerkmenu.jsp" %>
            
           <%}%>
       <%
String UniqueID="";
String name="";
if(request.getParameter("name")!=null && !request.getParameter("name").equals(""))  {  
name=request.getParameter("name");
       }
if(request.getParameter("UniqueID")!=null && !request.getParameter("UniqueID").equals(""))  {  
UniqueID=request.getParameter("UniqueID");
       }

 
%>
           
<div id="container" style="height:300px;">
               <form action="../saveStatus">
               <h2>HIV STATUS</h2>
               <table>
                   
                   
                   <tr class="d0"><td>UniqueID </td><td><input type="hidden" name="UniqueID" value="<%= UniqueID  %>"   id="UniqueID">
                   <input type="hidden" name="Name" value="<%= name  %>"   id="Name" ><%= UniqueID  %></td></tr>
                   <tr class="d1"><td >Full Name  </td><td><%= name  %></td></tr>
                   <tr class="d0"><td>Date Tested </td><td><input type="text" name="testeddate" value=""   id="datepicker" class="datepicker"> </td></tr> 
                   <tr class="d1"><td>HIV Status </td>
                       <td><select name="status">
                               <option value=""></option>
                               <option value="P">Positive </option>
                               <option value="N">Negative </option>
                           </select>
                       </td>
                   </tr> 
                   <td><input type="submit" name="Save" value="Save"  ></td>
               </table>
           </form>
           </div>    
          
           
           
           
            
        <!--=====================================================================================--> 
            </div>
    
    
   
</div>
      </body>
</html>



