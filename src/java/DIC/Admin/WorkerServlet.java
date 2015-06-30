/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import Reports.Enrollment_count_report;
import dbConnect.AES;
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

/**
 *
 * @author Maureen
 */
public class WorkerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
               String UniqueID=request.getParameter("UniqueID");
               System.out.println("aaaaaaa"+UniqueID);
             // int no=Integer.parseInt(ProductID);
                 String FirstName = "";
                 String Lastname = "";
                 String SecondName = "";
               dbConnect conn = new dbConnect();
     		try {
			ArrayList userList=null;
				String query = "select * from enrollment where UniqueID ="+UniqueID;
				System.out.println("query " + query);
				conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
				  
				   userList =new ArrayList();
				
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
                                  userList.add(conn.rs.getString(28));
				  userList.add(conn.rs.getString(29));
                                  
                                       final String strPssword = "encryptor key";
                       AES.setKey(strPssword);
                                  
                                                       if(conn.rs.getString("FirstName")!=null && !conn.rs.getString("FirstName").trim().equals("") && !conn.rs.getString("FirstName").equals("null")){
                                       FirstName =    conn.rs.getString("FirstName");
                                        AES.decrypt(FirstName.trim());
                                       System.out.println("String To Decrypt : " + FirstName);
                                       System.out.println("Decrypted : " + AES.getDecryptedString());}
                                       
                          if(conn.rs.getString("SecondName")!=null && !conn.rs.getString("SecondName").trim().equals("") && !conn.rs.getString("SecondName").equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString("SecondName").trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("SecondName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    SecondName=AES.getDecryptedString();
                          }
                      if(conn.rs.getString("LastName")!=null && !conn.rs.getString("LastName").trim().equals("") && !conn.rs.getString("LastName").equals("null")){
//                      Lastname =  conn.rs.getString("LastName");
                    AES.decrypt(Lastname.trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("LastName"));
                     Lastname=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                      }
				  userList.add(FirstName);
				  userList.add(SecondName);
				  userList.add(Lastname);
				  userList.add(conn.rs.getString("EnrollID"));
				 
				  System.out.println(userList);
				
				}

				request.setAttribute("userList",userList);
				
////                  String nextJSP = ;
//				response.sendRedirect("admin/editWorkers.jsp");
                                
                                   String nextJSP = "/admin/editWorkers.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				conn.connect.close();
				System.out.println("Disconnected from database");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Enrollment_count_report.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Enrollment_count_report.class.getName()).log(Level.SEVERE, null, ex);
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
