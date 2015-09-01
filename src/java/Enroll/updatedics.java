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

/**
 *
 * @author Maureen
 */
public class updatedics extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String uniqueid="";
            String DICName1="";
            String County1="";
            String  RID="";
            String  AID="";
            String  MID="";
           dbConnect conn= new dbConnect();
           String getdic="select * from enrollment";
           conn.rs = conn.state.executeQuery(getdic);
           while(conn.rs.next()){
           uniqueid=conn.rs.getString("UniqueID");
               DICName1=conn.rs.getString("DICName");
               County1=conn.rs.getString("district");
               
               String select ="select * from riskreductionmain where UniqueID='"+uniqueid+"' ";
               conn.rs3= conn.state4.executeQuery(select);
               while(conn.rs3.next()){
                   RID=conn.rs3.getString("ID");
                   System.out.println(RID);
               try{String updateriskreductionmain="Update riskreductionmain set County1='"+County1+"',DICName1='"+DICName1+"' where UniqueID='"+uniqueid+"' and ID='"+RID+"'";
               conn.state1.executeUpdate(updateriskreductionmain);
               System.out.println(updateriskreductionmain);}
               catch(SQLException ex) {  
                Logger.getLogger(updatedics.class.getName()).log(Level.SEVERE, null, ex);
               }
               }
               String select1 ="select * from riskassessmentmain  where UniqueID='"+uniqueid+"' ";
               conn.rs5= conn.state5.executeQuery(select1);
               while(conn.rs5.next()){
                     AID=conn.rs5.getString("ID");
               String updateriskassessmentmain="Update riskassessmentmain set County1='"+County1+"' , DICName1='"+DICName1+"' where UniqueID='"+uniqueid+"' AND ID='"+AID+"'";
                        System.out.println(updateriskassessmentmain);
               conn.state2.executeUpdate(updateriskassessmentmain);
                System.out.println(updateriskassessmentmain);
               }
                String select2 ="select * from medical_form  where unique_identifier='"+uniqueid+"' ";
               conn.rs6= conn.state6.executeQuery(select2);
               while(conn.rs6.next()){
                    MID=conn.rs6.getString("id");
               String updatemedical_form="Update medical_form set county1='"+County1+"' , DICName1='"+DICName1+"' where unique_identifier='"+uniqueid+"' AND ID='"+MID+"'";
                conn.state3.executeUpdate(updatemedical_form);
               System.out.println(updatemedical_form);
           }
        }
        }catch(SQLException ex) {            
           out.println(ex.toString());
           System.out.println(ex);
            Logger.getLogger(updatedics.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(updatedics.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(updatedics.class.getName()).log(Level.SEVERE, null, ex);
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
