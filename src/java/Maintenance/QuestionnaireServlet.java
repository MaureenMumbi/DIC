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
public class QuestionnaireServlet extends HttpServlet {

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
              dbConnect conn = new dbConnect();
session = request.getSession(true);
                                
                                
                                        
                                        
                                        ArrayList questions = new ArrayList();
                                        
                                        String query = "select * from questions";
                                        System.out.println("query " + query);
                try {
                    conn.state = conn.connect.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(CountyServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                                        conn.rs = conn.state.executeQuery(query);
        if(questions!=null && questions.size()>0 ){questions.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                                         
                      QuestionnaireBean DB= new QuestionnaireBean();
                       DB.setID(conn.rs.getInt(1));
                       DB.setDOMAINID(conn.rs.getString(2));
                       DB.setSUBDOMAINID(conn.rs.getString(3));
                       DB.setQUESTION(conn.rs.getString(4));
                       DB.setTYPE(conn.rs.getString(5));
                       DB.setISCODED(conn.rs.getString(6));
                       DB.setDEPENDANT(conn.rs.getString(7));
                       DB.setDEPENDANTVALUE(conn.rs.getString(8));
                       DB.setDEPENDANTQUESTION(conn.rs.getString(9));
                    
                      
         
                       questions.add(DB);
          System.out.println("aaaaaa"+DB.getID());
          System.out.println("vhgh"+DB.getSUBDOMAINID());
          System.out.println("vnhggh"+DB.getQUESTION());
          System.out.println("bbbbbbb"+DB.getTYPE());
          System.out.println("bbbbbbb"+DB.getDEPENDANT());
          System.out.println("bbbbbbb"+DB.getDEPENDANTQUESTION());
          System.out.println("bbbbbbb"+DB.getDEPENDANTVALUE());
          System.out.println("bbbbbbb"+DB.getDOMAINID());
          System.out.println("bbbbbbb"+DB.getISCODED());
        
                       
                      
        }
       session.setAttribute("questions", questions);
                                 String nextJSP = "/Maintenance/createQuestionairre.jsp";
                                        
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                                        dispatcher.forward(request,response);
                                        conn.connect.close();
                                        System.out.println("Disconnected from database");
        } catch (SQLException ex) {
            Logger.getLogger(DICServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
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
