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
            throws ServletException, IOException {
             session=request.getSession();
      String msg=""; 
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        /**  Get the last backed up timestamp   */
        int days=0;
          int noofassess=0; 
          int noofenrollments=0; 
     
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
            
            System.out.println(noofassess+" bbb  "+noofenrollments);
              if((noofassess>=5)||(noofenrollments>=5)){
                    //msg="<font color='green'><h3>Note: </font> <font color='orange'>You have not backed your data for <b>"+days+"</b> days.</font><br/> <font color='green'>Kindly Log into the system,<br/> On the systems menu,point <br/> >> Data........................... <br/> >>Send Backup to M&E Officer <br/>>> Send Backup.................. </h3></font>";
                     
                 msg="<div><h3>Note: You have not connected your computer to the internet for data syncing to occur <br/> Kindly connect to the internet and Log into the system for data syncing to occur</h3><h4> Click here to close the alert</h4></div> ";
                  // msg="<h3>Note: You have not backed your data for <b>"+days+"</b> days.<br/> <font color='green'>Kindly Log into the system,<br/> On the systems menu,point <br/> >> Data........................... <br/> >>Send Backup to M&E Officer <br/>>> Send Backup.................. </font></h3>";
                //    msg="not backed up";
                   System.out.println(msg);  
            
            }
                
            } catch (SQLException ex) {
                Logger.getLogger(checkbackup.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       session.setAttribute("backupsms",msg);   
       
       out.println(msg);
      if(msg.equals("")){
              
       session.setAttribute("backupsms",null);   
      
      }      
            
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
        processRequest(request, response);
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
