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
public class query2 extends HttpServlet {

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
           int counts=0; 
            int counter=0;
            String query="SELECT COUNT(uniqueid)as no,RiskReductionMain.DOA,"
                    + " UNIQUEID FROM RiskReductionMain GROUP BY RiskReductionMain.UNIQUEID HAVING  no>'1'"
                    + " AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))" 
                    + " BETWEEN (STR_TO_DATE('01/01/2011','%e/%c/%Y')) "
                    + " AND (STR_TO_DATE('31/12/2013','%e/%c/%Y')) ";
            
            conn.rs = conn.state.executeQuery(query);
            while(conn.rs.next()){
            
            String query2="SELECT COUNT(uniqueid)as no,RiskReductionMain.DOA,"
                    + " UNIQUEID FROM RiskReductionMain  where"
                    + " (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))" 
                    + " BETWEEN (STR_TO_DATE('01/12/2013','%e/%c/%Y')) "
                    + " AND (STR_TO_DATE('31/12/2013','%e/%c/%Y')) and uniqueid='"+conn.rs.getString(3) +"'  ";
              conn.rs2= conn.state2.executeQuery(query2);
              while(conn.rs2.next()){
              System.out.println("kkk"+conn.rs2.getInt(1));
              counts+=conn.rs2.getInt(1);
              counter++;
              }
              
            
            }
          System.out.println("counts"+counts);  
          System.out.println("counter"+counter);  
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
            Logger.getLogger(query2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(query2.class.getName()).log(Level.SEVERE, null, ex);
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
