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
public class RiskReductionServletRecord extends HttpServlet {

//   public class AssessmentServletRecord extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        dbConnect conn = new dbConnect();
        HttpSession session;
        session = request.getSession();
String startdate="";
String enddate="";
startdate=request.getParameter("startdate");
enddate=request.getParameter("enddate");

			   
			try {
				
								ArrayList reduction =new ArrayList();
				String query = "select * from riskreductionmain WHERE  (STR_TO_DATE(DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))";
//				System.out.println("query " + query);
				conn.state = conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(query);


 if(reduction!=null && reduction.size()>0 ){reduction.clear();}

				while(conn.rs.next())
                                {
				   assessbean ab= new assessbean();
//                       ab.setASSESSMENTID(conn.rs.getString("AssessmentID"));
//                       ab.setASSESSMENTDATE(conn.rs.getString("AssessmentDate"));
//                       ab.setUNIQUEID(conn.rs.getString("UniqueID"));
//                    
                      
                                             ab.setASSESSMENTID(conn.rs.getString("RiskReductionID"));
				  ab.setASSESSMENTDATE(conn.rs.getString("DOA"));
//                                  String query2 = "select * from cadrecode where CadreCodeID='"+conn.rs.getString("CadreProvider")+"'";
//                                  conn.rs2 = conn.state2.executeQuery(query2);
//                                  while(conn.rs2.next()){
//                                       al.add(conn.rs2.getString(2));
//                                  }
                                 
                                  ab.setUNIQUEID(conn.rs.getString("UniqueID"));

                       reduction.add(ab);  
				
				 
//				 System.out.println("al :: "+assessments.get(0));
//				 System.out.println("al :: "+assessments.get(1));
//				 System.out.println("al :: "+assessments.get(2));
//				  userList.add(al);
				}

//				request.setAttribute("userList",userList);
				  session.setAttribute("reduction", reduction);
                                String nextJSP = "/DIC/admin/viewRed.jsp";
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