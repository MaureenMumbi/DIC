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
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 * @author Geofrey Nyabuto
 */
public class update_lockDate extends HttpServlet {
HttpSession session;
String currentDate,maxDate;
int maxID,months,date;
String status,newLockDate,newMinDate;
Date lock_date,minDate;
int addMonths,lockStatus;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        session=request.getSession();
        dbConnect conn = new dbConnect();
        IdGenerator IG = new IdGenerator();
        
        addMonths=lockStatus=0;
       String getMaxId="SELECT MAX(id) FROM lock_data"; 
       conn.rs=conn.state.executeQuery(getMaxId);
       if(conn.rs.next()==true){
         maxID=conn.rs.getInt(1);
       }
       String getMaxDate="SELECT period_diff(date_format(now(), '%Y%m'), date_format(STR_TO_DATE(lock_date,'%m/%d/%Y'), '%Y%m')) as Months,STR_TO_DATE(lock_date,'%m/%d/%Y'),STR_TO_DATE(min_date,'%m/%d/%Y') FROM lock_data WHERE id = '"+maxID+"'";
       conn.rs=conn.state.executeQuery(getMaxDate);
       if(conn.rs.next()==true){
      months=conn.rs.getInt(1);
      lock_date=conn.rs.getDate(2);
      minDate=conn.rs.getDate(3);
      System.out.println(" date is :  "+lock_date+" months : "+months);
      
       }
      
       if(months>=1){
//         Check todays date if it is 5th or more
      date=IG.date;
      
      if(months==1){
      if(date>=10){
//      lock data called    
      lockStatus++;    
          
      }
      else{
//          do nothing
      }
      }
      else{
      if(date>=10){
//      lock data called    
       lockStatus++;   
      }
      else{
//          do nothing
    months--;
    lockStatus++;
     }     
          
      }
      
      if(lockStatus>=1){
//      addMonths=(months/3)*3;
      addMonths=months;
    
      
//      CODE TO LOCK DATA HERE............................................................................

        Calendar calLockDate = Calendar.getInstance();
        Calendar calMinDate = Calendar.getInstance();
        calLockDate.setTime(lock_date);
        calLockDate.add(Calendar.MONTH, addMonths); //minus number would decrement the days
        
        calMinDate.setTime(minDate);
        calMinDate.add(Calendar.MONTH, addMonths); //minus number would decrement the days
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
      newLockDate = formatter.format(calLockDate.getTime());
      newMinDate = formatter.format(calMinDate.getTime());
     
      System.out.println("Months are : "+months+" new lock date : "+newLockDate+" new min date is : "+newMinDate);
      
//      UPDATE NEW LOCK DATES
      
      String updator="INSERT INTO lock_data (lock_date,min_date) VALUES('"+newLockDate+"', '"+newMinDate+"')";
      conn.state.executeUpdate(updator);
     status="Lock updated";
      
       }
      else{
           System.out.println("Few days to closing.....");
       }
       }
       
      else if(months<0){
         status="Wrong current date";  
       }
      else if (months>=0 && months<3){
           System.out.println("We cannot lock your data................."+months);
           status="data is ok";
       }
        out.println(status);
       
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
        Logger.getLogger(update_lockDate.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(update_lockDate.class.getName()).log(Level.SEVERE, null, ex);
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
