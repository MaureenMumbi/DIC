<%-- 
    Document   : createQuestionairre
    Created on : Aug 22, 2013, 3:35:01 PM
    Author     : Maureen
--%>
<%!

int domain;


%>
<%@page import="dbConnect.dbConnect"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<html><head>
       
	<title>Creating questions</title>
		
<!--        <script src="scripts/jquery.tabwizard.js" type="text/javascript"></script>
        <script src="scripts/jquery.tabwizard.js" type="text/javascript"></script>
        <link href="scripts/tabs.css" rel="stylesheet" type="text/css">-->
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
                                  
									
                                                                        sUpdateURL: "UpdateQuestionnaire",
                                                                        sAddURL: "AddQuestionnaire",
                                                                        sDeleteURL: "DeleteQuestionnaire",
                    							"aoColumns": [  null,                 									
                    									
                    									                									
                    									
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving...',
                                                            					tooltip: 'Click to edit ',
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
                    									},
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving ...',
                                                            					tooltip: 'Click to edit ',
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
                    									},
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving platforms...',
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
                    									},
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
                    									},
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
                    									},
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
                    									},{
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
                height:700px;
                width:1000px; 
                overflow-x: auto;
    }
     .example {
    width:1200px;
    height:1000px;
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
 <a href="/DIC/Questionnaire/Questionnairewizard.jsp"<button id="" value="Ok">Add new question...</button> </a>
<!--<a href="../DIC/Questionnaire/createQuestions.jsp"><input type="button" value="Add a Question"></a>-->
  <button id="btnDeleteRow" value="cancel">Delete selected question</button>

<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th>ID</th>
			<th>Domain ID</th>
			<th>Sub Domain</th>
			<th>Question ID</th>
			<th>Question</th>
			<th>Question type</th>
			<th>Is Coded</th>
			<th>Has Dependant</th>
			<th>Dependant Question</th>
			
			
		</tr>
	</thead>
	<tfoot>
		<tr>

		        
		</tr>

	</tfoot>
   <tbody>
		 
        <c:forEach  var="today" items="${questions}"  >
          
          <c:set var="ID"  value="${today.ID}"></c:set>
          <c:set var="SubDomainID"  value="${today.SUBDOMAINID}"></c:set>
          <c:set var="DomainID"  value="${today.DOMAINID}"></c:set>
          <c:set var="Question"  value="${today.QUESTION}"></c:set>
          <c:set var="Type"  value="${today.TYPE}"></c:set>
          <c:set var="IsCoded"  value="${today.ISCODED}"></c:set>
          <c:set var="Dependant"  value="${today.DEPENDANT}"></c:set>
          <c:set var="DependantValue"  value="${today.DEPENDANTVALUE}"></c:set>
          <c:set var="DependantQuestion"  value="${today.DEPENDANTQUESTION}"></c:set>
         
         
         
           
         <input type="hidden" id="id" name="id" value="<%= pageContext.getAttribute("ID")%>" />
        <input type="hidden" id="SubdomainID" name="SubdomainID" value="<%= pageContext.getAttribute("SubDomainID")%>" />
         <input type="hidden" id="DomainID" name="DomainID" value="<%= pageContext.getAttribute("DomainID")%>" />
         <input type="hidden" id="Question" name="Question" value="<%= pageContext.getAttribute("Question")%>" />
       <input type="hidden" id="Name" name="Name" value="<%= pageContext.getAttribute("Name")%>" />
        <input type="hidden" id="Type" name="Type" value="<%= pageContext.getAttribute("Type")%>" />
        <input type="hidden" id="DependantQuestion" name="DependantQuestion" value="<%= pageContext.getAttribute("DependantQuestion")%>" />
        <input type="hidden" id="DependantValue" name="DependantValue" value="<%= pageContext.getAttribute("DependantValue")%>" />
        <input type="hidden" id="DependantQuestion" name="DependantQuestion" value="<%= pageContext.getAttribute("DependantQuestion")%>" />
         
        <tr id="<%=pageContext.getAttribute("ID")%>">
           
           <td>${today.ID} </td>
           <td>${today.SUBDOMAINID} </td>
           <td>${today.QUESTION} </td>
           <td>${today.DOMAINID} </td>
           <td>${today.TYPE} </td>
           <td>${today.ISCODED} </td>
           <td>${today.DEPENDANT} </td>
           <td>${today.DEPENDANTVALUE} </td>
           <td>${today.DEPENDANTQUESTION} </td>
         
          </tr>
       
         </c:forEach>
               
	</tbody>
</table>
 
			</div>
			<div class="spacer"></div>

			
			
                </div>
			
			
			
		</div>
    
    
    
    


	</body>


</html>
