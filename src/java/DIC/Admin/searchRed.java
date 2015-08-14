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
public class searchRed extends HttpServlet {

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
        dbConnect conn = new dbConnect();

			
		  
 String searchRed="";
       	  if(request.getParameter("reduction")!= null && !request.getParameter("reduction").equals("")){
            
            searchRed = request.getParameter("reduction");
           }
			
			try {
				
				
				ArrayList al=null;
				ArrayList userList =new ArrayList();
				String query = "select * from riskreductionmain where UniqueID='"+searchRed+"'";
//				System.out.println("query " + query);
				conn.state = conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
					al  = new ArrayList();
				 

                                  al.add(conn.rs.getString("RiskReductionID"));
				  al.add(conn.rs.getString("DOA"));
                                  String query2 = "select * from cadrecode where CadreCodeID='"+conn.rs.getString("CadreProvider")+"'";
                                  conn.rs2 = conn.state2.executeQuery(query2);
                                  while(conn.rs2.next()){
                                       al.add(conn.rs2.getString(2));
                                  }
                                  al.add(conn.rs.getString("UniqueID"));

				
				 
//				 System.out.println("al :: "+al);
				  userList.add(al);
				}

				request.setAttribute("userList",userList);
				
                                String nextJSP = "/admin/ViewRiskRed.jsp";
				RequestDispatcher dispatcher;
                                           dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
//				conn.connect.close();
//				System.out.println("Disconnected from database");
			
                        
                        		
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
