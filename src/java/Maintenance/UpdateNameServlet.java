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
public class UpdateNameServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
      
// thsi gets the id og the row that is being edited
String id = request.getParameter("id");// values passed from the ajax
     String value = request.getParameter("value");// values passed from the ajax
//     String value2 = request.getParameter("value2");// values passed from the ajax
//     String value3 = request.getParameter("value3");// values passed from the ajax
    String columnName = request.getParameter("columnName");// values passed from the ajax
     String columnId = request.getParameter("columnId");// values passed from the ajax
     String columnPosition = request.getParameter("columnPosition");// values passed from the ajax
     String rowId = request.getParameter("rowId"); // values passed from the ajax 
System.out.println(value);
System.out.println(columnName);
System.out.println(columnId);
int CID =(Integer.parseInt(columnId)) ;
System.out.println(columnPosition);
System.out.println(rowId);
response.getWriter().print(value); 

 session= request.getSession(true);
//  String unique=(String)session.getAttribute("countyid");
	dbConnect conn = new dbConnect();
       String query1="";
       String query2="";
       String query3="";
        
 	// update the table with the value that was edited from the form
        if(CID == 1){
	 query1 = "update enrollment set FirstName='"+value+"' where UniqueID='"+id+"'";
          conn.state.executeUpdate(query1);
        }
        else if(CID== 2){
            query2 = "update enrollment set SecondName='"+value+"' where UniqueID='"+id+"'";
             conn.state.executeUpdate(query2);
        }
         
            else if(CID==3){
             query3 = "update enrollment set lastname='"+value+"' where UniqueID='"+id+"'";
             conn.state.executeUpdate(query3);
            }
          
      System.out.println(query1);
      System.out.println(query2);
      System.out.println(query3);
                                
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
            Logger.getLogger(UpdateNameServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR"+ex.toString());
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
            Logger.getLogger(UpdateNameServlet.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("ERROR"+ex.toString());
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
