<%-- 
    Document   : Diary
    Created on : Feb 26, 2014, 3:05:46 PM
    Author     : Maureen
--%>

<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
dbConnect conn = new dbConnect();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Diary </title>
        <link rel="StyleSheet" href="css/main.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
 
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
<link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <script src="js/dataTables.fnGetFilteredNodes.js" type="text/javascript"></script>
        <script src="js/dataTables.fnGetHiddenNodes.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready( function () {
//				$('#example').dataTable().makeEditable({
//                                  
//									
//                                                                        sUpdateURL: "UpdateCondomCode",
//                                                                        sAddURL: "AddCondomCode",
//                                                                        sDeleteURL: "DeleteCondomCode",
//                    							"aoColumns": [ null,                  									
//                    									
//                    									null,null
////                    									
//											]									
//
//										});
				
			
                        
                        
                        oTable = $('#example').dataTable();   
            $('form[name=formname]').submit(function(){

                           //replace 'yourformsnameattribute' with the name of your form
//  (oTable.fnGetHiddenNodes()).find('input:checkbox').appendTo(this);
  //$(oTable.fnGetHiddenNodes()).attr('checked',this.checked).appendTo(this).css("visibility","hidden");

  ////this is what passes any hidden nodes to your form when a user clicks SUBMIT on your FORM
} );
 
$('.checkall').click( function() { //this is the function that will mark all your checkboxes when the input with the .checkall class is clicked
    $('input', oTable.fnGetFilteredNodes()).attr('checked',this.checked); //note it's calling fnGetFilteredNodes() - this is so it will mark all nodes whether they are filtered or not
} );
       } );               
		</script>

<!-- <link rel="StyleSheet" href="main.css" type="text/css" />
 <script type="text/javascript" src="scripts/jquery-1.8.3.js"></script> 
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
 You can add more layouts if you want 

<script type="text/javascript" src="js/noty/themes/default.js"></script>



-->      <script type="text/javascript" src="js/DICHelp.js"></script> 
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <!--
    
     <script type="text/javascript" src="scripts/jquery.tablesorter.js"></script>
        <script type="text/javascript" src="scripts/jquery.tablesorter.pager.js"></script>
        <link href="css/jquery.tablesorter.pager.css" rel="stylesheet"/>
        <link href="images/style_sorter.css" rel="stylesheet"/>
        <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">

	<script src="js/jquery-ui-1.10.3.custom.js"></script>
	<script type="text/javascript"> 
	$(document).ready(function() 
    { 
        $("#tablesorter")
        .tablesorter({widthFixed: true, widgets: ['zebra']})
        .tablesorterPager({container: $("#pager")}); 
    });
	</script>    -->
<!--<script type="text/javascript">
 function checkAll(event) {

    var options = document.getElementsByClassName("reminders");
    for (var i = 0; i < options.length; i++) {
        options[i].checked = event.srcElement.checked;
    }
}
</script>-->
<script  type="text/javascript">
function toggle(source) {
  checkboxes = document.getElementsByClassName("reminders");
  for(var i=0, n=checkboxes.length;i<n;i++) {
    checkboxes[i].checked = source.checked;
  }
}</script>
    </head>
    <body>
         

<div class="example" style="width:1350px; height: 700px;">
            <div class="login">
            
     <%
              
        String username=(String)session.getAttribute("Username");
      
               if(username==null){
//                 response.sendRedirect("index.jsp");     
               } else{
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
     
            <div id="container" style="width:1000px; height: 400px;">
                <div>
            <% 
 
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
         <% if(Sectionshelp[18]!=null){%>
         <%=Sectionshelp[18]%> 
         <%}%>
    </td>
    </tr>
                        </table>   
            <form action="sendSMS" method="post" name="formname">
         <h4>FSW APPOINTMENTS DIARY</h4>
          <table cellpadding="0" cellspacing="0" border="0" class="display" id="example" >
                    
	<thead>
              <tr>
                    <th>UNIQUE ID </th>
		    <th>FIRST NAME</th>
		    <th>MIDDLE NAME</th>
		    <th>PHONE NO.</th>
		    <th>ALTERNATIVE PHONE NO.</th>
		    <th>APPOINTMENT DATE </th>
		     <th>SEND SMS  </th>
		</tr>
	</thead>
        <%
        int count=0;
%>
         <c:forEach  var="detail" items="${details}"  >
           <% count++; %>
          <c:set var="id"  value="${detail.UNIQUEID}"></c:set>
          <c:set var="fname"  value="${detail.FNAME}"></c:set>
          <c:set var="mname"  value="${detail.MNAME}"></c:set>
          <c:set var="phoneno"  value="${detail.PHONENO}"></c:set>
          <c:set var="phoneno1"  value="${detail.PHONENO1}"></c:set>
          <c:set var="date"  value="${detail.DATE}"></c:set>
        
         
       
        
       
       
<!--       <tbody>-->
         
     <tr id="<%=pageContext.getAttribute("id")%>">
          <td>${detail.UNIQUEID} </td>
          <td>${detail.FNAME} </td>
          <td>${detail.MNAME} </td>
          <td>${detail.PHONENO} </td>
          <td>${detail.PHONENO1} </td>
          <td> ${detail.DATE}</td>
        <td><input type="checkbox" value="<%=pageContext.getAttribute("id")%>" class="reminders" name="reminder<%= count %>" id="reminder<%= count %>" ></td>
       <input type="hidden" id="id" name="id<%= count %>" value="<%= pageContext.getAttribute("id")%>" />
       <input type="hidden" id="fname" name="fname<%= count %>" value="<%= pageContext.getAttribute("fname")%>" />
       <input type="hidden" id="mname" name="mname<%= count %>" value="<%= pageContext.getAttribute("mname")%>" />
       <input type="hidden" id="phoneno" name="phoneno<%= count %>" value="<%= pageContext.getAttribute("phoneno")%>" />
       <input type="hidden" id="phoneno1" name="phoneno1<%= count %>" value="<%= pageContext.getAttribute("phoneno1")%>" />
       <input type="hidden" id="date" name="date<%= count %>" value="<%= pageContext.getAttribute("date")%>" />
   
         </tr>
        
       
<!--       </tbody>-->
         </c:forEach>
      
<input type="text" id="count" name="count" value="<%= count %>" />
          
     </table>
<table style="background-color: grey; height:40px">
 <tr>
     <td colspan="8"><input type="submit"  value="Send SMS" name="submit" style="width: 200px;height:30px;" ></td>      

      
      <td style="width: 887px;"></td>   <td style="width: 100px;" style="background-color: grey;"><input type="checkbox" onClick="toggle(this)" class="checkall" /> Select All</td>
             
         </tr>
       
</table>
          </form>
            </div>
        <div>
         
     
        </div>
  
       
      </div>
      
</div>
  
    
            
            
            
       
    </body>
</html>

