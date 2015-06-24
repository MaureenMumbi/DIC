/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

import DIC.Admin.EditWorker;
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
public class UpdateQuestionnaire extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     String id = request.getParameter("id");
     String value = request.getParameter("value");
      String columnName = request.getParameter("columnName");// values passed from the ajax
     String columnId = request.getParameter("columnId");// values passed from the ajax
     String columnPosition = request.getParameter("columnPosition");// values passed from the ajax
     String rowId = request.getParameter("rowId"); // values passed from the ajax 
    System.out.println("value!!!!!!!!!"+id);
    System.out.println("value!!!!!!!!!"+value);
    System.out.println("value"+      columnId);
int CID =(Integer.parseInt(columnId)) ;
HttpSession session;
 response.getWriter().print(value); 
 session= request.getSession(true);
//  String unique=(String)session.getAttribute("countyid");
	dbConnect conn = new dbConnect();		
 			
	String query1 = "";
	String query2 = "";
	String query3= "";
	String query4= "";
	String query5 = "";
	String query6= "";
	String query7= "";
	String query8 = "";
	String query9 = "";
               // "update questions set QuestionsID='"+value+"'where ID='"+id+"'";
	if(CID==1){
	 query1 = "update questions set QuestionsID='"+value+"'where ID='"+id+"'";
          conn.state.executeUpdate(query1);
        }
        else if(CID==2){
            query2 = "update questions set DomainID='"+value+"' where ID='"+id+"'";
             conn.state.executeUpdate(query2);
        }
         
            else if(CID ==3){
             query3 = "update questions set SubDomainID='"+value+"' where ID='"+id+"'";
             conn.state.executeUpdate(query3);}
            
          else if(CID ==4){
             query4 = "update questions set Question='"+value+"' where ID='"+id+"'";
             conn.state.executeUpdate(query4);
             System.out.println("query8"+query4);
            
            }
          
            else if(CID==5){
             query5 = "update questions set type='"+value+"' where ID='"+id+"'";
             conn.state.executeUpdate(query5);}
          
     
                                
		 
        
            else if(CID==6){
             query6 = "update questions set isCoded='"+value+"' where ID='"+id+"'";
             conn.state.executeUpdate(query6);}
          
     
                                
		 
        
            else if(CID==7){
             query7 = "update questions set hasDependant='"+value+"' where ID='"+id+"'";
             conn.state.executeUpdate(query7);}
          
     
                                
		 
        
            else if(CID==8){
            try{ query8 = "update questions set dependantValue='"+value+"' where ID='"+id+"'";
            System.out.println("query8"+query8);
             conn.state.executeUpdate(query8);
            }
            catch(SQLException ex){
                ex.toString();
                System.out.println(ex.toString());
            }
            }
          
     
                                
		 
        
            else if(CID==8){
             query9 = "update questions set DependantQuestion='"+value+"' where ID='"+id+"'";
             conn.state.executeUpdate(query9);}
          
          
                               
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
            Logger.getLogger(UpdateQuestionnaire.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateQuestionnaire.class.getName()).log(Level.SEVERE, null, ex);
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
