/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messaging;

import dbConnect.dbConnect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maureen
 */
public class SendTargetedSMS extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        dbConnect conn = new dbConnect();
        String UniqueID="";
      String Name="";
      String phoneNo="";
      String message="";
      String salutation="";
      salutation="Hi";
      int counters=0;
      String category="";
       if (request.getParameter("category") != null && !"".equals(request.getParameter("category"))) {
      category= request.getParameter("category");}
        ArrayList messages = new ArrayList();
      if (request.getParameter("counter") != null && !"".equals(request.getParameter("counter"))) {
            counters = Integer.parseInt(request.getParameter("counter"));
       }
      for(int l=1;l<=counters;l++){
      String msg=request.getParameter("msg_"+counters);
     System.out.println(counters);
         
 
//        System.out.println("counters" + counters);
      
    if (request.getParameter("msg_" + l) != null && !"".equals(request.getParameter("msg_" + l))) {
                msg = request.getParameter("msg_" + l).trim();
//                sentMsg  = msg.replace("%20"," ");
                System.out.println(msg);
    message=msg;
    }
      if (messages != null && messages.size() > 0) {
                messages.clear();
            }
    // }
      
      if(category.equalsIgnoreCase("fp")){
         String getWorker="SELECT riskreductionmain.UniqueID, FirstName, LastName,PhoneNo " +
"FROM riskreductionmain, enrollment, riskreductiondetails where riskreductiondetails.QID='J2' AND " +
" (STR_TO_DATE(riskreductionmain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('01/10/2014','%e/%c/%Y')) " +
" AND (STR_TO_DATE('31/03/2015','%e/%c/%Y')) " + 
" AND riskreductionmain.RiskReductionID = riskreductiondetails.RiskReductionID" +
" and riskreductionmain.UniqueID= enrollment.UniqueID" +
" AND riskreductiondetails.currentStatus like 'Yes'";
         System.out.println(getWorker);
          conn.rs= conn.state.executeQuery(getWorker);
          while(conn.rs.next()){
              
                  UniqueID= conn.rs.getString(1);
                  Name= conn.rs.getString(2);
                  phoneNo= conn.rs.getString(4);
                  
                  System.out.println(UniqueID +" bbb "+Name +" ccc "+phoneNo);
   System.out.println("aaaa   "+messages.size());
 if (phoneNo != null &&!"0".equals(phoneNo)&& !"".equals(phoneNo) &&  message != null && !message.trim().equals("")) {
                            System.out.println("sms1------" + message);
                        System.out.println("phoneNum------" + phoneNo);
                        System.out.println("Name------" + Name);


// Create the URL for adding the phones number to sms 
                        messages.add("http://localhost:8011/send/sms/" + phoneNo + "/" + salutation.trim().replace(" ", "%20") + "%20" + Name.trim().replace(" ", "%20") + "%20,%20" + message.trim().replace(" ", "%20"));
                        for (int j = 0; j < messages.size(); j++) {
                            System.out.println("Message      " + messages.get(j).toString());
                        }



                    }//end of if for phone number 
                  }}
      if(category.equals("nohiv")){
     System.out.println(category+"  in hiv");
        String getWorker="SELECT riskreductionmain.UniqueID, FirstName, LastName,PhoneNo " +
"FROM riskreductionmain, enrollment, riskreductiondetails where riskreductiondetails.QID='E1' AND " +
" (STR_TO_DATE(riskreductionmain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('01/10/2014','%e/%c/%Y')) " +
" AND (STR_TO_DATE('31/03/2015','%e/%c/%Y')) " + 
" AND riskreductionmain.RiskReductionID = riskreductiondetails.RiskReductionID" +
" and riskreductionmain.UniqueID= enrollment.UniqueID" +
" AND riskreductiondetails.currentStatus like 'No'";
         System.out.println(getWorker);
          conn.rs= conn.state.executeQuery(getWorker);
          while(conn.rs.next()){
              
                  UniqueID= conn.rs.getString(1);
                  Name= conn.rs.getString(2);
                  phoneNo= conn.rs.getString(4);
                  
                  System.out.println(UniqueID +" bbb "+Name +" ccc "+phoneNo);
   System.out.println("aaaa   "+messages.size());
 if (phoneNo != null &&!"0".equals(phoneNo)&& !"".equals(phoneNo) &&  message != null && !message.trim().equals("")) {
                            System.out.println("sms1------" + message);
                        System.out.println("phoneNum------" + phoneNo);
                        System.out.println("Name------" + Name);


// Create the URL for adding the phones number to sms 
                        messages.add("http://localhost:8011/send/sms/" + phoneNo + "/" + salutation.trim().replace(" ", "%20") + "%20" + Name.trim().replace(" ", "%20") + "%20,%20" + message.trim().replace(" ", "%20"));
                        for (int j = 0; j < messages.size(); j++) {
                            System.out.println("Message      " + messages.get(j).toString());
                        }



                    }//end of if for phone number 
                  }
      
      
      }
            //    } // end of while
         //   }// end of if 
       for (int a = 0; a < messages.size(); a++) {
     System.out.println("URL 1 "+messages.get(a)); 
                  System.out.println("size "+messages.size()); 
                try {

                    URL obj1 = new URL("" + messages.get(a));

                    HttpURLConnection connection = (HttpURLConnection) obj1.openConnection();
                    //connection.setReadTimeout(5000);

                    System.out.println("Request URL ... " + obj1);

                    boolean redirect = false;

                    // normally, 3xx is redirect
                    int statuses = connection.getResponseCode();
                    if (statuses != HttpURLConnection.HTTP_OK) {
                        if (statuses == HttpURLConnection.HTTP_MOVED_TEMP
                                || statuses == HttpURLConnection.HTTP_MOVED_PERM
                                || statuses == HttpURLConnection.HTTP_SEE_OTHER) {
                            redirect = true;
                        }
                    }

                    System.out.println("Response Code ... " + statuses);

                    if (redirect) {

                        // get redirect url from "location" header field
                        String newUrl = connection.getHeaderField("Location");

                        // get the cookie if need, for login
                        String cookies = connection.getHeaderField("Set-Cookie");

                        // open the new connnection again
                        connection = (HttpURLConnection) new URL(newUrl).openConnection();

                        System.out.println("Redirect to URL : " + newUrl);

                    }

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuffer html = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        html.append(inputLine);
                    }
                    in.close();

                    System.out.println("URL Content... \n" + html.toString());
                    System.out.println("Done");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            
           
        }// end of for loop
//       if (messages != null && messages.size() > 0) {
//      messages.clear();
//   } 
      } 
           
     response.sendRedirect("/DIC/admin/selectSMS.jsp");}
       
//        if (uniqueid != null && uniqueid.size() > 0) {
//        uniqueid.clear();
//  } if (dates != null && dates.size() > 0) {
//      dates.clear();
//   }
  
      
    //}   

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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SendTargetedSMS.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SendTargetedSMS.class.getName()).log(Level.SEVERE, null, ex);
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
