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
public class AssessmentServlet extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
                doPost(request, response);
        }
HttpSession session;
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
               String UniqueID=request.getParameter("UniqueID").toString();
              
               session = request.getSession();
               session.setAttribute("UniqueID", UniqueID);
               
             // int no=Integer.parseInt(ProductID);
              
               dbConnect conn = new dbConnect();
     		try {
			ArrayList userList=null;
				String query = "select DirectAnswers from riskassessmentdetails LEFT JOIN  riskassessmentmain  ON riskassessmentdetails.AssessmentID = riskassessmentmain.AssessmentID";
				System.out.println("query " + query);
				conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
				  for(int i=0;i<61;i++){
				   userList =new ArrayList();
				  
				  
				  userList.add(conn.rs.getString("DirectAnswers"));
                                  }
				  
				 
				  
//				System.out.println("A::"+ userList);
				}

				request.setAttribute("userList",userList);
				
                String nextJSP = "/admin/editAssessment.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				
			} catch (Exception e) {
			e.printStackTrace();
                        e.toString();
                        out.println("dint work");
                        out.println(e.toString());
                        
			}
  }
}