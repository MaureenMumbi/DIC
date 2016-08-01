/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import Maintenance.BehaviourBean;
import Maintenance.saveAccessTrail;
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
public class AssessmentServletRecord extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
HttpSession session;
                       session = request.getSession();
                        dbConnect conn = new dbConnect();
String startdate="";
String enddate="";
startdate=request.getParameter("startdate");
enddate=request.getParameter("enddate");

			   
			try {
				
				 ArrayList assessments = new ArrayList();
				ArrayList al=null;
				ArrayList userList =new ArrayList();
				String query = "select * from riskassessmentmain where (STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))";
				System.out.println("query " + query);
				conn.state = conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(query);
 if(assessments!=null && assessments.size()>0 ){assessments.clear();}

				while(conn.rs.next())
               {
//					al  = new ArrayList();
//				 al.add(conn.rs.getString("AssessmentID"));
//                                 al.add(conn.rs.getString("AssessmentDate"));
//                                 al.add(conn.rs.getString("UniqueID"));
//                                 System.out.println(conn.rs.getString("AssessmentID"));
//                                 System.out.println(conn.rs.getString("AssessmentDate"));
//                                 System.out.println(conn.rs.getString("UniqueID"));
				   assessbean ab= new assessbean();
                       ab.setASSESSMENTID(conn.rs.getString("AssessmentID"));
                       ab.setASSESSMENTDATE(conn.rs.getString("AssessmentDate"));
                       ab.setUNIQUEID(conn.rs.getString("UniqueID"));
                    
                      
          
                       assessments.add(ab);  
				
				 
//				 System.out.println("al :: "+assessments.get(0));
//				 System.out.println("al :: "+assessments.get(1));
//				 System.out.println("al :: "+assessments.get(2));
//				  userList.add(al);
				}

if(session.getAttribute("accessTrail")!=null){
saveAccessTrail access = new saveAccessTrail();
String task="Loaded risk assessment forms for all the clients for possible editing or deleting. ";
String username=session.getAttribute("accessTrail").toString();
access.addAccess(username,task);
}
                                
                                
//				request.setAttribute("userList",userList);
				  session.setAttribute("assessments", assessments);
                                String nextJSP = "/DIC/admin/viewAssess.jsp";
				response.sendRedirect(nextJSP);
				
			
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
