<%-- 
    Document   : DIC
    Created on : Aug 20, 2013, 9:58:50 AM
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
	<title>DIC</title>
		

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
                                  
									
                                                                        sUpdateURL: "UpdateDIC",
                                                                        sAddURL: "AddDIC",
                                                                        sDeleteURL: "DeleteDIC",
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
  <button id="btnAddNewRow" value="Ok">Add new DIC...</button> 
  <button id="btnDeleteRow" value="cancel">Delete selected DIC</button>

<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th>DIC ID</th>
			<th>DIC Name</th>
			<th>DistrictID</th>
			
			
		</tr>
	</thead>
	<tfoot>
		<tr>

		        
		</tr>

	</tfoot>
   <tbody>
	   <c:forEach  var="today" items="${list2}"  >
             <c:set var="DICID"  value="${today.DICID}"></c:set>
             <c:set var="DICName"  value="${today.DICNAME}"></c:set>
             <c:set var="Disrict"  value="${today.DISTRICTID}"></c:set>
            <input type="hidden" id="DICid" name="DICid" value="<%= pageContext.getAttribute("DICID")%>" />
            <input type="hidden" id="DICName" name="DICName" value="<%= pageContext.getAttribute("DICName")%>" />
            <input type="hidden" id="District" name="District" value="<%= pageContext.getAttribute("District")%>" />
           
            <tr id="<%=pageContext.getAttribute("DICID")%>">
          
           
           <td>  ${today.DICID} </td>
           <td class="sorting_1">${today.DICNAME} </td>
           <td>${today.DISTRICTID} </td>
           
          
          </tr>
       
         </c:forEach>
               
	</tbody>
</table>
 
			</div>
			<div class="spacer"></div>

			
			

                </div>
</div>
			
			
		
    
    
    
     <form id="formAddNewRow" action="#" title="Add new DIC">
         
            <tr>
               
                <td>District</td><select name="Districts">
                        <option value=""></option>
                       
               <%
               dbConnect conn = new dbConnect();
                                                      String districtQuery= "SELECT DistrictID,District FROM Districts";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(districtQuery);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("DistrictID")%>'><%=conn.rs.getString("District")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("DistrictID"));
                                System.out.println(conn.rs.getString("District"));                                                      }
                                
                               
                                                   %>
                                            

</select>
                </td>
                <td>DIC Name </td> <td><input type="text" value="" name="DICName"></td>
              
            </tr>
    
     </form>
  </body>


</html>


