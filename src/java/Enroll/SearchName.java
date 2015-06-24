/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Enroll;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class SearchName extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     session = request.getSession(true);  
    

    String msg;
  
            

            dbConnect conn = new dbConnect();

String name= request.getParameter("name");
System.out.println("///////"+name);            


            String sqlquery="SELECT UniqueID,ClientInit,District,DICName,Sex FROM enrollment WHERE FirstName LIKE '%"+name+"%'";
List userlist=new ArrayList();
            conn.state = conn.connect.createStatement();
                                conn.rs = conn.state.executeQuery(sqlquery);
                                 List user=new ArrayList();
                                 while (conn.rs.next()) {
                                              user.add(conn.rs.getString(1));
                                              user.add(conn.rs.getString(2));
                                              user.add(conn.rs.getString(3));
                                              user.add(conn.rs.getString(4));
                                              user.add(conn.rs.getString(5));
                                    userlist.add(user);
                                    System.out.println(userlist);
	  
	  
	  request.setAttribute("userlist",userlist);  
	  RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/index_1.jsp");
	  dispatcher1.forward(request, response);		
  }
                                 if(userlist.size()<1){
                                 
                                 msg="User not in the System.";
                               
                                 session.setAttribute("msg", msg);
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index_1.jsp");
                                dispatcher.forward(request, response);	 
	 
                                 
                                }
                                 else{
                                  session.setAttribute("msg","");
                                 
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
            Logger.getLogger(SearchName.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchName.class.getName()).log(Level.SEVERE, null, ex);
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
