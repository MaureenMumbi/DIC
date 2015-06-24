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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class deleteWorker extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
                                try {
response.setContentType("text/html");
PrintWriter out = response.getWriter();


String UniqueID=request.getParameter("UniqueID");


// HttpSession session = request.getSession();
 




dbConnect conn = new dbConnect();



     String query = "delete from enrollment where UniqueID='"+UniqueID+"'";
     String childage = "delete from childage where UniqueID='"+UniqueID+"'";
     String clientoparea = "delete from clientoparea where UniqueID='"+UniqueID+"'";
     String clientoccupation = "delete from clientoccupation where UniqueID='"+UniqueID+"'";
     
    
String selectRA="select *  from riskreductionmain where  UniqueID ='"+UniqueID+"'";
conn.rs2 = conn.state2.executeQuery(selectRA);
while(conn.rs2.next()){
  String riskreductiondet = "delete from riskreductiondetails where  RiskReductionID='"+conn.rs2.getString("RiskReductionID") +"' ";   
  conn.state.executeUpdate(riskreductiondet);

}
String selectRR="select *  from riskassessmentmain where  UniqueID ='"+UniqueID+"'";
conn.rs3 = conn.state3.executeQuery(selectRR);
while(conn.rs3.next()){
  String riskreductionasse = "delete  from riskassessmentdetails where  AssessmentID='"+conn.rs3.getString("AssessmentID") +"' ";   
  conn.state.executeUpdate(riskreductionasse);

}

 String riskreductionmain = "delete  from riskreductionmain where  UniqueID='"+UniqueID+"' ";
     String riskassessmentmain = "delete from riskassessmentmain where  UniqueID='"+UniqueID+"' ";
     try {

conn.state.executeUpdate(query);
conn.state.executeUpdate(riskreductionmain);
conn.state.executeUpdate(riskassessmentmain);
conn.state.executeUpdate(childage);
conn.state.executeUpdate(clientoparea);
conn.state.executeUpdate(clientoccupation);

response.sendRedirect("admin/indexWorker.jsp");
} 

catch (SQLException ex) {
     Logger.getLogger(deleteWorker.class.getName()).log(Level.SEVERE, null, ex);
     out.println(ex);
}

     
     
} 
                        
                    catch (SQLException ex) {
                                Logger.getLogger(deleteWorker.class.getName()).log(Level.SEVERE, null,ex);
                    }
                
                                
                                
                        }                     
     }