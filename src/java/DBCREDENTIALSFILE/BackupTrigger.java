/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCREDENTIALSFILE;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Maureen
 */
public class BackupTrigger extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String nextpage;
    private boolean shutdown;
    int year, month, date, hour, min, sec, schedulingmin;
      private Date dit;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
               PrintWriter out = response.getWriter();
            
            JobDetail backupjob = JobBuilder.newJob(db_backup.class).withIdentity("DICDBBACKUPJOB" + "1").build();

             //schedule the job
                SchedulerFactory schFactory = new StdSchedulerFactory();
                Scheduler sch = schFactory.getScheduler();
                sch.start();
                
              
                
                
                
                 //=========whether to stop scheduler or start===============    

            if (request.getParameter("shutdown") != null) {

                if (request.getParameter("shutdown").equals("true")) {



                    //set shutdown to false after shutting down
                    nextpage = "";

                    shutdown = true;

                    
                    if (!sch.getCurrentlyExecutingJobs().isEmpty()) {
                    }

                    sch.shutdown(shutdown);

//after a shutdown, revert the statements to true           

                    sch.shutdown(false);

                    out.println("Restart scheduler");




                } else if (request.getParameter("shutdown") != null && request.getParameter("shutdown").equals("false")) {

                    nextpage = "";
                    shutdown = false;
                    out.println("stop scheduler");

                }
            }

            //=======================end of start or stop scheduler======================           

            dbConnect conn= new dbConnect(); 
            
            
             conn.rs = conn.state.executeQuery("Select * from scheduler_settings where schedule_id='1'");
            //second minute hour am/pm

            
            String anc_check_time = "0 02 8pm ";

            String ancretrigertime = "";
            if (conn.rs.next()) {

                anc_check_time = "0 " + conn.rs.getString("minute") + " " + conn.rs.getString("hour") + conn.rs.getString("am_pm");
                ancretrigertime = year + "-" + month + "-" + date + " " + conn.rs.getString("hour") + ":" + conn.rs.getString("minute") + ":" + conn.rs.getString("second");

                dit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(ancretrigertime);

            }
            
            
            
            
           
            
              
            CronTrigger backuptrigger = TriggerBuilder.newTrigger().withIdentity("backuptrigger" + 45, "dbbackuptriggergroup" + 46).withSchedule(CronScheduleBuilder.cronSchedule(anc_check_time + " * * ?")) // .withSchedule(CronScheduleBuilder.cronSchedule("0 26 8a * * ?"))
                    .build();
            
             if (!sch.isShutdown()) {

                sch.scheduleJob(backupjob, backuptrigger);

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
                
                
                
                
        } catch (ParseException ex) {
            Logger.getLogger(BackupTrigger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BackupTrigger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SchedulerException ex) {
            Logger.getLogger(BackupTrigger.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


    
     //=================DATE FUNCTION========
    public void currentdates() {

        Calendar cal = Calendar.getInstance();

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        date = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        min = cal.get(Calendar.MINUTE);
        sec = cal.get(Calendar.SECOND);
        schedulingmin = cal.get(Calendar.MINUTE) + 2;
    }

}

  