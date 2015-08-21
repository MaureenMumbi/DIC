/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.AES;
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
public class visitSummary extends HttpServlet {

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
       HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
   
          try {
          
		dbConnect conn = new dbConnect();		
		    String FirstName="";
      String MiddleName="";
      String LastName="";
      String dicname="";
     String alldata="";
     String riskassessid="";
      if(request.getParameter("DICName")!=null && !request.getParameter("DICName").equals("")){
      dicname=request.getParameter("DICName");}
      System.out.println(" dicname  "+dicname);
	alldata="";
        session =request.getSession();	
alldata+="<thead>" +
"<tr>" +
"<th>UniqueID</th>"
+"<th>Full Name</th>"
+"<th>Client Initials</th>" +
"<th>DIC Name</th>" +
"<th>DOA</th>" +
"<th>RA</th>" +
"<th>RD</th>" +
"<th>LAST VISIT</th>" +
"</tr>" +
"</thead>";
alldata+="<tbody>";
String rr="";
String ra="";
String query="SELECT riskassessmentmain.UniqueID,FirstName,SecondName,LastName,ClientInit,AssessmentDate,enrollment.DICName,AssessmentID from enrollment,riskassessmentmain WHERE enrollment.UniqueID=riskassessmentmain.UniqueID  and enrollment.DICName='"+dicname+"' and "
        + " AssessmentDate IN (SELECT MAX(AssessmentDate) FROM riskassessmentmain GROUP BY riskassessmentmain.UniqueID)";

//String query = "select * from enrollment,riskassessmentmain where enrollment.UniqueID=riskassessmentmain.UniqueID and   DICName='"+dicname+"' and MAX(STR_TO_DATE(riskassessmentmain.DOA,'%e/%c/%Y'))";
				  System.out.println(query);
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{riskassessid=conn.rs.getString(8);
                                    String getrr="select * from riskreductionmain where UniqueID='"+conn.rs.getString(1)+"'";
                                    conn.rs4 = conn.state4.executeQuery(getrr);
                                    if(conn.rs4.next()){
                                    rr= "<img src='images/tick1.JPG' style='width:20px;height:20px;'>";}else{
                                         rr= "<img src='images/cros1.JPG'  style='width:20px;height:20px;'>";
                                    }
                                    FirstName="";
                                    MiddleName="";
                                    LastName="";
				String fullname=""	;
			
                                if(session.getAttribute("lockNames")==null){
                               fullname=""; 
                                }
                                else{
                                if(session.getAttribute("lockNames").toString().equals("YES")){
                            fullname="";    
                                }
                                else{
                                     final  String strPssword ="?*1>9@(&#"; 
              AES.setKey(strPssword);
                         if(conn.rs.getString(2)!=null && !conn.rs.getString(2).trim().equals("") && !conn.rs.getString(2).equals("null")){
                            
                        AES.decrypt(conn.rs.getString(2).trim());
                        FirstName =  AES.getDecryptedString()  ;
                                                   }
                                       
                          if(conn.rs.getString(3)!=null && !conn.rs.getString(3).trim().equals("") && !conn.rs.getString(3).equals("null")){               
                           AES.decrypt(conn.rs.getString(3).trim());
                           MiddleName=AES.getDecryptedString();
                          }
                      if(conn.rs.getString(4)!=null && !conn.rs.getString(4).trim().equals("") && !conn.rs.getString(4).equals("null")){

                            AES.decrypt(conn.rs.getString(4).trim());
                            LastName=AES.getDecryptedString();

                    
                      }  fullname=FirstName +" "+MiddleName+" "+LastName;
                                }
                                }
                                if(conn.rs.getString(6)!=null && !conn.rs.getString(6).equals("")){
                                ra="<img src='images/tick1.JPG' style='width:20px;height:20px;'>";
                                }
                                else{
                                ra="<img src='images/cros1.JPG' style='width:20px;height:20px;'>";}

alldata+=" <tr id='"+conn.rs.getString(1)+"'>" +

"<td class=\"sorting_1\">"+conn.rs.getString(1)+"</td>"
+"<td class=\"sorting_1\">"+fullname+"</td>"
+"<td class=\"sorting_1\">"+conn.rs.getString(5)+" </td>" +
"<td class=\"sorting_1\">"+conn.rs.getString(7)+" </td>" +
"<td class=\"sorting_1\">"+conn.rs.getString(6)+" </td>" +
"<td class=\"sorting_1\">"+ ra+" </td>" +
"<td class=\"sorting_1\">"+rr+" </td>" +
"<td class=\"sorting_1\"><input type=\"button\"  name=\"view\" id=\"view_"+conn.rs.getString("UniqueID") +"\" value=\"Last Visit\" onclick=\"viewRecord('"+conn.rs.getString("UniqueID")+"')\"> <img src='images/utube.gif' style='display:none;' id=\"viewimage"+conn.rs.getString("UniqueID") +"\"></img> </td>" +
"</tr>"  ; }      
                               
alldata+="</tbody>";
System.out.println(alldata);

//				session.setAttribute("summary",summary);
				
//                                String nextJSP = "admin/summaryVisit.jsp";
//				response.sendRedirect(nextJSP);
                                	out.println(alldata);
//                                 String nextJSP = "/summaryVisit.jsp";
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//				dispatcher.forward(request,response);
			
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
//			out.println(e);
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
