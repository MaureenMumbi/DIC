/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */

public class RegisterUser extends HttpServlet {
MessageDigest m;
HttpSession session;
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
       
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();



         
          
                                   dbConnect conn = new dbConnect();


            String Name = request.getParameter("Name").toString();
            String Username = request.getParameter("Username").toString();
            String Password = request.getParameter("Password").toString();
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
                            m.update(Password.getBytes(), 0, Password.length());
                            String pw = new BigInteger(1, m.digest()).toString(16);
            
           
            session = request.getSession();
            
            String PhoneNo = request.getParameter("PhoneNo").toString();
            String Email = request.getParameter("Email").toString();
            String Location = request.getParameter("Location").toString();
            String AccessLevel = request.getParameter("AccessLevel").toString();
            
            
             Date timestamp= new Date();

           
String query = "INSERT INTO user(Name,Username,Password,PhoneNo,Email,Location,AccessLevel,syncstatus)"
+ " VALUES ('"+Name+"','"+Username+"','"+pw+"','"+PhoneNo+"','"+Email+"','"+Location+"','"+AccessLevel+"','0')";		
        try {    
           
            conn.state.executeUpdate(query);
            session.setAttribute("clerk_added", "<font color=\"green\">Clerk added succesfully</font>");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("clerk_added1", "<font color=\"green\">Clerk Not Added </font>");
        }
           
        
        
         
              out.println("Inserted into db");
            response.sendRedirect("RegisterUser.jsp");
        
                       
    }
}

                               

 
    
    
    
    
    
    
    
    
    
    
    
    
    