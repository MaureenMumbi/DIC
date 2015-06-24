/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
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
public class logoutServlet extends HttpServlet {
  dbConnect conn = new dbConnect();
       int quarter = 0;
    String month, insert_month;  
   
    int insert_year;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     HttpSession session=request.getSession(true);
       Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String formattedDate = formatter.format(date);
                
                //____________________GET COMPUTER NAME____________________________________
String computername=InetAddress.getLocalHost().getHostName();
System.out.println("Computer name "+computername);
        String logStatus=(String)session.getAttribute("loggedIn");
        String inserter = "insert into taskauditor set host_comp='" + computername + "' , action='LOGOUT',time='" + formattedDate + "',username='" + session.getAttribute("Username") + "'";
            conn.state.executeUpdate(inserter);
            if(logStatus!=null){
        if (logStatus.equalsIgnoreCase("log")){
            session.invalidate();
            
        }
            }
        response.sendRedirect("../DIC/Login.jsp");
        
        
                     //Goes to RiskReductionMain to check date
    String check_date = "SELECT * FROM riskreductionmain";
    conn.rs1=conn.state.executeQuery(check_date);
    while(conn.rs1.next()){
    month = conn.rs1.getString(3);
    System.out.println("picked date    :   "+month);
    String assessment_id = conn.rs1.getString(2);
    String mnth[]=month.split("/");
    if(mnth.length>=3){
    String retval=mnth[1];
    int retval1=Integer.parseInt(mnth[2]);

    
    
     System.out.println("Month is    "+retval);
     //Comparing the monthly dates
     if (retval.equals("10") || retval.equals("11") || retval.equals("12")){
         insert_month = "Q1";
        
     }
     if (retval.equals("01")||retval.equals("1") || retval.equals("02")|| retval.equals("2") || retval.contains("03")){
         insert_month = "Q2";
     }
     if (retval.contains("4") || retval.contains("5") || retval.contains("6")){
         insert_month = "Q3";
     }
     if (retval.contains("7") || retval.contains("8") || retval.contains("9")){
         insert_month = "Q4";
     }
//     String insert_quarter = "UPDATE riskreductionmain SET qtr ='"+insert_month+"',year='"+retval1+"' WHERE RiskReductionID ='"+assessment_id+"' ";
//     System.out.println(insert_quarter);
//     conn.state2.executeUpdate(insert_quarter);
     System.out.println("assesmnent id is    :" +assessment_id);
     System.out.println("inserted quarter:" +insert_month);
        


    }  }
    addyear();  
   checkdate();
   checkmonth();
   checkyear();
      
    }

    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(logoutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(logoutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
    
    public  void checkdate() throws SQLException{
         //Goes to RiskAssessmentMain to check date
        String check_date1 = "SELECT * FROM riskreductionmain";
        conn.rs1=conn.state.executeQuery(check_date1);
        while(conn.rs1.next()){
        month = conn.rs1.getString(3);
        System.out.println("picked date    :   "+month);
        String assessment_id = conn.rs1.getString(2);
        
        String mnth[]=month.split("/");
         if(mnth.length>=3){
        String retval=mnth[1];

         System.out.println("Month is    "+retval);
         //Comparing the monthly dates
         if (retval.equals("10") || retval.equals("11") || retval.equals("12")){
             insert_month = "Q1";
         }
         if (retval.equals("01") || retval.equals("02") || retval.equals("03")){
             insert_month = "Q2";
         }
         if (retval.equals("04") || retval.equals("05") || retval.equals("06")){
             insert_month = "Q3";
         }
         if (retval.equals("07") || retval.equals("08") || retval.equals("09")){
             insert_month = "Q4";
         }
         String insert_quarter = "UPDATE riskreductionmain SET qtr ='"+insert_month+"' WHERE RiskReductionID ='"+assessment_id+"'";
         
         conn.state2.executeUpdate(insert_quarter);
         System.out.println("assesmnent id is    :" +assessment_id);
         System.out.println("inserted quarter:" +insert_month);
    
    }}}
    
    public void checkyear() throws SQLException{
    
        String check_date = "SELECT * FROM riskreductionmain";
        conn.rs1=conn.state.executeQuery(check_date);
        while(conn.rs1.next()){
        month = conn.rs1.getString(3);
        System.out.println("picked date    :   "+month);
        String assessment_id = conn.rs1.getString(2);
        String mnth[]=month.split("/");
         if(mnth.length>=3){
        String retval=mnth[1];
        int retval1=Integer.parseInt(mnth[2]);

         System.out.println("Month is    "+retval);
         System.out.println("Year is    "+retval1);
         //Comparing the monthly dates
         if (retval.equals("10") || retval.equals("11") || retval.equals("12")){
             insert_year = (retval1 + 1);
         }
         if (retval.equals("01") || retval.equals("02") || retval.equals("03")){
             insert_year = retval1;
         }
         if (retval.equals("04") || retval.equals("05") || retval.equals("06")){
             insert_year = retval1;
         }
         if (retval.equals("07") || retval.equals("08") || retval.equals("09")){
             insert_year = retval1;
         }
         String insert_quarter = "UPDATE riskreductionmain SET year ='"+insert_year+"' WHERE RiskReductionID ='"+assessment_id+"'";
         
         conn.state2.executeUpdate(insert_quarter);
         System.out.println("assesmnent id is    :" +assessment_id);
         System.out.println("inserted year:" +insert_year);
    
    }}}
    
    public void checkmonth() throws SQLException{
    
       //Goes to RiskAssessmentMain to check date
        String check_date = "SELECT * FROM riskassessmentmain";
        conn.rs1=conn.state.executeQuery(check_date);
        while(conn.rs1.next()){
        month = conn.rs1.getString(3);
        System.out.println("picked date    :   "+month);
        String assessment_id = conn.rs1.getString(2);
        String mnth[]=month.split("/");
       
         if(mnth.length>=3){
        String retval=mnth[1];
 String monthly = mnth[1];
        String insert_quarter="";
        int yearly = Integer.parseInt(mnth[2]);
        int insert_year=0;
         System.out.println("Month is    "+retval);
         //Comparing the monthly dates
         if (retval.equals("01")){
             insert_month = "1";
         }
         if (retval.equals("02")){
             insert_month = "2";
         }
         if (retval.equals("03")){
             insert_month = "3";
         }
         if (retval.equals("04")){
             insert_month = "4";
         }
         if (retval.equals("05")){
             insert_month = "5";
         }
         if (retval.equals("06")){
             insert_month = "6";
         }
         if (retval.equals("07")){
             insert_month = "7";
         }
         if (retval.equals("08")){
             insert_month = "8";
         }
         if (retval.equals("09")){
             insert_month = "9";
         }
         if (retval.equals("10")){
             insert_month = "10";
         }
         if (retval.equals("11")){
             insert_month = "11";
         }
         if (retval.equals("12")){
             insert_month = "12";
         }
         
         //Identifying the quarter
if (monthly.equals("10") || monthly.equals("11") || monthly.equals("12")){
             insert_quarter = "1";
         }
         if (monthly.equals("01") || monthly.equals("02") || monthly.equals("03")){
             insert_quarter = "2";
         }
         if (monthly.equals("04") || monthly.equals("05") || monthly.equals("06")){
             insert_quarter = "3";
         }
         if (monthly.equals("07") || monthly.equals("08") || monthly.equals("09")){
             insert_quarter = "4";
         }
//Identifying the year
         if (monthly.equals("10") || monthly.equals("11") || monthly.equals("12")){
             insert_year = (yearly + 1);
         }
         if (monthly.equals("01") || monthly.equals("02") || monthly.equals("03")){
             insert_year = yearly;
         }
         if (monthly.equals("04") || monthly.equals("05") || monthly.equals("06")){
             insert_year = yearly;
         }
         if (monthly.equals("07") || monthly.equals("08") || monthly.equals("09")){
             insert_year = yearly;
         }
         String insert_quarters = "UPDATE riskassessmentmain SET Month ='"+insert_month+"',Pefar_year='"+yearly+"',Quarter='"+insert_quarter+"' WHERE AssessmentID ='"+assessment_id+"'";
         
         conn.state2.executeUpdate(insert_quarters);
         System.out.println("assesmnent id is    :" +assessment_id);
         System.out.println("inserted quarter:" +insert_month);
         System.out.println("Update query is    :" +insert_quarters);
    
    }}}
    
    public void addyear() throws SQLException{
    
      String check_date = "SELECT * FROM enrollment";
        conn.rs1=conn.state.executeQuery(check_date);
        while(conn.rs1.next()){
        month = conn.rs1.getString("DOE");
        System.out.println("enrollment picked date    :   "+month);
        String assessment_id = conn.rs1.getString("UniqueID");
        String mnth[]=month.split("/");
        String retval=mnth[1];
        int retval1=Integer.parseInt(mnth[2]);

         System.out.println("Month is    "+retval);
         System.out.println("Year is    "+retval1);
         //Comparing the monthly dates
         if (retval.equals("10") || retval.equals("11") || retval.equals("12")){
             insert_year = (retval1 + 1);
         }
         if (retval.equals("01") || retval.equals("02") || retval.equals("03")){
             insert_year = retval1;
         }
         if (retval.equals("04") || retval.equals("05") || retval.equals("06")){
             insert_year = retval1;
         }
         if (retval.equals("07") || retval.equals("08") || retval.equals("09")){
             insert_year = retval1;
         }
         String insert_quarter = "UPDATE enrollment SET Pefar_year ='"+insert_year+"' WHERE UniqueID  ='"+assessment_id+"'";
        
         conn.state2.executeUpdate(insert_quarter);
          System.out.println(insert_quarter);
         System.out.println("assesmnent id is    :" +assessment_id);
         System.out.println("inserted year:" +insert_year);
        


        }
    }
}
