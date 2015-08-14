<%-- 
    Document   : SubDomain
    Created on : Aug 22, 2013, 9:58:50 AM
    Author     : Maureen
--%>

<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<html><head>
	<title>Sub- Domain</title>
		

        <script src="scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <!--<script src="media/js/jquery-ui.js" type="text/javascript"></script>-->
<!--   <script src="media/js/jquery.validate.js" type="text/javascript"></script>-->
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
<script src="scripts/jquery.validate.js" type="text/javascript"></script>
<link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />

		<script type="text/javascript">
			$(document).ready( function () {
				$('#example').dataTable().makeEditable({
                                  
									
                                                                        sUpdateURL: "UpdateSubDomain",
                                                                        sAddURL: "AddSubDomain",
                                                                        sDeleteURL: "DeleteSubDomain",
                    							"aoColumns": [                   									
                    									null,
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving...',
                                                            					tooltip: 'Click to edit',
												type: 'textarea',
                                                 						submit:'Save changes',
                                                                                                callback : function(value, settings)
                                                                                                                        { 
                                                                                                                            alert(value);
                                                                                                                            window.location.reload();
                                                                                                                        
                                                                                                                        },
												fnOnCellUpdated: function(sStatus, sValue, row, column, settings){
													alert("(Cell Callback): Cell["+row+","+column+"] is updated with value " + sValue);
												}
                    									}
                    									
                    									
                    								
//                    									
											]									

										});
				
			} );
		</script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-17838786-2']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
	<link rel="StyleSheet" href="css/main.css" type="text/css" />
 <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
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
	 <body id="dt_example">
         

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
             <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
   
    <%@include file="../menu/adminmenu.html" %>
    
    
		<div id="container">
		
			<div id="demo">
  <button id="btnAddNewRow" value="Ok">Add new Sub-Domain...</button> 
  <button id="btnDeleteRow" value="cancel">Delete selected Sub-Domain</button>

<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th>ID</th>
			<th>Sub Domain </th>
			<th>Domain ID</th>
			
			
		</tr>
	</thead>
	<tfoot>
		<tr>

		        
		</tr>

	</tfoot>
   <tbody>
		 
        <c:forEach  var="today" items="${subdomain}"  >
             <c:set var="ID"  value="${today.ID}"></c:set>
             <c:set var="SubDomainName"  value="${today.SUBDOMAIN}"></c:set>
             <c:set var="DomainID"  value="${today.DOMAINID}"></c:set>
            <input type="hidden" id="id" name="id" value="<%= pageContext.getAttribute("ID")%>" />
            <input type="hidden" id="SubDomainName" name="SubDomainName" value="<%= pageContext.getAttribute("SubDomainName")%>" />
            <input type="hidden" id="DomainID" name="DomainID" value="<%= pageContext.getAttribute("DomainID")%>" />
           
            <tr id="<%=pageContext.getAttribute("ID")%>">
          
           
           <td>  ${today.ID} </td>
           <td class="sorting_1">${today.SUBDOMAIN} </td>
           <td>${today.DOMAINID} </td>
           
          
          </tr>
       
         </c:forEach>
               
	</tbody>
</table>
 
			</div>
			<div class="spacer"></div>

			
			

			
			
			
		
                </div></div>
    
    
    
     <form id="formAddNewRow" action="#" title="Add new sub-domain">
          <table>
            <tr>
               
                <td><select name="DomainID">
                        <option value=""></option>
                       
               <%
               dbConnect conn = new dbConnect();
                                                      String districtQuery= "SELECT DomainID,Domain FROM domains";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(districtQuery);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("DomainID")%>'><%=conn.rs.getString("Domain")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("DomainID"));
                                System.out.println(conn.rs.getString("Domain"));                                                      }
                                
                               
                                                   %>
                                            

</select>
                </td>
                <td>Code</td> <td><input type="text" value="" name="subdomain"></td>
                
            </tr>
     </table>
     </form>
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