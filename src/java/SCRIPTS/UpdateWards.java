/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCRIPTS;

import DIC.Admin.LoginServlet;
import Enroll.updatedics;
import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emmanuel E
 */
public class UpdateWards extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        dbConnect conn=new dbConnect();
                  
                         //update the necessary codes before progressing to the next page
                            updatetable(conn);
        
                            
                          		
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
                  
                            
        try {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("Wards Update Completed");
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
            Logger.getLogger(UpdateWards.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateWards.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
    
        public void updatetable( dbConnect conn){
      
    try {
        String checkiftableexists="SHOW Columns from riskassessmentmain like 'ward1'";
        
        conn.rs=conn.state.executeQuery(checkiftableexists);
        //if column doesnt exist, then add  the wardq column into the table
        if(conn.rs.next())
        { System.out.println("Table exists");}
        else
        {
        
    conn.state1.executeUpdate("ALTER TABLE `riskassessmentmain` ADD COLUMN `ward1` VARCHAR(200) NULL AFTER `DICName1`");
    conn.state1.executeUpdate("ALTER TABLE `riskreductionmain` ADD COLUMN `ward1` VARCHAR(200) NULL AFTER `DICName1`");
    conn.state1.executeUpdate("ALTER TABLE `medical_form` ADD COLUMN `ward1` VARCHAR(200) NULL AFTER `DICName1`");
      //after this, call a method to update all the wards
    updatewards(conn);
    
            
        }
        
        
        
        
        
        //check if acccess trail table exists
        
        String checkifaccesstrailtableexists="SHOW TABLES LIKE 'access_trail'";
        
        conn.rs=conn.state.executeQuery(checkiftableexists);
        //if column doesnt exist, then add  the wardq column into the table
        if(conn.rs.next())
        { System.out.println("access trail tableTable exists");}
        else {
        //import access trail
       String importcode="CREATE TABLE `access_trail` (`id` varchar(50) NOT NULL,`username` varchar(50) DEFAULT NULL, `task` varchar(2000) DEFAULT NULL, `hostcomp` varchar(100) DEFAULT NULL, `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1";     
      
       conn.state.executeUpdate(importcode);
       
        }
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        }
        
        
        
          public void updatewards( dbConnect conn){
          
              
    try {
        String ward="";
        String uniqueid="";
        String DICName1="";
        String County1="";
        String getdic="select UniqueID,District,DICName,ward from enrollment";
        conn.rs = conn.state.executeQuery(getdic);
        while(conn.rs.next()){
            uniqueid=conn.rs.getString("UniqueID");
            DICName1=conn.rs.getString("DICName");
            County1=conn.rs.getString("district");
             ward=conn.rs.getString("ward");
             System.out.println("ward is :::"+ward);
            String RID="";
            String select ="select ID from riskreductionmain where UniqueID='"+uniqueid+"' and (ward1 is null || ward1='')";
            conn.rs3= conn.state4.executeQuery(select);
            while(conn.rs3.next()){
                RID=conn.rs3.getString("ID");
                System.out.println(RID);
                try{String updateriskreductionmain="Update riskreductionmain set County1='"+County1+"',DICName1='"+DICName1+"',ward1='"+ward+"' where UniqueID='"+uniqueid+"' and ID='"+RID+"'";
                conn.state1.executeUpdate(updateriskreductionmain);
                System.out.println(updateriskreductionmain);}
                catch(SQLException ex) {
                    Logger.getLogger(updatedics.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String AID="";
            String select1 ="select ID from riskassessmentmain  where UniqueID='"+uniqueid+"' and ward1 is null ";
            conn.rs5= conn.state5.executeQuery(select1);
            while(conn.rs5.next()){
                AID=conn.rs5.getString("ID");
                String updateriskassessmentmain="Update riskassessmentmain set County1='"+County1+"' , DICName1='"+DICName1+"' , ward1='"+ward+"' where UniqueID='"+uniqueid+"' AND ID='"+AID+"'";
                System.out.println(updateriskassessmentmain);
                conn.state2.executeUpdate(updateriskassessmentmain);
                System.out.println(updateriskassessmentmain);
            }
            String MID="";
            String select2 ="select id from medical_form  where unique_identifier='"+uniqueid+"' and DICName1 is null";
            conn.rs6= conn.state6.executeQuery(select2);
            while(conn.rs6.next()){
                MID=conn.rs6.getString("id");
                String updatemedical_form="Update medical_form set county1='"+County1+"' , DICName1='"+DICName1+"' , ward1='"+ward+"' where unique_identifier='"+uniqueid+"' AND ID='"+MID+"'";
                conn.state3.executeUpdate(updatemedical_form);
                System.out.println(updatemedical_form);
            }
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
          
          
          
          }
    
    
    
    

}
