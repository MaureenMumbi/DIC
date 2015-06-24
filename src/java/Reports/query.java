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
public class query extends HttpServlet {

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
            
            int totalpple=0;
          dbConnect conn = new dbConnect();
          int count=0;
          
          String query ="SELECT COUNT(uniqueid)as no,RiskReductionMain.DOA, UNIQUEID FROM RiskReductionMain "
                  + "GROUP BY RiskReductionMain.UNIQUEID HAVING  no> '1' AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))" 
                    + " BETWEEN (STR_TO_DATE('01/01/2011','%e/%c/%Y')) "
                    + " AND (STR_TO_DATE('31/05/2014','%e/%c/%Y'))"
                  + "";
          conn.rs= conn.state.executeQuery(query);
          while(conn.rs.next()){
//              System.out.println(conn.rs.getString(1));
//              System.out.println(conn.rs.getString(2));
//              System.out.println(conn.rs.getString(3));
              
              String query1="SELECT count(riskreductions3.UniqueIDs1), HIVTodayTestStatus FROM RiskReductionMain, riskreductions3"  
                      + "  where"
                      + " riskreductions3.UniqueIDs1 =RiskReductionMain.UniqueID "
                      + "and HIVTodayTestStatus = 'N' AND riskreductions3.UniqueIDs1='"+conn.rs.getString(3)+"'"
                      + " AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"
                  + " BETWEEN (STR_TO_DATE('01/05/2014','%e/%c/%Y')) "
                  + "AND (STR_TO_DATE('31/05/2014','%e/%c/%Y')) " ;
               conn.rs2= conn.state2.executeQuery(query1);
               if(conn.rs2.next()){
                   count++;
                   totalpple+=conn.rs2.getInt(1);
               System.out.println("aaaa"+conn.rs2.getInt(1));
               System.out.println("aaaa"+conn.rs2.getString(2));
               }
          }
          System.out.println("***"+count);
          System.out.println("!!!"+totalpple);
        } finally {            
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
            Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
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
