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
public class rrainsert extends HttpServlet {

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
        try {
            dbConnect conn = new dbConnect();
            String uniqueid="";
            String riskassessid="";
            String uniqueid1="";
            String riskassessid1="";
            String dicname="";
            String district="";
            String dates="";
            
            /* TODO output your page here. You may use following sample code. */
            String query1="select * from riskassessmentmain";
          conn.rs5 = conn.state5.executeQuery(query1);
          while(conn.rs5.next()){
          uniqueid=conn.rs5.getString("UniqueID");
          riskassessid=conn.rs5.getString("AssessmentID");
          dates=conn.rs5.getString("AssessmentDate");
            
          
          String select="select * from  riskassessments where UniqueIDs LIKE '"+uniqueid+"' and DOA  LIKE '"+dates+"' and RiskAssessID='"+riskassessid+"' ";
         System.out.println(uniqueid+"___"+riskassessid+"___"+dates);
          conn.rs4 = conn.state4.executeQuery(select);
          
          System.out.println(select);
          if(conn.rs4.next()==true){ 
 
  System.out.println("Data converted already added");

 }
          else {
  
          System.out.println("Time to insert");
          
          String query2="REPLACE INTO riskassessments( DOA,RiskAssessID, UniqueIDs,districts,dicnames ,SexLast, CondomUse, SexPartGender, Lasttime, NoPayingClients, RegPartner, NoRegPartner, TimeRegPartner, PracticeVaginal, PracticeOral, "
                  + "PracticeAnal, CondomVaginal, CondomOral, CondomAnal, CondomProvider, HIVPartStatus, NoHIVPartStatus,"
                  + " PartCondomUse, Dgenitals, PUrine, PSex, SGenitals, GSores, DiscolorUrine, AbdominalPain, STISeekTreat, STIPlaceTreated, LubricantUse, KYJelly, Saliva, "
                  + "OtherLubricants, LubUseAnal, LubUseVaginal, AlcoholUse, AlcoholFrequency, DrugUse, DrugType, DrugFrequency, VaginalDouche, AfterSexDouche, BathDouche, CdBurstDouche, OtherDouche, Hit"
                  + ", LasttimeHit, raped, LasttimeRaped, economiccsupport, LastEconomic, Verbal, LastVerbal, FPnotUse,"
                  + " FPnotUseLast, SeekTreatment, PlaceTreated,ReportPolice,ReportWhere, Pregnant, HaveKids, UseFP,FPMethodUsed)"
                  + "SELECT"
  + "(select AssessmentDate from  riskassessmentmain where riskassessmentmain.AssessmentID='"+riskassessid+"'),"
  + "(SELECT AssessmentID FROM riskassessmentdetails WHERE riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT riskassessmentmain.UniqueID FROM riskassessmentmain,Riskassessmentdetails WHERE  riskassessmentmain.AssessmentID='"+riskassessid+"' limit 1),"
 + "(select District from enrollment where Uniqueid='"+uniqueid+"'),"
    + "(select dicname from enrollment where Uniqueid='"+uniqueid+"'),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'A' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'B' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'C' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'D' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'E' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'F' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"'limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'G' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'H' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'I1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'I2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'I3' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'J1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'J2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'J' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
 
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'K' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'L1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'L2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'L3' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"

  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'M1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'M2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'M3' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'M4' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'M5' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'M6' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'M7' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
   + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'N1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'N2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'O1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'O2A' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'O2B' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'O2C' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'O3A' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'O3B' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  
  
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'Q1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'Q2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
 
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'R1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'R2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'R3' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'S1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'SbA' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'SbB' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'SbC' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'SbD' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T3' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T4' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T5' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T6' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T7' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T8' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T9' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'T10' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1 ),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'U1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'U2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'V1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'V2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'P1' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'P2' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'P3' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1),"
  + "(SELECT  DirectAnswers FROM riskassessmentdetails,riskassessmentmain WHERE QuestionID = 'P4' AND Riskassessmentdetails.AssessmentID = '"+riskassessid+"' limit 1)"

                  + "limit 1";
          
          conn.state.executeUpdate(query2);
          System.out.println(query2);
          } }
        } catch(SQLException EX) {  
            System.out.println(EX.toString());
            out.close();
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
            Logger.getLogger(Inserts.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Inserts.class.getName()).log(Level.SEVERE, null, ex);
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
