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
     String medical = "delete from medical_form where unique_identifier='"+UniqueID+"'";
     
    
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
conn.state.executeUpdate(medical);

response.sendRedirect("admin/indexWorker.jsp");

     
     		
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