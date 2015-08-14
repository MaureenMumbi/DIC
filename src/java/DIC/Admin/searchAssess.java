/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maureen
 */
public class searchAssess extends HttpServlet {

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
    dbConnect conn = new dbConnect();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String searchAssess="";
       	  if(request.getParameter("assess")!= null && !request.getParameter("assess").equals("")){
            
            searchAssess = request.getParameter("assess");
           }
           
			try {
				
				
				ArrayList al=null;
				ArrayList userList =new ArrayList();
                        if(userList!=null && !userList.isEmpty()){
            userList.clear();}
                                
            if(al!=null && !al.isEmpty()){
                       al.clear();
            }
				String query = "select * from riskassessmentmain where UniqueID='"+searchAssess+"'";
				System.out.println("query " + query);
				conn.state = conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
               {
					al  = new ArrayList();
				 al.add(conn.rs.getString("AssessmentID"));
                                 al.add(conn.rs.getString("AssessmentDate"));
                                 al.add(conn.rs.getString("UniqueID"));
                                 
				  
				
				 
//				 System.out.println("al :: "+al);
				  userList.add(al);
				}

				request.setAttribute("userList",userList);
				
                                String nextJSP = "/admin/ViewAssessment.jsp";
				RequestDispatcher dispatcher;
                                           dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
						
       if(conn.rs!=null){ conn.rs.close();}
        
        
         if(conn.state!=null){ conn.state.close();}
        
			} catch (Exception e) {
			out.println(e);
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
