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
public class Search extends HttpServlet {

      HttpSession session;


      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          String msg;
          msg="";
     
       session = request.getSession(true);
        try {
            response.setContentType("text/html");
            

            dbConnect conn = new dbConnect();

String value= request.getParameter("value");
System.out.println("///////"+value);            


            String sqlquery="SELECT UniqueID,ClientInit,District,DICName,Sex FROM enrollment WHERE UniqueID LIKE '%"+value+"%'";
List userlist=new ArrayList();
int x=0;
x=0;
            conn.state = conn.connect.createStatement();
                                conn.rs = conn.state.executeQuery(sqlquery);
                                 List user=new ArrayList();
                                 if (conn.rs.next()==true) {
                                     x++;
                                              user.add(conn.rs.getString(1));
                                              user.add(conn.rs.getString(2));
                                              user.add(conn.rs.getString(3));
                                              user.add(conn.rs.getString(4));
                                              user.add(conn.rs.getString(5));
                                    userlist.add(user);
//                                    System.out.println(userlist);
	  
	  
		
  }
        
                                 if(x<1){
                               
                                 msg="User not in the System.";
                               
                                 session.setAttribute("msg", msg);
//                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index_1.jsp");
//                                dispatcher.forward(request, response);	 
	 
                                 
                                }
                                 else{ 
                                     msg="";
                                  session.setAttribute("msg",msg);
                                 
                                 }
                                   request.setAttribute("userlist",userlist);  
	  RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/index_1.jsp");
	  dispatcher1.forward(request, response);
          System.out.println(userlist.size());
                      System.out.println("msg  "+msg);      
		
                         if(conn.rs!=null){ conn.rs.close();}
         if(conn.rs1!=null){ conn.rs1.close();}
         if(conn.rs2!=null){ conn.rs2.close();}
         if(conn.rs3!=null){ conn.rs3.close();}
         if(conn.rs4!=null){ conn.rs4.close();}
         if(conn.rs5!=null){ conn.rs5.close();}
         if(conn.rs6!=null){ conn.rs6.close();}
         if(conn.rs7!=null){ conn.rs7.close();}
        
         if(conn.state!=null){ conn.state.close();}
         if(conn.state1!=null){ conn.state1.close();}
         if(conn.state2!=null){ conn.state2.close();}
         if(conn.state3!=null){ conn.state3.close();}
         if(conn.state4!=null){ conn.state4.close();}
         if(conn.state5!=null){ conn.state5.close();}
         if(conn.state6!=null){ conn.state6.close();}
         if(conn.state7!=null){ conn.state7.close();}
}
        catch (SQLException ex) {				  
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            out.println("user doesnt exist in the system");
         
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
            Logger.getLogger(EnrollServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EnrollServlet.class.getName()).log(Level.SEVERE, null, ex);
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
     

    
         