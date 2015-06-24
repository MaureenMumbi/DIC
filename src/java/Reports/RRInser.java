/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

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
 * @author Maureen
 */
public class RRInser extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
        
            dbConnect conn = new dbConnect();
        String DOA="";
        String riskassessid="";
        String cadre="";
        String uniqueid="";
        
           String query="select * from riskreductionmain";
          conn.rs2 = conn.state2.executeQuery(query);
          while(conn.rs2.next()){
          uniqueid=conn.rs2.getString("uniqueid");
          riskassessid=conn.rs2.getString("riskreductionid");
          DOA=conn.rs2.getString("DOA");
          cadre=conn.rs2.getString("cadreprovider");
         
          System.out.println(riskassessid);
          
String query2="REPLACE INTO riskreduction(Cadre,UniqueID,Date, CasualCdUse, CdProvided,  RegCdUse, RegCdAction,"
        + " WBLubricant, WBLubAction, AlDrugUseScore, AlDrugUseAction,HSFTKnowToday,HSFTKnowTodayAction,"
        + " HSFTAppointment, HSFTAppointmentAction, HIVTodayTest, HIVTodayTestAction, HIVTestPart, HIVTestPartAction,"
        + " STICheck, STICheckAction, STINextCheck, STINextCheckAction, CCScreening, CCScreeningAction,"
        + "CCAppointment, CCAppointmentAction, TBCheck, TBCheckAction, NextAppt, NextApptAction, GBVCheck, GBVCheckAction, "
        + "FPCurrentMethod, FPCurrMAction, FPMethod, FPMethodAction, FPMethodType, FPMethodTypeAction,NoMethod"
        + ", NoMethodAction, AltIncomeSource, AltIncomeSourceAction,DONA)"
  + "SELECT "
//        + "("+cadre+"),"
//        + "("+riskassessid+"),"
//        + "("+DOA+"),"
  + "(SELECT cadreprovider FROM riskreductiondetails,riskreductionmain WHERE  riskreductionmain.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT uniqueid FROM riskreductiondetails,riskreductionmain WHERE riskreductionmain.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT DOA FROM riskreductiondetails,riskreductionmain WHERE riskreductionmain.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'B1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'B1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'B2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'B2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'B3' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'B3' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'C' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'C' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'C' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'D1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'D1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'D2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Appointments FROM riskreductiondetails,riskreductionmain WHERE QID = 'D2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'E1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'E1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'E2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'E2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'F1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'F2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Appointments FROM riskreductiondetails,riskreductionmain WHERE QID = 'F2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'G1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'G1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Appointments FROM riskreductiondetails,riskreductionmain WHERE QID = 'G1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'G2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'H1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'H1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Appointments FROM riskreductiondetails,riskreductionmain WHERE QID = 'H1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'H2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'I' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'I' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'J1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'J1' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'J2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'J2' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'J3' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'J3' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'J4' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'J4' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'K' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT Action FROM riskreductiondetails,riskreductionmain WHERE QID = 'K' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1),"
  + "(SELECT currentStatus FROM riskreductiondetails,riskreductionmain WHERE QID = 'L' AND riskreductiondetails.RiskReductionID = '"+riskassessid+"' limit 1)"
   + "limit 1";
    conn.state3.executeUpdate(query2) ;  
    }
    }     

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
            Logger.getLogger(RRInser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
            Logger.getLogger(RRInser.class.getName()).log(Level.SEVERE, null, ex);
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
