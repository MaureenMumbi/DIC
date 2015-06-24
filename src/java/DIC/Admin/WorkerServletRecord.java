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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class WorkerServletRecord extends HttpServlet {
HttpSession session;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
      String [] district=null;
      String DICName="";
      
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
		dbConnect conn = new dbConnect();		
				
			session =request.getSession();	
			
				String query = "select * from enrollment where DICName='"+DICName+"' and (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+start_date+"','%e/%c/%Y')) AND (STR_TO_DATE('"+end_date+"','%e/%c/%Y'))";
				System.out.println(query);
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
					
				 SummaryBean DB= new SummaryBean();
                                 DB.setUNIQUEID(conn.rs.getString("UniqueID"));
                                 DB.setNAME(conn.rs.getString("FirstName") +" "+conn.rs.getString("SecondName")+" "+conn.rs.getString("LastName"));
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
				
			} catch (Exception e) {
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