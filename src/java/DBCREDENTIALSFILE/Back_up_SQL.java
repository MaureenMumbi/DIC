/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCREDENTIALSFILE;

import dbConnect.dbConnect;
import dbConnect.dbConnectTemp;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class Back_up_SQL extends HttpServlet {

    String dbname, dbuser, dbpassword;
    boolean executed = false;
    String dbpath, dbpathD, dbpathE, dbpathF, dbpathG, dbpathM,importpath;
    String found_folder, full_date, path, computername, senderofmail;
    HttpSession session;
    String[] myalphabet = {"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException, SQLException {
        session = request.getSession();
        dbConnect conn = new dbConnect();

        String lasttimestampid = "1";
        String lasttimestamp = "2014-03-12 11:25:20";

        dbname = "dic";
        dbuser = "root";
        dbpassword = "";
        String nextpage = "";
        found_folder = "";
//MAKE A DIRECTORY TO STORE THE BACK_UP FILE.
//        GET CURRENT DATE:
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
String filname="";
Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
                String formattedDate = formatter.format(date);
        full_date = "Created_On_" + year + "_" + month + "_" + day + "_" + hour + "_" + min + "_" + sec;
        String full_dates = day + " / " + month + " / " + year + "  :and the exact time is  " + hour + ":" + min + ":" + sec;
        URL location = dbConnectTemp.class.getProtectionDomain().getCodeSource().getLocation();
         if (session.getAttribute("Username") != null) {
          filname=session.getAttribute("Username").toString()+"_";

          senderofmail = " which has been sent by user :: " + session.getAttribute("Username").toString() + ". Sent From'"+session.getAttribute("Location").toString()+"' DIC";
         senderofmail+="To merge this data , "
                + "\n(1)Download the attachment to any folder of choice;"
                + " \n(2) Select Bakcups then select Import Data.\n"
                + "(3)From the merging page that opens, Browse and select the sql file you have downloaded.\n"
                + "(4)Click on Merge and wait for a success message"
                + "";
        } else {
            senderofmail = "";
        }
        
         filname+=formattedDate+"_";
        computername = InetAddress.getLocalHost().getHostName();
        if (1 == 1) {
//         
            String executeCmd = "";


            if (conn.dbsetup[3] != null) {
                dbpassword = conn.dbsetup[3];


            }



            if (conn.dbsetup[2] != null) {

                dbuser = conn.dbsetup[2];


            }



            if (conn.dbsetup[1] != null) {

                dbname = conn.dbsetup[1];

            }
            System.out.println("PASSWORD IS :" + dbpassword);
            System.out.println("USER IS :" + dbuser);
            System.out.println("DBNAME IS :" + dbname);


            for (int i = 0; i < myalphabet.length; i++) {
                try {
                    System.out.println("at position  :  " + myalphabet[i]);
                    String current_drive = myalphabet[i];
                    File f = new File(current_drive + ":\\wamp\\mysql\\bin\\");
                    File f1 = new File(current_drive + ":\\wamp\\bin\\mysql\\mysql5.6.12\\bin");
                    File f2 = new File(current_drive + ":\\Program Files\\MySQL\\MySQL Server 5.5\\bin");
                    File f3 = new File(current_drive + ":\\DIC_DBBACKUP");

                    //     CREATE A DIRECTORY AND THE FILE TO HOLD DATA
                    if (f3.exists() && f3.isDirectory()) {
                        //path="C:\\PPT_UPLOADS\\BACKUP\\";
                        path = current_drive + ":\\DIC_DBBACKUP\\BACKUP";
                          importpath = current_drive + ":\\DIC_DBBACKUP\\IMPORTS";
                        new File(path).mkdirs();
                        new File(importpath).mkdirs();
                        dbpath = path + "\\" + full_date + "_DIC.sql";
                    }

                    //select the last timestamp which a backup was picked from.....



                    conn.rs = conn.state.executeQuery("select MAX(timestampid) from timestamp");
                    if (conn.rs.next()) {

                        
      conn.rs1=conn.state1.executeQuery("select timestamp from timestamp where timestampid='"+conn.rs.getString(1)+"'");
          
      if(conn.rs1.next()){
       lasttimestamp = conn.rs1.getString("timestamp");

      System.out.println(conn.rs1.getString("timestamp"));
      
      }
                        
     
                        System.out.println("Timestamp id::"+conn.rs.getString(1));
                        
                        
                        lasttimestampid = conn.rs.getString(1);

                    }

                    //conn.st_6.close();


// CHECK WHICH PROGRAM IS INSTALLED TO ENSURE THAT DATA IS BACKED UP SUCCESSFULLY.             

                    if (f.exists() && f.isDirectory()) {
                        executeCmd = current_drive + ":\\wamp\\mysql\\bin\\mysqldump --host=localhost --user=" + dbuser + " --password=" + dbpassword + " " + dbname + " audit enrollment childage clientmember clientoccupation clientoparea dummy medical_form riskassessmentdetails riskassessmentmain riskreductionmain riskreductiondetails user taskauditor --where=timestamp>='" + lasttimestamp + "' -r " + dbpath + "";
//executeCmd = "C:\\wamp3\\bin\\mysql\\mysql5.6.12\\bin\\mysqldump --no-create-info --skip-add-drop-table --host=localhost --user="+dbuser+" --password="+dbpassword+" "+dbname+" audit enrollment childage clientmember clientoccupation clientoparea dummy medical_form riskassessmentdetails riskassessmentmain riskreductionmain riskreductiondetails user taskauditor --where=timestamp>='"+startdate+"' -r "+dbpath+"";

                        found_folder = "it is old wamp";
                    }
                    if (f1.exists() && f1.isDirectory()) {


                        executeCmd = current_drive + ":\\wamp\\bin\\mysql\\mysql5.6.12\\bin\\mysqldump --host=localhost --user=" + dbuser + " --password=" + dbpassword + " " + dbname + " audit enrollment childage clientmember clientoccupation clientoparea dummy medical_form riskassessmentdetails riskassessmentmain riskreductionmain riskreductiondetails user taskauditor --where=timestamp>='" + lasttimestamp + "' -r " + dbpath + "";
                        found_folder = "it is new wamp";
                    }
                    if (f2.exists() && f2.isDirectory()) {
                        executeCmd = current_drive + ":\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump --host=localhost --user=" + dbuser + " --password=" + dbpassword + " " + dbname + " audit enrollment childage clientmember clientoccupation clientoparea dummy medical_form riskassessmentdetails riskassessmentmain riskreductionmain riskreductiondetails user taskauditor --where=timestamp>='" + lasttimestamp + "' -r " + dbpath + "";
                        found_folder = "it is workbench";
                    }
                } catch (SQLException ex) {
                    
                    
                         session.setAttribute("datasend", "<font color=\"red\">an SQL Error occured while sending data</font>");
                        
                    Logger.getLogger(Back_up_SQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }




            System.out.println(found_folder);
            System.out.println(executeCmd);
            Process runtimeProcess;
            try {
                System.out.println("trying to back up the data.");
                runtimeProcess = Runtime.getRuntime().exec(executeCmd);
                int processComplete = runtimeProcess.waitFor();
                System.out.println("at 1 is " + processComplete);
                if (processComplete == 0) {
//                SEND TO THE MAIL BACKED UP DATA.
                    System.out.println("Backup created successfully");

                  
                            conn.state.executeUpdate("update timestamp set datasend='yes' where timestampid='" + lasttimestampid + "'");

            
                            
                            Format formatters = new SimpleDateFormat("yyyy-MM-dd");
                            String mdate;

                           Date mydate = new Date();
                        mdate = formatters.format(mydate);
                            
                            
String daytime=""+year+"-"+month+"-"+day;
                            // a new timestamp that will be called next time a backup is being created.

                            conn.state.executeUpdate("insert into timestamp (timestamp,datasend) values('"+mdate+"','No')");



                            session.setAttribute("datasend", "<font color=\"green\">Backup has been created in C:/DIC_DBBACKUP/BACKUP </font>");
                        
                       if(!"127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress().toString())){
                Send_Data_Main dt=new Send_Data_Main();
                String locations="";
                if(session.getAttribute("Location").toString()!=null){
                locations= session.getAttribute("Location").toString();}
                else{locations="";}
                dt.Sendattachments(full_dates, dbpath,computername,senderofmail,filname,locations);
                session.setAttribute("network_error", "Backup has been created and send via mail");
                //out.println("Backup has been created and send via mail....");
                }
                else{
               
                session.setAttribute("network_error", "Backup has been created but NOT send via mail due to problems in internet connection");
                 // out.println("Backup has been created but NOT send via mail due to problems in internet connection........");
                }
				 
            } 

                    
                 else {
                    System.out.println("Could not create the backup");
                    session.setAttribute("datasend", "Backup Could not be created");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        
       
        response.sendRedirect("backup2.jsp");
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
                    try {
                        processRequest(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(Back_up_SQL.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (MessagingException ex) {
            Logger.getLogger(Back_up_SQL.class.getName()).log(Level.SEVERE, null, ex);
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
                    try {
                        processRequest(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(Back_up_SQL.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (MessagingException ex) {
            Logger.getLogger(Back_up_SQL.class.getName()).log(Level.SEVERE, null, ex);
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
