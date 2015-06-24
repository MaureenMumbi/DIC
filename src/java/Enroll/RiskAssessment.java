/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Enroll;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class RiskAssessment extends HttpServlet {
    
    
     

   public void processRequest(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
       
                                                      
response.setContentType("text/html");
PrintWriter out = response.getWriter();

dbConnect conn = new dbConnect();
 HttpSession session =request.getSession(true);
String UniqueID1 = (String)session.getAttribute("UniqueID");           
String ClientInit1 = (String)session.getAttribute("ClientInit");           
String District1 = (String)session.getAttribute("District");           
String Sex1 = (String)session.getAttribute("Sex");  
String DICName1 = (String)session.getAttribute("DICName");  


System.out.println( UniqueID1);
System.out.println( ClientInit1);
System.out.println( District1);
System.out.println( Sex1);
System.out.println( DICName1);

//String unique = request.getParameter("unique").toString();
String DOA = request.getParameter("DOA").toString();
//String District = request.getParameter("District1").toString();
//String DICName = request.getParameter("DICName").toString();
//String ClientInit = request.getParameter("ClientInit").toString();
//String UniqueID = request.getParameter("UniqueID").toString();
//String Sex = request.getParameter("Sex").toString();
String SexLast = request.getParameter("SexLast");
String CondomUse = request.getParameter("CondomUse");
String SexPartGender = request.getParameter("SexPartGender");
String ActiveSexWork = request.getParameter("ActiveSexWork");
String NoPayingClients = request.getParameter("NoPayingClients");

String RegPartner = request.getParameter("RegPartner");
String NoRegPartner = request.getParameter("NoRegPartner");
String TimeRegPartners = request.getParameter("TimeRegPartners");
String PracticeVaginal = request.getParameter("PracticeVaginal");
String PracticeOral = request.getParameter("PracticeOral");
String PracticeAnal = request.getParameter("PracticeAnal");
String CondomVaginal= request.getParameter("CondomVaginal");
String CondomOral= request.getParameter("CondomOral");
String CondomAnal= request.getParameter("CondomAnal");
String CondomProvider= request.getParameter("CondomProvider");
String HIVPartStatus= request.getParameter("HIVPartStatus");
String NoHIVPartStatus= request.getParameter("NoHIVPartStatus");
String PartCondomUse= request.getParameter("PartCondomUse");




String query = "INSERT INTO RiskAssessment(DOA,District,DICName,ClientInit,UniqueID,Sex,SexLast,CondomUse,SexPartGender,ActiveSexWork,"
+ "NoPayingClients,RegPartner,NoRegPartner,TimeRegPartner,PracticeVaginal,PracticeOral,PracticeAnal,CondomVaginal,CondomOral,CondomAnal,"
+ " CondomProvider,HIVPartStatus,NoHIVPartStatus,PartCondomUse)"
+ " VALUES ('"+DOA+"','"+District1+"','"+DICName1+"','"+ClientInit1+"','"+UniqueID1+"','"+Sex1+"','"+SexLast+"','"+CondomUse+"',"
        + "'"+SexPartGender+"',"
+ "'"+ActiveSexWork+"','"+NoPayingClients+"','"+RegPartner+"','"+NoRegPartner+"','"+TimeRegPartners+"','"+PracticeVaginal+"',"
        + "'"+PracticeOral+"','"+PracticeAnal+"','"+CondomVaginal+"','"+CondomOral+"','"+CondomAnal+"',"
+ "'"+CondomProvider+"','"+HIVPartStatus+"','"+NoHIVPartStatus+"','"+PartCondomUse+"')";
                try {
                    conn.state.executeUpdate(query);
                    out.println("Inserted into db");
                   response.sendRedirect("../DIC/RiskAssessment2.jsp");
                } catch (SQLException ex) {
                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
                    out.println(ex);
                }



}
                                           
   
                                
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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