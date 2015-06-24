<%-- 
    Document   : createQuestions
    Created on : Aug 21, 2013, 4:01:14 PM
    Author     : Maureen
--%>

<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questionnaire Wizard</title>
   
<link href="tabs.css" rel="Stylesheet" type="text/css" />
<script src="../jquery-1.7.2.js" type="text/javascript"></script>
<script src="jquery.history.js" type="text/javascript"></script>
<script src="jquery.tabwizard.js" type="text/javascript"></script>
<style type="text/css">
.displayDiv
{
width: 500px;
/*padding: 25px;*/
border-left: solid 1px #000;
border-right: solid 1px #000;
border-bottom: solid 1px #000;
border-radius: 0 0 15px 15px;
display: none;
text-align: left;
font-size: 16px;
margin: auto;
}
</style>
<script type="text/javascript">
$(function()
{
var $test = $('#test');
$test.tabWizard(
{
tabs:
[
{ text: 'Sections', hash: 'Sections' },
{ text: 'Question Details', hash: 'QuestionDetails' },
{ text: 'Question Qualities', hash: 'QuestionQualities' },
{ text: 'Dependency', hash: 'Dependency' }

]
}
);
$.history.init(function(hash)
{
var tabName = "Sections";
if(hash != "")
tabName = hash;
$test.tabWizard('setSelected', tabName);
$('.displayDiv:visible').slideUp('fast', function()
{
$('#' + tabName + 'Container').slideDown('fast');
});
if ($('.displayDiv:visible').length == 0)
{
$('#' + tabName +'Container').slideDown('fast');
}
},
{ unescape: ",/" });
});
</script>
</head>
<body>
     <form action="../Maintenance/AddQuestionnaire" method="post">
<div style="text-align: center;">
<div id="test">
</div>
</div>
    
<div class="displayDiv" id="SectionsContainer">
   
<table>
            <tr><td>Select Domain</td>
                <td>   <select name="domain"><option value=""></option>
                       
               <%
               dbConnect conn = new dbConnect();
                                                      String Query= "SELECT DomainID,Domain FROM domains";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
              <option value='<%=conn.rs.getInt("DomainID")%>'><%=conn.rs.getString("Domain")%></option>
                                                   <%
                                                       
                               System.out.println(conn.rs.getInt("DomainID"));
                                System.out.println(conn.rs.getString("Domain"));                                                      }
                                
                               
                                                   %>
                    </select>
                </td></tr>
            <tr><td>Select Section</td><td>
                    <select name="subdomain">
                       <%
             
                                                      String Query1= "SELECT SubDomainID,SubDomain FROM subdomain";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query1);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
              <option value='<%=conn.rs.getInt("SubDomainID")%>'><%=conn.rs.getString("SubDomain")%></option>
                                                   <%
                                                       
                               System.out.println(conn.rs.getInt("SubDomainID"));
                                System.out.println(conn.rs.getString("SubDomain"));                                                      }
                                
//                      int DomainID = conn.rs.getInt("SubDomainID");       



                                 
                                                   
%>
                    
                    
                    </select> 
                    
                </td>
                
</table>
</form>
</div>
<div class="displayDiv" id="QuestionDetailsContainer">
    <table>
        <tr><td>Question No</td><td><input type="text" name="questionNo" value=""></td></tr>
        <tr><td>Question Name</td><td><input type="text" name="questionName" value=""></td></tr>
        <tr><td>Question</td><td><input type="text"  name="question" value=""></td></tr>
        <tr><td>Choose Question Type</td><td>
                    <select name="type" >
                        <option value=""></option>
                        <option value="Text">Text </option>
                        <option value="Checkbox">Checkbox</option>
                        <option value="Dropdown">DropDown</option>
   
                    </select>
                </td></tr>
    </table>
</div>
<div class="displayDiv" id="QuestionQualitiesContainer">
    <table>
<!--        is the question required to be filled during data entry -->
        <tr><td>Is it a required question</td>
        
            <td><select name="type">
                    <option value="Yes">Yes</option>
                    <option value="No">No</option> 
                </select>
            </td>
        
        </tr>
      <!--        for question which have a drop down of codes -->
        <tr><td>Does the question have a code? </td>
           <td><select name="type">
                    <option value="Yes">Yes</option>
                    <option value="No">No</option> 
                </select>
            </td>
        <tr><td>If yes, choose the code you want </td>
           <td><select name="type">
                   <option value=""></option>
                    <%
             
                               String Query2= "SELECT CodeID,CodeName,subDomainID FROM Codes where subDomainID='"+1+"'";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query2);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
              <option value='<%=conn.rs.getInt("CodeID")%>'><%=conn.rs.getString("CodeName")%></option>
                                                   <%
                                                       
                               System.out.println(conn.rs.getInt("CodeID"));
                                System.out.println(conn.rs.getString("CodeName"));  
                                                                                   }
                              
                               
                               
                               
                               
                               
                              
                               
                                                   %>
                                                   
                                                   
                    
                    
                    </select> 
               
            </td>
            
            
            <!--        for question which have a drop down of codes -->
       

    </table>
                                                   
</div>
<div class="displayDiv" id="DependencyContainer">
    <table>
       
        <!--        for question whose answers will create a dependance with another question-->
        <tr><td>Does the question have dependants</td> 
        <td><select name="HasDependants">
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
      
                </select></td></tr> 
        <tr><td>What is the dependant question?</td>
            <td><input name="dependantquestion" type="text" value=""></td></tr> 
        
        
        <tr><td><input type="submit" name="" value="SUBMIT"></td></tr>    
    </table>
</div>
                                                   
 <form action="../Maintenance/AddQuestionnaire">
</body>
</html>
        
    </body>
</html>
