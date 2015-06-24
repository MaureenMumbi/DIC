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

    String msg;
     public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        doPost(request, response);
    }

   public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
       PrintWriter out = response.getWriter();
       session = request.getSession(true);
        try {
            response.setContentType("text/html");
            

            dbConnect conn = new dbConnect();

String value= request.getParameter("value");
System.out.println("///////"+value);            


            String sqlquery="SELECT UniqueID,ClientInit,District,DICName,Sex FROM enrollment WHERE UniqueID LIKE '%"+value+"%'";
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
        catch (SQLException ex) {				  
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            out.println("user doesnt exist in the system");
         
        }				  
   }}
                

    
         