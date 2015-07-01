/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCREDENTIALSFILE;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Maureen
 */
public class InternetThread extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            response.setContentType("text/html;charset=UTF-8");
                           
            System.out.println("Tomcat Called__");
            
           StartThread(false);

            
            
            PrintWriter out = response.getWriter();
            try {
                /* TODO output your page here. You may use following sample code. */               
out.println("</html>");
            } finally {
                out.close();
            }
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    public String StartThread( boolean shutdown){
   
      int jobprefix=0;
    
    try {
        JobDetail syndatajob = JobBuilder.newJob(SYNCEXCECUTER.class).withIdentity("SYNCSCHEDULER"+jobprefix).build();
        SchedulerFactory schFactory = new StdSchedulerFactory();
        Scheduler sch = schFactory.getScheduler();
        sch.start();
        
        
        //=========whether to stop scheduler or start===============
        
     
            
            if (shutdown==true) {
               
                // realtimesmsjob = null;
                if (!sch.getCurrentlyExecutingJobs().isEmpty()) {
                }
                
                sch.shutdown(shutdown);
//after a shutdown, revert the statements to true
                sch.shutdown(false);
                
            }
            
            
            else if(shutdown==false){
               
            }
      
        
//=======================end of start or stop scheduler======================
        
//===============================MONTHLY EXPECTED DELIVERY DATE===============================
        
//second minute hour am/pm
        
        CronTrigger syncTrigger = TriggerBuilder.newTrigger().withIdentity("synctrigger"+jobprefix, "synctriggergroup"+jobprefix).withSchedule(CronScheduleBuilder.cronSchedule("0 0/3 * * * ?")) // .withSchedule(CronScheduleBuilder.cronSchedule("0 26 8a * * ?"))
                .build(); 
        if (!sch.isShutdown()) {
            sch.scheduleJob(syndatajob, syncTrigger);
        }
    } catch (SchedulerException ex) {
        Logger.getLogger(InternetThread.class.getName()).log(Level.SEVERE, null, ex);
    }

return "finished calling";
    
    }
}
