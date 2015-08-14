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
 *@author Hare Cheka Arnold
 */
public class MedicalServlet extends HttpServlet {

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
       String UniqueID=request.getParameter("UniqueID");
       String MedicalID=request.getParameter("MedicalID");
       
               //System.out.println("aaaaaaa"+UniqueID);
               String medicine[]=UniqueID.split(",");
           
//               String MedicalID=medicine[1];
//               String MedicaluniID=medicine[0];
//               System.out.println("aaaaaaa"+MedicalID);
//               System.out.println("aaaaaaa"+MedicaluniID);
//               //System.out.println("aaaaaaa"+MedicalID);
             // int no=Integer.parseInt(ProductID);
               
               dbConnect conn = new dbConnect();
     		try {
			ArrayList userList=null;
				String query = "select * from medical_form where unique_identifier=? and id='"+MedicalID+"'";
                                conn.ps = conn.connect.prepareStatement(query);
                                    conn.ps.setString(1,UniqueID);

                                  conn.rs=  conn.ps.executeQuery(); 
				System.out.println("query " + query);
//				conn.state= conn.connect.createStatement();
//				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
				  
				   userList =new ArrayList();
                                  userList.add(conn.rs.getString(1));
                                  System.out.println(conn.rs.getString(1));
				  userList.add(conn.rs.getString(2));
				  userList.add(conn.rs.getString(3));
				  userList.add(conn.rs.getString(4));
				  userList.add(conn.rs.getString(5));
				  userList.add(conn.rs.getString(6));
				  userList.add(conn.rs.getString(7));
				  userList.add(conn.rs.getString(8));
				  userList.add(conn.rs.getString(9));
				  userList.add(conn.rs.getString(10));
				  userList.add(conn.rs.getString(11));
				  userList.add(conn.rs.getString(12));
				  userList.add(conn.rs.getString(13));
				  userList.add(conn.rs.getString(14));
				  userList.add(conn.rs.getString(15));
				  userList.add(conn.rs.getString(16));
				  userList.add(conn.rs.getString(17));
				  userList.add(conn.rs.getString(18));
				  userList.add(conn.rs.getString(19));
				  userList.add(conn.rs.getString(20));
				  userList.add(conn.rs.getString(21));
				  userList.add(conn.rs.getString(22));
				  userList.add(conn.rs.getString(23));
				  userList.add(conn.rs.getString(24));
				  userList.add(conn.rs.getString(25));
				  userList.add(conn.rs.getString(26));
				  userList.add(conn.rs.getString(27));
				  userList.add(conn.rs.getString(28));
				  userList.add(conn.rs.getString(29));
				  userList.add(conn.rs.getString(30));
				  userList.add(conn.rs.getString(31));
				  userList.add(conn.rs.getString(32));
				  userList.add(conn.rs.getString(33));
                                  userList.add(conn.rs.getString(34));
				  userList.add(conn.rs.getString(35));
				  userList.add(conn.rs.getString(36));
				
				  
				 
				  System.out.println("list"+userList);
				
				}

				request.setAttribute("userList",userList);
				
                String nextJSP = "/admin/editMedical.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				conn.connect.close();
				System.out.println("Disconnected from database");
                                		
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
			e.printStackTrace();
                        e.toString();
                        out.println("dint work");
                        out.println(e.toString());
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
