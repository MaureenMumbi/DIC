/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

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

/**
 *
 * @author Hare Cheka Arnold
 */
public class searchMedical extends HttpServlet {

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
   String search="";
    dbConnect conn = new dbConnect();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList a = new ArrayList();
        ArrayList userList = new ArrayList();
              
            if(request.getParameter("worker")!= null && !request.getParameter("worker").equals("")){
            
            search = request.getParameter("worker");
           }
            if(userList!=null && !userList.isEmpty()){
            userList.clear();}
                                
            if(a!=null && !a.isEmpty()){
            a.clear();}
                                
				String query = "select * from medical_form where unique_identifier ='"+search+"'";
				System.out.println("query " + query);
				conn.state = conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
					a  = new ArrayList();
				 
                                  a.add(conn.rs.getString("unique_identifier"));
                                  System.out.println(conn.rs.getString("unique_identifier"));
				  a.add(conn.rs.getString("id"));
                                  System.out.println(conn.rs.getString("id"));
                                  a.add(conn.rs.getString("dater"));
                                  System.out.println(conn.rs.getString("dater"));
                                  a.add(conn.rs.getString("signature"));
                                  System.out.println(conn.rs.getString("signature"));
                                   //String querys1 = "select * from districts where DistrictID='"+conn.rs.getString("District")+"'";
                                  //conn.rs1= conn.state3.executeQuery(querys1);
                                 // while(conn.rs1.next()){
                                     //  a.add(conn.rs1.getString(2));
                                 // }
				 
//                                  al.add(conn.rs.getString("District"));
				  //a.add(conn.rs.getString("DICName"));
				  //a.add(conn.rs.getString("DOB"));
				  //a.add(conn.rs.getString("Sex"));
                                  //String marital=conn.rs.getString("MaritalStatus");
                                  
                                  //String querys = "select * from marital_status where Marital_StatusID='"+marital+"'";
                                  //conn.rs2= conn.state2.executeQuery(querys);
                                  //while(conn.rs2.next()){
                                    //   a.add(conn.rs2.getString(2));
                                  //}
				 
				
				 
//				 System.out.println("al :: "+a);
				  userList.add(a);
				}

				request.setAttribute("userList",userList);
//				response.sendRedirect("admin/indexWorker.jsp");
                                String nextJSP = "/admin/viewMedicalForm.jsp";
				RequestDispatcher dispatcher;
                                           dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				 
            
            
            
            		
                         if(conn.rs!=null){ conn.rs.close();}
        
        
         if(conn.state!=null){ conn.state.close();}
        
            
            
            
        
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
            Logger.getLogger(searchWorker.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(searchWorker.class.getName()).log(Level.SEVERE, null, ex);
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
