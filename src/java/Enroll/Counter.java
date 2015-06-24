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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class Counter extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
             dbConnect conn = new dbConnect();
           HttpSession session= request.getSession(true);

String id = (String) session.getAttribute("UniqueID");      
     System.out.println("bhfasghcdfashjcvhjzxvcbnzxvcbnsz"+id);      


            String sqlquery="SELECT UniqueID FROM riskassessmentmain where UniqueID='"+ id+"'";
            System.out.println("bhfasghcdfashjcvhjzxvcbnzxvcbnsz"+sqlquery);
int count=0;
            
                                conn.rs = conn.state.executeQuery(sqlquery);
                                
                                 while (conn.rs.next()) {
                                             conn.rs.getString("UniqueID");
                                             count++;
                                 }
                                 
                                 
                                 System.out.println(count);
                     
                        session.setAttribute("count", count);      
              response.sendRedirect("RiskAssessment.jsp");                   
//	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RiskAssessment.jsp");
//	  dispatcher.forward(request, response);		
  }
        catch (SQLException ex) {
            Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
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
