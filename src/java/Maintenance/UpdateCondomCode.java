/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class UpdateCondomCode extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session;
   
      
// this gets the id of the row that is being edited
String id = request.getParameter("id");// values passed from the ajax
     String value = request.getParameter("value");// values passed from the ajax
    String columnName = request.getParameter("columnsName");// values passed from the ajax
     String columnId = request.getParameter("columnId");// values passed from the ajax
     String columnPosition = request.getParameter("columnPosition");// values passed from the ajax
     String rowId = request.getParameter("rowId"); // values passed from the ajax 

 response.getWriter().print(value); 

 session= request.getSession(true);
//  String unique=(String)session.getAttribute("countyid");
	dbConnect conn = new dbConnect();		
 	// update the table with the value that was edited from the form		
	String query = "update condomcode set CondomCode='"+value+"'where CondomCodeID='"+id+"'";
				
           
			     
                                try {
                                    //executes the query to update the db
                        conn.state.executeUpdate(query);
                        
//                   response.sendRedirect("CountyServlet");
            } 
                        
                    catch (SQLException ex) {// catches an sql error an outputs it
                                Logger.getLogger(UpdateCondomCode.class.getName()).log(Level.SEVERE, null, ex);
                                out.println(ex.toString());
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
