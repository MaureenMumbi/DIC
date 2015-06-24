/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import Enroll.Enroll;
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
public class check_date_insert_quarter extends HttpServlet {

    HttpSession session;
    int quarter = 0;
    String month, insert_month;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        dbConnect conn = new dbConnect();
        
        //Goes to RiskAssessmentMain to check date
        String check_date = "SELECT * FROM riskreductionmain";
        conn.rs1=conn.state.executeQuery(check_date);
        while(conn.rs1.next()){
        month = conn.rs1.getString(3);
        System.out.println("picked date    :   "+month);
        String assessment_id = conn.rs1.getString(2);
        String mnth[]=month.split("/");
        String retval=mnth[1];
        String retval1=mnth[2];

         System.out.println("Month is    "+retval);
         //Comparing the monthly dates
         if (retval.equals("10") || retval.equals("11") || retval.equals("12")){
             insert_month = "Q1";
         }
         if (retval.equals("01") || retval.equals("02") || retval.equals("03")){
             insert_month = "Q2";
         }
         if (retval.equals("04") || retval.equals("05") || retval.equals("06")){
             insert_month = "Q3";
         }
         if (retval.equals("07") || retval.equals("08") || retval.equals("09")){
             insert_month = "Q4";
         }
         String insert_quarter = "UPDATE riskreductionmain SET qtr ='"+insert_month+"',year='"+retval1+"' WHERE RiskReductionID ='"+assessment_id+"' ";
         
         conn.state2.executeUpdate(insert_quarter);
         System.out.println("assesmnent id is    :" +assessment_id);
         System.out.println("inserted quarter:" +insert_month);
        


        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet responseer
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(check_date_insert_quarter.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(check_date_insert_quarter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

