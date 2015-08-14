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
public class sendSMS extends HttpServlet {

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
    String addPhones = "";
    String msg = "";
    String status = "";

    HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          
        String message = "";

    String confirmation = "";
    String warnings = "";
    String sms1 = "";
    String salutation = "";
    String phoneNum;
    String FName;
    String NokphoneNum;
    String consent;
    String FinalSMS = "";
    String queries = "";
    int count = 1;
    ArrayList phone = new ArrayList();
    String FinalNum = "";
    int counter = 0;
String visitdate="";
String fname="";
String reminder="";
ArrayList uniqueid= new ArrayList();
ArrayList dates= new ArrayList();
        String startdate="";
        String enddate="";
        
      
            
            String query="";
            
           
            
        
        ArrayList messages = new ArrayList();
             ArrayList messages1 = new ArrayList();
            
              int internalcount=0;
             int counters = 0;
      

String salutationEng="";
String salamu="";
        
        if (request.getParameter("count") != null && !"".equals(request.getParameter("count"))) {
            counters = Integer.parseInt(request.getParameter("count"));
        }
       reminder="";
       visitdate="";
  if (uniqueid != null && uniqueid.size() > 0) {
        uniqueid.clear();
  } if (dates != null && dates.size() > 0) {
      dates.clear();
   }
        System.out.println("counters" + counters);
        for (int i = 1; i <= counters; i++) {
       
  if (request.getParameter("reminder"+i) != null && !"".equals(request.getParameter("reminder"+i))) {
            reminder = request.getParameter("reminder"+i);
               internalcount++;
               System.out.println("mmmm   "+reminder);
                uniqueid.add(reminder);
                 if (request.getParameter("date"+i) != null && !"".equals(request.getParameter("date"+i))) {
            visitdate = request.getParameter("date"+i);
             System.out.println("mmmm   "+visitdate);
              dates.add(visitdate);
        }    
                   }
 
    
       
      
        
        }
        
        
        
        
        System.out.println("uniqueidsize    "+uniqueid.size() +"_____"+dates.size());
       System.out.println("nnnn "+internalcount);
       dbConnect conn= new dbConnect();
       for(int m=0;m<uniqueid.size();m++){
           String getdata="";
          
        getdata="select * from enrollment where UniqueID='"+uniqueid.get(m)+"'";
           System.out.println("aa  "+getdata);  
    
       conn.rs = conn.state.executeQuery(getdata);
       if(conn.rs.next()){
  salutationEng = "Hi";
            salamu ="jambo";
           if(conn.rs.getString("PhoneNo")!=null && !conn.rs.getString("PhoneNo").equals("")){
            System.out.println("aaa "+reminder);
//                sentMsg  = msg.replace("%20"," ");
                System.out.println(msg);
          
            phoneNum = conn.rs.getString("PhoneNo");
            FName = conn.rs.getString("FirstName");
      
           

          msg = "Your next DIC Visit is scheduled for "+dates.get(m) +".Please attend your visit in the nearest DIC.";
            System.out.println(msg);
            System.out.println(salamu);
            System.out.println(salutation);



           
         
          
                  
                        message = msg;

                     
                           
                          
                   
                        salutation = salutationEng;

                  

                    String p = "";
                    String phones2 = "";
                    String phones = "";
                    System.out.println(phoneNum + "___" + FName + "______" + message );
                    if (phoneNum != null && !phoneNum.equals("") && message != null && !message.equals("")) {
                      
                        System.out.println("____________________" + message);
                        System.out.println("____________________" + phoneNum);
                        if (phoneNum.startsWith("7")) {
                            phones = phoneNum.substring(0, 1);
                            System.out.println("qqqqq" + phones);
                            phones2 = phoneNum.substring(1, 9);
                            System.out.println("wwwwww" + phones2);
                            String k = phones.replace("7", "07");
                            System.out.println("kkkkkk     " + k);


                            phoneNum = k + phones2;

                            System.out.println("lllll  " + FinalNum);
                        }

                    } 


  if (messages != null && messages.size() > 0) {
                messages.clear();
            }
                  



                    if (reminder!=null && !"".equals(reminder)
                            && phoneNum != null &&!"0".equals(phoneNum)&& 
                            !"".equals(phoneNum) && message != null && !message.trim().equals("")) {

       

                        System.out.println("sms1------" + message);
                        System.out.println("phoneNum------" + phoneNum);
                        System.out.println("Name------" + FName);
                        System.out.println("salutation------" + salutation);

                        FinalSMS = salutation + " " + FName + "," + message;

                        System.out.println("FinalSMS------" + FinalSMS);




// Create the URL for adding the phones number to sms 
                        messages.add("http://localhost:8011/send/sms/" + phoneNum + "/" + salutation.trim().replace(" ", "%20") + "%20" + FName.trim().replace(" ", "%20") + "%20,%20" + message.trim().replace(" ", "%20"));
                        for (int j = 0; j < messages.size(); j++) {
                            System.out.println("Message      " + messages.get(j).toString());
                        }



                    }//end of if for phone number 
                  
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

            }
            for (int a = 0; a < messages1.size(); a++) {
                System.out.println("URL 1 " + messages1.get(a));
                System.out.println("size " + messages1.size());
                try {

                    URL obj = new URL("" + messages1.get(a));

                    HttpURLConnection conne = (HttpURLConnection) obj.openConnection();
                    conne.setReadTimeout(5000);

                    System.out.println("Request URL ... " + obj);

                    boolean redirect = false;

                    // normally, 3xx is redirect
                    int statuss = conne.getResponseCode();
                    if (statuss != HttpURLConnection.HTTP_OK) {
                        if (statuss == HttpURLConnection.HTTP_MOVED_TEMP
                                || statuss == HttpURLConnection.HTTP_MOVED_PERM
                                || statuss == HttpURLConnection.HTTP_SEE_OTHER) {
                            redirect = true;
                        }
                    }

                    System.out.println("Response Code ... " + statuss);

                    if (redirect) {

                        // get redirect url from "location" header field
                        String newUrl = conne.getHeaderField("Location");

                        // get the cookie if need, for login
                        String cookies = conne.getHeaderField("Set-Cookie");

                        // open the new connnection again
                        conne = (HttpURLConnection) new URL(newUrl).openConnection();

                        System.out.println("Redirect to URL : " + newUrl);

                    }

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(conne.getInputStream()));
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
            }
        }// end of for loop
        } }
       
        if (uniqueid != null && uniqueid.size() > 0) {
        uniqueid.clear();
  } if (dates != null && dates.size() > 0) {
      dates.clear();
   }
  if (messages != null && messages.size() > 0) {
      messages.clear();
   }
       response.sendRedirect("filterDiary.jsp");
   
    
    		
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sendSMS.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(sendSMS.class.getName()).log(Level.SEVERE, null, ex);
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
