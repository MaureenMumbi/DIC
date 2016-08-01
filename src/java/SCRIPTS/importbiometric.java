/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCRIPTS;

import dbConnect.dbConnect;
import dbConnect.dbConnectLocal;
import dbConnect.dbConnectTemp;
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
public class importbiometric extends HttpServlet {

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
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            
            dbConnectTemp onlineconn = new dbConnectTemp();
            dbConnect localconn = new dbConnect();
            
            //here you want to pick data from existing biometrics data, and replace it with
            
            
            String fps="Select UniqueID,fingerprint from fingerprints";
            localconn.rs=localconn.state.executeQuery(fps);
            int a=0;
            while(localconn.rs.next()){
             a++;
              //now   update the equivalent in the db 
                
                String updateexisting="update enrollment set fingerprint='"+localconn.rs.getString(2)+"' where UniqueID='"+localconn.rs.getString(1)+"' and (fingerprint='' || fingerprint is null || fingerprint= 'null')";
                
                System.out.println(a+"__"+localconn.state1.executeUpdate(updateexisting));
                
            }
            
            
            try {
                /* TODO output your page here. You may use following sample code. */
                
                out.println("</html>");
            } finally {
                out.close();
            }
        }   catch (SQLException ex) {
            Logger.getLogger(importbiometric.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
