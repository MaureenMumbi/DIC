/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import dbConnect.AES;
import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class Appointments extends HttpServlet {

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
    HttpSession session;
     String uniqueid="";
          String doa="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       session = request.getSession();
       dbConnect conn = new dbConnect();
           String selecteddate="";
           String DICName="";
  selecteddate= request.getParameter("selecteddate");
  DICName= request.getParameter("DICName");
           String fname="";
           String query1="";
           String query="";
           String dates="";
           int count=0;
           String date="";
               String FirstName="";
      String MiddleName="";
      String PhoneNo="";
            ArrayList details = new ArrayList();
  // String query = "SELECT * FROM anc_visits WHERE DATE(VisitDate) = DATE(NOW())";     
                            if(details!=null && details.size()>0)
                            {
                                details.clear();
                            }       
                         //query="SELECT * FROM riskreductionmain WHERE DATE(DOA) = DATE(CURDATE()+INTERVAL 3 MONTH)";
                        // query="SELECT DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH)  FROM riskreductionmain ";
                         query="SELECT UniqueID,(STR_TO_DATE(DOA,'%e/%c/%Y')),DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH) FROM riskreductionmain Where DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH) BETWEEN (STR_TO_DATE('"+selecteddate+"','%e/%c/%Y')) AND DATE_ADD((STR_TO_DATE('"+selecteddate+"','%e/%c/%Y')),INTERVAL 7 DAY)";
                               //  + "// BETWEEN CURDATE() AND DATE_SUB(CURDATE(),INTERVAL 7 DAY)";
                         
                         
                        // query="SELECT UniqueID, DOA FROM riskreductionmain WHERE DOA BETWEEN SYSDATE() AND DATE_ADD(SYSDATE(), INTERVAL 3 MONTH); ";
                         // query="SELECT DOA FROM riskreductionmain where DATE_SUB(DOA,INTERVAL 3 MONTH)=CURDATE()";     
                         conn.rs2 = conn.state.executeQuery(query); 
                          while(conn.rs2.next()){
                              count++;
                              uniqueid= conn.rs2.getString(1);
                              doa= conn.rs2.getString(2);
                              dates= conn.rs2.getString(3);
                              
                                  AppointmentBean DB= new AppointmentBean();
                                    DB.setUNIQUEID(uniqueid);
                                          DB.setDATE(dates);
                              String query2="SELECT * FROM enrollment where UniqueID='"+uniqueid+"' and  DICName='"+DICName+"' and PhoneNo!=''";
                               conn.rs2 = conn.state2.executeQuery(query2); 
                               System.out.println(query2);
                               while(conn.rs2.next()){
                         if(session.getAttribute("lockNames")==null){
                            DB.setFNAME("");
                            DB.setMNAME("");
                            DB.setPHONENO("");
                            DB.setPHONENO1("");   
                                }
                                else{
                                if(session.getAttribute("lockNames").toString().equals("YES")){
                            DB.setFNAME("");
                            DB.setMNAME("");
                            DB.setPHONENO("");
                            DB.setPHONENO1("");      
                                }
                                else{
                           
                                final  String strPssword = "?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs2.getString("FirstName")!=null && !conn.rs2.getString("FirstName").trim().equals("") && !conn.rs2.getString("FirstName").equals("null")){
                                    
                                        AES.decrypt(conn.rs2.getString("FirstName").trim());
                                       System.out.println("String To Decrypt : " +  conn.rs2.getString("FirstName"));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
                                                      FirstName =  AES.getDecryptedString()  ;
                                                   }
                                       
                          if(conn.rs2.getString("SecondName")!=null && !conn.rs2.getString("SecondName").trim().equals("") && !conn.rs2.getString("SecondName").equals("null")){               
//                        
                    AES.decrypt(conn.rs2.getString("SecondName").trim());
                     System.out.println("String To Decrypt : " + conn.rs2.getString("SecondName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    MiddleName=AES.getDecryptedString();
                          }
                      if(conn.rs2.getString("PhoneNo")!=null && !conn.rs2.getString("PhoneNo").trim().equals("") && !conn.rs2.getString("PhoneNo").equals("null")){
//                      Lastname =  conn.rs2.getString("LastName");
                    AES.decrypt(conn.rs2.getString("PhoneNo").trim());
                     System.out.println("String To Decrypt : " + conn.rs2.getString("PhoneNo"));
                     PhoneNo=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                      }
              
              
                           
                     
//                                 DB.setNAME(FirstName +" "+MiddleName+" "+PhoneNo);
                                    
                                    
                             DB.setFNAME(FirstName);
                            DB.setMNAME(MiddleName);
                            DB.setPHONENO(PhoneNo);
                            DB.setPHONENO1("");
                                }
                         }
                         details.add(DB);
                               }
                     
                     System.out.println("UNIQUE ID"+uniqueid);
                              System.out.println("DOA"+doa);
    }
                           session.setAttribute("details", details);       
                                    response.sendRedirect("Diary.jsp");
                                        conn.connect.close();
                                        System.out.println("Disconnected from database");
       
                         

 
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
            Logger.getLogger(Appointments.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Appointments.class.getName()).log(Level.SEVERE, null, ex);
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
