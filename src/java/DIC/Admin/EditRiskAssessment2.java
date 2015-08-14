/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class EditRiskAssessment2 extends HttpServlet {
     public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
                doPost(request, response);
        }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			 dbConnect conn = new dbConnect();
                         

			//out.println(request.getRequestURI());

			
String AlcoholUse= request.getParameter("AlcoholUse").toString();
String AlcoholFrequency= request.getParameter("AlcoholFrequency").toString();
String DrugUse= request.getParameter("DrugUse").toString();
String DrugType= request.getParameter("DrugType").toString();
String DrugFrequency= request.getParameter("DrugFrequency").toString();
String VaginalDouche= request.getParameter("VaginalDouche").toString();
String AfterSexDouche= request.getParameter("AfterSexDouche").toString();
String BathDouche= request.getParameter("BathDouche").toString();
String CdBurstDouche= request.getParameter("CdBurstDouche");
String OtherDouche= request.getParameter("OtherDouche");
String VerbalInsults= request.getParameter("VerbalInsults").toString();
String Hit= request.getParameter("Hit").toString();
String ForcedSex= request.getParameter("ForcedSex").toString();
String LastVerbalInsult= request.getParameter("LastVerbalInsult");
String LastVerbalInsultHit= request.getParameter("LastVerbalInsultHit");
String LastVerbalInsultForced= request.getParameter("LastVerbalInsultForced");
String SeekTreatment= request.getParameter("SeekTreatment").toString();
String PlaceTreated= request.getParameter("PlaceTreated").toString();
String ReportPolice= request.getParameter("ReportPolice").toString();
HttpSession session;

 session= request.getSession(true);
  String unique=(String)session.getAttribute("UniqueID");
			
 			
	String query = "update RiskAssessment set AlcoholUse='"+AlcoholUse+"',AlcoholFrequency='"+AlcoholFrequency+"',DrugUse='"+DrugUse+"',DrugType='"+DrugType+"'"
                       + ",DrugFrequency='"+DrugFrequency+"',VaginalDouche='"+VaginalDouche+"',AfterSexDouche='"+AfterSexDouche+"',"
                + "BathDouche='"+BathDouche+"',CdBurstDouche='"+CdBurstDouche+"',OtherDouche='"+OtherDouche+"',"
                + "VerbalInsults='"+VerbalInsults+"',Hit='"+Hit+"',ForcedSex='"+ForcedSex+"',LastVerbalInsult='"+LastVerbalInsult+"',LastVerbalInsultHit='"+LastVerbalInsultHit+"',"
                + "LastVerbalInsultForced='"+LastVerbalInsultForced+"',SeekTreatment='"+SeekTreatment+"',PlaceTreated='"+PlaceTreated+"',ReportPolice='"+ReportPolice+"' where UniqueID='"+unique+"'";
				
           
			     
                                try {
                        conn.state.executeUpdate(query);
                       
                         response.sendRedirect("AssessmentServletRecord");
                         
                         		
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
            } 
                        
                    catch (SQLException ex) {
                                Logger.getLogger(EditWorker.class.getName()).log(Level.SEVERE, null, ex);
                                out.println(ex.toString());
                    }
                                
		 }
	  }


                    