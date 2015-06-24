<%-- 
    Document   : EditQuestions
    Created on : Aug 22, 2013, 8:49:41 PM
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
	<title>Question Codes</title>
		

        



<body id="dt_example">
		<div id="container">
		
			<div id="demo">
  

<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th>Question ID</th>
			<th>Question name</th>
			<th>Question type</th>
			<th>Is Coded</th>
			<th>Has Dependant</th>
			<th>Dependant Value</th>
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
          <c:set var="Question"  value="${today.QUESTION}"></c:set>
          <c:set var="type"  value="${today.TYPE}"></c:set>
          <c:set var="IsCoded"  value="${today.ISCODED}"></c:set>
          <c:set var="Dependant"  value="${today.DEPENDANT}"></c:set>
          <c:set var="dependantValue"  value="${today.DEPENDANTVALUE}"></c:set>
          <c:set var="dependantQuestion"  value="${today.DEPENDANTQUESTION}"></c:set>
         
           
         <input type="hidden" id="id" name="id" value="<%= pageContext.getAttribute("ID")%>" />
       <input type="hidden" id="subdomainID" name="subdomainID" value="<%= pageContext.getAttribute("SubDomainID")%>" />
         
            <tr id="<%=pageContext.getAttribute("ID")%>">
           
          <td> ${today.ID} </td>
         <td><input type="text" name="id" value="${today.SUBDOMAINID}"> </td>
         <td><input type="text" name="question" value="${today.QUESTION}" ></td>
          <td><input type="text" name="type" value="${today.TYPE}"></td>
          <td><input type="text" name="type" value="${today.ISCODED}"></td>
          <td><input type="text" name="type" value="${today.DEPENDANT}"></td>
          <td><input type="text" name="type" value="${today.DEPENDANTVALUE}"></td>
           <td><input type="text" name="type" value="${today.DEPENDANTQUESTION}"></td>
           <td><input type="submit" name="submit" value="Submit"></td> 
        
          </tr>
       
         </c:forEach>
               
               
	</tbody>
</table>
 
			</div>
			<div class="spacer"></div>

			
			

			
			
			
		</div>
    
    
    

	</body>
