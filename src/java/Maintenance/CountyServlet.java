/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class CountyServlet extends HttpServlet {

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
    HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
           session=request.getSession(true);
   
       

                            dbConnect conn = new dbConnect();

                            
                            
                                    
                                    
                                    ArrayList list1 = new ArrayList();
                                    
                                    String query = "select DistrictID,District from districts";
                                    System.out.println("query " + query);
            try {
                conn.state = conn.connect.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(CountyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                                    conn.rs = conn.state.executeQuery(query);
    if(list1!=null && list1.size()>0 ){list1.clear();}

                                    while(conn.rs.next())
                                    {
                                            
                                     
                   CountyBean DB= new CountyBean();
                   DB.setID(conn.rs.getInt(1));
                   DB.setCOUNTY(conn.rs.getString(2));
                  
      
                   list1.add(DB);
                   System.out.println(DB.getID());  
                   System.out.println(DB.getCOUNTY());  
                  
    }

      
             
               session.setAttribute("list1", list1);
                             String nextJSP = "/Maintenance/AddDistricts.jsp";
                                    
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                                    dispatcher.forward(request,response);
                                    conn.connect.close();
                                    System.out.println("Disconnected from database");
        } catch (SQLException ex) {
            Logger.getLogger(CountyServlet.class.getName()).log(Level.SEVERE, null, ex);
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
