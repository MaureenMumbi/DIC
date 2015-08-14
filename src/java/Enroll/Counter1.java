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
public class Counter1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        doPost(request, response);
    }

   public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

 
            dbConnect conn = new dbConnect();
           HttpSession session= request.getSession(true);

String id = (String) session.getAttribute("UniqueID");      
                                 
           

// this code counts the number of occurences of a unique ID in the table risk reduction to enable us to know the number of times a client has been assessed.
            String sqlquery="SELECT UniqueID FROM riskreductionmain where UniqueID='"+ id+"'";
int count1=0;
            conn.state = conn.connect.createStatement();
                                conn.rs = conn.state.executeQuery(sqlquery);
                                
                                 while (conn.rs.next()) {
                                             conn.rs.getString("UniqueID");
                                             count1++;
                                 }
                                 
                                 
                                 System.out.println(count1);
                     
                        session.setAttribute("count1", count1);      
                                 
	  //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RiskReduction.jsp");
          response.sendRedirect("RiskReduction.jsp");
	  //dispatcher.forward(request, response);		
  
        		
                         if(conn.rs!=null){ conn.rs.close();}
      
         if(conn.state!=null){ conn.state.close();}
        
        
        
        }
        catch (SQLException ex) {
            Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
        }
}				  
   }
            