/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCREDENTIALSFILE;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maureen
 */
public class InternetThreadClass {

    static int a = 0;
    public Timer _t = null;
     String msg="";
    //this is the primary status that will be used to check whether syncing is going on.
    public static boolean syncingstatus;
    // A variable to shows whether the checking of internet presence is already running
    //true means checking is ongoing
    public static boolean netcheckingstatus;
    public static String pagecalled="no";
    public InternetThreadClass() {
        //initialize this values if they have not been initialized to valid initializing them every time
        
        
        if(!syncingstatus==true&&!syncingstatus==false){
        syncingstatus = false;   
        System.out.println("%%%%%%%%%%%%% Syncing status set to false");
        }else {        
          System.out.println("%%%%%%%%%%%%% Syncing status is _________________"+syncingstatus);
        }
        
        if(!netcheckingstatus==true&&!netcheckingstatus==false){
           netcheckingstatus = true;
        }
        else {
          System.out.println("%%%%%%%%%%%%% netchacking status is _________________"+netcheckingstatus);        
        }
        
    //if the server dbconn is showing syncing is going on, then set the syncing status to true.
     
pagecalled="no";
    }

    public String  startorendthread() {

        
         msg="@@@no msg";
        a = 0;

        if(pagecalled.equals("no")){
            
        pagecalled="yes";
        _t = new Timer();
        final String conn = "";
        _t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                a++;
                System.out.println(" a is +++++++ ;"+a);
                if (syncingstatus==false) {
                    if (testInet("google.com") || testInet("twitter.com") || testInet("amazon.com")) {
                       
                        try {
                            System.out.println("_Internet Connection available.Calling merging page once!");
                            
                            
                            
                            //Call the page that does merging
                            
                            SyncData sd= new SyncData();
                            if(sd.MergeData()==true){
                                msg="Data Saved Online";
                                netcheckingstatus=false;
                                
                                if (a>=1) {
                                    System.out.println("_Stopping timer to wait for syncing to finish");
                                    pagecalled="no";
                                    _t.cancel();  // Terminates this timer, discarding any currently scheduled tasks.
                                    _t.purge();
                                    
                                }
                                //make page called to be zero here
                                
                                
                                //********************************************************
                                //********************************************************
                                
                                
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
                                                } else {
                    System.out.println("Syncing is ongoing");
                    //if syncing is ongoing, you cant do anything about it  
                    //thereffore stop the timer
                    System.out.println("Syncing is ongoing and thus timer has been stopped");
                    _t.cancel();  // Terminates this timer, discarding any currently scheduled tasks.
                    _t.purge();

                }
                

            }
        }, 30000, 30000);
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
