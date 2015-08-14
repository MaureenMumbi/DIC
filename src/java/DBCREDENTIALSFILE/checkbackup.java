/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCREDENTIALSFILE;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.Format;
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
 * @author MANUEL
 */
public class checkbackup extends HttpServlet {

    HttpSession session=null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
             session=request.getSession();
      String msg=""; 
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        /**  Get the last backed up timestamp   */
        int days=0;
          int noofassess=0; 
          int noofenrollments=0; 
     int maxdays=0;
     int remainingdays=0;
        String message="";
     maxdays=3;
     
         String getbackup=" select count(uniqueid) from enrollment where syncstatus='0'";  
            
         dbConnect conn= new dbConnect();   
            try {
            
                conn.rs= conn.state.executeQuery(getbackup);
                if(conn.rs.next()==true){
                noofenrollments=conn.rs.getInt(1);
                 
                } 
               
                
                String is20recordsunsaved="SELECT COUNT(UniqueID) FROM riskassessmentmain WHERE syncstatus='0' ";  
            
            System.out.println(is20recordsunsaved);
            
            conn.rs1=conn.state1.executeQuery(is20recordsunsaved);
            
            if(conn.rs1.next()){
            
            //count the number of records reached 
                 noofassess=conn.rs1.getInt(1);
               
                
                }
            int maxID=0;
                String getMaxId="SELECT MAX(id) FROM lastconnection"; 
       conn.rs=conn.state.executeQuery(getMaxId);
       if(conn.rs.next()==true){
         maxID=conn.rs.getInt(1);
       }
       String getMaxDate="SELECT DATEDIFF(NOW(),lastconnectiondate) FROM lastconnection WHERE ID = '"+maxID+"'";
       conn.rs=conn.state.executeQuery(getMaxDate);
       if(conn.rs.next()==true){
      days=conn.rs.getInt(1);
    
      
       }
    System.out.println("days  "+days +" "+maxdays);
//     saveLastInternectConn checkinternet = new saveLastInternectConn();
          if (saveLastInternectConn.checkinternet("google.com") || saveLastInternectConn.checkinternet("twitter.com") || saveLastInternectConn.checkinternet("amazon.com")) {
          System.out.println("There is internet");
         }
          int daysafterlock=0;
      if(days>maxdays){
//       if(days>maxdays  ){
       // lock system
             daysafterlock=days-maxdays;
          if( (noofassess>=5)||(noofenrollments>=5)){
            msg="<div><h3>Note: Kindly connect to the internet for system to unlock. Your system was locked "+daysafterlock+" days ago</h3><h4> Click here to close the alert</h4></div> ";
              message="Lock" ; 
            session.setAttribute("backupsms",msg); }    
       } else if(days<maxdays){
           remainingdays=maxdays-days;
       System.out.println("nnn"+days);
            System.out.println(noofassess+" bbb  "+noofenrollments);
              if((noofassess>=5)||(noofenrollments>=5)){
//                    msg="<font color='green'><h3>Note: </font> <font color='orange'>You have not backed your data for <b>"+days+"</b> days.</font><br/> <font color='green'>Kindly Log into the system,<br/> On the systems menu,point <br/> >> Data........................... <br/> >>Send Backup to M&E Officer <br/>>> Send Backup.................. </h3></font>";
                     
                 msg="<h3>Note: You have not connected your computer to the internet for data syncing to occur <br/> Kindly connect to the internet and Log into the system for data syncing to occur.<br/>You have "+remainingdays+" days remaining before system locks.</h3><h4> Click here to close the alert</h4>";
                  // msg="<h3>Note: You have not backed your data for <b>"+days+"</b> days.<br/> <font color='green'>Kindly Log into the system,<br/> On the systems menu,point <br/> >> Data........................... <br/> >>Send Backup to M&E Officer <br/>>> Send Backup.................. </font></h3>";
                //    msg="not backed up";
                   System.out.println(msg); 
                      session.setAttribute("backupsms",msg);   
              
            }
        message="Unlock" ; 
       }
             out.println(message);     
            } catch (SQLException ex) {
                Logger.getLogger(checkbackup.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    
       
     
      if(msg.equals("")){
              
       session.setAttribute("backupsms",null);   
      
      }      
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
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
            Logger.getLogger(checkbackup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
            Logger.getLogger(checkbackup.class.getName()).log(Level.SEVERE, null, ex);
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
