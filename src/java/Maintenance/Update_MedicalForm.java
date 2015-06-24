/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

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
 * @author Hare Cheka Arnold
 */
public class Update_MedicalForm extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        dbConnect conn=new dbConnect();
       // Getting values from the form
        String  medical_identifier=request.getParameter("medical_identifier");
      String  unique_identifier=request.getParameter("unique_identifier");
       String temperature=request.getParameter("temperature");
       String temperature_complain=request.getParameter("temperature_complain");
       String blood_pressure=request.getParameter("blood_pressure");
       String blood_pressure_complain=request.getParameter("blood_pressure_complain");
       String p=request.getParameter("p");
       String p_complain=request.getParameter("p_complain");
      String  weight=request.getParameter("weight"); 
       String weight_complain=request.getParameter("weight_complain");
       String ga=request.getParameter("ga");
       String ga_findings=request.getParameter("ga_findings");
       String skin=request.getParameter("skin");
       String skin_findings=request.getParameter("skin_findings");
       String ent=request.getParameter("ent");        
       String ent_findings=request.getParameter("ent_findings");        
       String eyes=request.getParameter("eyes");        
       String eyes_findings=request.getParameter("eyes_findings");
       String abdomen=request.getParameter("abdomen");        
       String abdomen_findings=request.getParameter("abdomen_findings");
       String genitourinary=request.getParameter("genitourinary");
      String  genitourinary_findings=request.getParameter("genitourinary_findings");
      String  musculoskeletal=request.getParameter("musculoskeletal");        
      String  musculoskeletal_findings=request.getParameter("musculoskeletal_findings");
      String  respiratory=request.getParameter("respiratory");        
      String  respiratory_findings=request.getParameter("respiratory_findings");
      String  psychological=request.getParameter("psychological");        
      String  psychological_findings=request.getParameter("psychological_findings");
      String  diagnosis=request.getParameter("diagnosis");
      String  management=request.getParameter("management");
      String  referral=request.getParameter("referral");
      String  specify_others=request.getParameter("specify_others");
      String  TCA=request.getParameter("TCA");
       String cadre=request.getParameter("cadre");        
       String dater=request.getParameter("dater");        
      String  signature=request.getParameter("signature");
      
      
     
        
       // Updating the database on the Medical Table:

      int returnedint=generateRandom(cadre);
      
      System.out.println("Returned Interger"+returnedint);
        
       
        String medical_form_adder="UPDATE medical_form SET temperature='"+temperature+"',"
                + "temperature_complain='"+temperature_complain+"',blood_pressure='"+blood_pressure+"',blood_pressure_complain='"+blood_pressure_complain+"',"
                + "p='"+p+"',p_complain='"+p_complain+"',weight='"+weight+"',weight_complain='"+weight_complain+"',ga='"+ga+"',"
                + "ga_findings='"+ga_findings+"',skin='"+skin+"',skin_findings='"+skin_findings+"',ent='"+ent+"',ent_findings='"+ent_findings+"',"
                + "eyes='"+eyes+"',eyes_findings='"+eyes_findings+"',abdomen='"+abdomen+"',abdomen_findings='"+abdomen_findings+"',"
                + "genitourinary='"+genitourinary+"',genitourinary_findings='"+genitourinary_findings+"',musculoskeletal='"+musculoskeletal+"',"
                + "musculoskeletal_findings='"+musculoskeletal_findings+"',respiratory='"+respiratory+"',respiratory_findings='"+respiratory_findings+"',"
                + "psychological='"+psychological+"',psychological_findings='"+psychological_findings+"',diagnosis='"+diagnosis+"',"
                + "management='"+management+"',referral='"+referral+"',specify_others='"+specify_others+"',TCA='"+TCA+"',"
                + "cadre='"+returnedint+"',dater='"+dater+"',signature='"+signature+"' WHERE id='"+medical_identifier+"' && unique_identifier='"+unique_identifier+"'";
 System.out.println(medical_form_adder);
       conn.state.executeUpdate(medical_form_adder);
        
     
 // session.setAttribute("session_fail", "<font color=\"green\">Medical form Updated successfully.</font>");   
 System.out.println("Updated successfully");      
  
    
 response.sendRedirect("admin/index_Medical.jsp");   
    
    
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
            Logger.getLogger(Update_MedicalForm.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Update_MedicalForm.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
       public int generateRandom(String cadre){
          dbConnect conn=new dbConnect();
       String random = "select * from cadrecode where CadreCode ='"+cadre+"'";
       System.out.println(random);
       int cadre_id=0;
       
       try {
       conn.rs=conn.state.executeQuery(random);
       
       if(conn.rs.next())
				{
            cadre_id = Integer.parseInt(conn.rs.getString(1));
            
            System.out.println(random);
       }
       
             }
       catch(SQLException ex) {
           
           System.out.println(ex);
       }
       return cadre_id;
             }
    
}
