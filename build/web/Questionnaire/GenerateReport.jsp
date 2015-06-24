<%-- 
    Document   : GenerateReport
    Created on : Aug 29, 2013, 11:46:33 AM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="http://localhost:8080/DIC/Report2" method="post" >
            <table>
                <tr><td>Select table</td>
                    <td><select name="table">
                            <option value=""></option>
                            <option value="enrollment">Enrollment</option>
                            <option value="riskassessmentdetails">Risk Assessment</option>
                            <option value="riskreductiondetails">Risk Reduction</option>
                       </select> </td>
                       <td>Specification</td>
                       <td>
                        <select name="where">
                            <option value=""></option>
                            <option value="UniqueID">Unique ID</option>
                            <option value="District"> District</option>
                            <option value="ClientInit"> Client Initials</option>
                       </select>    
                      </td>
                      <td>Districts</td>
                      <td>
                        <select name="districts">
                            <option value=""></option>
                            <option value="Kajiado">Kajiado</option>
                            <option value="Nakuru"> Nakuru</option>
                           
                       </select>    
                      </td>
                      <td><input type="submit" name="submit" value="Submit"></td>
                         </tr>
                
                
                
                
            </table>       
            
            
            
            
        </form>
    </body>
</html>
