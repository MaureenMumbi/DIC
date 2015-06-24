<%-- 
    Document   : ViewAssessment
    Created on : Aug 12, 2013, 2:29:30 PM
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
<title>View Clients Assessments</title>
<script language="javascript" type="text/javascript" >
//     var idw = document.getElementById("UID").value(); 
     function editRecord(UniqueID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/AssessmentServlet?UniqueID='"+UniqueID+"'";
    f.submit();
    
}
function deleteRecord(UniqueID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/DeleteAssessment?UniqueID="+UniqueID; 
    f.submit();
}

</script>
  
        <script type="text/javascript" src="scripts/jquery-1.8.3.js"></script> 
        <script type="text/javascript" src="scripts/jquery.tablesorter.js"></script>
        <script type="text/javascript" src="scripts/jquery.tablesorter.pager.js"></script>
        <link href="css/jquery.tablesorter.pager.css" rel="stylesheet"/>
        <link href="images/style_sorter.css" rel="stylesheet"/>
        <script src="../js/jquery-ui-1.10.3.custom.js"></script>
	<script type="text/javascript"> 
	$(document).ready(function() 
    { 
        $("#assessmenttable")
        .tablesorter({widthFixed: true, widgets: ['zebra']})
        .tablesorterPager({container: $("#pager")}); 
    });
	</script>    


      
	

        <script type="text/javascript" src="../js/DICHelp.js"></script> 
<!--
	<script type="text/javascript">
	$(function() {
		$("#assessmenttable")
			.tablesorter({widthFixed: true, widgets: ['zebra']})
			.tablesorterPager({container: $("#pager")});
	});
	</script>-->
 <link rel="StyleSheet" href="css/main.css" type="text/css" />
 <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
    #container{
                height:600px;
                width:1000px;
/*                 overflow-x: auto;*/
    }
     .example {
    width:1350px;
    height:900px;
    
     }
    </style>        
</head>
    <body>
<div class="example">
           <div class="login">
        <% 
          if(session.getAttribute("Username")!=null){
        String username=(String)session.getAttribute("Username");
      %>
          
       <a class="button-1" href="../DIC/logoutServlet">LogOut</a>          
     <h5>Welcome <%=username%></h5>
     <% }else{
               response.sendRedirect("../index.jsp"); }
     %>
           </div>
           </div>
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
 <table>              
<tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[19]!=null){%>
         <%=Sectionshelp[19]%> 
         <%}%>
    </td>
    </tr>
                        </table>   
        
        <h3> Manage Risk Assessments <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="images/help_24.png"/> </a></h3>
        <form action ="/DIC/searchAssess" method="post">
            <table style="width: 400px;">
         <tr><td>Enter Unique ID</td><td><input type="text" name="assess" value=""> </td><td><input type="submit" name="submit" value="Search"></td></tr> 
           
            </table>
            
        </form>
    <table>
           <tr>
        <td colspan=9 align="center"><a href="/DIC/Enrollment.jsp" style="font-weight:bold;color:#cc0000;">Enroll New Client</a></td>
    </tr>
    <tr><td colspan=9 align="center" ></td></tr>
    </table>      
    <form name="form">
    
     <table style="width:1000px;" class="tablesorter" id="assessmenttable" >
     <thead>   
      <tr>
      <td>Assessment ID</td>
      <td>Date of Assessment</td>
      <td>Unique Identifer</td>
      <td>Edit</td>
      <td>Delete</td>
  </tr>
         </thead>
         <tbody>
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
                        
                        session = request.getSession(true);
                        session.setAttribute("UniqueID", UniqueID);

			
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
                        <td><input type="button" name="Edit" value="Edit" id="UID" onclick="editRecord('<%= UniqueID %>')"></td>
                       
                         <td>
                             <input type="button"  name="delete" value="Delete" onclick="deleteRecord('<%= UniqueID %>')">
                         </td>
                        
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
         </tbody>
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
  
 
 </BODY>
</HTML>

