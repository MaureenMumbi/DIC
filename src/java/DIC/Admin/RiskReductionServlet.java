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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class RiskReductionServlet extends HttpServlet {
  HttpSession session;  
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
               String UniqueID1=request.getParameter("UniqueID1");
               String UniqueID=request.getParameter("UniqueID");
               
               session = request.getSession(true);
               session.removeAttribute("UI");
//               String UniqueID;
               dbConnect conn = new dbConnect();
        session.setAttribute("UniqueID1",UniqueID1);
//               System.out.println("aaaaaaa"+UniqueID1);
             // int no=Integer.parseInt(ProductID);
       String [] ui1=UniqueID1.split("/");
       String dist,month,year,id;
       dist=ui1[2];
       month=ui1[3];
       year=ui1[4];
       id=ui1[5];
       String full_id=dist+"/"+month+"/"+year+"/"+id;
         full_id=full_id.replace("'", "");  


//          System.out.println("hre is the id:" +full_id);     
               
               
     		try {
			ArrayList userList=null;
                        
                     session.setAttribute("UI", full_id);
                       
String name_selector="select * from enrollment where UniqueID='"+UniqueID+"'";
System.out.println(name_selector);
conn.rs=conn.state.executeQuery(name_selector);
while(conn.rs.next()){
String full_name=conn.rs.getString("FirstName")+" "+conn.rs.getString("SecondName")+" "+conn.rs.getString("LastName");
  session.setAttribute("full_name", full_name);
}                     
//  conn.rs.close();                      
                        String query = "select currentStatus,Action,Appointments from riskreductiondetails LEFT JOIN  riskreductionmain  ON riskreductiondetails.RiskReductionID = riskreductionmain.RiskReductionID AND riskreductiondetails.RiskReductionID ='"+UniqueID1+"'";
								System.out.println("query " + query);
								System.out.println("query " + full_id );
				
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
				  
				   userList =new ArrayList();
				 
				  userList.add(conn.rs.getString("currentStatus"));
				  userList.add(conn.rs.getString("Action"));
				  userList.add(conn.rs.getString("Appointments"));
				 
//				  System.out.println(userList);
				 
				  
				
				}

				request.setAttribute("userList",userList);
				
                String nextJSP = "/admin/editRiskRed.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				
			
                		
                         if(conn.rs!=null){ conn.rs.close();}
      
        
         if(conn.state!=null){ conn.state.close();}
        
                
                
                
                
                
                
                
                
                } catch (Exception e) {
			e.printStackTrace();
                        e.toString();
                        out.println("dint work");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditRiskAssessment.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditRiskAssessment.class.getName()).log(Level.SEVERE, null, ex);
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