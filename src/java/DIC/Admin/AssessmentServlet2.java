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
public class AssessmentServlet2 extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
                doPost(request, response);
        }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		HttpSession session;

 session= request.getSession(true);
               String UniqueID=request.getParameter("UniqueID");
               System.out.println("aaaaaaa"+UniqueID);
             // int no=Integer.parseInt(ProductID);
               String unique=(String) session.getAttribute("UniqueID");
               System.out.println(unique);
               dbConnect conn = new dbConnect();
     		try {
			ArrayList userList=null;
				String query = "select * from riskassessment where UniqueID ='"+unique+"'";
				System.out.println("query " + query);
				conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
				  
				   userList =new ArrayList();
				  
				  userList.add(conn.rs.getString(32));
				  userList.add(conn.rs.getString(33));
				  userList.add(conn.rs.getString(34));
				  userList.add(conn.rs.getString(35));
				  userList.add(conn.rs.getString(36));
				  userList.add(conn.rs.getString(37));
				  userList.add(conn.rs.getString(38));
				  userList.add(conn.rs.getString(39));
				  userList.add(conn.rs.getString(40));
				  userList.add(conn.rs.getString(41));
				  userList.add(conn.rs.getString(42));
				  userList.add(conn.rs.getString(43));
				  userList.add(conn.rs.getString(44));
				  userList.add(conn.rs.getString(45));
				  userList.add(conn.rs.getString(46));
				  userList.add(conn.rs.getString(47));
				  userList.add(conn.rs.getString(48));
				  userList.add(conn.rs.getString(49));
				  userList.add(conn.rs.getString(50));
				 
				  
				  
				 
				  
				System.out.println("A::"+ userList);
				}

				request.setAttribute("userList",userList);
				
                String nextJSP = "/admin/editAssessment2.jsp";
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
                        
			}
  }
}