/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;


import Maintenance.DICServlet;
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


public class DQAMissingData extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
         try {
           
              dbConnect conn = new dbConnect();
             
session = request.getSession(true);
  String type="";
  type=request.getParameter("type");
                                
                                        
                                        
                                        ArrayList missingdata = new ArrayList();
                                     if(type.equals("missingdata")) {  
                 String query = "select UniqueID, DICName,DOE from enrollment where (DICNAME=''|| DICNAME='NULL') || (DOE='' || DOE ='NULL')  ";
                                        System.out.println("query " + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(missingdata!=null && missingdata.size()>0 ){missingdata.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       DQAMissingBean DB= new DQAMissingBean();
                       DB.setUNIQUEID(conn.rs.getString(1));
                       DB.setDICNAME(conn.rs.getString(2));
                       DB.setDOE(conn.rs.getString(3));
                     
                       
                    
                      
          
                       missingdata.add(DB);
                       
                      
        }
                                     }
                                     if(type.equals("wrongdate")) {  
                 String query = "select UniqueID, DICName,DOE from enrollment where  DOE NOT REGEXP '^..........$'";
                                        System.out.println("query " + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(missingdata!=null && missingdata.size()>0 ){missingdata.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       DQAMissingBean DB= new DQAMissingBean();
                       DB.setUNIQUEID(conn.rs.getString(1));
                       DB.setDICNAME(conn.rs.getString(2));
                       DB.setDOE(conn.rs.getString(3));
                     
                       
                    
                      
          
                       missingdata.add(DB);
                       
                      
        }
                                     }
                                     if(type.equals("less2012")) {  
                 String query = "select UniqueID, DICName,DOE from enrollment where (STR_TO_DATE(DOE,'%e/%c/%Y'))<STR_TO_DATE('01/01/2012','%e/%c/%Y')";
                                        System.out.println("query " + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(missingdata!=null && missingdata.size()>0 ){missingdata.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       DQAMissingBean DB= new DQAMissingBean();
                       DB.setUNIQUEID(conn.rs.getString(1));
                       DB.setDICNAME(conn.rs.getString(2));
                       DB.setDOE(conn.rs.getString(3));
                     
                       
                    
                      
          
                       missingdata.add(DB);
                       
                      
        }
                                     }
                                     if(type.equals("dob")) {  
                 String query = "select UniqueID, DICName,DOB from enrollment where (STR_TO_DATE(DOB,'%e/%c/%Y'))>STR_TO_DATE('01/01/2004','%e/%c/%Y') ";
                                        System.out.println("query " + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(missingdata!=null && missingdata.size()>0 ){missingdata.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       DQAMissingBean DB= new DQAMissingBean();
                       DB.setUNIQUEID(conn.rs.getString(1));
                       DB.setDICNAME(conn.rs.getString(2));
                       DB.setDOE(conn.rs.getString(3));
                     
                       
                    
                      
          
                       missingdata.add(DB);
                       
                      
        }
                                     }
                                     
                                     
                                     
                                     
                                     
                                     
                                     
                                     
       session.setAttribute("missingdata", missingdata);
         session.setAttribute("type",type);
         
         System.out.println(type);
       String nextJSP = "/admin/DQAMissingData.jsp";
          response.sendRedirect("admin/DQAMissingData.jsp");                              
//                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//                                        dispatcher.forward(request,response);
//                                        conn.connect.close();
//                                        System.out.println("Disconnected from database");
      
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
            Logger.getLogger(DICServlet.class.getName()).log(Level.SEVERE, null, ex);
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
