/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maureen
 */
public class DeleteAssessment extends HttpServlet {

   public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
			
                              
response.setContentType("text/html");
PrintWriter out = response.getWriter();


String UniqueID=request.getParameter("UniqueID"); 

// HttpSession session = request.getSession();




String assessID="";
String querys="";
String query1="";
dbConnect conn = new dbConnect();
// querys="select * from riskassessmentmain where UniqueID='"+UniqueID+"'";
//conn.rs2 = conn.state.executeQuery(querys);
//while(conn.rs2.next()){
//assessID=conn.rs2.getString("AssessmentID");
//  query1 = "delete from riskassessmentdetails where AssessmentID='"+assessID+"'";
//}
System.out.println(UniqueID);
System.out.println(querys);
System.out.println(query1);
     ArrayList al=null;
     ArrayList userList =new ArrayList();
      
     String query = "delete from riskassessmentmain where AssessmentID='"+UniqueID+"'";
     query1 = "delete from riskassessmentdetails where AssessmentID='"+UniqueID+"'";
   System.out.println(query);

     try {


conn.state.executeUpdate(query1);
conn.state1.executeUpdate(query);
response.sendRedirect("admin/index_Assessment.jsp");
} 

catch (SQLException ex) {
     Logger.getLogger(deleteWorker.class.getName()).log(Level.SEVERE, null, ex);
     out.println(ex);
}

     
     
} 
                        
                 
                
                                
                                
                        }                     
     