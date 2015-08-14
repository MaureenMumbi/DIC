/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Maureen
 */
public class searchWorker extends HttpServlet {

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
                                
				String query = "select * from enrollment where UniqueID ='"+search+"'";
				System.out.println("query " + query);
				conn.state = conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
					a  = new ArrayList();
				 
                                  a.add(conn.rs.getString("UniqueID"));
				  a.add(conn.rs.getString("ClientInit"));
                                  a.add(conn.rs.getString("DOE"));
                                   String querys1 = "select * from districts where DistrictID='"+conn.rs.getString("District")+"'";
                                  conn.rs1= conn.state3.executeQuery(querys1);
                                  while(conn.rs1.next()){
                                       a.add(conn.rs1.getString(2));
                                  }
				 
//                                  al.add(conn.rs.getString("District"));
				  a.add(conn.rs.getString("DICName"));
				  a.add(conn.rs.getString("DOB"));
				  a.add(conn.rs.getString("Sex"));
                                  String marital=conn.rs.getString("MaritalStatus");
                                  
                                  String querys = "select * from marital_status where Marital_StatusID='"+marital+"'";
                                  conn.rs2= conn.state2.executeQuery(querys);
                                  while(conn.rs2.next()){
                                       a.add(conn.rs2.getString(2));
                                  }
				 
				
				 
//				 System.out.println("al :: "+a);
				  userList.add(a);
				}

				request.setAttribute("userList",userList);
//				response.sendRedirect("admin/indexWorker.jsp");
                                String nextJSP = "/admin/ViewWorker.jsp";
				RequestDispatcher dispatcher;
                                           dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				 
            		
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
