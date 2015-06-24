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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maureen
 */
public class DeleteRiskRed extends HttpServlet {
 public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

	
        String UniqueID=request.getParameter("UniqueID");
        
           
                      // HttpSession session = request.getSession();
	
                      System.out.println(UniqueID);
                       
        
       
        
                     dbConnect conn = new dbConnect();
                 
             
				ArrayList al=null;
				ArrayList userList =new ArrayList();
				String query = "delete from riskreductionmain where RiskReductionID='"+UniqueID+"'";
				String query1 = "delete from riskreductiondetails where RiskReductionID='"+UniqueID+"'";
			
                                try {
       
                        
                        conn.state.executeUpdate(query1);
                        conn.state.executeUpdate(query);
                      
                         response.sendRedirect("admin/index_RiskReduction.jsp");
            } 
                        
                    catch (SQLException ex) {
                                Logger.getLogger(deleteWorker.class.getName()).log(Level.SEVERE, null, ex);
                                out.println(ex);
                    }
                
                                
                                
                        }                     
     }