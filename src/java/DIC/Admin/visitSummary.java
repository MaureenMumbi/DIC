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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      HttpSession session;
          try {
              ArrayList summary =new ArrayList();
		dbConnect conn = new dbConnect();		
		    String FirstName="";
      String MiddleName="";
      String LastName="";
      String dicname="";
     String alldata="";
      if(request.getParameter("DICName")!=null && !request.getParameter("DICName").equals("")){
      dicname=request.getParameter("DICName");}
      System.out.println(" dicname  "+dicname);
			session =request.getSession();	
				alldata+="<thead>\n" +
"		<tr>" +
"			<th>UniqueID</th>" ;

    alldata+="<th>Full Name</th>";

alldata+="<th>Client Initials</th>\n" +
"           <th>DIC Name</th>\n" +
"           <th>DOA</th>\n" +
"           <th>LAST VISIT</th>\n" +
"		</tr>\n" +
"	</thead><tbody>";
				
String query="SELECT riskassessmentmain.UniqueID,FirstName,SecondName,LastName,ClientInit,AssessmentDate,enrollment.DICName from enrollment,riskassessmentmain WHERE enrollment.UniqueID=riskassessmentmain.UniqueID  and enrollment.DICName='"+dicname+"' and "
        + " AssessmentDate IN (SELECT MAX(AssessmentDate) FROM riskassessmentmain GROUP BY riskassessmentmain.UniqueID)";

//String query = "select * from enrollment,riskassessmentmain where enrollment.UniqueID=riskassessmentmain.UniqueID and   DICName='"+dicname+"' and MAX(STR_TO_DATE(riskassessmentmain.DOA,'%e/%c/%Y'))";
				  System.out.println(query);
				conn.rs = conn.state.executeQuery(query);


				while(conn.rs.next())
				{
					
				 SummaryBean DB= new SummaryBean();
                                 DB.setUNIQUEID(conn.rs.getString(1));
                                if(session.getAttribute("lockNames")==null){
                                DB.setNAME("");     
                                }
                                else{
                                if(session.getAttribute("lockNames").toString().equals("YES")){
                               DB.setNAME("");      
                                }
                                else{
                                     final  String strPssword ="?*1>9@(&#"; 
              AES.setKey(strPssword);
                         if(conn.rs.getString(2)!=null && !conn.rs.getString(2).trim().equals("") && !conn.rs.getString(2).equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString(2).trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString(2));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
                                                      FirstName =  AES.getDecryptedString()  ;
                                                   }
                                       
                          if(conn.rs.getString(3)!=null && !conn.rs.getString(3).trim().equals("") && !conn.rs.getString(3).equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString(3).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(3));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    MiddleName=AES.getDecryptedString();
                          }
                      if(conn.rs.getString(4)!=null && !conn.rs.getString(4).trim().equals("") && !conn.rs.getString(4).equals("null")){
//                      Lastname =  conn.rs.getString("LastName");
                    AES.decrypt(conn.rs.getString(4).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(4));
                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                      }
              
              
                           
                     
                                 DB.setNAME(FirstName +" "+MiddleName+" "+LastName);
                                    
                                    System.out.println("names  "+FirstName +" "+MiddleName+" "+LastName);
                                    
                                    
//                                 DB.setNAME(conn.rs.getString("FirstName") +" "+conn.rs.getString("SecondName")+" "+conn.rs.getString("LastName"));
                                }
                                }
                                 DB.setCLIENTINIT(conn.rs.getString(5));
                                 DB.setDOE(conn.rs.getString(6));
                                 DB.setDICNAME(conn.rs.getString(7));
			
				summary.add(DB);
				
                    alldata+=" <tr id='"+conn.rs.getString(1)+"'>\n" +
"           \n" +
"           <td class=\"sorting_1\">"+conn.rs.getString(1)+"</td>\n" ;

   alldata+="<td class=\"sorting_1\">"+FirstName +" "+MiddleName+" "+LastName+"</td>";

alldata+="<td class=\"sorting_1\">"+conn.rs.getString(5)+" </td>\n" +
"         <td class=\"sorting_1\">"+conn.rs.getString(7)+" </td>\n" +
"         <td class=\"sorting_1\">"+conn.rs.getString(6)+" </td>\n" +
"         <td class=\"sorting_1\"><input type=\"button\"  name=\"view\" value=\"Last Visit\" onclick=\"viewRecord('"+conn.rs.getString("UniqueID")+"')\"> </td>\n" +
"          </tr>"  ;    }      
                               
alldata+="</tbody>";
System.out.println(alldata);

				session.setAttribute("summary",summary);
				
//                                String nextJSP = "admin/summaryVisit.jsp";
//				response.sendRedirect(nextJSP);
                                	out.println(alldata);
                                 String nextJSP = "/summaryVisit.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
			
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
