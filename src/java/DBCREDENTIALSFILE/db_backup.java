/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCREDENTIALSFILE;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Maureen
 */

    
public class db_backup implements Job{
String usersession="";
  String computername="";
   String senderofmail="";
   HttpSession session;
//     session= request.getSession();
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            
            URL location = DBCREDENTIALSFILE.db_backup.class.getProtectionDomain().getCodeSource().getLocation();
             String  mydrive = location.getFile().substring(1, 2);
             System.out.println("drive "+mydrive);
             String password="";
             String user="";
             String dbname="";   
             String storagepath="C:\\DIC_DBBACKUP\\DBCONNECTION\\DO_NOT_DELETE\\";
              System.out.println("storagepath "+storagepath);
             dbConnect conn= new dbConnect();
          
          String dbpath="";  

     computername = InetAddress.getLocalHost().getHostName();
     
   
         String filname="";    

Date dates= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
                String formattedDate = formatter.format(dates);

         filname+=formattedDate+"_";
     
     
 
             if(conn.dbsetup[3]!=null){
             password=conn.dbsetup[3];
                 
             
             }
             
             
             
             if(conn.dbsetup[2]!=null){
                 
             user=conn.dbsetup[2];
                 
             
             }
             
             
             
             if(conn.dbsetup[1]!=null){
                 
             dbname=conn.dbsetup[1];                 
             
             }
         
System.out.println("PASSWORD IS :"+password);
             System.out.println("USER IS :"+user);
             System.out.println("DBNAME IS :"+dbname);
             
             Calendar cal = Calendar.getInstance();

     int   year = cal.get(Calendar.YEAR);
      int  month = cal.get(Calendar.MONTH) + 1;
      int  date = cal.get(Calendar.DAY_OF_MONTH);
      int  hour = cal.get(Calendar.HOUR_OF_DAY);
      int  min = cal.get(Calendar.MINUTE);
      int  sec = cal.get(Calendar.SECOND);
             
      String dat=year+"_"+month+"_"+date+"_"+hour+"_"+min+"_"+sec;
             
      //String prepa="set path=M:\\wamp\\bin\\mysql\\mysql5.1.36\\bin";       
      
               dbpath=storagepath+dbname+"_"+dat+".sql";
               //all comps
               String command2="C:/wamp3/bin/mysql/mysql5.6.12/bin mysqldump -u "+user+" -p"+password+" "+dbname+" -r "+storagepath+dbname+"_"+dat+".sql";
             //  C:\wamp3\bin\mysql\mysql5.6.12
               //manus comps
               //String backup="C:\\wamp3\\bin\\mysql\\mysql5.6.12\\bin\\mysqldump --no-create-info --skip-add-drop-table -u "+user+" -p"+password+" "+dbname+" -r "+storagepath+dbname+"_"+dat+".sql";
               //String backup="C:\\wamp3\\bin\\mysql\\mysql5.6.12\\bin\\mysqldump --no-create-info --skip-add-drop-table -u "+user+" -p"+password+" "+dbname+"  audit enrollment childage clientmember clientoccupation clientoparea dummy medical_form riskassessmentdetails riskassessmentmain user taskauditor -r "+storagepath+dbname+"_"+dat+".sql";
               String backup="C:\\wamp3\\bin\\mysql\\mysql5.6.12\\bin\\mysqldump --no-create-info --skip-add-drop-table -u "+user+" -p"+password+" "+dbname+" taskauditor --where=timestamp='2014-02-20'  -r "+storagepath+dbname+"_"+dat+".sql";
              //dont run this for now
             //  mysqldump -uroot -p database -r utf8.dump
               //mysqldump -u root -pYourPasword database table_name \ --compact --no-create-info | \sed -r "s/\([0-9]*/\(NULL/g"
              
               
               //--no-create-db --no-create-info mydb > mydb.sql
             //  String command5="C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -u root -pmaureen --no-create-db  -–no-create-info   dic -r "+mydrive+":\\"+dbname+"_"+dat+".sql";
               String command5="C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -u root -pmaureen -compact -no-create-info  dic  -r "+mydrive+":\\"+dbname+"_"+dat+".sql";
              // String command5="C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -u root -pmaureen dic venue \\ -compact -no-create-info | \\sed -r \"s/\\([0-9]*/\\(NULL/g\">"+mydrive+":\\"+dbname+"_"+dat+".sql";
               //godfreys comp
               
               String command3="C:\\wamp\\bin\\mysql\\bin\\mysqldump -u "+user+" -p"+password+" dic -r "+storagepath+dbname+"_"+dat+".sql";
            // Process prs=  Runtime.getRuntime().exec(prepa);
                System.out.println(backup);
               System.out.println(command5);
               Runtime runtime = Runtime.getRuntime();
               runtime.exec(backup);
//               runtime.exec(command2);
//               runtime.exec(command3);
               runtime.exec(command5);
             
               System.out.println(backup);
               System.out.println(command5);
        String updateChecked=" update taskauditor set checked='backedup' where timestamp='2014-02-20'";
        conn.state.executeUpdate(updateChecked);
       
//                SEND TO THE MAIL BACKED UP DATA.
            if("127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress().toString())){
//         System.out.println("you are offline");
    System.out.println("network_error, You are not connected to the internet. Please connect to the internet and try again.");
     }
                if(!"127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress().toString())){
                Send_Data dt=new Send_Data();
                    try {  
                           String locations="";
                if(session.getAttribute("Location").toString()!=null){
                locations= session.getAttribute("Location").toString();}
                else{locations="";}
                        dt.Sendattachment(dat, dbpath,computername,senderofmail,filname,locations);
                    } catch (MessagingException ex) {
                        Logger.getLogger(db_backup.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(ex.toString());
                    }
               
                }
          	 
            else {
                System.out.println("---------------Could not create the backup--------------");
				
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
        } catch (SQLException ex) {
            Logger.getLogger(db_backup.class.getName()).log(Level.SEVERE, null, ex);
        }
//            System.out.println("at 1 is "+processComplete);
//            if (processComplete == 0) {
//             if(!"127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress().toString())){
//                Send_Data dt=new Send_Data();
//            try {
//                dt.Sendattachment(dat, dbpath,computername);
//            } catch (MessagingException ex) {
//                Logger.getLogger(db_backup.class.getName()).log(Level.SEVERE, null, ex);
//            }
//             }
//               
//               // int processComplete = prs.waitFor();
// 
//            
     
         catch (IOException ex) {
            System.out.println("ERROR WHILE PERFORMING DATA BACKUP   : "+ex.toString());
            Logger.getLogger(DBCREDENTIALSFILE.db_backup.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    
    
}

