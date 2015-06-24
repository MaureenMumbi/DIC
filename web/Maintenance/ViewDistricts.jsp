<%-- 
    Document   : ViewDistricts
    Created on : Aug 16, 2013, 1:38:07 PM
    Author     : Maureen
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>View Enrolled Clients</title>
<script type="text/javascript">
        function displayResult()
        {
            document.getElementById("myTable").insertRow(-1).innerHTML = '<td><input type="text" name="UniqueID" value=""></td><td><input type="text" name="Districts" value=""></td>';
        }
        </script>



 <script language="javascript" type="text/javascript" >
     var idw = document.getElementById("UID").value(); 
     function editRecord(idw){
    var f=document.form;
    f.method="post";
    f.action="http://localhost:8080/DIC/EditDistricts?UniqueID='"+idw+"'";
    f.submit();
    
}
function deleteRecord(idw){
    var f=document.form;
    f.method="post";
    f.action="/DeleteDistricts?UniqueID="+idw; 
    f.submit();
}

</script>
 <link rel="StyleSheet" href="../main.css" type="text/css" />
 <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
     #container{
                height:500px;
                width:1000px; 
    }
     .example {
    width:1000px;
    height:900px;
     }
    </style>

   </head>
    <body>
         

<div class="example">
           <div class="login">
     <% String logStatus=(String)session.getAttribute("loggedIn");
               if(logStatus==null){
     %>
                   <a class="button-1" href="Login.jsp">Login</a>
     <%        } else{
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
   
   <%@include file="../menu/adminmenu.html" %>
    
    
    
    <div id="container">
     <form name="form">
  <table style="width:1000px;" id="myTable" border="1">>
    <tr>
        <td colspan=9 align="center"><a href="/DIC/Enrollment.jsp" style="font-weight:bold;color:#cc0000;">Enroll New Client</a></td>
    </tr>
    <tr><td colspan=9 align="center" ></td></tr>
    <tr style="background-color:#cccccc;font-weight:bold;">
       <td> Unique Id</td>
       <td>District</td>
       
       

      <td>Edit</td>
      <td>Delete</td>
  </tr>
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
			int UniqueID = (Integer)viewList.get(0);
                        
                        System.out.println("aaaaaaa"+UniqueID);
			
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
                       
                         <td><input type="button" disabled name="delete" value="Delete" onclick="deleteRecord('<%= UniqueID %>');"></td>
                         
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
        
        
        <button type="button" onclick="displayResult()">Insert new row</button> 
     <tr><td colspan=9 align="center" ></td></tr>
  </table>
    </form>
      </div>
 
     </div>
    </body>
 
</html>

