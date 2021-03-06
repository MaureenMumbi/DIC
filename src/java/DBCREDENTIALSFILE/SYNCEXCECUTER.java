/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCREDENTIALSFILE;

import static DBCREDENTIALSFILE.InternetThreadClass.a;
import static DBCREDENTIALSFILE.InternetThreadClass.netcheckingstatus;
import static DBCREDENTIALSFILE.InternetThreadClass.pagecalled;
import static DBCREDENTIALSFILE.InternetThreadClass.syncingstatus;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Emmanuel E
 */
public class SYNCEXCECUTER implements Job  {

     static int a = 0;
    public Timer _t;

     String msg="";
    //this is the primary status that will be used to check whether syncing is going on.
    public static boolean syncingstatus;
    // A variable to shows whether the checking of internet presence is already running
    //true means checking is ongoing
    public static boolean netcheckingstatus;
    public static String pagecalled="no";
      String computername="";
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
         try {
             //____________________COMPUTER NAME____________________________________
              computername=InetAddress.getLocalHost().getHostName();
//System.out.println("Computer name "+computername);
         } catch (UnknownHostException ex) {
             Logger.getLogger(SYNCEXCECUTER.class.getName()).log(Level.SEVERE, null, ex);
         }
    
     startorendthread();
        
        
    
    }
  
    
    public String  startorendthread() {

        
         msg="@@@no msg";
        a = 0;

        if(pagecalled.equals("no")){            
        pagecalled="yes";    
    
                a++;
               // System.out.println(" a is +++++++ ;"+a);
                if (syncingstatus==false) {
                    if (testInet("google.com") || testInet("twitter.com") || testInet("amazon.com")) {                       
                        try {
       // System.out.println("_Internet Connection available.Calling merging page once!");
                            //Call the page that does merging 
//            UNCOMMENT       
                             if(!computername.equalsIgnoreCase("ANALYTICS")&&!computername.equalsIgnoreCase("fhi360-pc3")){
                           SyncData sd= new SyncData();
                            if(sd.MergeData()==true){
                                msg="Data Saved Online";
                                netcheckingstatus=false;
                                
                                if (a>=1) {
                                    //System.out.println("_Stopping timer to wait for syncing to finish");
                                    pagecalled="no";
                                    //_t.cancel();  // Terminates this timer, discarding any currently scheduled tasks.
                                    //_t.purge();
                                    
                                }
                            }}
                            //this code should work only at the system that seats at the fhi360 local servers
                            //this can be fhi360-pc3 or nkufs01
                            if(computername.equalsIgnoreCase("FHI360-pc3")||computername.equalsIgnoreCase("nkufs02")){
                            
                            SyncDataLocal sd1= new SyncDataLocal();
                            if(sd1.MergeData()==true){
                                msg="Data Saved to local ";
                                netcheckingstatus=false;
                                
                                if (a>=1) {
                                   // System.out.println("_Stopping timer to wait for local syncing to finish");
                                    pagecalled="no";
                                  }
                                    }                      
                            
                            }
                            // once the page is called, it should return back a stop of the
                        } catch (SQLException ex) {
                            Logger.getLogger(InternetThreadClass.class.getName()).log(Level.SEVERE, null, ex);
                        }
                          
                      

                    } else {
          //keep on checking for internet connection
                           netcheckingstatus=true;
                        msg="No Internet Connection";
                        System.out.println("No Internet connection but timer is listening");
          //dont stop the cycle
                    }

        //in here., check whether an app is running
                                                } 
                else {
                 
                    System.out.println("Syncing is ongoing and thus timer has been stopped");                    

                }
                

            }
       
        pagecalled="no";
        return msg;
    }

    public static boolean testInet(String site) {
        Socket sock = new Socket();
        InetSocketAddress addr = new InetSocketAddress(site, 80);
        try {
            sock.connect(addr, 3000);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                sock.close();
            } catch (IOException e) {
            }
        }
    }
    
}
