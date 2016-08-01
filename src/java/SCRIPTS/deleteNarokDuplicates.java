/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCRIPTS;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emmanuel E
 */
public class deleteNarokDuplicates extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            
            dbConnect conn= new dbConnect();
            String UniqueID="";
            
            String del=" select * from todelete ";
            conn.rs7=conn.state7.executeQuery(del);
            int cnt=0;
            while(conn.rs7.next()){
                cnt++;
                UniqueID=conn.rs7.getString(1);
            //get the unique ids that should be deleted
                System.out.println(cnt+"__ Delete Id "+conn.rs7.getString(1));
                
                
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
     

conn.state.executeUpdate(query);
conn.state.executeUpdate(riskreductionmain);
conn.state.executeUpdate(riskassessmentmain);
conn.state.executeUpdate(childage);
conn.state.executeUpdate(clientoparea);
conn.state.executeUpdate(clientoccupation);
conn.state.executeUpdate(medical);

                
            
            
          
        }  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(deleteNarokDuplicates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(deleteNarokDuplicates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
