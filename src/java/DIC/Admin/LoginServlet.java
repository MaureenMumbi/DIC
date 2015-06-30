/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class LoginServlet extends HttpServlet {
MessageDigest m;
String computername;
  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        
            doGet(request, response);
            
    
        }
    
    @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                String userName = request.getParameter("Username");
                String Password = request.getParameter("Password");
                Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String formattedDate = formatter.format(date);
                  dbConnect conn=new dbConnect();
        try {
            //decrypt password
       
           m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                m.update(Password.getBytes(), 0, Password.length());
                String userPass = new BigInteger(1, m.digest()).toString(16);
               
                
//____________________GET COMPUTER NAME____________________________________
computername=InetAddress.getLocalHost().getHostName();
System.out.println("Computer name "+computername);
                
       
            
               
                try {
                        String queryString = "SELECT Username,Password,AccessLevel,Location FROM user WHERE password=?";
                      
                        conn.ps = conn.connect.prepareStatement(queryString);
                        conn.ps.setString(1, userPass);
                        conn.rs = conn.ps.executeQuery();
                        HttpSession session =request.getSession(true);
                        // verifying user credentials before creating Servlet Context object

                            while(conn.rs.next()==true){
                                 session.setAttribute("Location",conn.rs.getString(4));
                                 System.out.println("location "+conn.rs.getString(4));
                                    if (userName.equalsIgnoreCase(conn.rs.getString("Username"))) {
                                        if(conn.rs.getString("AccessLevel").equalsIgnoreCase("1")){
                                            session= request.getSession(true);
                                            session.setAttribute("Username", conn.rs.getString("Username"));
                                          
                                            session.setAttribute("AccessLevel", conn.rs.getString("AccessLevel"));
                                            ServletContext context = getServletContext();
                                           response.sendRedirect("Enrollment.jsp");
                                            session.setAttribute("loggedIn", "log");
                                            request.removeAttribute("loginError");
                                            String ip=InetAddress.getLocalHost().getHostAddress(); 
String inserter="insert into taskauditor set host_comp='"+computername+" "+ip+"' , action='Logged in ',time='"+formattedDate+"',username='"+conn.rs.getString("Username")+"'";                     
             conn.state.executeUpdate(inserter);  
                                           
                                        }
                                        else{    
                                            session = request.getSession(true);
                                            session.setAttribute("Username", conn.rs.getString("Username"));
                                            session.setAttribute("AccessLevel", conn.rs.getString("AccessLevel"));
                                            session.setAttribute("loggedIn", "log");
                                            request.removeAttribute("loginError");
                                            ServletContext context = getServletContext();
                                           response.sendRedirect("admin/index_admin.jsp");
                                            
                                        }
//                                        conn.rs.close();
                                             
       String AccessLevel="",user="";        
               
        		
	if(session.getAttribute("AccessLevel")!=null){		
       AccessLevel=session.getAttribute("AccessLevel").toString();
        }
        else{
        AccessLevel="0";   
        }
        String checkHost="select user()";
       conn.rs=conn.state.executeQuery(checkHost);
       if(conn.rs.next()==true){
//            System.out.println("host name is : "+conn.rs.getString(1));
        user=conn.rs.getString(1);
       }
       
       if(!AccessLevel.equals("2")  && !user.startsWith("root@")){
        session.setAttribute("lockNames", "YES");
       }
       else{
       session.setAttribute("lockNames", "NO");     
       }
       session.setAttribute("lockNames", "YES");
           System.out.println("to lock : "+session.getAttribute("lockNames").toString());          
                
               
                                    }


                                        if(!(userName.equalsIgnoreCase(conn.rs.getString("Username")))){
                                                request.setAttribute("loginError", "OOps!!! Invalid Username");    
                                                ServletContext context = getServletContext();
                                                response.sendRedirect("index.jsp");
                                                session.setAttribute("login", "OOps!!! Invalid Username");
                                               
                                            }


                                       
                                          
                                    }    
                            
                            if(conn.rs.next()==false){
                                            request.setAttribute("loginError", "OOps!!! Invalid Password");    
                                            ServletContext context = getServletContext();
                                            response.sendRedirect("index.jsp");
                                            
                                            session.setAttribute("login", "OOps!!! Invalid Password");
                                           
                            }                
 } catch (Exception e) {
                        
                        out.println(e.getMessage());
                }

        }


}