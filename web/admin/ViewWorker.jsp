<%-- 
    Document   : ViewProduct
    Created on : Feb 7, 2013, 9:53:42 PM
    Author     : Maureen
--%>



<%@page import="dbConnect.dbConnect"%>
<%@ page import="java.util.*"%>
<%@ page language="java"%>
<%@page import="DIC.Admin.*" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>View Enrolled Clients</title>
<!-- <script src="js/jquery-1.7.2.js"></script>-->
<!--        <script type="text/javascript" src="scripts/jquery-latest.js"></script>-->
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script> 
        <script type="text/javascript" src="../js/jquery.tablesorter.js"></script>
	<script type="text/javascript" src="../js/jquery.tablesorter.pager.js"></script>
       <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet"/>
	
<!-- <script src="js/jquery-1.7.2.js"></script>-->
	<script src="../js/jquery-ui-1.10.3.custom.js"></script>

        <script type="text/javascript" src="../js/DICHelp.js"></script> 
 
	<script type="text/javascript">
	
	$(function() {
		$(".tablesorter")
			.tablesorter()
			.tablesorterPager({container: $("#pager")});
	});
	</script>


 <script language="javascript" type="text/javascript" >
    
     function editRecord(UniqueID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/WorkerServlet?UniqueID='"+UniqueID+"'";
    
    f.submit();
    
}
function deleteRecord(UniqueID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
    f.submit();
}

</script>
<link rel="StyleSheet" href="css/main.css" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
  <style type="text/css">
    #container{
                height:1000px;
                width:1050px; 
                overflow-x: auto;
    }
     .example {
    width:1350px;
    height:1200px;
     }
    </style>

   </head>
    <body>
         

<div class="example">
           <div class="login">
     <% String logStatus=(String)session.getAttribute("loggedIn");
               if(session.getAttribute("loggedIn")==null){
                   response.sendRedirect("/DIC/index.jsp");
     %>
                   
     <%        } else{
     %>
                   <a class="button-1" href="../logoutServlet">LogOut</a> 
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
             <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
   
           <!--=========================================menu=========================================-->     
           <div style="width:1350px;">
                     <%
if(session.getAttribute("AccessLevel")!=null){            

if (session.getAttribute("AccessLevel").equals("2")) {%>
            <%@include file="../menu/adminmenu.html" %>
            <%}
else{%>

 <%@include file="../menu/clerkmenu.html" %>

<%}

}

else{ %>
        
             <%@include file="../menu/clerkmenu.html" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>
    
           
    
    <div id="container">
         <table>              
<tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[19]!=null){%>
         <%=Sectionshelp[19]%> 
         <%}%>
    </td>
    </tr>
                        </table>   
        
        <h3> Manage Enrollments <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="images/help_24.png"/> </a></h3>
        <form action ="/DIC/searchWorker" method="post">
            <table style="width: 400px;">
         <tr><td>Enter Unique ID</td><td><input type="text" name="worker" value=""></td><td><input type="submit" name="submit" value="Search"></td></tr> 
           
            </table>
            
        </form>
        
        
     <form name="form">
  <table class="tablesorter" style="width:1000px;">
      <thead>
    <tr>
        <td colspan=9 align="center"><a href="/DIC/Enrollment.jsp" style="font-weight:bold;color:#cc0000;">Enroll New Client</a></td>
    </tr>
    <tr><td colspan=9 align="center" ></td></tr>
    <tr style="background-color:#cccccc;font-weight:bold;">
       <td>Unique Identifer</td>
       <td>Client Initials</td>
       <td>Date of Enrollment</td>
       <td>County</td>
       <td>DIC Name</td>
       <td>DOB</td>
       <td>Sex</td>
       <td>Marital Status</td>
       

      <td>Edit</td>
      <td>Delete</td>
  </tr>
    </thead>
	<%
	String bgcolor="";
	int count=0;
	List viewList = new ArrayList();
	Iterator  viewItr;
	
	if(request.getAttribute("userList")!=null && request.getAttribute("userList")!="")
	{
		List userList =  (ArrayList)request.getAttribute("userList");
		Iterator itr = userList.iterator();
		 
		while(itr.hasNext())
		{
			
			if(count%2==0)
			{
			 bgcolor = "#F0F0F0;";
			}
			else
			{
				
				bgcolor = "#F8F8FF";
			}
			
			viewList = (ArrayList)itr.next();
			String UniqueID = viewList.get(0).toString();
                        
                       
			
			viewItr = viewList.iterator();
			%>
			<tr style="background-color:<%=bgcolor%>;">
			<%	
			while(viewItr.hasNext())
			{
			
				%>
				<td><%=viewItr.next()%></td>
				
				<%
					
			}
			count++;
			%>
                        <td><a href="" target="_blank" onclick="editRecord('<%= UniqueID %>')">Edit</a></td>
                       
                         <td><input type="button" name="delete" value="Delete" onclick="deleteRecord('<%= UniqueID %>');"></td>
                        
                        </tr>
			<%
		}
	}
	if(count==0)
	{
		%>
		<tr><td colspan="9" align="center">&nbsp;</td></tr>
            <tr><td colspan="9" align="center">No Record Available</td></tr>
		<%
	}
	%>
     <tr><td colspan=9 align="center" ></td></tr>
  </table>
    </form>
      <div id="pager" class="pager">
     	<form>
            <img src="images/first.png" class="first"/>
		<img src="images/prev.png" class="prev"/>
		<input type="text" class="pagedisplay"/>
		<img src="images/next.png" class="next"/>
		<img src="images/last.png" class="last"/>
		<select class="pagesize">
			<option selected="selected"  value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option  value="40">40</option>
		</select>
	</form>
</div>
      </div>
 
     </div>
    </body>
 
</html>

