<%-- 
    Document   : viewMedicalDetails
    Created on : Dec 3, 2014, 11:13:46 AM
    Author     : Maureen
--%>
<%@page import="dbConnect.AES"%>
<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : CondomCode
    Created on : Aug 20, 2013, 5:04:02 PM
    Author     : Maureen
--%>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%! HttpSession session;
String username="";
   String FirstName="";
      String MiddleName="";
      String LastName="";
      String name="";
   %>

   <%if(session.getAttribute("accessTrail")!=null){ %>
<%@page import="Maintenance.saveAccessTrail"%>
<%
saveAccessTrail access = new saveAccessTrail();
String task="Accessed new medical form module. Enables users to add a new medical form. ";
String username=session.getAttribute("accessTrail").toString();
access.addAccess(username,task);

%>
<%}%>

<html><head>
	<title>Medical Details</title>
		

        <script src="scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <!--<script src="media/js/jquery-ui.js" type="text/javascript"></script>-->
<!--   <script src="media/js/jquery.validate.js" type="text/javascript"></script>-->
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
<script src="scripts/jquery.validate.js" type="text/javascript"></script>
<link href="../media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="../media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="../media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="../media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="../media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
<link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />

		<script type="text/javascript">
			$(document).ready( function () {
				$('#example').dataTable().makeEditable({
                                  
									
                                                                        sUpdateURL: "UpdateCondomCode",
                                                                        sAddURL: "AddCondomCode",
                                                                        sDeleteURL: "DeleteCondomCode",
                    							"aoColumns": [ null,                  									
                    									
                    									null,null
//                    									
											]									

										});
				
			} );
		</script>
  <script language="javascript" type="text/javascript" >
    
     function editRecord(UniqueID,name){
         
//     alert(UniqueID+"   "+MedicalID);
    var f=document.form;
    f.method="post";
    f.action="/DIC/admin/medical_form.jsp?UniqueID="+UniqueID+"&name="+name+"";
    f.submit();
    
}
function deleteRecord(UniqueID,MedicalID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/deleteMedical?UniqueID="+UniqueID+","+MedicalID+""; 
    f.submit();
}

</script>
<link rel="StyleSheet" href="css/main.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
   #container{
                height:500px;
                width:1200px; 
    }
     .example {
    width:1350px;
    height:900px;
     }
    </style>
    </head>
	 <body id="dt_example">
         

<div class="example">
            <div class="login">
      <% 
          if(session.getAttribute("Username")!=null){
        String username=(String)session.getAttribute("Username");
      %>
          
       <a class="button-1" href="/DIC/logoutServlet">LogOut</a>          
     <h5>Welcome <%=username%></h5>
     <% }else{
//               response.sendRedirect("/DIC/index.jsp"); 
     }
     %>
           </div>
             <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
   
       <!--=========================================menu=========================================-->     
              <div style="width:1350px;"> 
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
            
            
        <!--=====================================================================================--> 
            </div>
    
    
    
		<div id="container">
		
			<div id="demo">
<!--  <button id="btnAddNewRow" value="Ok">Add new code...</button> 
  <button id="btnDeleteRow" value="cancel">Delete selected code</button>-->
    <form name="form">
    
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		
			<tr>
			<th>Unique Identifer </th>
   <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%> <th>Full Name</th><%}}%>

       
       
 
      <th>Bio Medical</th>
    

			
		</tr>
			

			
		</thead>
	<tfoot>
		<tr>

		        
		</tr>

	</tfoot>
   <tbody>
		 
         <% 
          dbConnect conn = new dbConnect();
          String getname="";
    
     getname="select * from enrollment";
    conn.rs2 = conn.state2.executeQuery(getname);
    while(conn.rs2.next()){


%>
<tr id="<%= conn.rs2.getString("UniqueID") %>">
    <td> <%= conn.rs2.getString("UniqueID") %></td>
   <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%> 
    
                             <%
                             
                             
                                final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs2.getString("FirstName")!=null && !conn.rs2.getString("FirstName").trim().equals("") && !conn.rs2.getString("FirstName").equals("null")){
                                    
                                        AES.decrypt(conn.rs2.getString("FirstName").trim());
                                       System.out.println("String To Decrypt : " +  conn.rs2.getString("FirstName"));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
                                                      FirstName =  AES.getDecryptedString()  ;
                                                   }
                                       
                          if(conn.rs2.getString("SecondName")!=null && !conn.rs2.getString("SecondName").trim().equals("") && !conn.rs2.getString("SecondName").equals("null")){               
//                        
                    AES.decrypt(conn.rs2.getString("SecondName").trim());
                     System.out.println("String To Decrypt : " + conn.rs2.getString("SecondName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    MiddleName=AES.getDecryptedString();
                          }
                      if(conn.rs2.getString("LastName")!=null && !conn.rs2.getString("LastName").trim().equals("") && !conn.rs2.getString("LastName").equals("null")){
//                      Lastname =  conn.rs2.getString("LastName");
                    AES.decrypt(conn.rs2.getString("LastName").trim());
                     System.out.println("String To Decrypt : " + conn.rs2.getString("LastName"));
                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                      }
        
                             
     name=  FirstName+"  "+ MiddleName+"  "+ LastName;%>
      <td> <%= name %> </td><%}}%>
      <td><input type="button" name="Edit" value="New Medical Form "  onclick="editRecord('<%= conn.rs2.getString("UniqueID")  %>','<%=name%>')"></td>
                       
                        
                        </tr>
			<%
		}
	
	%>
            
	</tbody>
</table>
    </form>
			</div>
			<div class="spacer"></div>

			
			

			
			
			
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