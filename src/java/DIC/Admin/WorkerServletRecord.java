/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.AES;
import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class WorkerServletRecord extends HttpServlet {
HttpSession session;
  String user=""; 
  boolean isnotAdminServer=true;
   String AccessLevel;    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      dbConnect conn = new dbConnect();		
      session =request.getSession();
      String FirstName="";
      String MiddleName="";
      String LastName="";
      
      String DICName="";
      isnotAdminServer=true;
     AccessLevel=user=""; 
       String start_date="";
       String end_date="";
      if(request.getParameter("DICName")!=null && !request.getParameter("DICName").equals("")){
      DICName = request.getParameter("DICName");}
        if(request.getParameter("startdate")!=null && !request.getParameter("startdate").equals("")){
      start_date = request.getParameter("startdate");}
          if(request.getParameter("enddate")!=null && !request.getParameter("enddate").equals("")){
        end_date = request.getParameter("enddate");}
//      if(request.getParameterValues("district")!=null && !request.getParameterValues("district").equals("")){
//      district = request.getParameterValues("district");}
         
      
          try {
              ArrayList enrollments =new ArrayList();
    if(session.getAttribute("lockNames")!=null){
     System.out.println("to lock : "+session.getAttribute("lockNames").toString());}
                        
				String query = "select * from enrollment where DICName='"+DICName+"' and (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+start_date+"','%e/%c/%Y')) AND (STR_TO_DATE('"+end_date+"','%e/%c/%Y'))";
				System.out.println(query);
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
				 FirstName="";
       MiddleName="";
       LastName="";	
				SummaryBean DB= new SummaryBean();
                                DB.setUNIQUEID(conn.rs.getString("UniqueID"));
                                if(session.getAttribute("lockNames")==null){
                                DB.setNAME("");     
                                }
                                else{
                                if(session.getAttribute("lockNames").toString().equals("YES")){
                               DB.setNAME("");      
                                }
                                else{
                               final  String strPssword = "?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs.getString("FirstName")!=null && !conn.rs.getString("FirstName").trim().equals("") && !conn.rs.getString("FirstName").equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString("FirstName").trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString("FirstName"));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
                                                      FirstName =  AES.getDecryptedString()  ;
                                                   }
                                       
                          if(conn.rs.getString("SecondName")!=null && !conn.rs.getString("SecondName").trim().equals("") && !conn.rs.getString("SecondName").equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString("SecondName").trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("SecondName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                   
                    
                    MiddleName=AES.getDecryptedString();
                          }
                      if(conn.rs.getString("LastName")!=null && !conn.rs.getString("LastName").trim().equals("") && !conn.rs.getString("LastName").equals("null")){
//                      Lastname =  conn.rs.getString("LastName");
                    AES.decrypt(conn.rs.getString("LastName").trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("LastName"));
                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                      }
              
              
                           
                     
                                 DB.setNAME(FirstName +" "+MiddleName+" "+LastName);
                                }
                                }
                                 DB.setCLIENTINIT(conn.rs.getString("ClientInit"));
                                 DB.setDOE(conn.rs.getString("DOE"));
                                 DB.setDICNAME(conn.rs.getString("DICName"));
                                 DB.setHAND(conn.rs.getString("capturedhand"));
			
				enrollments.add(DB);
				}
                        
				session.setAttribute("enrollments",enrollments);
//				
                                String nextJSP = "admin/viewEnroll.jsp";
				response.sendRedirect(nextJSP);
                                
//                                 String nextJSP = "/admin/viewEnroll.jsp";
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//				dispatcher.forward(request,response);
				
			
          
          
          
          
          		
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
          } catch (Exception e) {
                        e.printStackTrace();
                        e.toString();
                        out.println("dint work");
                        out.println(e.toString());
                        out.println(e.toString());
                       
			}
       
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
        processRequest(request, response);
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
        processRequest(request, response);
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